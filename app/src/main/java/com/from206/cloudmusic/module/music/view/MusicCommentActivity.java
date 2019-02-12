package com.from206.cloudmusic.module.music.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.GsonUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.MusicCommentAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.music.model.CommentLikeResult;
import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.module.music.model.MusicCommentResult;
import com.from206.cloudmusic.module.music.presenter.MusicCommentPresenter;
import com.from206.cloudmusic.module.music.presenter.MusicCommentPresenterImpl;
import com.from206.cloudmusic.utils.AnimationTool;
import com.from206.cloudmusic.utils.HttpCode;
import com.from206.cloudmusic.view.CommonHeaderView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

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
public class MusicCommentActivity extends LoadingBaseActivity<MusicCommentPresenterImpl> implements MusicCommentPresenter.View, BaseQuickAdapter.OnItemChildClickListener, OnLoadMoreListener {
    private Music music;
    @BindView(R.id.head_view)
    CommonHeaderView headerView;

    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefreshLayout;
    private MusicCommentAdapter musicCommentAdapter;
    private List<MusicCommentResult.CommentsBean> commentsBeanList = new ArrayList<>();
    private int pageNum = 0;
    private int pageSize = 20;
    private ImageView ivLike;

    @Override
    public void fetchData() {
        mPresenter.fetchMusicComment(String.valueOf(music.getId()), String.valueOf(pageSize), String.valueOf(pageNum * pageSize));

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
        rvComment.setLayoutManager(new LinearLayoutManager(mContext));
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setOnLoadMoreListener(this);


    }

    /**
     * 初始化ui
     */
    private void initUI(View view) {
        ImageView ivCover = view.findViewById(R.id.iv_cover);
        TextView tvMusicName = view.findViewById(R.id.tv_music_name);
        TextView tvAuthor = view.findViewById(R.id.tv_author);

        Glide.with(mContext).load(music.getPicUrl()).into(ivCover);
        tvMusicName.setText(music.getName());
        tvAuthor.setText(music.getAuthor());

    }

    @Override
    public void setState(int state, String msg) {
        handleState(state,msg);

    }

    /**
     * 获取评论
     *
     * @param result
     */
    @Override
    public void loadMusicComment(MusicCommentResult result) {
        smartRefreshLayout.finishLoadMore();
        if (result.getCode() == HttpCode.SUCCESS) {
            headerView.setTitle(String.format(getResources().getString(R.string.total_music_comment), result.getTotal()));
            if (musicCommentAdapter == null) {
                musicCommentAdapter = new MusicCommentAdapter(commentsBeanList);
//                rvComment.setAdapter(musicCommentAdapter);
                musicCommentAdapter.bindToRecyclerView(rvComment);
                musicCommentAdapter.setOnItemChildClickListener(this);
                View view = LayoutInflater.from(mContext).inflate(R.layout.header_view_music_comment,null);
                musicCommentAdapter.addHeaderView(view);
                initUI(view);
            }
            //转换精彩评论
            if (null != result.getHotComments() && result.getHotComments().size() > 0) {
                musicCommentAdapter.setHotCommentNum(result.getHotComments().size());
                String str = GsonUtils.toJson(result.getHotComments());
                List<MusicCommentResult.CommentsBean> list = new Gson()
                        .fromJson(str, new TypeToken<List<MusicCommentResult.CommentsBean>>() {
                        }
                                .getType());
                commentsBeanList.addAll(list);
            }
            smartRefreshLayout.setEnableLoadMore(result.isMore());
            commentsBeanList.addAll(result.getComments());
            musicCommentAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadCommentLike(CommentLikeResult result) {
        if (result.getCode() == HttpCode.SUCCESS) {
            Boolean isLiked = (Boolean) ivLike.getTag(R.id.tag_isLiked);
            int position= (int) ivLike.getTag(R.id.tag_position);
            if (isLiked) {
                ivLike.setImageResource(R.drawable.xv);
            } else {
                ivLike.setImageResource(R.drawable.xw);
            }
            AnimationTool.scaleView(ivLike);
            musicCommentAdapter.getData().get(position).setLiked(!isLiked);
            int count = musicCommentAdapter.getData().get(position).getLikedCount()+( isLiked?-1:1);
            musicCommentAdapter.getData().get(position).setLikedCount(count);
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

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        //点赞
        if (view.getId() == R.id.iv_like || view.getId() == R.id.tv_comment_like_count) {
            MusicCommentResult.CommentsBean comment = musicCommentAdapter.getData().get(position);
            ivLike = (ImageView) musicCommentAdapter.getViewByPosition(position,R.id.iv_like);
            ivLike.setTag(R.id.tag_isLiked,comment.isLiked());
            ivLike.setTag(R.id.tag_position,position);
            mPresenter.fetchCommentLike(String.valueOf(music.getId())
                    ,String.valueOf(comment.getCommentId()),comment.isLiked()?"0":"1","0");
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pageNum++;
        fetchData();
    }
}
