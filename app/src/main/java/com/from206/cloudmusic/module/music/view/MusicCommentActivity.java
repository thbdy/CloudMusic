package com.from206.cloudmusic.module.music.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.MusicCommentAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.module.music.model.MusicCommentResult;
import com.from206.cloudmusic.module.music.presenter.MusicCommentPresenter;
import com.from206.cloudmusic.module.music.presenter.MusicCommentPresenterImpl;
import com.from206.cloudmusic.utils.HttpCode;
import com.from206.cloudmusic.view.CommonHeaderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 音乐评论页面
 * Created by 75232 on 2019/2/1
 * Email：752323877@qq.com
 */
public class MusicCommentActivity extends LoadingBaseActivity<MusicCommentPresenterImpl> implements MusicCommentPresenter.View {
    @BindView(R.id.tv_music_name)
    TextView tvMusicName;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.rl_music_info)
    RelativeLayout rlMusicInfo;
    private Music music;
    @BindView(R.id.head_view)
    CommonHeaderView headerView;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    private MusicCommentAdapter musicCommentAdapter;
    private List<MusicCommentResult.CommentsBean> commentsBeanList = new ArrayList<>();
    @Override
    public void fetchData() {
        mPresenter.fetchMusicComment(String.valueOf(music.getId()));

    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectMusicCommentActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_music_comment;
    }

    @Override
    protected void initViews() {
        music = (Music) getIntent().getSerializableExtra("music");
        initUI();


    }

    /**
     * 初始化ui
     */
    private void initUI() {
        rvComment.setLayoutManager(new LinearLayoutManager(mContext));
        Glide.with(mContext).load(music.getPicUrl()).into(ivCover);
        tvMusicName.setText(music.getName());
        tvAuthor.setText(music.getAuthor());

    }

    @Override
    public void setState(int state, String msg) {

    }

    /**
     * 获取评论
     *
     * @param result
     */
    @Override
    public void loadMusicComment(MusicCommentResult result) {
        if (result.getCode() == HttpCode.SUCCESS) {
            headerView.setTitle(String.format(getResources().getString(R.string.total_music_comment), result.getTotal()));
            if(musicCommentAdapter == null){
                musicCommentAdapter = new MusicCommentAdapter(commentsBeanList);
                rvComment.setAdapter(musicCommentAdapter);
            }
            commentsBeanList.clear();
            commentsBeanList.addAll(result.getComments());
            musicCommentAdapter.notifyDataSetChanged();
        }

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
