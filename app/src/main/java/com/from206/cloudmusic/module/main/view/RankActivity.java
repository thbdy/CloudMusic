package com.from206.cloudmusic.module.main.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.RankAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.main.model.RankResult;
import com.from206.cloudmusic.module.main.presenter.RankPresenter;
import com.from206.cloudmusic.module.main.presenter.RankPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 排行榜
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class RankActivity extends LoadingBaseActivity<RankPresenterImpl> implements RankPresenter.View {
    @BindView(R.id.rv_rank)
    RecyclerView rvRank;
    private RankAdapter rankAdapter;
    private List<RankResult.ListBean> rankList = new ArrayList<>();
    @Override
    public void fetchData() {
        //请求排行榜数据
        mPresenter.fetchRank();
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectRankActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rank;
    }

    @Override
    protected void initViews() {
        rvRank.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void setState(int state, String msg) {

    }
    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
    /**
     * 请求排行榜数据回调
     * @param result
     */
    @Override
    public void loadRankInfo(RankResult result){
        if(result.getCode() == 200){
            if(rankAdapter == null){
                rankAdapter = new RankAdapter(R.layout.item_rank,rankList);
                rvRank.setAdapter(rankAdapter);
            }
            rankList.clear();
            rankList.addAll(result.getList());
            rankAdapter.notifyDataSetChanged();
        }

    }
}
