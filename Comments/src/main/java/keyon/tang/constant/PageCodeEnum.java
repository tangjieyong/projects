package keyon.tang.constant;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 21:38
 * @Version 1.0
 */
public enum PageCodeEnum {

    ADD_SUCCESS(1000,"添加成功"),
    ADD_FAILURE(1001,"添加失败"),;
    private int pageCode;
    private String msg;

    PageCodeEnum(int pageCode,String msg){
        this.pageCode=pageCode;
        this.msg=msg;
    }

    public static  final String KEY="pageCode";

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
