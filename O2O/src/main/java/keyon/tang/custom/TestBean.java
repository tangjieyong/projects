package keyon.tang.custom;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/12 20:38
 * @Version 1.0
 */
public class TestBean {
 private String shopStr;
 private MultipartFile shopImg;

    public String getShopStr() {
        return shopStr;
    }

    public void setShopStr(String shopStr) {
        this.shopStr = shopStr;
    }

    public MultipartFile getShopImg() {
        return shopImg;
    }

    public void setShopImg(MultipartFile shopImg) {
        this.shopImg = shopImg;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "shopStr='" + shopStr + '\'' +
                ", shopImg=" + shopImg +
                '}';
    }
}
