package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.main.model.SearchHotResult;
import com.from206.cloudmusic.module.main.model.SearchResult;
import com.from206.cloudmusic.module.main.model.SearchSuggestResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface SearchPresenter {
    interface Presenter {
        void fetchSearch(String keywords,String limit, String offset,String type);
        void fetchSearchHot();
        void fetchSearchSuggest(String keywords,String type);
    }
    interface View extends BaseView {
        void loadSearch(SearchResult result);
        void loadSearchHot(SearchHotResult result);
        void loadSearchSuggest(SearchSuggestResult result);
    }
}
