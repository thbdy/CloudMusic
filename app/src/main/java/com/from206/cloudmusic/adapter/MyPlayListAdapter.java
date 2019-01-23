package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.user.model.UserPlayListResult;

import java.util.List;

/**
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class MyPlayListAdapter extends BaseQuickAdapter<UserPlayListResult.PlaylistBean,BaseViewHolder> {
    public MyPlayListAdapter( @Nullable List<UserPlayListResult.PlaylistBean> data) {
        super(R.layout.item_my_play_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserPlayListResult.PlaylistBean item) {
        ImageView ivCover = helper.getView(R.id.iv_cover);
        Glide.with(mContext).load(item.getCoverImgUrl()).into(ivCover);
        helper.setText(R.id.tv_name,item.getName());
        helper.setText(R.id.tv_desc,String.format(mContext.getResources().getString(R.string.my_play_list_desc),
                item.getTrackCount(),item.getPlayCount()));

    }
}
