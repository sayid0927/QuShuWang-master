package com.wengmengfan.doutu.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;


import com.wengmengfan.doutu.R;
import com.wengmengfan.doutu.base.BaseFragment;
import com.wengmengfan.doutu.base.BaseFragmentPageAdapter;
import com.wengmengfan.doutu.base.Constant;
import com.wengmengfan.doutu.bean.DongTuHomeBean;
import com.wengmengfan.doutu.component.AppComponent;
import com.wengmengfan.doutu.component.DaggerMainComponent;
import com.wengmengfan.doutu.presenter.contract.DongTuHomeContract;
import com.wengmengfan.doutu.presenter.impl.DongTuHomePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * sayid ....
 * Created by wengmf on 2018/2/23.
 */

public class DongTuHomeFragment extends BaseFragment implements DongTuHomeContract.View {



    @Inject
    DongTuHomePresenter mPresenter;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;


    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();


    @Override
    public void loadData() {
//        mPresenter.DongTu_Title(DongTuHomeUrl);
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    protected void initView(Bundle bundle) {

        mTitleList.add("邪恶动态图");
        mTitleList.add("邪恶图片");
        mTitleList.add("美女图片");

        mFragments.add(DongTu_Title.newInstance("http://www.yaoqmhw.net/xedtt/",4));
        mFragments.add(DongTu_Title.newInstance("http://www.yaoqmhw.net/xetp/",5));
        mFragments.add(DongTu_Title.newInstance("http://www.yaoqmhw.net/mntp/",6));

        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);

        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(vp);

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_wo_home;
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

    }

    @Override
    public void DongTu_Title_Success(List<DongTuHomeBean> data) {
//        if (data != null && data.size() != 0) {
//            for (int i = 0; i < data.size(); i++) {
//                mTitleList.add(data.get(i).getTitle());
//                String subUrl = data.get(i).getUrl();
//                subUrl = StringUtlis.subString(subUrl, "/");
//                subUrl = StringUtlis.subString(subUrl, "/");
//                mFragments.add(DongTu_Title.newInstance(DongTuHomeUrl+subUrl));
//
//            }
//        }

//        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
//        vp.setAdapter(myAdapter);
//        myAdapter.notifyDataSetChanged();
//        tabLayout.setupWithViewPager(vp);
    }

}
