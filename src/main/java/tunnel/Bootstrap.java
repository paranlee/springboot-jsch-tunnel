package tunnel;

import config.Destination;
import config.Router;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@Component
public class Bootstrap {

    public Bootstrap() {}

    private Tunnel tunnel;

    // this simulates a new client sending a message
    // realistic these clients come all the time
    @EventListener(ApplicationReadyEvent.class)
    public void startup() throws InterruptedException {
        this.tunnel = new Tunnel();
    }
}