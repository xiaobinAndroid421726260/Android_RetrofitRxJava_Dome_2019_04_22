package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.api;

import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.bean.HomeBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.util.Map;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/23 9:37
 * @version V1.0
 */
public interface ApiService {

    @POST(HttpsApi.quesTeacher)
    Observable<ResponseBody> getResponseBody(@QueryMap Map<String, String> map);

    @POST(HttpsApi.quesTeacher)
    Observable<HomeBean> getHomeBean(@QueryMap Map<String, String> map);
}
