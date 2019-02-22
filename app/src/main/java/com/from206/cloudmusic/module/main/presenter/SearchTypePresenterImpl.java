package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.main.model.SearchSuggestResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class SearchTypePresenterImpl extends BasePresenter<SearchTypePresenter.View> implements SearchTypePresenter.Presenter {
    private NetService service;

    @Inject
    public SearchTypePresenterImpl(NetService service) {
        this.service = service;
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
