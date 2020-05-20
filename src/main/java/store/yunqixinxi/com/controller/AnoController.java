package store.yunqixinxi.com.controller;

import com.eheart.common.entity.RRGenerator;
import com.eheart.common.entity.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import store.yunqixinxi.com.common.utils.JwtUtis;
import store.yunqixinxi.com.model.common.TokenModel;
import store.yunqixinxi.com.model.dto.StoreLoginDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/anon")
public class AnoController {
    @Autowired
    private JwtUtis jwtUtis;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResult<String> login(@Valid @RequestBody StoreLoginDto dto){
        String linkMobile = dto.getLinkMobile();
        String password = dto.getPassword();
        String isCompany = dto.getIsCompany();

        String token = null;
        if("12345678900".equals(linkMobile) && "123456".equals(password)){
            TokenModel tokenModel = new TokenModel();
            tokenModel.setStorecode("100000012");
            tokenModel.setStorename("全聚德烤鸭店");
            tokenModel.setTelephone(dto.getLinkMobile());
            tokenModel.setUsername("王老吉");
            token = jwtUtis.createJWT(tokenModel);
        }else{
            return RRGenerator.error("登陆失败，手机号或密码错误");
        }
        return RRGenerator.success(token,"登陆成功");
    }
}
