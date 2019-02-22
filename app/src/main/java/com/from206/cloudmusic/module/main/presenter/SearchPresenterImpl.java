package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.main.model.SearchHotResult;
import com.from206.cloudmusic.module.main.model.SearchResult;
import com.from206.cloudmusic.module.main.model.SearchSuggestResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class SearchPresenterImpl extends BasePresenter<SearchPresenter.View> implements SearchPresenter.Presenter {
    private NetService service;

    @Inject
    public SearchPresenterImpl(NetService service) {
        this.service = service;
    }


    @Override
    public void fetchSearch(String keywords, String limit, String offset, String type) {
        invoke(service.fetchSearch(keywords, limit, offset, type),new Callback<SearchResult>(){
            @Override
            public void onResponse(SearchResult data) {
                mView.loadSearch(data);
            }
        });
    }

    @Override
    public void fetchSearchHot() {
        invoke(service.fetchSearchHot(),new Callback<SearchHotResult>(){
            @Override
            public void onResponse(SearchHotResult data) {
                mView.loadSearchHot(data);
            }
        });
    }

    @Override
    public void fetchSearchSuggest(String keywords,String type) {
        invoke(service.fetchSearchSuggest(keywords, type),new Callback<SearchSuggestResult>(){
            @Override
            public void onResponse(SearchSuggestResult data) {
                mView.loadSearchSuggest(data);
            }
        });
    }
}
