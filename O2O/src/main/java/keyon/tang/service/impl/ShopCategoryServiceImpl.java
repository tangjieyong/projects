package keyon.tang.service.impl;

import keyon.tang.dao.ShopCategoryDao;
import keyon.tang.dao.ShopDao;
import keyon.tang.entity.Shop;
import keyon.tang.entity.ShopCategory;
import keyon.tang.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/10 22:00
 * @Version 1.0
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Autowired
    private ShopDao shopDao;


    @Override
    public List<ShopCategory> queryShopCategoryList(Integer shopId) {
        Shop shop = shopDao.queryShopById(shopId);
        ShopCategory shopCategory=new ShopCategory();
        shopCategory.setParentId(shop.getParentCategoryId());
        shopCategoryDao.queryShopCategoryList(shopCategory);
        return shopCategoryDao.queryShopCategoryList(shopCategory);
    }

    @Override
    public ShopCategory getShopCategoryById(Long shopCategoryId) {

        return shopCategoryDao.queryShopCategory(shopCategoryId);
    }
}
