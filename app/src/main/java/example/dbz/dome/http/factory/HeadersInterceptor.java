package example.dbz.dome.http.factory;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/22 17:01
 * @version V1.0 头信息
 */
public class HeadersInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder requestBuilder = originalRequest.newBuilder();
        requestBuilder.addHeader("Content-Type", "text/html; charset=UTF-8")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("Accept-Encoding", "Vary")
                .method(originalRequest.method(), originalRequest.body())
                .build();
        return chain.proceed(requestBuilder.build());
    }
}
