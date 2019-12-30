package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.AddressEntity;
import com.jinshu.settinglibrary.entity.BankBranchListEntity;
import com.jinshu.settinglibrary.entity.BankDetailEntity;
import com.jinshu.settinglibrary.entity.BankListEntity;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.fragment.SelectAreaMenuDialogFragment;
import com.jinshu.settinglibrary.fragment.SelectBankBranchDialogFragment;
import com.jinshu.settinglibrary.fragment.SelectBankDialogFragment;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.ViewStyle;

/**
 * Create on 2019/10/17 17:10 by bll
 */


public class CreateBankCardActivity extends SBaseActivity implements View.OnClickListener,
        SelectAreaMenuDialogFragment.OnSelectFinishClickListener,
        SelectBankDialogFragment.OnSelectFinishClickListener, SelectBankBranchDialogFragment.OnSelectBankBranchFinishClickListener {

    private EditText etCardUserName, etUserPhone, etCardNumber;
    private TextView tvBank, tvCity, tvBranch;
    private Button btnSubmit;
    private String cityID;
    private BankListEntity.DataInfo.RowsInfo mBankInfo;
    private String cardType;
    private String memberBankID;
    private BankDetailEntity.DataInfo info;
    private String bankID;//总行id

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_create_bank_card;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setBackAction();
        etCardUserName = findViewById(R.id.et_card_user_name);
        etUserPhone = findViewById(R.id.et_user_phone);
        etCardNumber = findViewById(R.id.et_card_number);
        tvBank = findViewById(R.id.tv_bank);
        tvCity = findViewById(R.id.tv_city);
        tvBranch = findViewById(R.id.tv_bank_branch);
        btnSubmit = findViewById(R.id.btn_submit);

        ViewStyle.setBtnStyle(btnSubmit);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            cardType = bundle.getString(SAppConstant.BANK_CARD_TYPE);
            memberBankID = bundle.getString(SAppConstant.BANK_CARD_ID);
        }
        if (Configure.CREATE.name().equals(cardType)) {
            setTitle("添加银行卡");
        } else if (Configure.UPDATE.name().equals(cardType)) {
            setTitle("修改银行卡");
            setRightTitle("删除");
            getBankDetail();
        }
    }

    private void getBankDetail() {
        SApi.getDefault(SHostType.BASE_URL)
                .getMemberBankDetail(MasterUtils.addSessionID(), memberBankID)
                .compose(SRxSchedulers.<SBaseResponse<BankDetailEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<BankDetailEntity>>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse<BankDetailEntity> response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        if (response.body == null || response.body.getData() == null) {
                            return;
                        }
                        info = response.body.getData();
                        etCardUserName.setText(info.getName());
                        etUserPhone.setText(info.getPhoneNumber());
                        etCardNumber.setText(info.getCardCode());
                        tvBank.setText(info.getShortName());
                        tvBranch.setText(info.getBankName());
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void setListener() {
        tvBank.setOnClickListener(this);
        tvCity.setOnClickListener(this);
        tvBranch.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        setRightTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SApi.getDefault(SHostType.BASE_URL)
                        .deleteOneMemberBank(MasterUtils.addSessionID(), memberBankID)
                        .compose(SRxSchedulers.<SBaseResponse>io_main())
                        .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
                            @Override
                            protected void onSuccess(SBaseResponse response) {
                                if (response.header.code != 0) {
                                    ToastUtil.showShort(response.header.msg);
                                    return;
                                }
                                setResult(RESULT_OK);
                                finish();
                            }

                            @Override
                            protected void onFail(String message) {
                                ToastUtil.showShort(message);
                            }
                        });
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_bank) {
            SelectBankDialogFragment dialogFragment = SelectBankDialogFragment.newInstance();
            dialogFragment.setCancelable(false);
            dialogFragment.setOnSelectFinishClickListener(this);
            dialogFragment.show(getSupportFragmentManager(), dialogFragment.getClass().getName());
        } else if (v.getId() == R.id.tv_city) {
            SelectAreaMenuDialogFragment dialogFragment = SelectAreaMenuDialogFragment.newInstance();
            dialogFragment.setCancelable(false);
            dialogFragment.setOnSelectFinishClickListener(this);
            dialogFragment.show(getSupportFragmentManager(), dialogFragment.getClass().getName());
        } else if (v.getId() == R.id.tv_bank_branch) {
            if (mBankInfo != null) {
                bankID = mBankInfo.getBankID();
            } else {
                bankID = info.getBankID();
            }
            SelectBankBranchDialogFragment dialogFragment = SelectBankBranchDialogFragment.newInstance(bankID, cityID);
            dialogFragment.setCancelable(false);
            dialogFragment.setOnSelectBankFinishClickListener(this);
            dialogFragment.show(getSupportFragmentManager(), dialogFragment.getClass().getName());
        } else if (v.getId() == R.id.btn_submit) {
            if (Configure.CREATE.name().equals(cardType)) {
                submitCard();
            } else if (Configure.UPDATE.name().equals(cardType)) {
                updateCard();
            }
        }
    }


    /**
     * 提交
     */
    private void submitCard() {
        String name = etCardUserName.getText().toString();
        String phone = etUserPhone.getText().toString();
        String number = etCardNumber.getText().toString();
        String bank = tvBank.getText().toString();
        String bankBranch = tvBranch.getText().toString();
        String city = tvCity.getText().toString();

        if (!validate(name, phone, number, bank, bankBranch, city)) {
            return;
        }

        SApi.getDefault(SHostType.BASE_URL)
                .submitOneMemberBank(MasterUtils.addSessionID(), name, bankID, bank, bankBranch, number, phone)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        setResult(RESULT_OK);
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void updateCard() {
        String name = etCardUserName.getText().toString();
        String phone = etUserPhone.getText().toString();
        String number = etCardNumber.getText().toString();
        String bank = tvBank.getText().toString();
        String bankBranch = tvBranch.getText().toString();
        String city = tvCity.getText().toString();

        if (!validate(name, phone, number, bank, bankBranch, city)) {
            return;
        }

        SApi.getDefault(SHostType.BASE_URL)
                .updateMyMemberBank(MasterUtils.addSessionID(), name, bank, bankBranch, number, memberBankID, phone)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        setResult(RESULT_OK);
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }


    private boolean validate(String name, String phone, String number, String bank, String bankBranch, String city) {

        if (StrUtils.isEmpty(name)) {
            ToastUtil.showShort("请输入持卡人名字");
            return false;
        }

        if (!StrUtils.isMobile(phone)) {
            ToastUtil.showShort("请输入正确的预留手机号");
            return false;
        }

//        if (!StrUtils.checkBankCard(number)) {
//            ToastUtil.showShort("请输入正确的卡号");
//            return false;
//        }

        if (StrUtils.isEmpty(bank)) {
            ToastUtil.showShort("请选择银行");
            return false;
        }

        if (StrUtils.isEmpty(city)) {
            ToastUtil.showShort("请选择省市县");
            return false;
        }

        if (StrUtils.isEmpty(bankBranch)) {
            ToastUtil.showShort("请选择支行");
            return false;
        }
        return true;
    }

    /*省市县回调*/
    @Override
    public void onSelectFinish(AddressEntity.DataInfo.RowsInfo info, String area, String shengID, String shengName, String cityID, String cityName, String xianID, String xianName, String zhenID, String zhenName) {
        tvCity.setText(area);
        if (shengName.endsWith("市")) {
            this.cityID = shengID;
        } else {
            this.cityID = cityID;
        }
    }

    /*银行列表回调*/
    @Override
    public void onSelectClick(BankListEntity.DataInfo.RowsInfo info) {
        if (info != null) {
            this.mBankInfo = info;
            tvBank.setText(info.getBankName());
        }
    }

    /*支行列表回调*/
    @Override
    public void onSelectBankBranchClick(BankBranchListEntity.DataInfo.RowsInfo info) {
        if (info != null) {
            tvBranch.setText(info.getName());
        }
    }
}
