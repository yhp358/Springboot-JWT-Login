package store.yunqixinxi.com.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mapper")
public class Config {
    private String mappers;

    private String identy;
}
