package keyon.tang.service;

import keyon.tang.bean.AdBase;
import keyon.tang.bean.AdCustom;
import keyon.tang.bean.Page;
import keyon.tang.exception.CustomException;

import java.util.List;
import java.util.Map;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 21:09
 * @Version 1.0
 */
public interface AdService {
    boolean insertAd(AdCustom adCustom) throws CustomException;

    List<AdCustom> selectAdByPage(AdBase adBase);
}
