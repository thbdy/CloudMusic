package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.main.model.DJProgramResult;

import java.util.List;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class DJProgramAdapter extends BaseQuickAdapter<DJProgramResult.ResultBean,BaseViewHolder> {
    public DJProgramAdapter(@Nullable List<DJProgramResult.ResultBean> data) {
        super(R.layout.activity_dj_program, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DJProgramResult.ResultBean item) {
        helper.setText(R.id.tv_name,item.getName());
        ImageView ivCover = helper.getView(R.id.iv_cover);
        Glide.with(mContext).load(item.getPicUrl()).into(ivCover);
        helper.setText(R.id.tv_author,item.getProgram().getDj().getNickname());


    }
}
