package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.music.model.PlayListDetailResult;

import java.util.List;

/**
 * Created by 75232 on 2019/1/28
 * Email：752323877@qq.com
 */
public class SheetMusicListAdapter extends BaseQuickAdapter<PlayListDetailResult.PlaylistBean.TracksBean,BaseViewHolder> {
    public SheetMusicListAdapter( @Nullable List<PlayListDetailResult.PlaylistBean.TracksBean> data) {
        super(R.layout.item_sheet_music_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PlayListDetailResult.PlaylistBean.TracksBean item) {

        helper.setText(R.id.tv_num,String.valueOf(helper.getLayoutPosition()+1));
        helper.setText(R.id.tv_music_name,item.getName());
        helper.setText(R.id.tv_author,item.getAl().getName());
        if(item.getAlia().size() > 0){
            helper.setText(R.id.tv_alia,"("+item.getAlia().get(0)+")");
        }else {
            helper.setText(R.id.tv_alia,"");
        }
        ImageView ivMv = helper.getView(R.id.iv_mv);
        if(item.getMv() == 0){
            ivMv.setVisibility(View.INVISIBLE);
        }else {
            ivMv.setVisibility(View.VISIBLE);
        }
        helper.addOnClickListener(R.id.iv_mv);
//        if(item.getCopyright() == 0 && item.getCrbt() != null){ //没有版权
//            helper.setTextColor(R.id.tv_music_name,mContext.getResources().getColor(R.color.colorPrimary));
//            helper.setTextColor(R.id.tv_author,mContext.getResources().getColor(R.color.colorPrimary));
//        }else {
//            helper.setTextColor(R.id.tv_music_name,mContext.getResources().getColor(R.color.color333333));
//            helper.setTextColor(R.id.tv_author,mContext.getResources().getColor(R.color.color666666));
//        }

    }
}
