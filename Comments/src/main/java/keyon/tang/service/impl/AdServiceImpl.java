package keyon.tang.service.impl;

import keyon.tang.bean.AdBase;
import keyon.tang.bean.AdCustom;
import keyon.tang.bean.Page;
import keyon.tang.dao.AdMapper;
import keyon.tang.exception.CustomException;
import keyon.tang.po.Ad;
import keyon.tang.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 21:09
 * @Version 1.0
 */

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper;
    @Value("${Image.savePath}")
    String fileDir;

    /**
     * 分页查找广告
     * @param adBase
     * @return
     */
    @Override
    public List<AdCustom> selectAdByPage(AdBase adBase) {
         return adMapper.selectAdByPage(adBase);
    }

    /**
     * 向数据库中添加广告
     * @param adCustom
     * @return
     * @throws CustomException
     */
    @Override
    public boolean insertAd(AdCustom adCustom) throws CustomException{
        MultipartFile fileUpload = adCustom.getImgFile();
//        上传的文件不得为空
       if(fileUpload !=null && fileUpload.getSize()>0){
//           保存文件的文件夹是否存在
           File imgDir=new File(fileDir);
           if(!imgDir.exists()){
               imgDir.mkdirs();
           }
//           将上传的文件重命名
           String imgName=System.currentTimeMillis()+"_"+fileUpload.getOriginalFilename();
//           在文件夹中创建文件
           File imgFile=new File(imgDir,imgName);
           try {
               fileUpload.transferTo(imgFile);
           } catch (IOException e) {
               e.printStackTrace();
           }
           Ad ad=new Ad();
           BeanUtils.copyProperties(adCustom,ad);
           ad.setImgFileName(fileDir+imgName);
           return adMapper.insertAd(ad)>0;
       }else{
           throw new CustomException("插入图片为空");
       }

    }
}
