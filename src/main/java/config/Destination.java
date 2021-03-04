package config;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/*
 * Tunnel routing node configuration
 * */
@Configuration
public class Destination {

    private static final Logger log = LoggerFactory.getLogger(Destination.class);

    public static String ip;
    public static Integer port;

    @Value("${destination.ip}")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    @Value("${destination.port}")
    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }

    // String myIp, Integer myNonUsePort
    public static void portForward(Session session) throws JSchException {
        Integer assignedPort = session.setPortForwardingL(My.ip, My.port, Destination.ip, Destination.port);

        log.info(My.ip + ":" + My.port);
        log.info(" ↔ ROUTE (entrance of the tunnel) " + Router.ip + ":" + Router.port);
        log.info(" ↔ DESTINATION (destination of the tunnel) " + Destination.ip + ":" + Destination.port);
    }
}