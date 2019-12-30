package com.jinshu.settinglibrary.download;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Create on 2019/9/10 17:31 by bll
 */


public class DownloadManager {

    public void load(String url, final FileCallback callback) {
        DownloadRetrofit.getInstance()
                .getApiService()
                .downLoadFile(url)
                .subscribeOn(Schedulers.io())//请求网络 在调度者的io线程
                .observeOn(Schedulers.io()) //指定线程保存文件
                .doOnNext(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        callback.saveFile(responseBody);
                    }
                }).observeOn(AndroidSchedulers.mainThread()) //在主线程中更新ui
                .subscribe(new FileSubscriber<ResponseBody>(callback));
    }
}
