package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.main.model.DailyRecommendResult;

import java.util.List;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class DailyRecommendAdapter extends BaseQuickAdapter<DailyRecommendResult.RecommendBean,BaseViewHolder> {
    public DailyRecommendAdapter(@Nullable List<DailyRecommendResult.RecommendBean> data) {
        super(R.layout.item_daily_recommend, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailyRecommendResult.RecommendBean item) {
        helper.setText(R.id.tv_num,String.valueOf(helper.getLayoutPosition()+1));
        helper.setText(R.id.tv_music_name,item.getName());
        helper.setText(R.id.tv_author,item.getArtists().get(0).getName());
        if(item.getAlias().size() > 0){
            helper.setText(R.id.tv_alia,"("+item.getAlias().get(0)+")");
        }else {
            helper.setText(R.id.tv_alia,"");
        }
//        ImageView ivMv = helper.getView(R.id.iv_mv);
//        if(item.getMv() == 0){
//            ivMv.setVisibility(View.INVISIBLE);
//        }else {
//            ivMv.setVisibility(View.VISIBLE);
//        }
        helper.addOnClickListener(R.id.iv_mv);
    }
}
