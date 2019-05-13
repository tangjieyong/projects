package keyon.tang.dao;

import keyon.tang.entity.Shop;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/8 19:45
 * @Version 1.0
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 根据店铺的编号来查询店铺的信息
     * @param shopId
     * @return
     */
    Shop queryShopInfo(Integer shopId);

    Shop queryShopById(Integer shopID);
}
