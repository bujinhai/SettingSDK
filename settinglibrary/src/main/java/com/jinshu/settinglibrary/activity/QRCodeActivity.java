package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.king.zxing.util.CodeUtils;

/**
 * Create on 2019/10/24 15:56 by bll
 */

public class QRCodeActivity extends SBaseActivity {

    private ImageView ivQrCode;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_qr_code;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("我的专属二维码");
        setBackAction();
        ivQrCode = findViewById(R.id.iv_qr_code);
        Bitmap bitmap = CodeUtils.createQRCode("http://www.baidu.com", 300, null);
        ivQrCode.setImageBitmap(bitmap);
    }
}
