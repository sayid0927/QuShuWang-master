package com.ManHuan.manhuan.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.ManHuan.manhuan.R;
import com.ManHuan.manhuan.base.BaseFragment;
import com.ManHuan.manhuan.base.Constant;
import com.ManHuan.manhuan.component.AppComponent;
import com.ManHuan.manhuan.component.DaggerMainComponent;
import com.ManHuan.manhuan.presenter.contract.DongTuImgBrowseContract;
import com.ManHuan.manhuan.presenter.impl.DongTuImgBrowsePresenter;
import com.ManHuan.manhuan.utils.ImgLoadUtils;
import com.syd.oden.circleprogressdialog.core.CircleProgressDialog;

import javax.inject.Inject;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Administrator on 2017/11/4 0004.
 */

public class DongTuImageBrowseFragment extends BaseFragment implements DongTuImgBrowseContract.View {

    @Inject
    DongTuImgBrowsePresenter mPresenter;

    @BindView(R.id.mPhotoView)
    ImageView mPhotoView;

    private String imgUrl, downUrl;
    PhotoViewAttacher mAttacher;

    private CircleProgressDialog circleProgressDialog;

    public static DongTuImageBrowseFragment newInstance(String imgUrl) {
        DongTuImageBrowseFragment manHuan_name = new DongTuImageBrowseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("imgUrl", imgUrl);
        manHuan_name.setArguments(bundle);
        return manHuan_name;
    }

    @Override
    protected void initView(Bundle bundle) {
        imgUrl = bundle.getString("imgUrl");
        circleProgressDialog = new CircleProgressDialog(getActivity());
        mPhotoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showNoticeDialog();
                return false;
            }
        });
        mPresenter.Fetch_DongTu_Img(imgUrl);
        Logger.e("imgUrl >> " + imgUrl);
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_imagebrowse;
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
    public void downloadPicFromNet_Success(String filePath) {
        Toast.makeText(getSupportActivity(), "已保存动图在  " + filePath, Toast.LENGTH_LONG).show();
    }

    @Override
    public void Fetch_DongTu_Img_Success(String Url) {
        this.downUrl = Url;
        ImgLoadUtils.GifloadImage(getContext(), Url, mPhotoView);
    }

    @Override
    public void showError(String message) {

    }

    private void showNoticeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getSupportActivity());
        builder.setTitle("下载动图");
        builder.setPositiveButton("下载动图", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                mPresenter.downloadPicFromNet(downUrl);
            }
        });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }
}
