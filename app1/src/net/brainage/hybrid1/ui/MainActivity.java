/*
 * (#) net.brainage.hybrid1.ui.MainActivity
 * Created on 2010. 11. 8
 */
package net.brainage.hybrid1.ui;

import net.brainage.hybrid1.R;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * 
 * 
 * @author ms29.seo@gmail.com
 * @version 1.0
 */
public class MainActivity extends Activity
{

    /**
     * 
     */
    private static final boolean DEBUG = true;

    /**
     * 
     */
    private static final String TAG = "MainActivity";

    /**
     * 
     */
    private WebView mBrowser;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "create " + TAG + " ...");

        initActivity();
    }

    /**
     * 
     */
    private void initActivity() {
        Log.i(TAG, "start initActivity() ...");

        mBrowser = (WebView) findViewById(R.id.web_view);

        // clear cache
        mBrowser.clearCache(true);

        // this is necessary for "alert()" to work
        mBrowser.setWebChromeClient(new WebChromeClient());

        // get settings so we can config our WebView instance
        WebSettings settings = mBrowser.getSettings();

        // JavaScript?  Of course!
        settings.setJavaScriptEnabled(true);

        // add our custom functionality to the javascript environment
        mBrowser.addJavascriptInterface(new AndroidInfoHandler(), "android");

        // add our custom functionality to the javascript environment
        // mBrowser.addJavascriptInterface(new CalculatorHandler(), "calc");

        // load a page to get things started
        mBrowser.loadUrl("file:///android_asset/www/index.html");
    }

    /**
     * Android Information JavaScript Handler
     * 
     * @author ms29.seo@gmail.com
     * @version 1.0
     */
    final class AndroidInfoHandler
    {

        /**
         * @return
         */
        public String getManufacture() {
            if ( DEBUG ) {
                Log.d(TAG, "manufacture : " + Build.MANUFACTURER);
            }
            return Build.MANUFACTURER;
        }

        /**
         * @return
         */
        public String getModel() {
            if ( DEBUG ) {
                Log.d(TAG, "model : " + Build.MODEL);
            }
            return Build.MODEL;
        }

        /**
         * @return
         */
        public String getProduct() {
            if ( DEBUG ) {
                Log.d(TAG, "product : " + Build.PRODUCT);
            }
            return Build.PRODUCT;
        }
        
        /**
         * @return
         */
        public String getCodename() {
            return Build.VERSION.CODENAME;
        }

    }

}