package keyon.tang.dao;

import keyon.tang.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/10 21:28
 * @Version 1.0
 */
public interface ShopCategoryDao {
    List<ShopCategory> queryShopCategoryList(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
      ShopCategory queryShopCategory(Long shopCategoryId);
}
