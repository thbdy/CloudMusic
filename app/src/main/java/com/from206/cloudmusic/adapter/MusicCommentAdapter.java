package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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
    /**
     * 热门评论数
     */
    private int mHotCommentNum = 0;


    public MusicCommentAdapter(@Nullable List<MusicCommentResult.CommentsBean> data) {
        super(R.layout.item_music_comment, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, MusicCommentResult.CommentsBean item) {
        TextView tvCommentType = helper.getView(R.id.tv_comment_type);
        TextView tvReplyNum = helper.getView(R.id.tv_reply_num);
        if(helper.getLayoutPosition() == mHotCommentNum + 1){
            tvCommentType.setVisibility(View.VISIBLE);
            tvCommentType.setText("最新评论");
        } else if(helper.getLayoutPosition() == 1){
            tvCommentType.setVisibility(View.VISIBLE);
            tvCommentType.setText("精彩评论");
        }else {
            tvCommentType.setVisibility(View.GONE);
        }

        final ImageView ivHead = helper.getView(R.id.iv_head);
        Glide.with(mContext).load(item.getUser().getAvatarUrl())
                .apply(new RequestOptions().placeholder(R.drawable.aun))
                .into(ivHead);
        helper.setText(R.id.tv_user_name,item.getUser().getNickname());
        helper.setText(R.id.tv_user_comment,item.getContent());
        helper.setText(R.id.tv_comment_like_count,item.getLikedCount()+"");
        String timeFormat = TimeUtils.millis2String(item.getTime());
        helper.setText(R.id.tv_time,TimeUtils.getFriendlyTimeSpanByNow(timeFormat));
        helper.addOnClickListener(R.id.iv_like);
        helper.addOnClickListener(R.id.tv_comment_like_count);
        helper.setImageResource(R.id.iv_like,item.isLiked()?R.drawable.xw:R.drawable.xv);
        helper.setTextColor(R.id.tv_comment_like_count,item.isLiked()?mContext.getResources().getColor(R.color.colorPrimary)
                :mContext.getResources().getColor(R.color.colorBBBBBB));
        if(item.getBeReplied().size() > 0){
            tvReplyNum.setText(item.getBeReplied().size()+"条回复 >");
            tvReplyNum.setVisibility(View.VISIBLE);
        }else {
            tvReplyNum.setVisibility(View.GONE);
        }


    }
    public void setHotCommentNum(int mHotCommentNum) {
        this.mHotCommentNum = mHotCommentNum;
    }
}

