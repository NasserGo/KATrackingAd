package addemo.android.appicplay.com.appicdemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.ap.android.trunk.sdk.core.APApplication;


public class XApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public Context getBaseContext() {
        return APApplication.getBaseContext(super.getBaseContext());
    }
}
