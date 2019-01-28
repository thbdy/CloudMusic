package com.from206.cloudmusic.module.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseFragment;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.main.model.BannerResult;
import com.from206.cloudmusic.module.main.presenter.RecommendPresenter;
import com.from206.cloudmusic.module.main.presenter.RecommendPresenterImpl;
import com.from206.cloudmusic.utils.GlideImageLoader;
import com.youth.banner.Banner;

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
        implements RecommendPresenter.View {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.ll_rank)
    LinearLayout llRank;
    Unbinder unbinder;
    private List<String> bannerImageList = new ArrayList<>();


    @Override
    protected void fetchData() {
        //请求轮播图数据
        mPresenter.fetchBanner();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {

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
            for (BannerResult.BannersBean bean : result.getBanners()) {
                bannerImageList.add(bean.getImageUrl());
            }
            banner.setImages(bannerImageList).setImageLoader(new GlideImageLoader()).start();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_rank,R.id.ll_personal_fm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //排行榜
            case R.id.ll_rank:
                startActivity(new Intent(mContext,RankActivity.class));
                break;
            //私人FM
            case R.id.ll_personal_fm:
                startActivity(new Intent(mContext,PersonalFmActivity.class));
                break;
        }
    }
}
