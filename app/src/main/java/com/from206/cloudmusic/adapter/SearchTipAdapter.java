package com.from206.cloudmusic.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.main.model.SearchSuggestResult;

import java.util.List;

/**
 * Created by 75232 on 2019/2/21
 * Email：752323877@qq.com
 */
public class SearchTipAdapter extends BaseQuickAdapter<SearchSuggestResult.ResultBean.AllMatchBean,BaseViewHolder> {
    public SearchTipAdapter( @Nullable List<SearchSuggestResult.ResultBean.AllMatchBean> data) {
        super(R.layout.item_search_tip, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchSuggestResult.ResultBean.AllMatchBean item) {
        helper.setText(R.id.tv_name,item.getKeyword());

    }
}
