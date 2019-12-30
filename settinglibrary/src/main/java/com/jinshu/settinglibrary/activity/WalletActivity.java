package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.WalletEntity;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StatusBarUtil;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

/**
 * Create on 2019/11/28 15:37 by bll
 */


public class WalletActivity extends SBaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private TextView tvBalance, tvAccount, tvCoupon, tv_integral;
    private TextView tv_red_pocket, tv_gift_card;
    private RelativeLayout rl_recharge, rl_withdraw;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_wallet;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        StatusBarUtil.setStatusBarTranslucent(this);
        ivBack = findViewById(R.id.iv_back);
        tvBalance = findViewById(R.id.tv_balance);
        tvAccount = findViewById(R.id.tv_account);
        tvCoupon = findViewById(R.id.tv_coupon);
        tv_integral = findViewById(R.id.tv_integral);
        tv_red_pocket = findViewById(R.id.tv_red_pocket);
        tv_gift_card = findViewById(R.id.tv_gift_card);
        rl_recharge = findViewById(R.id.rl_recharge);
        rl_withdraw = findViewById(R.id.rl_withdraw);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        getWalletData();
    }

    private void getWalletData() {
        SApi.getDefault(SHostType.BASE_URL)
                .getMemberStatisticsWallet(MasterUtils.addSessionID())
                .compose(SRxHelper.<WalletEntity>handleResult())
                .compose(SRxSchedulers.<WalletEntity>io_main())
                .subscribe(new SRxSubscriber<WalletEntity>(mContext) {
                    @Override
                    protected void onSuccess(WalletEntity walletEntity) {
                        if (walletEntity.getMemberStatisticsDto() == null) {
                            return;
                        }
                        WalletEntity.MemberStatisticsDtoInfo info = walletEntity.getMemberStatisticsDto();
                        tvBalance.setText("¥" + info.getCashBalance());
                        tvCoupon.setText("" + info.getBonusTotal());
                        tv_integral.setText("" + info.getPoint());

                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void setListener() {
        ivBack.setOnClickListener(this);
        tvAccount.setOnClickListener(this);
        rl_recharge.setOnClickListener(this);
        rl_withdraw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        } else if (v.getId() == R.id.tv_account) {
            SystemUtils.jumpActivity(mActivity, AccountActivity.class);
        } else if (v.getId() == R.id.rl_recharge) {
            SystemUtils.jumpActivity(mActivity, RechargeActivity.class);
        } else if (v.getId() == R.id.rl_withdraw) {
            SystemUtils.jumpActivity(mActivity, WithdrawActivity.class);
        }
    }
}
