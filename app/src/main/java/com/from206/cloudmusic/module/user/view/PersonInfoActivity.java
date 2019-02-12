package com.from206.cloudmusic.module.user.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.MyPlayListAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.login.model.LoginResult;
import com.from206.cloudmusic.module.music.model.SongSheet;
import com.from206.cloudmusic.module.music.view.SongSheetActivity;
import com.from206.cloudmusic.module.user.model.PersonInfoResult;
import com.from206.cloudmusic.module.user.model.UserPlayListResult;
import com.from206.cloudmusic.module.user.model.UserSubCountResult;
import com.from206.cloudmusic.module.user.presenter.PersonInfoPresenter;
import com.from206.cloudmusic.module.user.presenter.PersonInfoPresenterImpl;
import com.from206.cloudmusic.utils.PersonInfoUtil;
import com.from206.cloudmusic.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用户个人资料页面
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class PersonInfoActivity extends LoadingBaseActivity<PersonInfoPresenterImpl> implements PersonInfoPresenter.View, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.iv_person_info_bg)
    ImageView ivPersonInfoBg;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_nick_name)
    TextView tvNickName;
    @BindView(R.id.tv_follows)
    TextView tvFollows;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.rv_play_list)
    RecyclerView rvPlayList;
    private PersonInfoResult personInfoResult;
    private LoginResult.ProfileBean profile;
    private MyPlayListAdapter myPlayListAdapter;
    private List<UserPlayListResult.PlaylistBean> playlistBeanList = new ArrayList<>();

    @Override
    public void fetchData() {
        //获取用户详情
//        mPresenter.fetchPersonInfo(PersonInfoUtil.getPersonInfo().getProfile().getUserId() + "");
        //获取用户信息 , 歌单，收藏，mv, dj 数量
//        mPresenter.fetchUserSubCount();
        //获取用户歌单
        mPresenter.fetchUserPlayList(PersonInfoUtil.getPersonInfo().getProfile().getUserId() + "");
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectPersonInfoActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_person_info;
    }

    @Override
    protected void initViews() {
        updatePersonInfo();
        rvPlayList.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void setState(int state, String msg) {
        handleState(state, msg);
    }

    @Override
    public void loadPersonInfo(PersonInfoResult result) {
        if (result.getCode() == 200) {
            Log.e("CloudMusic", "获取个人资料成功");
            personInfoResult = result;
            updatePersonInfo();
        } else {
            Log.e("CloudMusic", "获取个人资料失败" + result.getCode());
        }


    }

    @Override
    public void loadUserSubCount(UserSubCountResult result) {

    }

    /**
     * 用户歌单
     *
     * @param result
     */
    @Override
    public void loadUserPlayList(UserPlayListResult result) {
        if (result.getCode() == 200) {
            if (myPlayListAdapter == null) {
                myPlayListAdapter = new MyPlayListAdapter(playlistBeanList);
                rvPlayList.setAdapter(myPlayListAdapter);
                myPlayListAdapter.setOnItemClickListener(this);
            }
            playlistBeanList.clear();
            playlistBeanList.addAll(result.getPlaylist());
            myPlayListAdapter.notifyDataSetChanged();
        }

    }

//    /**
//     * 更新个人页面资料
//     */
//    private void updatePersonInfo() {
//        Glide.with(mContext).load(personInfoResult.getProfile().getAvatarUrl()).into(ivHead);
//        Glide.with(mContext).load(personInfoResult.getProfile().getBackgroundUrl()).into(ivPersonInfoBg);
//        tvNickName.setText(personInfoResult.getProfile().getNickname());
//    }

    /**
     * 更新个人页面资料
     */
    private void updatePersonInfo() {
        profile = PersonInfoUtil.getPersonInfo().getProfile();
        Glide.with(mContext).load(profile.getAvatarUrl()).into(ivHead);
        Glide.with(mContext).load(profile.getBackgroundUrl()).into(ivPersonInfoBg);
        tvNickName.setText(profile.getNickname());
        tvFans.setText(String.format(getResources().getString(R.string.follows), profile.getFolloweds()));
        tvFollows.setText(String.format(getResources().getString(R.string.fans), profile.getFollows()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        UserPlayListResult.PlaylistBean bean = playlistBeanList.get(position);
        SongSheet songSheet = new SongSheet();
        songSheet.setName(bean.getName());
        songSheet.setCreatedName(bean.getCreator().getNickname());
        songSheet.setCreatedIcon(bean.getCreator().getAvatarUrl());
        songSheet.setPicUrl(bean.getCoverImgUrl());
        songSheet.setId(bean.getId());
        Intent intent = new Intent(mContext,SongSheetActivity.class);
        intent.putExtra("songsheet",songSheet);
        startActivity(intent);
    }
}
