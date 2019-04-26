package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.factory;

import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.App;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.utils.NetUtils;
import okhttp3.*;

import java.io.IOException;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/23 15:03
 * @version V1.0
 */
public class CacheInterceptor implements Interceptor {

    private static final String CACHE_NAME = App.getInstance().getPackageName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetUtils.isNetworkConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response response = chain.proceed(request);
        if (!NetUtils.isNetworkConnected()) {
            int maxAge = 0;
            // 有网络时 设置缓存超时时间0个小时
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader(CACHE_NAME)// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build();
        } else {
            // 无网络时，设置超时为4周
            int maxStale = 60 * 60 * 24 * 28;
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader(CACHE_NAME)
                    .build();
        }
        return response;
    }
}
