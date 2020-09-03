package com.appnet.android.social.auth;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.FragmentActivity;

public class AuthManager implements OnConnectionFailedListener {
    public static final int RC_LOGIN_GOOGLE = 1000;
    public static final int RC_LOGIN_FACEBOOK = 2000;
    private GoogleAuth mGoogleAuth;
    private FacebookAuth mFacebookAuth;
    private int mCurrentRequestCode = 0;
    private OnLoginListener mOnLoginListener;

    public AuthManager() {
    }

    public void signInGoogle(FragmentActivity activity, String clientId, OnLoginListener loginListener) {
        mOnLoginListener = loginListener;
        mCurrentRequestCode = RC_LOGIN_GOOGLE;
        if(mGoogleAuth == null) {
            mGoogleAuth = new GoogleAuth(activity, this, clientId);
        }
        mGoogleAuth.signIn(activity, mCurrentRequestCode);
    }

    public void signInFacebook(FragmentActivity activity, OnLoginListener loginListener) {
        mOnLoginListener = loginListener;
        mCurrentRequestCode = RC_LOGIN_FACEBOOK;
        if(mFacebookAuth == null) {
            mFacebookAuth = new FacebookAuth();
        }
        mFacebookAuth.login(activity, mOnLoginListener);
    }

    public void signOutGoogle(FragmentActivity activity, String clientId, final OnLogoutListener listener) {
        if(mGoogleAuth == null) {
            mGoogleAuth = new GoogleAuth(activity, this, clientId);
        }
        mGoogleAuth.signOut(listener);
    }

    public void signOutFacebook() {
        if(mFacebookAuth == null) {
            mFacebookAuth = new FacebookAuth();
        }
        mFacebookAuth.logout();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (mCurrentRequestCode) {
            case RC_LOGIN_GOOGLE:
                handleLoginGoogle(requestCode, resultCode, data);
                break;
            case RC_LOGIN_FACEBOOK:
                handleLoginFacebook(requestCode, resultCode, data);
                break;
        }
        mCurrentRequestCode = 0;
    }

    private void handleLoginGoogle(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_CANCELED) {
            mOnLoginListener.onLoginError(requestCode, "");
            return;
        }
        if(mGoogleAuth != null) {
            callResult(requestCode, mGoogleAuth.getSignInAccount(data));
        }
    }

    private void handleLoginFacebook(int requestCode, int resultCode, Intent data) {
        if(mFacebookAuth != null) {
            mFacebookAuth.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void callResult(int requestCode, SocialAccount data) {
        if(mOnLoginListener == null) {
            return;
        }
        if(data != null) {
            mOnLoginListener.onLoginSuccess(data);
        } else {
            mOnLoginListener.onLoginError(requestCode, "");
        }
    }

    @Override
    public void onConnectionFailed(int errorCode, String message) {
        if(mOnLoginListener == null) {
            return;
        }
        mOnLoginListener.onLoginError(errorCode, message);
    }
}
