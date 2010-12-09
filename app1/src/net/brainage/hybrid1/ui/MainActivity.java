/*
 * (#) net.brainage.hybrid1.ui.MainActivity
 * Created on 2010. 11. 8
 */
package net.brainage.hybrid1.ui;

import net.brainage.hybrid1.AppConstants;
import net.brainage.hybrid1.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
    private static final boolean DEBUG = AppConstants.DEBUG;

    /**
     * 
     */
    private static final String TAG = "MainActivity";

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ( DEBUG ) {
            Log.d(TAG, "create " + TAG + " ...");
        }

        setContentView(R.layout.activity_main);
    }

    /**
     * @param v
     */
    public void onClickBasicExample1(View v) {
        Intent intent = new Intent(AppConstants.ACTION_VIEW_BASICEXAMPLE1);
        startActivity(intent);
    }
    
    /**
     * @param v
     */
    public void onClickBasicExample2(View v) {
        Intent intent = new Intent(AppConstants.ACTION_VIEW_BASICEXAMPLE2);
        startActivity(intent);
    }

}