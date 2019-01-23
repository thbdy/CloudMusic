package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.main.model.RankResult;

import java.util.List;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class RankAdapter extends BaseQuickAdapter<RankResult.ListBean,BaseViewHolder> {
    public RankAdapter(int layoutResId, @Nullable List<RankResult.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RankResult.ListBean item) {
        ImageView ivCover = helper.getView(R.id.iv_cover);
        Glide.with(mContext).load(item.getCoverImgUrl()).into(ivCover);
        helper.setText(R.id.tv_name,item.getName());


        if(item.getTracks().size()>0){
            helper.setText(R.id.tv_top_1,"1. "+item.getTracks().get(0).getFirst()+"   "+
                    item.getTracks().get(0).getSecond());
        }
        if(item.getTracks().size()>1){
            helper.setText(R.id.tv_top_2,"2. "+item.getTracks().get(1).getFirst()+"   "+
                    item.getTracks().get(0).getSecond());
        }
        if(item.getTracks().size()>2){
            helper.setText(R.id.tv_top_3,"3. "+item.getTracks().get(2).getFirst()+"   "+
                    item.getTracks().get(0).getSecond());
        }
    }
}
