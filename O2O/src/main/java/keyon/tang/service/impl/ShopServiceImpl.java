package keyon.tang.service.impl;

import keyon.tang.custom.ShopCustom;
import keyon.tang.dao.ShopCategoryDao;
import keyon.tang.dao.ShopDao;
import keyon.tang.dto.ShopExcution;
import keyon.tang.entity.Shop;
import keyon.tang.entity.ShopCategory;
import keyon.tang.enums.ShopStateEnum;
import keyon.tang.exceptions.ShopException;
import keyon.tang.service.ShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/10 19:50
 * @Version 1.0
 */

/** 保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
 * //             不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
 */
@Transactional
@Service
public class ShopServiceImpl implements ShopService {
    @Value("${imgFile.path}")
    private String imgFilePath;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public Shop queryShopById(Integer shopID) {
        return shopDao.queryShopById(shopID);
    }

    @Override
    public ShopExcution addShop(ShopCustom shopCustom) {
//        传入的ShopCustom为空
        if (shopCustom == null) {
            return new ShopExcution(ShopStateEnum.NULL_SHOPID);
        } else {
//            下面的一系列操作为一个事务，用try....catch....抛出运行时异常的方式来实现事务的回滚

            try {
//                为shopCustom的时间字段赋值
                shopCustom.setEnableStatus(0);
                shopCustom.setCreateTime(new Date());
                shopCustom.setLastEditTime(new Date());
//                通过ShopCustom的ShopCategoryId查到parentId
//                parentId是一级列表内的id,ShopCategoryId是二级列表内的id，两个保存在同一张表内
//                传来的是二级列表的id
                if(shopCustom.getShopCategory()!=null){
                    Long categoryId = shopCustom.getShopCategory().getShopCategoryId();
                    ShopCategory category = shopCategoryDao.queryShopCategory(categoryId);
                    ShopCategory parentCategory=new ShopCategory();
                    parentCategory.setParentId(category.getParentId());
                    shopCustom.setParentCategory(parentCategory);
                }
//               如果传入的图片不为空就将图片保存在文件夹中，并且让ShopCustom保存对应的路径
//                允许传入的图片为空
                MultipartFile imgFile = shopCustom.getImgFile();
                if (imgFile != null) {
                    saveImgFile(shopCustom, imgFile);
                }
                Shop shop = new Shop();
                BeanUtils.copyProperties(shopCustom, shop);
//                调用dao的方法来操作数据库
                System.out.println("---------->"+shop.getOwnerId());
                int alterNum = shopDao.insertShop(shop);
                if (alterNum <= 0) {
                    throw new ShopException("insertShop error");
                } else {
                    return new ShopExcution(ShopStateEnum.PASS);
                }

            } catch (Exception e) {
                throw new ShopException("inner error" + e.getMessage());
            }

        }

    }

    public  void saveImgFile(ShopCustom shopCustom, MultipartFile imgFile)throws RuntimeException {
//            判断存放图片的文件夹是否存在
        File imgDir = new File(imgFilePath);
        if (!imgDir.exists()) {
            imgDir.mkdirs();
        }
//            对上传图片进行重命名
        String imgName = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
//            在文件夹下创建出新的文件
        File newFile = new File(imgFilePath, imgName);
        try {
            imgFile.transferTo(newFile);
            shopCustom.setShopImg(imgFilePath + imgName);
        } catch (IOException e) {
            throw new ShopException("save img error" + e.getMessage());
        }
    }
}






