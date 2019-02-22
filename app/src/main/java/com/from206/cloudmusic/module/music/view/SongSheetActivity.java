package com.from206.cloudmusic.module.music.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.SheetMusicListAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.music.model.PlayListDetailResult;
import com.from206.cloudmusic.module.music.model.SongSheet;
import com.from206.cloudmusic.module.music.presenter.SongSheetPresenter;
import com.from206.cloudmusic.module.music.presenter.SongSheetPresenterImpl;
import com.from206.cloudmusic.utils.TypeChangeUtil;
import com.from206.cloudmusic.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * 歌单页面
 * Created by 75232 on 2019/1/25
 * Email：752323877@qq.com
 */
public class SongSheetActivity extends LoadingBaseActivity<SongSheetPresenterImpl> implements SongSheetPresenter.View, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {
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
    @BindView(R.id.rl_bg)
    RelativeLayout rlBg;
    @BindView(R.id.iv_blur_bg)
    ImageView ivBlurBg;
    /**
     * 歌单资料
     */
//    private UserPlayListResult.PlaylistBean bean;
    private SongSheet songSheet;
    /**
     * 适配器
     */
    private SheetMusicListAdapter sheetMusicListAdapter;
    private List<PlayListDetailResult.PlaylistBean.TracksBean> playlistBeanList = new ArrayList<>();

    @Override
    public void fetchData() {
        mPresenter.fetchPlayListDetail(String.valueOf(songSheet.getId()));
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
        songSheet = (SongSheet) getIntent().getSerializableExtra("songsheet");
        rvMusicList.setLayoutManager(new LinearLayoutManager(mContext));
        initUI();

    }

    /**
     * 初始化一些界面
     */
    private void initUI() {
        tvCreatedName.setText(songSheet.getCreatedName());
        tvSheetName.setText(songSheet.getName());
        Glide.with(mContext).load(songSheet.getCreatedIcon()).into(ivCreatedIcon);
        Glide.with(mContext).load(songSheet.getPicUrl()).into(ivCover);
        //虚化背景图片
        Glide.with(this).load(songSheet.getPicUrl())
                .apply(bitmapTransform(new BlurTransformation(99,2)))
                .into(ivBlurBg);
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
                sheetMusicListAdapter.setOnItemChildClickListener(this);
            }
            playlistBeanList.clear();
            playlistBeanList.addAll(result.getPlaylist().getTracks());
            sheetMusicListAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(mContext,MusicActivity.class);
        intent.putExtra("music",TypeChangeUtil.chanToMusicType(playlistBeanList.get(position)));
        startActivity(intent);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if(view.getId() == R.id.iv_mv){
            Intent mvIntent = new Intent(mContext,MusicVideoActivity.class);
            mvIntent.putExtra("id",playlistBeanList.get(position).getMv());
            startActivity(mvIntent);
        }
    }
}
