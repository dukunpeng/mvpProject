package com.example.newtest.contract;

import com.example.newtest.base.IBaseModel;
import com.example.newtest.base.IBasePresenter;
import com.example.newtest.base.IBaseView;
import com.example.newtest.bean.CommonBannerBean;
import com.example.newtest.bean.UserData;
import com.example.newtest.common.APPClientParam;
import com.example.newtest.request.OkHttpClientManager;

import java.util.List;

/**
 * Created by Mark on 2018/7/13.
 */

public interface HomeContract {
    interface Model extends IBaseModel{
        void getBannerList(APPClientParam apm, OkHttpClientManager.ResultCallback<CommonBannerBean> callback);
        List<String> getList();
    }

    interface View extends IBaseView{

        void showList(List<String> strings);
    }

    interface Presenter extends IBasePresenter{
        void requestBanner();
        void getList();
    }
}
