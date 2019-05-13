package keyon.tang.dao;

import keyon.tang.bean.AdBase;
import keyon.tang.bean.AdCustom;
import keyon.tang.po.Ad;
import java.util.List;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 21:06
 * @Version 1.0
 */
public interface AdMapper {
    int insertAd(Ad ad);

    List<AdCustom> selectAdByPage(AdBase adBase);
}
