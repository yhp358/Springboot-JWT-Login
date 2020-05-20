package store.yunqixinxi.com.model.dto;


import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
public class StoreLoginDto implements Serializable {

    @Length(min = 11,max = 11,message = "手机号格式错误")
    @NotNull
    private String linkMobile;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "是否是企业能录不能为空")
    private String isCompany;

    public String getLinkMobile() {
        return linkMobile;
    }

    public void setLinkMobile(String linkMobile) {
        this.linkMobile = linkMobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsCompany() {
        return isCompany;
    }

    public void setIsCompany(String isCompany) {
        this.isCompany = isCompany;
    }
}
