package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baseapp.SBaseFragmentAdapter;
import com.jinshu.settinglibrary.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2019/10/17 15:26 by bll
 */


public class MessageActivity extends SBaseActivity {

    private ViewPager viewPager;
    private TabLayout tablayout;
    private MessageFragment fragment;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_invoice_list;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("我的消息");
        setBackAction();
        viewPager = findViewById(R.id.viewPager);
        tablayout = findViewById(R.id.tablayout);

        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("已读");
        titles.add("未读");

        for (int i = 0; i < titles.size(); i++) {
            fragment = new MessageFragment();
            Bundle args = new Bundle();
            args.putInt(SAppConstant.MESSAGE_TYPE, i + 1);
            fragment.setArguments(args);
            fragments.add(fragment);
        }

        viewPager.setAdapter(new SBaseFragmentAdapter(getSupportFragmentManager(), fragments, titles));
        viewPager.setOffscreenPageLimit(titles.size() - 1);
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabTextColors(ContextCompat.getColor(this, R.color.setting_main_text_color), ContextCompat.getColor(this, R.color.blue));

    }
}
