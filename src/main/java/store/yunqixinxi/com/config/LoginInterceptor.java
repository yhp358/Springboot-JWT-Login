package store.yunqixinxi.com.config;

import com.alibaba.fastjson.JSONObject;
import com.eheart.common.entity.RRGenerator;
import com.eheart.common.entity.RestStatus;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import store.yunqixinxi.com.common.consts.StoreConsts;
import store.yunqixinxi.com.common.utils.JwtUtis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Value("${isTest}")
    private boolean isTest;

    @Value("${auth.noauth.url}")
    private String noAuthUrl;

    @Autowired
    private JwtUtis jwtUtis;

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    //控制器执行之前进行拦截调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            //如果是测试环境的话放行
            if(isTest){
                return true;
            }
            //排除不拦截的路径
            String requestURI = request.getRequestURI();
            if(!StringUtils.isEmpty(requestURI) && validate(requestURI)){
                return true;
            }
            //验证token
            String storeCode = request.getHeader(StoreConsts.KEY_STORE_CODE);
            String token = request.getHeader(StoreConsts.AUTHORIZATION);

            boolean b = jwtUtis.volidteToken(token, storeCode);
            PrintWriter out = null;
            if(!b){
                try {
                    response.setContentType("text/html;charset=UTF-8");
                    response.setStatus(RestStatus.OK.value());
                    String ss = JSONObject.toJSONString(RRGenerator.error(RestStatus.UNAUTHORIZED.value(), "登陆验证失败，请重新登陆"));
                    out = response.getWriter();
                    out.append(ss);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (out != null) {
                        out.close();
                    }
                }
                return false;
            }
            return true;
    }

    private boolean validate(String servletPath) {
        String[] urls = noAuthUrl.split(",");
        for (String pattern : urls) {
            AntPathMatcher matcher = new AntPathMatcher();
            if (matcher.match(pattern, servletPath)) {
                return true; //不执行过滤
            }
        }
        return false;
    }
}
