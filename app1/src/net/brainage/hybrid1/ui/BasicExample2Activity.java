/*
 * (#) net.brainage.hybrid1.ui.BasicExample2Activity
 * Created on 2010. 11. 9
 */
package net.brainage.hybrid1.ui;

import net.brainage.hybrid1.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 
 * @author ms29.seo@gmail.com
 * @version 1.0
 */
public class BasicExample2Activity extends Activity
{

    /**
     * 
     */
    private static final boolean DEBUG = true;

    /**
     * 
     */
    private static final String TAG = "BasicExample2Activity";

    /**
     * 
     */
    private final Handler handler = new Handler();

    /**
     * 
     */
    private WebView mBrowser;

    /**
     * 
     */
    private TextView mWebMessage;

    /**
     * 
     */
    private EditText mTextMessage;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_example2);
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

        // load a page to get things started
        mBrowser.loadUrl("file:///android_asset/www/index2.html");

        mWebMessage = (TextView) findViewById(R.id.web_message);
        mTextMessage = (EditText) findViewById(R.id.text_message);
    }

    /**
     * @param v
     */
    public void sendMessageOnClick(View v) {
        Log.i(TAG, "start sendMessageOnClick() ...");
        mBrowser.loadUrl("javascript:setMessage('" + mTextMessage.getText().toString() + "')");
    }

    /**
     * 
     * @author ms29.seo@gmail.com
     * @version 1.0
     */
    final class AndroidInfoHandler
    {
        /**
         * @param message
         */
        public void setMessage(final String message) {
            Log.i(TAG, "start AndroidInfoHandler.setMessage() ...");
            handler.post(new Runnable() {
                public void run() {
                    mWebMessage.setText(message);
                }
            });
        }
    }

}
