package com.from206.cloudmusic.module.main.view;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.SearchTipAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.db.mdoel.Constant;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.main.model.SearchHotResult;
import com.from206.cloudmusic.module.main.model.SearchResult;
import com.from206.cloudmusic.module.main.model.SearchSuggestResult;
import com.from206.cloudmusic.module.main.presenter.SearchPresenter;
import com.from206.cloudmusic.module.main.presenter.SearchPresenterImpl;
import com.from206.cloudmusic.utils.HttpCode;
import com.from206.cloudmusic.view.FlowLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索页面
 * Created by 75232 on 2019/2/21
 * Email：752323877@qq.com
 */
public class SearchActivity extends LoadingBaseActivity<SearchPresenterImpl> implements
        SearchPresenter.View, BaseQuickAdapter.OnItemClickListener,
        FlowLayout.OnFlowClickListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.ll_search_tip) LinearLayout llSearchTip;
    @BindView(R.id.flow_layout) FlowLayout flowLayout;
    @BindView(R.id.et_search) EditText etSearch;
    @BindView(R.id.ll_header) LinearLayout llHeader;
    @BindView(R.id.root_layout) LinearLayout rootLayout;
    @BindView(R.id.rv_search_tip) RecyclerView rvSearchTip;
    @BindView(R.id.tv_keyword) TextView tvKeyWord;
    @BindView(R.id.layout_1) FrameLayout layout1;
    @BindView(R.id.layout_2) LinearLayout layout2;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.sliding_tab_layout)
    SlidingTabLayout slidingTabLayout;
    private MyHandler myHandler = new MyHandler(this);
    private SearchTipAdapter searchTipAdapter;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private static final String TAG = "SearchActivity";



    /**
     * 当前搜索类型
     */
    private int mCurrentType = 0;
    /**
     * 搜索关键词
     */
    private String mKeyWord;
    @Override
    public void fetchData() {
        mPresenter.fetchSearchHot();
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectSearchActivity(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        etSearch.addTextChangedListener(textWatcher);
        rvSearchTip.setLayoutManager(new LinearLayoutManager(mContext));
        flowLayout.setOnFlowClickListener(this);
//        slidingTabLayout.setViewPager(mViewPager,Constant.SEARCH_TYPE);
        for(int i = 0; i<Constant.SEARCH_TYPE.length; i++){
            fragmentList.add(SearchTypeFragment.createNewFragment(Constant.SEARCH_TYPE[i]));
        }
        slidingTabLayout.setViewPager(mViewPager,Constant.SEARCH_TYPE,this,fragmentList);
        mViewPager.addOnPageChangeListener(this);

    }



    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadSearch(SearchResult result) {

    }

    @Override
    public void loadSearchHot(final SearchHotResult result) {
        if(result.getCode() == HttpCode.SUCCESS){
             flowLayout.setData(result.getResult().getHots());
        }
    }

    @Override
    public void loadSearchSuggest(SearchSuggestResult result) {
        if(result.getCode() == HttpCode.SUCCESS){

            if(searchTipAdapter == null){
                searchTipAdapter = new SearchTipAdapter(result.getResult().getAllMatch());
                searchTipAdapter.bindToRecyclerView(rvSearchTip);
                searchTipAdapter.setOnItemClickListener(this);
            }else {
                searchTipAdapter.setNewData(result.getResult().getAllMatch());
            }
            tvKeyWord.setText("搜索 “"+etSearch.getText().toString()+"”");
            llSearchTip.setVisibility(View.VISIBLE);


        }

    }

    /**
     * 输入监听
     */
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(charSequence.toString().equals("")){
                llSearchTip.setVisibility(View.GONE);
                return;
            }
            if(myHandler.hasMessages(0)){
                myHandler.removeMessages(0);
            }
            Message message = new Message();
            message.what = 0;
            message.obj = charSequence.toString();
            myHandler.sendMessageDelayed(message,500);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if(adapter == searchTipAdapter){
            llSearchTip.setVisibility(View.GONE);
            String keyWord = searchTipAdapter.getData().get(position).getKeyword();
            etSearch.setText(keyWord);
            etSearch.setSelection(keyWord.length());
            myHandler.removeMessages(0);
            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.VISIBLE);
            // TODO: 2019/2/21 添加具体搜索功能
            mKeyWord = keyWord;
            ((SearchTypeFragment)fragmentList.get(mCurrentType)).loadData(mKeyWord,mCurrentType);
        }
    }

    @Override
    public void onClick(String keyword) {
        etSearch.setText(keyword);
        etSearch.setSelection(keyword.length());
        myHandler.removeMessages(0);
        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.VISIBLE);
        // TODO: 2019/2/21 添加具体搜索功能
//        mPresenter.fetchSearchSuggest(keyword,"");
        mKeyWord = keyword;
        ((SearchTypeFragment)fragmentList.get(mCurrentType)).loadData(mKeyWord,mCurrentType);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }


    @Override
    public void onPageSelected(int i) {
        mCurrentType = i;
        ((SearchTypeFragment)fragmentList.get(mCurrentType)).loadData(mKeyWord,mCurrentType);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


    class MyHandler extends Handler {
        WeakReference<SearchActivity> mActivity;

        MyHandler(SearchActivity activity) {
            mActivity = new WeakReference<SearchActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            mPresenter.fetchSearchSuggest((String) msg.obj,"mobile");
        }
    }
    @OnClick({R.id.root_layout,R.id.et_search})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.root_layout:
                llSearchTip.setVisibility(View.GONE);
                break;
            case R.id.et_search:
                if(!etSearch.getText().toString().equals("") && null != searchTipAdapter && searchTipAdapter.getData().size() > 0){
                    llSearchTip.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tv_keyword:
                llSearchTip.setVisibility(View.GONE);
                ToastUtils.showShort(etSearch.getText().toString());
                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                mKeyWord = etSearch.getText().toString();
                // TODO: 2019/2/21 添加具体搜索功能
//                mPresenter.fetchSearchSuggest(etSearch.getText().toString(),"");
                ((SearchTypeFragment)fragmentList.get(mCurrentType)).loadData(mKeyWord,mCurrentType);
                break;
        }
    }
}
