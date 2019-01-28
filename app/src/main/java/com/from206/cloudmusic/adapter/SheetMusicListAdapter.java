package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;

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

    }
}
