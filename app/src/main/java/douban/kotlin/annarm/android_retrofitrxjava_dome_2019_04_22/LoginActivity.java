package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.api.ApiService;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.bean.HomeBean;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.BaseObserver;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.RetrofitFactory;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.RetrofitManager;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.utils.LogUtils;
import douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.utils.ToastUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String url = "http://www.local.tongyi.com/api/quesTeacher";

    private TextView tv_review_result_review_loan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_review_result_review_loan = findViewById(R.id.tv_review_result_review_loan);

        Map<String, String> params = new HashMap<>();
        params.put("userToken", "c5472bd21ea71229d3e6de99d656affd");
        RetrofitManager.getInstance().postData(url, params, HomeBean.class, new BaseObserver<HomeBean>() {
            @Override
            public void onSucceed(HomeBean result) {
                ToastUtils.showToast("----成功了");
                tv_review_result_review_loan.setText("请求成功了");
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastUtils.showToast("----失败了");
                tv_review_result_review_loan.setText("请求失败了");
            }
        });


        RetrofitManager.toSubscribe(RetrofitManager.getInstance().create(ApiService.class).getHomeBean(params), new BaseObserver<HomeBean>() {
            @Override
            public void onSucceed(HomeBean result) {
                ToastUtils.showToast("----成功了");
                tv_review_result_review_loan.setText("请求成功了");
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastUtils.showToast("----失败了");
                tv_review_result_review_loan.setText("请求失败了");
            }
        });


        RetrofitManager.getInstance()
                .create(ApiService.class)
                .getHomeBean(params)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        ToastUtils.showToast("----成功了");
                        tv_review_result_review_loan.setText("请求成功了");
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showToast("----失败了");
                        tv_review_result_review_loan.setText("请求失败了");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
