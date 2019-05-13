package keyon.tang.custom;

import keyon.tang.entity.Shop;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/10 19:47
 * @Version 1.0
 */
public class ShopCustom extends Shop {
    private MultipartFile imgFile;

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    @Override
    public String toString() {
        return "ShopCustom{" +
                "imgFile=" + imgFile +
                '}'+super.toString();
    }
}
