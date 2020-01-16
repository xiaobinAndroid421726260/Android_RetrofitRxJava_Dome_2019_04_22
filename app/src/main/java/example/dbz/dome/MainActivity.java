package example.dbz.dome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import example.dbz.dome.api.ApiService;
import example.dbz.dome.bean.BaseResponse;
import example.dbz.dome.http.BaseObserver;
import example.dbz.dome.http.RetrofitManager;
import example.dbz.dome.utils.ToastUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String url = "https://域名/api/quesTeacher";

    private TextView tv_review_result_review_loan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_review_result_review_loan = findViewById(R.id.tv_review_result_review_loan);

        Map<String, String> params = new HashMap<>();
        params.put("userToken", "c5472bd21ea71229d3e6de99d656affd");
        // **********第一种请求
        RetrofitManager.getInstance().postData(url, params, BaseResponse.class, new BaseObserver<BaseResponse>() {
            @Override
            public void onSucceed(BaseResponse result) {
                ToastUtils.showToast("----成功了");
                tv_review_result_review_loan.setText("请求成功了");
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastUtils.showToast("----失败了");
                tv_review_result_review_loan.setText("请求失败了");
            }
        });

        // **********第二种请求
        RetrofitManager.toSubscribe(RetrofitManager.getInstance()
                .create(ApiService.class)
                .getBaseResponse(params), new BaseObserver<BaseResponse>() {
            @Override
            public void onSucceed(BaseResponse result) {
                ToastUtils.showToast("----成功了");
                tv_review_result_review_loan.setText("请求成功了");
            }

            @Override
            public void onFailed(int code, String msg) {
                ToastUtils.showToast("----失败了");
                tv_review_result_review_loan.setText("请求失败了");
            }
        });

        // **********第三种请求
        RetrofitManager.getInstance()
                .create(ApiService.class)
                .getBaseResponse(params)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        // 下面的用一种就可以
                        new BaseObserver<BaseResponse>() {
                            @Override
                            public void onSucceed(BaseResponse result) {
                                ToastUtils.showToast("----成功了");
                                tv_review_result_review_loan.setText("请求成功了");
                            }

                            @Override
                            public void onFailed(int code, String msg) {
                                ToastUtils.showToast("----失败了");
                                tv_review_result_review_loan.setText("请求失败了");
                            }
                        }
//                        new Observer<BaseResponse>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseResponse homeBean) {
//                        ToastUtils.showToast("----成功了");
//                        tv_review_result_review_loan.setText("请求成功了");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showToast("----失败了");
//                        tv_review_result_review_loan.setText("请求失败了");
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                }
                );
    }

}