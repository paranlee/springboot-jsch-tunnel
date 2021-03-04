package tunnel;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import config.Destination;
import config.Router;

import java.util.Properties;

public class Tunnel {

    public Tunnel(){
        this.connect();
    }

    private Session session;

    private Session createSession() throws JSchException {

        JSch jsch = new JSch();

        session = jsch.getSession(Router.name, Router.ip, Router.port);
        session.setPassword(Router.password);

        Properties props = new Properties();
        props.put("StrictHostKeyChecking", "no");
        session.setConfig(props);

        session.connect();

        return session;
    }

    /* this example do like ssh tunneling command
     * ssh -N -T -l [USER] -L[LOCAL_PC_PORT]:[TUNNER_DEST_DB_IP]:[TUNNER_DEST_DB_PORT] [LOCAL_CONNECTED_SSH_SERVER]
     *
     * ## VARIABLE ##
     * @ The local port is [LOCAL_PC_PORT] (The port of your machine)
     * @ [LOCAL_TO_SSH_SERVER] is the server to reach
     * @ [TUNNER_DEST_DB_IP] port is [TUNNER_DEST_DB_PORT]
     * @ [LOCAL_CONNECTED_SSH_SERVER] loginName is [USER]
     *
     * ## FLAG ##
     * @ N means no remote command
     * @ T disables pseudo-tty allocation (No terminal)
     * */
    private void connect() {
        try {
            Session session = this.createSession();

            // hey destination. sticky to here.
            Destination.portForward(session);

        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() {
        session.disconnect();
    }

}