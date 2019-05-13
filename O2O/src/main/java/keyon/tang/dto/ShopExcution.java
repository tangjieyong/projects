package keyon.tang.dto;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/9 16:09
 * @Version 1.0
 */
import keyon.tang.entity.Shop;
import keyon.tang.enums.ShopStateEnum;
import java.util.List;
/**
 * 封装shop操作执行后的结果
 * 操作的状态值及其描述 以及查询操作返回的数据封装在对应的bean内
 */
public class ShopExcution {
//    状态码
      private int state;

//      状态信息
      private String stateInfo;

    // 店铺数量
    private int count;

    // 操作的shop（增删改店铺的时候用）
    private Shop shop;

    // 获取的shop列表(查询店铺列表的时候用)
    private List<Shop> shopList;

    public ShopExcution(){}

//    操作错误调用此构造器
      public ShopExcution(ShopStateEnum shopStateEnum){
          this.state=shopStateEnum.getState();
          this.stateInfo=shopStateEnum.getStateInfo();
      }

//      操作成功使用的构造器，操作成功返回店铺的信息
      public ShopExcution(ShopStateEnum shopStateEnum, Shop shop){
          this.state=shopStateEnum.getState();
          this.stateInfo=shopStateEnum.getStateInfo();
          this.shop=shop;

      }

      public ShopExcution(ShopStateEnum shopStateEnum,List<Shop> shopList ){
          this.stateInfo=shopStateEnum.getStateInfo();
          this.state=shopStateEnum.getState();
          this.shopList=shopList;
      }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
