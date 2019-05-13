package keyon.tang.controller.api;

import keyon.tang.bean.AdBase;
import keyon.tang.bean.AdCustom;
import keyon.tang.bean.Page;
import keyon.tang.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/6 21:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    AdService adService;

    @Value("${Page.pageCapacity}")
    private int pageCapacity;

    @RequestMapping(value = "/homead", method = RequestMethod.GET)
    public List<AdCustom> homead(){
        Page page=new Page();
        page.setPageCapacity(pageCapacity);
        AdBase adBase=new AdBase();
        AdCustom adCustom=new AdCustom();
        adBase.setAdCustom(adCustom);
        adBase.setPage(page);
       return adService.selectAdByPage(adBase);
    }
}
