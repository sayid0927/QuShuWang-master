package com.wengmengfan.btwang.ui.fragment.homeChildFragment;

import com.wengmengfan.btwang.R;
import com.wengmengfan.btwang.base.BaseFragment;
import com.wengmengfan.btwang.bean.HomeHotsBean;
import com.wengmengfan.btwang.component.AppComponent;
import com.wengmengfan.btwang.ui.fragment.HomeFragment;

import java.util.List;

/**
 * sayid ....
 * Created by wengmf on 2018/3/12.
 */

public class HotsFilmFragment extends BaseFragment{

    private List<HomeHotsBean> data;

    public static HotsFilmFragment getInstance(List<HomeHotsBean> data) {
        HotsFilmFragment sf = new HotsFilmFragment();
        sf.data = data;
        return sf;
    }



    @Override
    public void loadData() {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_hots_film;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
