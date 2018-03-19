package com.wengmengfan.btwang.ui.activity;

import android.view.View;
import android.widget.LinearLayout;


import com.wengmengfan.btwang.R;
import com.wengmengfan.btwang.base.BaseActivity;
import com.wengmengfan.btwang.component.AppComponent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * sayid ....
 * Created by wengmf on 2018/3/8.
 */

public class AboutActivity extends BaseActivity {

    @BindView(R.id.llExit)
    LinearLayout llExit;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int getLayoutId() {

        return R.layout.activity_about_us;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.llExit})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.llExit:
                this.finish();
                break;
        }
    }
}
