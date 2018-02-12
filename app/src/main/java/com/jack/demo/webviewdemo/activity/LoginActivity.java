package com.jack.demo.webviewdemo.activity;

import android.databinding.ViewDataBinding;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import com.jack.demo.webviewdemo.BR;
import com.jack.demo.webviewdemo.utils.ToastUtils;
import com.jack.demo.webviewdemo.Constants;
import com.jack.demo.webviewdemo.R;
import com.jack.demo.webviewdemo.MyApplication;
import com.jack.demo.webviewdemo.activity.presenter.UserLoginPresenter;
import com.jack.demo.webviewdemo.activity.viewinterface.UserLoginView;
import com.jack.demo.webviewdemo.cloud.bean.UserBean;
import com.jack.demo.webviewdemo.cloud.bean.UserLoginRequestBean;
import com.jack.demo.webviewdemo.databinding.ActivityUserLoginBinding;
import com.jack.demo.webviewdemo.dialog.DialogLoading;
import com.jack.demo.webviewdemo.event.ExceptionEvent;
import com.jaky.utils.ActivityUtil;
import com.jaky.utils.FileUtils;
import com.jaky.utils.PreferenceUtils;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.net.ConnectException;


public class LoginActivity extends BaseActivity implements View.OnClickListener, UserLoginView {
    private ActivityUserLoginBinding loginDataBinding;
    private UserLoginPresenter userLoginPresenter;
    private UserLoginRequestBean userLoginRequestBean = new UserLoginRequestBean();
    private DialogLoading loginLoadingDialog;

    @Override
    protected void initData() {
        userLoginPresenter = new UserLoginPresenter(this);
        userLoginRequestBean.isKeepPassword = PreferenceUtils.getBooleanValue(MyApplication.getInstance(), Constants.SP_KEY_ISKEEPPASSWORD, false);
        restoreUserInfo();
        loginLoadingDialog = new DialogLoading(LoginActivity.this, getString(R.string.login_activity_loading_tip), false);
        MobclickAgent.setDebugMode(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
    }

    private void restoreUserInfo() {
        if (userLoginRequestBean.isKeepPassword) {
            String account = PreferenceUtils.getStringValue(MyApplication.getInstance(), Constants.SP_KEY_USER_ACCOUNT, "");
            String password = PreferenceUtils.getStringValue(MyApplication.getInstance(), Constants.SP_KEY_USER_PASSWORD, "");
            if (!TextUtils.isEmpty(account)) {
                userLoginRequestBean.account = account;
            }
            if (!TextUtils.isEmpty(password)) {
                userLoginRequestBean.password = password;
            }
        }
    }

    @Override
    protected void initView(ViewDataBinding binding) {
        loginDataBinding = (ActivityUserLoginBinding) binding;
        loginDataBinding.setListener(this);
        loginDataBinding.setVariable(BR.requestInfo, userLoginRequestBean);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.getClass().getName());
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected int getViewId() {
        return R.layout.activity_user_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_act_tv_startlogin:
                startLogin();
                break;
            case R.id.iv_main_activity_title_icon:
                showInputIpAddressDialog();
                break;
        }
    }

    private void showInputIpAddressDialog() {
    }

    private void showPassword() {
        if (userLoginRequestBean.isShowPassword) {
            userLoginRequestBean.setShowPassword(false);
            loginDataBinding.loginActEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            loginDataBinding.loginActEtPassword.setSelection( loginDataBinding.loginActEtPassword.getText().length());
        } else {
            userLoginRequestBean.setShowPassword(true);
            loginDataBinding.loginActEtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            loginDataBinding.loginActEtPassword.setSelection(loginDataBinding.loginActEtPassword.getText().length());
        }
    }

    private void startLogin() {
        if (checkLoginInfo()) {
            loginLoadingDialog.show();
            String md5Password = FileUtils.computeMD5(userLoginRequestBean.password).toUpperCase();
            userLoginPresenter.loginAccount(userLoginRequestBean.account, md5Password);
        }
    }

    private void saveUserInfo(UserBean userBean) {
        MyApplication.getInstance().setToken(userBean.token);
        PreferenceUtils.setBooleanValue(MyApplication.getInstance(), Constants.SP_KEY_ISKEEPPASSWORD, userLoginRequestBean.isKeepPassword);
        PreferenceUtils.setStringValue(MyApplication.getInstance(), Constants.SP_KEY_USER_PASSWORD, userLoginRequestBean.password);
        PreferenceUtils.setStringValue(MyApplication.getInstance(), Constants.SP_KEY_USER_ACCOUNT, userLoginRequestBean.account);
    }

    private boolean checkLoginInfo() {
        if (TextUtils.isEmpty(userLoginRequestBean.account)) {
            ToastUtils.show(getString(R.string.account_format_error_tips));
            return false;
        } else if (TextUtils.isEmpty(userLoginRequestBean.password)) {
            ToastUtils.show(getString(R.string.password_format_error_tips));
            return false;
        }

        return true;
    }

    private void skipToMainActivity() {
        ActivityUtil.startActivity(LoginActivity.this,MainActivity.class);
    }

    @Override
    public void onLoginSucceed(UserBean userBean) {
        dismissLoadDialog();
        saveUserInfo(userBean);
        skipToMainActivity();
        finish();
    }

    private void dismissLoadDialog() {
        if (null != loginLoadingDialog && loginLoadingDialog.isShowing()) {
            loginLoadingDialog.dismiss();
        }
    }

    @Override
    public void onLoginFailed(int errorCode, String msg) {
        dismissLoadDialog();
    }

    @Override
    public void onLoginError(String error) {
        dismissLoadDialog();
        ToastUtils.show(error);
    }

    @Override
    public void onLoginException(Throwable e) {
        dismissLoadDialog();
        if (e instanceof ConnectException) {
            ToastUtils.show(getString(R.string.common_tips_network_connection_exception));
        } else {
            ToastUtils.show(getString(R.string.common_tips_request_failed));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onExceptionEvent(ExceptionEvent event) {
        ToastUtils.show(event.getError());
    }
}

