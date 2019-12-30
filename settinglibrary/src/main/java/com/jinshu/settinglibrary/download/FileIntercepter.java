package com.jinshu.settinglibrary.download;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Create on 2019/8/29 09:33 by bll
 */


public class FileIntercepter implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new FileResponseBody(originalResponse))
                .build();
    }
}
