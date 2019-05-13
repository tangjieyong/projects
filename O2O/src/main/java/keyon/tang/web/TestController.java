package keyon.tang.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/11 8:41
 * @Version 1.0
 */
@Controller
public class TestController {
//    @RequestMapping("/shop/registerShop")
    public void receive(MultipartFile shopImg, String shopStr){
        System.out.println(shopStr);
        System.out.println(shopImg);
    }

    }

