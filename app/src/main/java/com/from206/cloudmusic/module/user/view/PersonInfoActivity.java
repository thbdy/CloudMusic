package com.from206.cloudmusic.module.user.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.MyPlayListAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.login.model.LoginResult;
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

/**
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class PersonInfoActivity extends LoadingBaseActivity<PersonInfoPresenterImpl> implements PersonInfoPresenter.View {

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
        mPresenter.fetchUserPlayList(PersonInfoUtil.getPersonInfo().getProfile().getUserId()+"");
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
        handleState(state,msg);
    }

    @Override
    public void loadPersonInfo(PersonInfoResult result) {
        if(result.getCode() == 200 ){
            Log.e("CloudMusic", "获取个人资料成功");
            personInfoResult = result;
            updatePersonInfo();
        }else {
            Log.e("CloudMusic", "获取个人资料失败"+result.getCode());
        }


    }

    @Override
    public void loadUserSubCount(UserSubCountResult result) {

    }

    /**
     * 用户歌单
     * @param result
     */
    @Override
    public void loadUserPlayList(UserPlayListResult result) {
        if(result.getCode() == 200){
            if(myPlayListAdapter == null){
                myPlayListAdapter = new MyPlayListAdapter(playlistBeanList);
                rvPlayList.setAdapter(myPlayListAdapter);
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
        tvFans.setText(String.format(getResources().getString(R.string.fans),profile.getFolloweds()));
        tvFollows.setText(String.format(getResources().getString(R.string.fans),profile.getFollows()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
