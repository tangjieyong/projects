package keyon.tang.bean;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/5 10:43
 * @Version 1.0
 */
public class AdBase {
    private AdCustom adCustom;
    private Page page;

    public AdCustom getAdCustom() {
        return adCustom;
    }

    public void setAdCustom(AdCustom adCustom) {
        this.adCustom = adCustom;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "AdBase{" +
                "adCustom=" + adCustom +
                ", page=" + page +
                '}';
    }
}
