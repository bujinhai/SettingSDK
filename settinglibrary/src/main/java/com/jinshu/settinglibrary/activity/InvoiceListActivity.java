package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baseapp.SBaseFragmentAdapter;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.fragment.InvoiceFragment;
import com.jinshu.settinglibrary.utils.SystemUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2019/10/17 15:26 by bll
 */


public class InvoiceListActivity extends SBaseActivity {

    private ViewPager viewPager;
    private TabLayout tablayout;
    InvoiceFragment fragment;

    private boolean isGoods;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_invoice_list;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("我的发票");
        setRightTitle("新增");
        setBackAction();
        viewPager = findViewById(R.id.viewPager);
        tablayout = findViewById(R.id.tablayout);

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            isGoods = bundle.getBoolean(SAppConstant.IS_GOODS);
        }

        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        titles.add("个人发票");
        titles.add("公司发票");

        for (int i = 0; i < titles.size(); i++) {
            fragment = new InvoiceFragment();
            Bundle args = new Bundle();
            args.putBoolean(SAppConstant.IS_GOODS, isGoods);
            if (i == 0) {
                args.putInt(SAppConstant.INVOICE_TYPE, 1);
            } else {
                args.putInt(SAppConstant.INVOICE_TYPE, 2);
            }
            fragment.setArguments(args);
            fragments.add(fragment);
        }

        viewPager.setAdapter(new SBaseFragmentAdapter(getSupportFragmentManager(), fragments, titles));
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabTextColors(ContextCompat.getColor(this, R.color.setting_main_text_color), ContextCompat.getColor(this, R.color.blue));

        setListener();
    }

    private void setListener() {
        setRightTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.INVOICE_FLAG, Configure.CREATE.name());
                SystemUtils.jumpActivityForResult(mActivity, InvoiceActivity.class, SAppConstant.INVOICE_CODE, bundle);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}
