package nettyTls;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;

public class ClientContext {
    private static SSLContext CLIENT_CONTEXT;
    private static final String PROTOCOL = "TLS";
    private static String PASSWD = "123456";
    private static String KEYTYPE = "pkcs12";

    static {
        CLIENT_CONTEXT = null;

        try{
            KeyStore ks = KeyStore.getInstance(KEYTYPE);
            ks.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\client.keystore"),PASSWD.toCharArray());
            //客户端私钥
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks,PASSWD.toCharArray());

            KeyStore ts = KeyStore.getInstance(KEYTYPE);
            ts.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\client_trust.keystore"),PASSWD.toCharArray());
            //客户端信任的服务端公钥
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(ts);

            CLIENT_CONTEXT = SSLContext.getInstance(PROTOCOL);
            CLIENT_CONTEXT.init(kmf.getKeyManagers(),tmf.getTrustManagers(),null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static SSLContext getSSLContext (){
        return CLIENT_CONTEXT;
    }
}
