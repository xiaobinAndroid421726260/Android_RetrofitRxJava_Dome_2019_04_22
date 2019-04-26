package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static App sInstance;
    private static Context sContext;

    public static App getInstance() {
        return sInstance;
    }

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sContext = getApplicationContext();
    }
}