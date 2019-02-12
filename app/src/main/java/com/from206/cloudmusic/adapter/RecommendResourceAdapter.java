package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.main.model.RecommendResourceResult;
import com.from206.cloudmusic.utils.StringUtil;

import java.util.List;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class RecommendResourceAdapter extends BaseQuickAdapter<RecommendResourceResult.RecommendBean,BaseViewHolder> {
    public RecommendResourceAdapter( @Nullable List<RecommendResourceResult.RecommendBean> data) {
        super(R.layout.item_recommend_resource, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendResourceResult.RecommendBean item) {
        ImageView ivCover = helper.getView(R.id.iv_cover);
        Glide.with(mContext).load(item.getPicUrl()).into(ivCover);
        helper.setText(R.id.tv_name,item.getName());
        helper.setText(R.id.tv_play_count, StringUtil.formatNum(String.valueOf(item.getPlaycount()),false));

    }
}
