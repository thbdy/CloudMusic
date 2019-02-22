package com.from206.cloudmusic.module.user.view;

import android.support.design.widget.TabLayout;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by 75232 on 2019/2/13
 * Email：752323877@qq.com
 */
public class FriendsActivity extends BaseActivity {
    @BindView(R.id.tab_layout)
    TabLayout tableLayout;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_friends;
    }

    @Override
    protected void initViews() {
        tableLayout.addTab(tableLayout.newTab().setText("关注"));
        tableLayout.addTab(tableLayout.newTab().setText("粉丝"));
        tableLayout.addTab(tableLayout.newTab().setText("添加好友"));

    }
}
