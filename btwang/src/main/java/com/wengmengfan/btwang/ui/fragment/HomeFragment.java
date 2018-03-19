package com.wengmengfan.btwang.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.flyco.tablayout.SegmentTabLayout;
import com.wengmengfan.btwang.R;
import com.wengmengfan.btwang.base.BaseFragment;
import com.wengmengfan.btwang.base.Constant;
import com.wengmengfan.btwang.bean.HomeHotsBean;
import com.wengmengfan.btwang.component.AppComponent;
import com.wengmengfan.btwang.component.DaggerMainComponent;
import com.wengmengfan.btwang.presenter.contract.HomeContract;
import com.wengmengfan.btwang.presenter.impl.HomeFragmentPresenter;
import com.wengmengfan.btwang.ui.fragment.homeChildFragment.HotsFilmFragment;
import com.wengmengfan.btwang.ui.fragment.homeChildFragment.HotsMangaFragment;
import com.wengmengfan.btwang.ui.fragment.homeChildFragment.HotsTeleplayFragment;
import com.wengmengfan.btwang.ui.fragment.homeChildFragment.HotsVarietyFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * sayid ....
 * Created by wengmf on 2018/3/12.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {

    @Inject
    HomeFragmentPresenter mPresenter;

    @BindView(R.id.tl_4)
    SegmentTabLayout tabLayout_4;

    private static final String sttBaseUrl = "https://www.80s.tt/";

    private String[] mTitles = {"电影", "电视剧", "综艺", "动漫"};

    private ArrayList<Fragment> mFragments2 = new ArrayList<>();




    @Override
    protected void initView(Bundle bundle) {

    }

    @Override
    public void loadData() {
        mPresenter.Fetch_80sHomeInfo(sttBaseUrl);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_hotfilm;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent).build().inject(this);
    }

    @Override
    public void showError(String message) {
        showDialog(message);
    }

    @Override
    public void Fetch_80sHomeInfo_Success(List<HomeHotsBean> data) {
        setState(Constant.STATE_SUCCESS);

        mFragments2.add(HotsFilmFragment.getInstance(data));
        mFragments2.add(HotsTeleplayFragment.getInstance(data));
        mFragments2.add(HotsVarietyFragment.getInstance(data));
        mFragments2.add(HotsMangaFragment.getInstance(data));

        tabLayout_4.setTabData(mTitles, getActivity(), R.id.fl_change, mFragments2);

    }
}
