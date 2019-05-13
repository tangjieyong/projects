package keyon.tang.controller;

import keyon.tang.bean.AdBase;
import keyon.tang.bean.AdCustom;
import keyon.tang.constant.PageCodeEnum;
import keyon.tang.exception.CustomException;
import keyon.tang.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 20:36
 * @Version 1.0
 */
 @Controller
 @RequestMapping("/ad")
public class Adcontroller {

  @Autowired
  AdService adService;

 /**
  * 跳转至广告添加页面
  * @return
  */
 @RequestMapping("/adInit")
  public String  adInit(){  return  "content/adAdd";}


 /**
  * 广告添加
  * @param adCustom
  * @param model
  * @return
  * @throws CustomException
  */
  @RequestMapping("/add")
  public String add(AdCustom adCustom, Model model) throws CustomException {

  if(adService.insertAd(adCustom)){//插入成功
      model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS);
  }else{
   model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_FAILURE);
   }
      return  "content/adAdd";
  }

    /**
     * 跳转到广告列表页面
     * @return
     */
  @RequestMapping("/adList")
  public String adList(){
      return "content/adList";
  }

    /**
     * 处理广告的分页查找
     * @param adBase
     */
  @RequestMapping("/search")
  public String  selectByPage(AdBase adBase,Model model){
      /**
       * 注意，来自页面的参数可以使用adbase来接收，但是发往页面的数据不能这样
       * 分页信息可以直接将adBase的值发过去，因为经过adService.selectAdByPage的计算后
       * adBase中的属性值已经赋值完成了
       */
      model.addAttribute("list",adService.selectAdByPage(adBase));
      model.addAttribute("searchParam",adBase);

      return "content/adList";
  }
}
