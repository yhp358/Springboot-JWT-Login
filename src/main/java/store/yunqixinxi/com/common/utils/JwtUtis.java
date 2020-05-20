package store.yunqixinxi.com.common.utils;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import store.yunqixinxi.com.common.consts.StoreConsts;
import store.yunqixinxi.com.model.common.TokenModel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtis {

    private static final Logger log = LoggerFactory.getLogger(JwtUtis.class);
    private static final String CALIMS_ID = "jti";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiresTime}")
    private Long expiresTime;

    @Autowired
    private RedisService redisService;

    public String createJWT(TokenModel model){
        //创建tokenid
        String tokenId = "token"+model.getStorecode()+"-"+ UUID.randomUUID().toString();
        log.info("生成的tokenid为. {}",tokenId);
        model.setTokenId(tokenId);
        String storename = model.getStorename();//0企业1单店
        String token = createToken(model);
        boolean result = false;
        if(storename.equals("1")){
            result = redisService.set(tokenId, model, expiresTime);
        }else{
            result = redisService.set(tokenId, model, 3000L);
        }
        if(!result){
            log.info("获取token失败");
        }
        return token;
    }

    /**
     * 创建token
     * @param model
     * @return
     */
    public String createToken(TokenModel model){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        //组装载荷信息中的数据
        Map<String, Object> calims = new HashMap<>();
        calims.put(CALIMS_ID,model.getTokenId());
        calims.put(StoreConsts.KEY_STORE_CODE,model.getStorecode());
        calims.put(StoreConsts.KEY_STORE_NAME,model.getStorename());
        calims.put(StoreConsts.KEY_USER_NAME,model.getUsername());
        calims.put(StoreConsts.KEY_TELEPHONE,model.getTelephone());
        JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ", "JWT").setClaims(calims).signWith(signatureAlgorithm, secret);
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 验证token
     */
    public boolean volidteToken(String token,String requestStoreCode){
        try {
            if(StringUtils.isEmpty(token)){
                return false;
            }
            if(StringUtils.isEmpty(requestStoreCode)){
                return false;
            }
            String tokenId = getFromToken(token);
            //判断redis中是否有此token
            if(!redisService.exists(tokenId)){
                return false;
            }
            TokenModel model = (TokenModel) redisService.get(tokenId);
            if(!model.getStorecode().equals(requestStoreCode)){
                redisService.remove(tokenId);
                return false;
            }
            Long expire = redisService.getexpire(tokenId);
            //判断过期时间小于
            if(expire<=300){
                redisService.setExpire(tokenId,expiresTime);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("验证token报错");
            return false;
        }
    }
    /**
     * 根据token取出calims
     */
    public Jws<Claims> getClamsFromToken(String token){
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            claims = null;
        }
        return claims;
    }

    /**
     * 获取token中的id
     * @param token
     * @return
     */
    public String getFromToken(String token){
        Jws<Claims> claims = getClamsFromToken(token);
        String tokenid = (String)claims.getBody().get(CALIMS_ID);
        return tokenid;
    }
}
