package com.wengmengfan.btwang.ui.fragment.homeChildFragment;

import android.os.Bundle;

import com.wengmengfan.btwang.R;
import com.wengmengfan.btwang.base.BaseFragment;
import com.wengmengfan.btwang.bean.HomeHotsBean;
import com.wengmengfan.btwang.component.AppComponent;

import java.util.List;

/**
 * sayid ....
 * Created by wengmf on 2018/3/12.
 */

public class HotsMangaFragment extends BaseFragment{

    private List<HomeHotsBean> data;


    public static HotsMangaFragment getInstance(List<HomeHotsBean> data) {
        HotsMangaFragment sf = new HotsMangaFragment();
        sf.data = data;
        return sf;
    }



    @Override
    public void loadData() {

    }

    @Override
    protected void initView(Bundle bundle) {
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_hots_manga;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
