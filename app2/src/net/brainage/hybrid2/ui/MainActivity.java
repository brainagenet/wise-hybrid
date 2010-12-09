/*
 * (#) net.brainage.hybrid2.ui.MainActivity
 * Created on 2010. 11. 10
 */
package net.brainage.hybrid2.ui;

import android.os.Bundle;

import com.phonegap.DroidGap;

/**
 * 
 * 
 * @author ms29.seo@gmail.com
 * @version 1.0
 */
public class MainActivity extends DroidGap {
    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
    
}