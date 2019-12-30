package com.jinshu.settinglibrary.download;

/**
 * @author bll
 * @package com.bll.framework.download
 * @date 2018/4/17  14:36
 * @describe 保存了progress和total的实体类
 */


public class FileLoadingBean {

    /**
     * 文件大小
     */
    long total;
    /**
     * 已下载大小
     */
    long progress;

    public long getProgress() {
        return progress;
    }

    public long getTotal() {
        return total;
    }

    public FileLoadingBean(long total, long progress) {
        this.total = total;
        this.progress = progress;
    }
}
