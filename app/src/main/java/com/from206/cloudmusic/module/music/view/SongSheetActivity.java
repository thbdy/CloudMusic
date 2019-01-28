package com.from206.cloudmusic.module.music.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.SheetMusicListAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.music.model.PlayListDetailResult;
import com.from206.cloudmusic.module.music.presenter.SongSheetPresenter;
import com.from206.cloudmusic.module.music.presenter.SongSheetPresenterImpl;
import com.from206.cloudmusic.module.user.model.UserPlayListResult;
import com.from206.cloudmusic.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 歌单页面
 * Created by 75232 on 2019/1/25
 * Email：752323877@qq.com
 */
public class SongSheetActivity extends LoadingBaseActivity<SongSheetPresenterImpl> implements SongSheetPresenter.View, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.tv_sheet_name)
    TextView tvSheetName;
    @BindView(R.id.iv_created_icon)
    CircleImageView ivCreatedIcon;
    @BindView(R.id.tv_created_name)
    TextView tvCreatedName;
    @BindView(R.id.ll_created)
    LinearLayout llCreated;
    @BindView(R.id.rv_music_list)
    RecyclerView rvMusicList;
    /**
     * 歌单资料
     */
    private UserPlayListResult.PlaylistBean bean;
    /**
     * 适配器
     */
    private SheetMusicListAdapter sheetMusicListAdapter;
    private List<PlayListDetailResult.PlaylistBean.TracksBean> playlistBeanList = new ArrayList<>();

    @Override
    public void fetchData() {
        mPresenter.fetchPlayListDetail(String.valueOf(bean.getId()));
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectSongSheetActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_song_sheet;
    }

    @Override
    protected void initViews() {
        bean = (UserPlayListResult.PlaylistBean) getIntent().getSerializableExtra("bean");
        rvMusicList.setLayoutManager(new LinearLayoutManager(mContext));
        initUI();

    }

    /**
     * 初始化一些界面
     */
    private void initUI() {
        tvCreatedName.setText(bean.getCreator().getNickname());
        tvSheetName.setText(bean.getName());
        Glide.with(mContext).load(bean.getCreator().getAvatarUrl()).into(ivCreatedIcon);
        Glide.with(mContext).load(bean.getCoverImgUrl()).into(ivCover);


    }

    @Override
    public void setState(int state, String msg) {

    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void loadPlayListDetail(PlayListDetailResult result) {
        if(result.getCode() == 200){
            if(sheetMusicListAdapter == null){
                sheetMusicListAdapter = new SheetMusicListAdapter(playlistBeanList);
                rvMusicList.setAdapter(sheetMusicListAdapter);
                sheetMusicListAdapter.setOnItemClickListener(this);
            }
            playlistBeanList.clear();
            playlistBeanList.addAll(result.getPlaylist().getTracks());
            sheetMusicListAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(mContext,MusicActivity.class);
        intent.putExtra("bean",playlistBeanList.get(position));
        startActivity(intent);
    }
}
