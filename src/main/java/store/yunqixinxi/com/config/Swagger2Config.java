package store.yunqixinxi.com.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("会员管理")
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.or(PathSelectors.regex("/api/card/.*")))
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多请关注http://www.baidu.com")
                .termsOfServiceUrl("http://www.baidu.com")
                .contact(new Contact("yhp","","136517215"))
                .version("1.0")
                .build();
    }
    @Bean
    public Docket RestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("卡类管理")
                .apiInfo(restapiInfo())
                .select()
                .paths(Predicates.or(PathSelectors.regex("/api/cardtype/.*")))
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo restapiInfo() {
        return new ApiInfoBuilder()
                .title("卡类管理")
                .description("更多请关注http://www.baidu.com")
                .termsOfServiceUrl("http://www.tsl.com")
                .contact(new Contact("yhp","","12130840"))
                .version("1.0")
                .build();
    }
}
