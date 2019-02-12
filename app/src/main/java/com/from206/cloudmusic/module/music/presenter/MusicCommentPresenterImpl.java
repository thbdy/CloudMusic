package com.from206.cloudmusic.module.music.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.music.model.CommentLikeResult;
import com.from206.cloudmusic.module.music.model.MusicCommentResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class MusicCommentPresenterImpl extends BasePresenter<MusicCommentPresenter.View> implements MusicCommentPresenter.Presenter {
    private NetService service;

    @Inject
    public MusicCommentPresenterImpl(NetService service) {
        this.service = service;
    }


    @Override
    public void fetchMusicComment(String id,String limit,String offset) {
        invoke(service.fetchMusicComment(id,limit,offset),new Callback<MusicCommentResult>(){
            @Override
            public void onResponse(MusicCommentResult data) {
                mView.loadMusicComment(data);
            }
        });

    }

    @Override
    public void fetchCommentLike(String id,String cid, String t, String type) {
        invoke(service.fetchCommentLike(id,cid, t, type),new Callback<CommentLikeResult>(){
            @Override
            public void onResponse(CommentLikeResult data) {
                mView.loadCommentLike(data);
            }
        });
    }
}
