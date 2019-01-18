package com.from206.cloudmusic.module.main.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    RecommendFragment recommendFragment;
    private FragmentTransaction ft;
    private FragmentManager fm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        fm = getSupportFragmentManager();
        recommendFragment = new RecommendFragment();
        ft = fm.beginTransaction();
        ft.add(R.id.fl_content,recommendFragment);
        ft.commit();

    }
}
