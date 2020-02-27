package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.entity.InvoiceDetailEntity;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

/**
 * Create on 2019/10/24 15:47 by bll
 */


public class InvoiceActivity extends SBaseActivity implements View.OnClickListener {

    private LinearLayout ll_invoice_taxType, personal_invoice, company_invoice, normal_invoice,
            special_invoice, ll_personal_invoice, ll_company_invoice, ll_company_special;
    private EditText etCompanyName, etTaxPayerNumber, etRegisterAddress, etRegisterPhone, etBankName, etBankAccount, etPersonName;
    private RelativeLayout rl_set_default;
    private ImageView iv_personal_invoice, iv_company_invoice, iv_normal_invoice, iv_special_invoice, iv_default;
    private Button btnSubmit;

    private int invoiceType = 1;//1.个人  2.公司
    private int taxType = 1;//1.普通  2.专用

    private boolean isDefault = false;
    private int defaultValue;

    private String invoiceFlag;
    private String memberInvoiceDefineID;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_receipt;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("添加赠票资质");
        setBackAction();

        ll_invoice_taxType = findViewById(R.id.ll_invoice_taxType);
        personal_invoice = findViewById(R.id.personal_invoice);
        company_invoice = findViewById(R.id.company_invoice);
        normal_invoice = findViewById(R.id.normal_invoice);
        special_invoice = findViewById(R.id.special_invoice);
        ll_personal_invoice = findViewById(R.id.ll_personal_invoice);
        ll_company_invoice = findViewById(R.id.ll_company_invoice);
        ll_company_special = findViewById(R.id.ll_company_special);
        rl_set_default = findViewById(R.id.rl_set_default);
        iv_personal_invoice = findViewById(R.id.iv_personal_invoice);
        iv_company_invoice = findViewById(R.id.iv_company_invoice);
        iv_normal_invoice = findViewById(R.id.iv_normal_invoice);
        iv_special_invoice = findViewById(R.id.iv_special_invoice);
        etPersonName = findViewById(R.id.et_person_name);
        etCompanyName = findViewById(R.id.et_company_name);
        etTaxPayerNumber = findViewById(R.id.et_tax_payer_number);
        etRegisterAddress = findViewById(R.id.et_register_address);
        etRegisterPhone = findViewById(R.id.et_register_phone);
        etBankName = findViewById(R.id.et_bank_name);
        etBankAccount = findViewById(R.id.et_bank_account);
        iv_default = findViewById(R.id.iv_set_default);
        btnSubmit = findViewById(R.id.btn_submit);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        invoiceFlag = bundle.getString(SAppConstant.INVOICE_FLAG);
        if (invoiceFlag.equals(Configure.UPDATE.name())) {
            memberInvoiceDefineID = bundle.getString(SAppConstant.MEMBER_INVOICE_DEFINE_ID);
            getInvoiceDetail();
        }
    }

    private void getInvoiceDetail() {
        SApi.getDefault(SHostType.BASE_URL)
                .getMemberInvoiceDefineDetail(MasterUtils.addSessionID(), memberInvoiceDefineID)
                .compose(SRxHelper.<InvoiceDetailEntity>handleResult())
                .compose(SRxSchedulers.<InvoiceDetailEntity>io_main())
                .subscribe(new SRxSubscriber<InvoiceDetailEntity>(mContext) {
                    @Override
                    protected void onSuccess(InvoiceDetailEntity entity) {
                        if (entity == null || entity.getMemberInvoiceDefineDto() == null) {
                            return;
                        }
                        InvoiceDetailEntity.MemberInvoiceDefineDtoInfo info = entity.getMemberInvoiceDefineDto();
                        if (info.getInvoiceType() == 1) {//个人
                            etPersonName.setText(info.getName());
                        } else if (info.getInvoiceType() == 2) {//公司
                            ll_company_invoice.setVisibility(View.VISIBLE);
                            ll_invoice_taxType.setVisibility(View.VISIBLE);
                            ll_personal_invoice.setVisibility(View.GONE);
                            etCompanyName.setText(info.getName());
                            etTaxPayerNumber.setText(info.getTaxCode() == null ? "" : info.getTaxCode());
                            if (info.getTaxType() == 2) {
                                ll_company_special.setVisibility(View.VISIBLE);
                                etRegisterAddress.setText(info.getAddress() == null ? "" : info.getAddress());
                                etRegisterPhone.setText(info.getPhone() == null ? "" : info.getPhone());
                                etBankName.setText(info.getBankName() == null ? "" : info.getBankName());
                                etBankAccount.setText(info.getBankAccount() == null ? "" : info.getBankAccount());
                            }
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.personal_invoice) {
            invoiceType = 1;
            setSelected(iv_personal_invoice, iv_company_invoice);
            ll_personal_invoice.setVisibility(View.VISIBLE);
            ll_company_invoice.setVisibility(View.GONE);
            ll_company_special.setVisibility(View.GONE);
            ll_invoice_taxType.setVisibility(View.GONE);
        } else if (v.getId() == R.id.company_invoice) {
            invoiceType = 2;
            setSelected(iv_company_invoice, iv_personal_invoice);
            ll_invoice_taxType.setVisibility(View.VISIBLE);
            ll_company_invoice.setVisibility(View.VISIBLE);
            ll_personal_invoice.setVisibility(View.GONE);
        } else if (v.getId() == R.id.normal_invoice) {
            taxType = 1;
            setSelected(iv_normal_invoice, iv_special_invoice);
            ll_company_invoice.setVisibility(View.VISIBLE);
            ll_company_special.setVisibility(View.GONE);
        } else if (v.getId() == R.id.special_invoice) {
            taxType = 2;
            setSelected(iv_special_invoice, iv_normal_invoice);
            ll_company_special.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.rl_set_default) {
            if (!isDefault) {
                iv_default.setImageResource(R.drawable.setting_select);
                isDefault = true;
                defaultValue = 1;
                if (memberInvoiceDefineID != null) {
                    setInvoiceDefault();
                }
            } else {
                iv_default.setImageResource(R.drawable.setting_unselect);
                isDefault = false;
                defaultValue = 2;
            }
        } else if (v.getId() == R.id.btn_submit) {
            if (invoiceFlag.equals(Configure.CREATE.name())) {
                submitOneMemberInvoiceDefine();
            } else {
                updateMemberInvoiceDefine();
            }
        }
    }

    private void setSelected(ImageView selected, ImageView unselected) {
        selected.setImageResource(R.drawable.setting_select);
        unselected.setImageResource(R.drawable.setting_unselect);
    }

    private void setListener() {
        personal_invoice.setOnClickListener(this);
        company_invoice.setOnClickListener(this);
        normal_invoice.setOnClickListener(this);
        special_invoice.setOnClickListener(this);
        rl_set_default.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    private void setInvoiceDefault() {
        SApi.getDefault(SHostType.BASE_URL)
                .setDefaultMemberInvoiceDefine(MasterUtils.addSessionID(), memberInvoiceDefineID)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void submitOneMemberInvoiceDefine() {
        String personName = etPersonName.getText().toString();
        String companyName = etCompanyName.getText().toString();
        String taxNumber = etTaxPayerNumber.getText().toString();
        String address = etRegisterAddress.getText().toString();
        String phone = etRegisterPhone.getText().toString();
        String bankName = etBankName.getText().toString();
        String bankAccount = etBankAccount.getText().toString();

        String name;

        if (invoiceType == 1) {//个人
            if (StrUtils.isEmpty(personName)) {
                ToastUtil.showShort("请输入姓名");
                return;
            }
            name = personName;
        } else {//公司
            if (StrUtils.isEmpty(companyName)) {
                ToastUtil.showShort("请输入单位名称");
                return;
            }
            if (StrUtils.isEmpty(taxNumber)) {
                ToastUtil.showShort("请输入识别号");
                return;
            }
            name = companyName;
            if (taxType == 2) {
                if (StrUtils.isEmpty(address)) {
                    ToastUtil.showShort("请输入注册地址");
                    return;
                }
                if (StrUtils.isEmpty(phone)) {
                    ToastUtil.showShort("请输入注册电话");
                    return;
                }
                if (StrUtils.isEmpty(bankName)) {
                    ToastUtil.showShort("请输入开户银行");
                    return;
                }
                if (StrUtils.isEmpty(bankAccount)) {
                    ToastUtil.showShort("请输入银行账户");
                    return;
                }
            }
        }

        SApi.getDefault(SHostType.BASE_URL)
                .submitOneMemberInvoiceDefine(MasterUtils.addSessionID(), invoiceType, name, taxType, taxNumber, address, phone, bankName, bankAccount, defaultValue)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (!response.success()) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra(SAppConstant.INVOICE_TYPE, invoiceType);
                        setResult(RESULT_OK, intent);
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void updateMemberInvoiceDefine() {
        String personName = etPersonName.getText().toString();
        String companyName = etCompanyName.getText().toString();
        String taxNumber = etTaxPayerNumber.getText().toString();
        String address = etRegisterAddress.getText().toString();
        String phone = etRegisterPhone.getText().toString();
        String bankName = etBankName.getText().toString();
        String bankAccount = etBankAccount.getText().toString();

        String name;

        if (invoiceType == 1) {//个人
            if (StrUtils.isEmpty(personName)) {
                ToastUtil.showShort("请输入姓名");
                return;
            }
            name = personName;
        } else {//公司
            if (StrUtils.isEmpty(companyName)) {
                ToastUtil.showShort("请输入单位名称");
                return;
            }
            if (StrUtils.isEmpty(taxNumber)) {
                ToastUtil.showShort("请输入识别号");
                return;
            }
            name = companyName;
            if (taxType == 2) {
                if (StrUtils.isEmpty(address)) {
                    ToastUtil.showShort("请输入注册地址");
                    return;
                }
                if (StrUtils.isEmpty(phone)) {
                    ToastUtil.showShort("请输入注册电话");
                    return;
                }
                if (StrUtils.isEmpty(bankName)) {
                    ToastUtil.showShort("请输入开户银行");
                    return;
                }
                if (StrUtils.isEmpty(bankAccount)) {
                    ToastUtil.showShort("请输入银行账户");
                    return;
                }
            }
        }
        SApi.getDefault(SHostType.BASE_URL)
                .updateMemberInvoiceDefine(MasterUtils.addSessionID(), memberInvoiceDefineID,
                        invoiceType, name, taxType, taxNumber, address, phone, bankName, bankAccount, defaultValue)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (!response.success()) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra(SAppConstant.INVOICE_TYPE, invoiceType);
                        setResult(RESULT_OK, intent);
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });

    }
}
