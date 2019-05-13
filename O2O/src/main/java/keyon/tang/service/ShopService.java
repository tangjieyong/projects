package keyon.tang.service;

import keyon.tang.custom.ShopCustom;
import keyon.tang.dto.ShopExcution;
import keyon.tang.entity.Shop;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/10 19:46
 * @Version 1.0
 */
public interface ShopService {

    /**
     * 添加店铺信息
     * @param shopCustom
     * @return
     */
    ShopExcution addShop(ShopCustom shopCustom);

    Shop queryShopById(Integer shopID);
}
