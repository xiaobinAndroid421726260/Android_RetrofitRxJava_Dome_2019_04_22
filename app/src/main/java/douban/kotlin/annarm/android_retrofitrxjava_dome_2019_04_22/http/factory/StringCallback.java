package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.http.factory;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class StringCallback implements Callback {

    protected abstract void onFailure(IOException e);

    protected abstract void onResponse(String response);


    @Override
    public void onFailure(Call call, IOException e) {
        onFailure(e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()){
            final String result = response.body().string();
            if (result.equals("") && result == null && result.trim().length() == 0) return;
            onResponse(result);
        }
    }
}
