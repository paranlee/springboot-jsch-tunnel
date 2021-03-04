package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/*
 * Tunnel routing node configuration
 * */
@Configuration
public class Router {

    private static final Logger log = LoggerFactory.getLogger(Router.class);

    public static String name;
    public static String password;
    public static String ip;
    public static Integer port;

    @Value("${router.name}")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Value("${router.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    @Value("${router.ip}")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    @Value("${router.port}")
    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }
}