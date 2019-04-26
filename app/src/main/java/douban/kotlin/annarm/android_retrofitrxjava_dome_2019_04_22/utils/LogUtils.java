package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.utils;

import android.util.Log;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/23 14:19
 * @version V1.0
 */
public class LogUtils {

    private static final String TAG = "-----LogUtils";

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void w(String msg) {
        Log.w(TAG, msg);
    }
}
