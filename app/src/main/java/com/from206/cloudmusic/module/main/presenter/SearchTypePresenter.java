package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.main.model.SearchSuggestResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface SearchTypePresenter {
    interface Presenter {
        void fetchSearchSuggest(String keywords,String type);
    }
    interface View extends BaseView {
        void loadSearchSuggest(SearchSuggestResult result);
    }
}
