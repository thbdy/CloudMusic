package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.music.model.MusicCommentResult;

import java.util.List;

/**
 * Created by 75232 on 2019/2/1
 * Email：752323877@qq.com
 */
public class MusicCommentAdapter extends BaseQuickAdapter<MusicCommentResult.CommentsBean,BaseViewHolder> {


    public MusicCommentAdapter(@Nullable List<MusicCommentResult.CommentsBean> data) {
        super(R.layout.item_music_comment, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, MusicCommentResult.CommentsBean item) {
        ImageView ivHead = helper.getView(R.id.iv_head);
        Glide.with(mContext).load(item.getUser().getAvatarUrl()).into(ivHead);
        helper.setText(R.id.tv_user_name,item.getUser().getNickname());
        helper.setText(R.id.tv_user_comment,item.getContent());
        helper.setText(R.id.tv_comment_like_count,item.getLikedCount()+"");
        String timeFormat = TimeUtils.millis2String(item.getTime());
        helper.setText(R.id.tv_time,TimeUtils.getFriendlyTimeSpanByNow(timeFormat));

    }
}

