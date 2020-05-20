package store.yunqixinxi.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@EnableScheduling
@EnableSwagger2
@MapperScan(basePackages = "store.yunqixinxi.com.mapper")
public class Application {//入口启动类
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
