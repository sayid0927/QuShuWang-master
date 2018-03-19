package com.wengmengfan.btwang.ui.fragment.homeChildFragment;

import com.wengmengfan.btwang.R;
import com.wengmengfan.btwang.base.BaseFragment;
import com.wengmengfan.btwang.bean.HomeHotsBean;
import com.wengmengfan.btwang.component.AppComponent;

import java.util.List;

/**
 * sayid ....
 * Created by wengmf on 2018/3/12.
 */

public class HotsVarietyFragment extends BaseFragment{


    private List<HomeHotsBean> data;

    public static HotsVarietyFragment getInstance(List<HomeHotsBean> data) {
        HotsVarietyFragment sf = new HotsVarietyFragment();
        sf.data = data;
        return sf;
    }


    @Override
    public void loadData() {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_hots_variety;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
