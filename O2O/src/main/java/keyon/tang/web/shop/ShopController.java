package keyon.tang.web.shop;
import com.alibaba.fastjson.JSON;
import keyon.tang.custom.ShopCustom;
import keyon.tang.dto.ShopExcution;
import keyon.tang.entity.Area;
import keyon.tang.entity.Shop;
import keyon.tang.entity.ShopCategory;
import keyon.tang.service.AreaService;
import keyon.tang.service.ShopCategoryService;
import keyon.tang.service.ShopService;
import keyon.tang.util.CodeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/11 11:13
 * @Version 1.0
 */
@RestController
@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private AreaService areaService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private ShopService shopService;

          @RequestMapping("/getShopInfo")
    public Map<String,Object> getShopInfo(ShopCustom shopCustom){
        Map<String,Object> resMap=new HashMap<>();
              List<Area> areaList = areaService.getAreaList();
              List<ShopCategory> shopCategoryList = shopCategoryService.queryShopCategoryList(shopCustom.getShopId());
              resMap.put("areaList",areaList);
              resMap.put("shopCategoryList",shopCategoryList);
              return resMap;
          }



           @RequestMapping("/registerShop")
           public Map<String,Object> registerShop(@RequestParam(value ="shopImg") MultipartFile file,HttpServletRequest request){
                Map<String,Object> resMap=new HashMap<>();
                     boolean isMatch = CodeUtil.checkVerifyCode(request);
                   System.out.println(isMatch);
//                     如果验证码输入错误，直接返回错误信息，添加商铺的逻辑不再执行
                      if(!isMatch){
                          resMap.put("msg","验证码输入错误，请重新输入！");
                             return  resMap;
                }
                ShopCustom shopCustom=new ShopCustom();
                  Shop shop = JSON.parseObject(request.getParameter("shopStr"), Shop.class);
                  BeanUtils.copyProperties(shop,shopCustom);
                  shopCustom.setImgFile(file);
                  shopCustom.setOwnerId(8);
                  ShopExcution shopExcution = shopService.addShop(shopCustom);
                  resMap.put("stateCode",shopExcution.getState());

                  return  resMap;
    }




















}
