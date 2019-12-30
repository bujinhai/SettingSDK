package com.jinshu.settinglibrary.download;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Create on 2019/8/29 17:24 by bll
 */


public class FileSubscriber<T> implements Observer<T> {

    private FileCallback fileCallback;

    public FileSubscriber(FileCallback fileCallback) {
        this.fileCallback = fileCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (fileCallback != null) {
            fileCallback.onStart();
        }
    }

    @Override
    public void onNext(T t) {
        if (fileCallback != null) {
            fileCallback.onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (fileCallback != null) {
            fileCallback.onError(e);
        }
    }

    @Override
    public void onComplete() {
        if (fileCallback != null) {
            fileCallback.onCompleted();
        }
    }
}
