package com.yunqixinxi.mode_user.runAlone;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yunqi.product.core.base.router.RouterPath;
import com.yunqi.product.core.base.vp.CoreBaseFragment;
import com.yunqixinxi.mode_user.R;
import com.yunqixinxi.mode_user.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@Route(path = RouterPath.USER)
public class UserFragment extends CoreBaseFragment {


    @BindView(R2.id.iv_bg)
    ImageView ivBg;

    @Override
    protected void init(Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_fragment_user;
    }

    @Override
    protected void initView(View rootView) {
        ButterKnife.bind(rootView);

    }

    @Override
    protected void initListenerAddData() {

    }

    @OnClick({R2.id.miv_collection, R2.id.miv_order, R2.id.miv_check, R2.id.miv_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R2.id.miv_collection:

                break;
            case R2.id.miv_order:
                break;
            case R2.id.miv_check:
                break;
            case R2.id.miv_about:
                break;
        }
    }
}
