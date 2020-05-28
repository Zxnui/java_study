package nettyTls;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;

public class ServerContext {
    private static SSLContext SERVER_CONTEXT;
    private static final String PROTOCOL = "TLS";
    private static String PASSWD = "123456";
    private static String KEYTYPE = "pkcs12";

    static {
        SERVER_CONTEXT = null;

        try{
            KeyStore ks = KeyStore.getInstance(KEYTYPE);
            ks.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\server.keystore"),PASSWD.toCharArray());
            //服务端私钥
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks,PASSWD.toCharArray());

            KeyStore ts = KeyStore.getInstance(KEYTYPE);
            ts.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\server_trust.keystore"),PASSWD.toCharArray());
            //服务端信任的客户端公钥
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(ts);

            SERVER_CONTEXT = SSLContext.getInstance(PROTOCOL);
            SERVER_CONTEXT.init(kmf.getKeyManagers(),tmf.getTrustManagers(),null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static SSLContext getSSLContext (){
        return SERVER_CONTEXT;
    }
}
