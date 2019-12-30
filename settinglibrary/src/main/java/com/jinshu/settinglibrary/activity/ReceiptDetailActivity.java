package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;

/**
 * Create on 2019/10/28 18:29 by bll
 */


public class ReceiptDetailActivity extends SBaseActivity {

    private EditText etCompanyName, etTaxPayerNumber, etRegisterAddress, etRegisterPhone, etBankName, etBankAccount;
    private Button btnModify, btnDelete;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_receipt_detail;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("添加赠票资质");
        setBackAction();

        etCompanyName = findViewById(R.id.et_company_name);
        etTaxPayerNumber = findViewById(R.id.et_tax_payer_number);
        etRegisterAddress = findViewById(R.id.et_register_address);
        etRegisterPhone = findViewById(R.id.et_register_phone);
        etBankName = findViewById(R.id.et_bank_name);
        etBankAccount = findViewById(R.id.et_bank_account);
        btnModify = findViewById(R.id.btn_modify_receipt);
        btnDelete = findViewById(R.id.btn_delete_receipt);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
//        SApi.getDefault(SHostType.BASE_URL)
//                .getMemberInvoiceDefineDetail(MasterUtils.addSessionID())
    }

    private void setListener() {
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
