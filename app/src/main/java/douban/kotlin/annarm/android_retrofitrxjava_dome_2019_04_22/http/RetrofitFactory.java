package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.orhanobut.logger.Logger;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.App;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.api.HttpsApi;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.factory.CacheInterceptor;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.factory.HeadersInterceptor;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.factory.StringCallback;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.factory.StringTypeAdapter;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.utils.GsonUtils;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/22 16:17
 * @version V1.0
 */
public class RetrofitFactory {

    private static final String CACHE_NAME = App.getInstance().getPackageName();
    private static final String BASE_URL = HttpsApi.BASE_URL;
    private static final int DEFAULT_CONNECT_TIMEOUT = 20;
    private static final int DEFAULT_WRITE_TIMEOUT = 20;
    private static final int DEFAULT_READ_TIMEOUT = 20;
    private OkHttpClient mOkHttpClient;
    private OkHttpClient.Builder mOkHttpClientBuilder;
    private Retrofit mRetrofit;

    public static RetrofitFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();

    }

    private RetrofitFactory() {
        mOkHttpClientBuilder = new OkHttpClient.Builder();
        /**
         * 设置缓存
         */
        File cacheFile = new File(App.getContext().getExternalCacheDir(), CACHE_NAME);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        mOkHttpClientBuilder.cache(cache);
        mOkHttpClientBuilder.addInterceptor(new CacheInterceptor());
        // 设置超时时间
        mOkHttpClientBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        mOkHttpClientBuilder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
        mOkHttpClientBuilder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
        mOkHttpClientBuilder.retryOnConnectionFailure(true); // 连接失败时重试
        // 添加日志拦截器
        mOkHttpClientBuilder.addInterceptor(loggingInterceptor());
        // 添加头部拦截器
        mOkHttpClientBuilder.addInterceptor(new HeadersInterceptor());
        mOkHttpClient = mOkHttpClientBuilder.build();
        changeBaseUrl(BASE_URL);
    }


    /**
     * APi接口服务类
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }


    /**
     * 支持自己定义事件处理
     * 设置订阅 和 所在的线程环境
     */
    public <T> void toSubscribe(Observable<T> observable, BaseObserver<T> baseObserver) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseObserver);
    }

    /**
     * 支持自己定义事件处理
     * 设置订阅 和 所在的线程环境
     */
    public <T> void toSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    /**
     * 传统模式解析
     */
    public <T> void postData(final String url, final Map<String, String> params, final Class<T> clz, final Observer<T> observer){
        Observable<T> observable = Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(final ObservableEmitter<T> emitter) throws Exception {
                mOkHttpClient.newCall(buildPostRequest(url, params)).enqueue(new StringCallback() {
                    @Override
                    protected void onFailure(IOException e) {
                        emitter.onError(e);
                    }

                    @Override
                    protected void onResponse(String response) {
                        T result = GsonUtils.fromJson(response, clz);
                        if (result != null){
                            emitter.onNext(result);
                        } else {
                            emitter.onError(new JsonSyntaxException(response));
                        }
                    }
                });
            }
        });

        toSubscribe(observable, observer);
    }


    /**
     * 请求的网址， 拼接请求的参数
     */
    private Request buildPostRequest(String url, Map<String, String> params) {
        if (params.isEmpty() || params == null || params.size() == 0) {
            params = new HashMap<>();
        }

        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合拼接参数
        Set set = params.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) i.next();
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody requestBody = builder.build();
        return new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
    }

    /**
     * 改变baseUrl
     */
    public void changeBaseUrl(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(StringTypeGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }


    /**
     * 解析把null转换成""
     */
    private Gson StringTypeGson() {
        Gson mGson = new GsonBuilder()
                //设置时间格式
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                //设置解析的时候把null转换成""
                .registerTypeHierarchyAdapter(String.class, new StringTypeAdapter())
                .create();
        return mGson;
    }


    /**
     * 添加日志拦截器
     */
    private HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Logger.e(message);
            }
        });
        // 设置日志级别
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}