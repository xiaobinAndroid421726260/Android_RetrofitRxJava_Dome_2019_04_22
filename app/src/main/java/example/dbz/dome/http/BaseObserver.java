package example.dbz.dome.http;

import android.net.ParseException;
import com.google.gson.JsonParseException;
import example.dbz.dome.R;
import example.dbz.dome.utils.ToastUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.json.JSONException;
import retrofit2.HttpException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

/**
 * description:
 *
 * @author Db_z
 * date 2019/4/23 10:31
 * @version V1.0
 */
public abstract class BaseObserver<T> implements Observer<T> {

    /**
     * 这里可以封装加载的动画
     * 在 onStart() 里面写开始加载动画
     * 在 onComplete() 里面写结束动画
     */

    public abstract void onSucceed(T result);

    public abstract void onFailed(int code, String msg);

//    @Override
//    protected void onStart() {
//        super.onStart();
//    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T result) {
        onSucceed(result);
    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {     //   HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException || e instanceof UnknownHostException) { // 连接错误
            onException(ExceptionReason.CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {  //  连接超时
            onException(ExceptionReason.CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException || e instanceof JSONException
                || e instanceof ParseException) {  //  解析错误
            onException(ExceptionReason.PARSE_ERROR);
        } else {
            onException(ExceptionReason.UNKNOWN_ERROR);
        }

        onFailed(-1, e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    private void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtils.showToast(R.string.common_connect_error);
                break;
            case CONNECT_TIMEOUT:
                ToastUtils.showToast(R.string.common_connect_timeout);
                break;
            case BAD_NETWORK:
                ToastUtils.showToast(R.string.common_bad_network);
                break;
            case PARSE_ERROR:
                ToastUtils.showToast(R.string.common_parse_error);
                break;
            case UNKNOWN_ERROR:
            default:
                ToastUtils.showToast(R.string.common_unknown_error);
                break;
        }
    }

    public enum ExceptionReason {
        PARSE_ERROR,
        BAD_NETWORK,
        CONNECT_ERROR,
        CONNECT_TIMEOUT,
        UNKNOWN_ERROR,
    }
}