package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http;

import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.Map;

/**
 * description:
 * Retrofit管理类：
 * 支持api接口模式 (Api 接口服务类， 注解模式) api接口需要自己实现
 * 支持传统模式 (参数：请求的url，POST的传参 Map, 实体类， 接口回调)
 *
 * @author Db_z
 * date 2019/4/23 11:09
 * @version V1.0
 */
public class RetrofitManager {

    private static RetrofitFactory sRetrofitFactory;

    public static RetrofitManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();

    }

    private RetrofitManager() {
        sRetrofitFactory = RetrofitFactory.getInstance();
    }


    /**
     * APi接口服务类
     */
    public <T> T create(Class<T> service) {
        return sRetrofitFactory.create(service);
    }


    /**
     * 改变baseUrl
     */
    public void changeBaseUrl(String baseUrl) {
        sRetrofitFactory.changeBaseUrl(baseUrl);
    }


    /**
     * 支持自己定义事件处理
     * 设置订阅 和 所在的线程环境
     */
    public static <T> void toSubscribe(Observable<T> observable, BaseObserver<T> baseObserver) {
        sRetrofitFactory.toSubscribe(observable, baseObserver);
    }


    /**
     * 支持自己定义事件处理
     * 设置订阅 和 所在的线程环境
     */
    public static <T> void toSubscribe(Observable<T> observable, Observer<T> observer) {
        sRetrofitFactory.toSubscribe(observable, observer);
    }


    /**
     * 传统模式传参
     */
    public <T> void postData(final String url, final Map<String, String> params, final Class<T> clz, final Observer<T> observer) {
        sRetrofitFactory.postData(url, params, clz, observer);
    }


}
