package com.from206.cloudmusic.module.music.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.music.model.CommentLikeResult;
import com.from206.cloudmusic.module.music.model.MusicCommentResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface MusicCommentPresenter {
    interface Presenter {
        void fetchMusicComment(String id,String limit,String offset);
        void fetchCommentLike(String id,String cid,String t,String type);
    }
    interface View extends BaseView {
        void loadMusicComment(MusicCommentResult result);
        void loadCommentLike(CommentLikeResult result);
    }
}
