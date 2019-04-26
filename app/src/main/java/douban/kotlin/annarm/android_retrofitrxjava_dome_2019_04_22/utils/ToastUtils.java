package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.utils;

import android.content.Context;
import android.widget.Toast;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.App;

/**
 * Created by admin on 2017/12/26.
 */

public class ToastUtils {
    /** 之前显示的内容 */
    private static String oldMsg ;
    /** Toast对象 */
    private static Toast toast = null ;
    /** 第一次时间 */
    private static long oneTime = 0 ;
    /** 第二次时间 */
    private static long twoTime = 0 ;


    /**
     *
     * @param message
     */
    public static void showToast(String message){
        showToast(App.getContext(), message);
    }
    /**
     *
     * @param res
     */
    public static void showToast(int res){
        showToast(App.getContext(), App.getContext().getString(res));
    }
    /**
     * 显示Toast
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message){
        if(toast == null){
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show() ;
            oneTime = System.currentTimeMillis() ;
        }else{
            twoTime = System.currentTimeMillis() ;
            if(message.equals(oldMsg)){
                if(twoTime - oneTime > Toast.LENGTH_SHORT){
                    toast.show() ;
                }
            }else{
                oldMsg = message ;
                toast.setText(message) ;
                toast.show() ;
            }
        }
        oneTime = twoTime ;
    }
}
