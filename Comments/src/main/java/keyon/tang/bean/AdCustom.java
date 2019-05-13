package keyon.tang.bean;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 20:49
 * @Version 1.0
 */

import keyon.tang.po.Ad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * 自定义拓展类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AdCustom extends Ad {
    private String img;
    private MultipartFile imgFile;


    @Override
    public String toString() {
        return super.toString();
    }
}
