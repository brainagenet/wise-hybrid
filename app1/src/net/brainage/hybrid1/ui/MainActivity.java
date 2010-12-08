/*
 * (#) net.brainage.hybrid1.ui.MainActivity
 * Created on 2010. 11. 8
 */
package net.brainage.hybrid1.ui;

import net.brainage.hybrid1.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * 
 * @author ms29.seo@gmail.com
 * @version 1.0
 */
public class MainActivity extends Activity
{

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}