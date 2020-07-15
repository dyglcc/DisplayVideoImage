package com.display.displayvideoimage.core;

import android.os.Build;
import android.text.TextUtils;

import java.io.IOException;
import java.util.Map;

import androidx.annotation.RequiresApi;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetWorkUtils {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String  sendMessge(String url, Map<String, String> map) {
        if (!TextUtils.isEmpty(url)) {
            OkHttpClient client = new OkHttpClient();
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry entry : map.entrySet()) {
                builder.add((String) entry.getKey(), (String) entry.getValue());
            }
            RequestBody body = builder.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
