package keyon.tang.service;

import keyon.tang.entity.ShopCategory;

import java.util.List;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/10 21:59
 * @Version 1.0
 */
public interface ShopCategoryService {
    ShopCategory getShopCategoryById(Long shopCategoryId);
    List<ShopCategory> queryShopCategoryList(Integer shopId);
}
