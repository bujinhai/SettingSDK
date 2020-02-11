package com.jinshu.settingsdk;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jinshu.settinglibrary.activity.MessageActivity;
import com.jinshu.settinglibrary.activity.SettingActivity;
import com.jinshu.settinglibrary.activity.WalletActivity;
import com.jinshu.settinglibrary.entity.ParamData;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.utils.permission.Acp;
import com.jinshu.settinglibrary.utils.permission.AcpListener;
import com.jinshu.settinglibrary.utils.permission.AcpOptions;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SettingActivity.OnLoginOutClickListener {

    private static final String OBJECT_ID = "402880866a4e6279016a4e69cff90006";
    private static final String NAME = "测试提交评论";
    private static final String OBJECT_NAME = "43434";
    private static final String OBJECT_DEFINE_ID = "8af5993a512ce9a201512e7d84b60873";

    private static final String NAVIGATOR_QUES_ID = "382f36b665274656afff0aa22071ce98";
    private static final String NAVIGATOR_HELP_ID = "12236a70d7784daa86caab65390ef14c";


    private Button btnSetting, btnRecovery, btnMessage, btnWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetting = findViewById(R.id.btn_setting);
        btnRecovery = findViewById(R.id.btn_recovery);
        btnMessage = findViewById(R.id.btn_message);
        btnWallet = findViewById(R.id.btn_wallet);

        btnSetting.setOnClickListener(this);
        btnRecovery.setOnClickListener(this);
        btnMessage.setOnClickListener(this);
        btnWallet.setOnClickListener(this);

        checkPermission(this);

//        BtnStyleEntity entity = new BtnStyleEntity();
//        entity.setBtnBgColor(Color.BLUE);
//        entity.setBtnHeight(ScreenUtils.dip2px(this, 100));
//        entity.setBtnCorner(10);
//        entity.setBtnTextColor(Color.YELLOW);
//        entity.setBtnTextSize(25);
//        SDKUtils.saveBtnEntity(entity);

    }

    private static void checkPermission(final Activity activity) {
        Acp.getInstance(activity).request(new AcpOptions.Builder().setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA).build(), new AcpListener() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied(List<String> permissions) {
                ToastUtil.showShort("获取权限失败，请手动开启");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recovery:
                SDKUtils.clearBtnEntity();
                break;
            case R.id.btn_setting:
                ParamData data = new ParamData(OBJECT_ID, NAME, OBJECT_NAME, OBJECT_DEFINE_ID, NAVIGATOR_QUES_ID, NAVIGATOR_HELP_ID);
                SettingActivity.startActivity(this, data);
                SettingActivity.setOnLoginOutClickListener(this);
                break;
            case R.id.btn_message:
                SystemUtils.jumpActivity(this, MessageActivity.class);
                break;
            case R.id.btn_wallet:
                SystemUtils.jumpActivity(this, WalletActivity.class);
                break;
        }
    }

    @Override
    public void onLoginOutClick() {
        SystemUtils.jumpActivity(this, LoginActivity.class);
    }

    @Override
    public void onUpdateAvatar() {

    }
}
