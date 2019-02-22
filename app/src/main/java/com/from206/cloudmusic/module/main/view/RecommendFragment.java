package com.from206.cloudmusic.module.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.DJProgramAdapter;
import com.from206.cloudmusic.adapter.RecommendResourceAdapter;
import com.from206.cloudmusic.base.LoadingBaseFragment;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.common.view.WebViewActivity;
import com.from206.cloudmusic.module.main.model.BannerResult;
import com.from206.cloudmusic.module.main.model.DJProgramResult;
import com.from206.cloudmusic.module.main.model.RecommendResourceResult;
import com.from206.cloudmusic.module.main.presenter.RecommendPresenter;
import com.from206.cloudmusic.module.main.presenter.RecommendPresenterImpl;
import com.from206.cloudmusic.module.music.model.SongSheet;
import com.from206.cloudmusic.module.music.view.SongSheetActivity;
import com.from206.cloudmusic.utils.GlideImageLoader;
import com.from206.cloudmusic.utils.HttpCode;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 推荐
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class RecommendFragment extends LoadingBaseFragment<RecommendPresenterImpl>
        implements RecommendPresenter.View, BaseQuickAdapter.OnItemClickListener, OnBannerClickListener {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.ll_rank)
    LinearLayout llRank;
    @BindView(R.id.rv_recommend)
    RecyclerView rvRecommend;
    @BindView(R.id.rv_recommend_dj)
    RecyclerView rvRecommendDJ;
    Unbinder unbinder;
    private List<String> bannerImageList = new ArrayList<>();
    private List<BannerResult.BannersBean> bannersBeanList = new ArrayList<>();
    private RecommendResourceAdapter recommendResourceAdapter;
    private DJProgramAdapter djProgramAdapter;

    @Override
    protected void fetchData() {
        //请求轮播图数据
        mPresenter.fetchBanner();
        //请求推荐歌单
        mPresenter.fetchRecommendResource();
        //请求推荐电台
        mPresenter.fetchDJProgram();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        rvRecommend.setLayoutManager(new GridLayoutManager(mContext, 3));
        rvRecommendDJ.setLayoutManager(new GridLayoutManager(mContext, 3));
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setOnBannerClickListener(this);


    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectRecommendFragment(this);
    }

    @Override
    public void setState(int state, String msg) {

    }

    /**
     * 获取轮播图请求回调
     *
     * @param result
     */
    @Override
    public void loadBannerInfo(BannerResult result) {
        if (result.getCode() == 200) {
            bannersBeanList.clear();
            bannersBeanList.addAll(result.getBanners());
            for (BannerResult.BannersBean bean : result.getBanners()) {
                bannerImageList.add(bean.getImageUrl());
            }
            banner.setImages(bannerImageList).setImageLoader(new GlideImageLoader()).start();
        }

    }

    @Override
    public void loadRecommendResource(RecommendResourceResult result) {
        if (result.getCode() == HttpCode.SUCCESS) {
            if (recommendResourceAdapter == null) {
                recommendResourceAdapter = new RecommendResourceAdapter(result.getRecommend());
                recommendResourceAdapter.bindToRecyclerView(rvRecommend);
                recommendResourceAdapter.setOnItemClickListener(this);
            }
            recommendResourceAdapter.notifyDataSetChanged();

        }

    }

    @Override
    public void loadDJProgram(DJProgramResult result) {
        if (result.getCode() == HttpCode.SUCCESS) {
            if (djProgramAdapter == null) {
                djProgramAdapter = new DJProgramAdapter(result.getResult());
                djProgramAdapter.bindToRecyclerView(rvRecommendDJ);
            }
            djProgramAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_rank, R.id.ll_personal_fm, R.id.ll_daily_recommend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //每日推荐
            case R.id.ll_daily_recommend:
                startActivity(new Intent(mContext, DailyRecommendActivity.class));
                break;
            //排行榜
            case R.id.ll_rank:
                startActivity(new Intent(mContext, RankActivity.class));
                break;
            //私人FM
            case R.id.ll_personal_fm:
                startActivity(new Intent(mContext, PersonalFmActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        RecommendResourceResult.RecommendBean bean = recommendResourceAdapter.getData().get(position);
        SongSheet songSheet = new SongSheet();
        songSheet.setId(bean.getId());
        songSheet.setPicUrl(bean.getPicUrl());
        songSheet.setName(bean.getName());
        songSheet.setCreatedName(bean.getCreator().getNickname());
        songSheet.setCreatedIcon(bean.getCreator().getAvatarUrl());
        Intent intent = new Intent(mContext, SongSheetActivity.class);
        intent.putExtra("songsheet", songSheet);
        startActivity(intent);


    }

    @Override
    public void OnBannerClick(int position) {
        Intent intent = new Intent(mContext,WebViewActivity.class);
        intent.putExtra("url",bannersBeanList.get(position).getUrl());
        startActivity(intent);
    }
}


