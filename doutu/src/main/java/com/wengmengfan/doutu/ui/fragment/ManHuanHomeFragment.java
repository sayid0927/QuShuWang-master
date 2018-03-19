package com.wengmengfan.doutu.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;


import com.wengmengfan.doutu.R;
import com.wengmengfan.doutu.base.BaseFragment;
import com.wengmengfan.doutu.base.BaseFragmentPageAdapter;
import com.wengmengfan.doutu.base.Constant;
import com.wengmengfan.doutu.bean.FenleiLeimuBean;
import com.wengmengfan.doutu.component.AppComponent;
import com.wengmengfan.doutu.component.DaggerMainComponent;
import com.wengmengfan.doutu.presenter.contract.ManHuanHomeContract;
import com.wengmengfan.doutu.presenter.impl.ManHuanHomePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * sayid ....
 * Created by wengmf on 2018/2/23.
 */

public class ManHuanHomeFragment extends BaseFragment implements ManHuanHomeContract.View {

    @Inject
    ManHuanHomePresenter mPresenter;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;

    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    public void loadData() {
        mPresenter.Jousp_Test();
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_manhuai_home;
    }

    @Override
    protected void initView() {
//        mPresenter.Jousp_Test();
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
    public void JouspTest_Success(List<FenleiLeimuBean> data) {
        if (data != null && data.size() != 0) {
            for (int i = 0; i < data.size(); i++) {
                mTitleList.add(data.get(i).getLeimu());
                mFragments.add(Meinvha_Title.newInstance(data.get(i).getId(),data.get(i).getUrl()));
            }
        }

        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(vp);

    }

    @Override
    public void showError(String message) {

    }

}
