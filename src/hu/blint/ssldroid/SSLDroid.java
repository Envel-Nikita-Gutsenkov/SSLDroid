package hu.blint.ssldroid;

import hu.blint.ssldroid.TcpProxy;
import android.app.*;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SSLDroid extends Service {

	final String TAG = "SSLDroid";
	
	@Override
    public void onCreate() {
		Toast.makeText(this, "SSLDroid Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
    }

	@Override
	public void onStart(Intent intent, int startid) {

        int listenPort = 9999; // port to listen on
        int targetPort = 443;   // port to connect to
        String targetHost = "sogo.balabit.com"; //remote host
        String keyFile = "/mnt/sdcard/blint-imaps.p12";
        String keyPass = "titkos";

		Toast.makeText(this, "SSLDroid Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
        
      	TcpProxy tp = new TcpProxy();
       	try {
        	   tp.serve(listenPort, targetHost, targetPort, keyFile, keyPass);
       	} catch (Exception e) {
       		Toast.makeText(this, "SSLDroid Sulyos Errorhiba" + e.getMessage(), Toast.LENGTH_LONG).show();
       	}
	}
    
    @Override
    public IBinder onBind(Intent intent) {
    	  return null;
    	}

    @Override
    public void onDestroy() {
    }
}

/*public class SSLDroid
{

	public static final int listenPort = 9999, // port to listen on
    targetPort = 443;   // port to connect to
    public static final String targetHost = "sogo.balabit.com"; //remote host
    static String keyFile = "/home/blint/vpn/blint-imaps.p12";
    static String keyPass = "titkos";

    public static void main(String[] args) {
    	TcpProxy tp = new TcpProxy();
    	try {
    	   tp.serve(listenPort, targetHost, targetPort, keyFile, keyPass);
    	} catch (Exception e) {
    	}
    }
} */
