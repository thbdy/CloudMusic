package com.from206.cloudmusic.module.main.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseFragment;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.main.model.SearchSuggestResult;
import com.from206.cloudmusic.module.main.presenter.SearchTypePresenter;
import com.from206.cloudmusic.module.main.presenter.SearchTypePresenterImpl;

import butterknife.BindView;

/**
 * Created by 75232 on 2019/2/22
 * Email：752323877@qq.com
 */
public class SearchTypeFragment extends LoadingBaseFragment<SearchTypePresenterImpl> implements SearchTypePresenter.View {
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;
    private static final String TAG = "SearchTypeFragment";
    /**
     * 搜索关键词
     */
    private String mKeyWord = "";

    private String type;


    public static SearchTypeFragment createNewFragment(String type) {
        SearchTypeFragment searchTypeFragment = new SearchTypeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        searchTypeFragment.setArguments(bundle);
        return searchTypeFragment;
    }

    @Override
    protected void fetchData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_type;
    }

    @Override
    protected void initView() {
        Bundle bundle = this.getArguments();
        type = bundle.getString("type");
        tvType.setText(type);
        rvSearch.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectSearchTypeFragment(this);
    }


    public void loadData(String keyWord,int position) {
        if(!keyWord.equals(mKeyWord)){
            if(position == 0){ //搜索综合
                mPresenter.fetchSearchSuggest(keyWord,"");
            }else {

            }
        }
        mKeyWord = keyWord;

    }

    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadSearchSuggest(SearchSuggestResult result) {

    }
}
