package com.jinshu.settinglibrary.download;


import com.jinshu.settinglibrary.base.baserx.SRxBus;
import com.jinshu.settinglibrary.utils.LibraryFileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * @author bll
 * @package com.bll.framework.download
 * @date 2018/4/17  14:12
 * @describe 一个抽象类实现了在里面利用IO流把文件保存到了本地
 * 定义了两个抽象方法让子类实现，onSuccess()当读写完成之后将文件回调给实现类以便安装apk，
 * onLoading()在文件读写的过程中通过订阅下载的进度把进度信息progress和total回调给实现类以便在通知中实时显示进度信息
 */


public abstract class FileCallback<T> {

    /**
     * 订阅下载进度
     */
    private CompositeDisposable rxSubscriptions = new CompositeDisposable();

    /**
     * 目标文件存储的文件名
     */
    private String destFileName;

    public FileCallback(String destFileName) {
        this.destFileName = destFileName;
        subscribeLoadProgress();// 订阅下载进度
    }

    /**
     * 成功后回调
     */
    public abstract void onSuccess(T t);

    /**
     * 下载过程回调
     */
    public abstract void onLoading(long progress, long total);

    /**
     * 开始下载回调
     */
    public void onStart(){
    }

    /**
     * 下载完成回调
     */
    public abstract void onCompleted();

    /**
     * 下载错误回调
     *
     * @param e
     */
    public abstract void onError(Throwable e);

    /**
     * 通过IO流写入文件
     *
     * @param response
     */
    public void saveFile(ResponseBody response) throws IOException {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len;
        FileOutputStream fos = null;
        try {
            is = response.byteStream();
            File file = LibraryFileUtils.getFile(destFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            unSubscribe();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 订阅文件下载进度
     */
    private void subscribeLoadProgress() {
        rxSubscriptions.add(SRxBus.getInstance()
                .toFlowable(FileLoadingBean.class)// FileLoadingBean保存了progress和total的实体类
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FileLoadingBean>() {
                    @Override
                    public void accept(FileLoadingBean fileLoadingBean) throws Exception {
                        onLoading(fileLoadingBean.getProgress(), fileLoadingBean.getTotal());
                    }
                }));
    }

    /**
     * 取消订阅，防止内存泄漏
     */
    private void unSubscribe() {
        if (!rxSubscriptions.isDisposed()) {
            rxSubscriptions.dispose();
        }
    }
}
