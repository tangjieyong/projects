package keyon.tang.enums;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/9 20:26
 * @Version 1.0
 */

/**
 * 封装店铺的状态
 */
public enum ShopStateEnum {
     CHECK(0,"审核中"),
     OFFLINE(-1,"非法店铺"),
     SUCCESS(1,"操作成功"),
     PASS(2,"通过审核"),
     INNER_ERROR(-1001,"操作失败"),
     NULL_SHOPID(-1002,"店铺的id为空"),
     NULL_SHOP_INFO(-1003,"传入空的信息"),
    ;
    private int state;
    private String stateInfo;

    private  ShopStateEnum(int state,String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    /**
     * 传入状态码返回对应的枚举常量
     * @param index
     * @return
     */
    public static ShopStateEnum stateOf(int index) {
        for (ShopStateEnum enu : values()) {
            if (enu.getState() == index)
                return enu;
        }
        return null;
    }


}
