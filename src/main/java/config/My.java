package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class My {
    private static final Logger log = LoggerFactory.getLogger(Router.class);

    public static String ip;
    public static Integer port;

    @Value("${server.ip}")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    @Value("${server.port}")
    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }

}
