package com.appnet.android.social.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.text.TextUtils;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

class GoogleAuth implements GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;
    private OnConnectionFailedListener mOnConnectionFailedListener;

    GoogleAuth(FragmentActivity activity, OnConnectionFailedListener listener, String clientId) {
        mOnConnectionFailedListener = listener;
        init(activity, clientId);
    }

    private void init(FragmentActivity activity, String clientId) {
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
        if(!TextUtils.isEmpty(clientId)) {
            builder.requestIdToken(clientId);
        }
        builder.requestEmail();
        GoogleSignInOptions gso = builder.build();
        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .enableAutoManage(activity, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if(mOnConnectionFailedListener != null) {
            mOnConnectionFailedListener.onConnectionFailed(connectionResult.getErrorCode(), connectionResult.getErrorMessage());
        }
    }

    void signIn(Activity activity, int requestCode) {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        activity.startActivityForResult(signInIntent, requestCode);
    }

    private void internalSignOut(final OnLogoutListener listener) {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (listener != null) {
                    listener.onLogoutSuccess();
                }
            }
        });
    }

    void signOut(final OnLogoutListener listener) {
        if(mGoogleApiClient.isConnected()) {
            internalSignOut(listener);
        } else {
            mGoogleApiClient.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                @Override
                public void onConnected(@Nullable Bundle bundle) {
                    internalSignOut(listener);
                }

                @Override
                public void onConnectionSuspended(int i) {

                }
            });
            mGoogleApiClient.connect();
        }
    }

    SocialAccount getSignInAccount(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        GoogleSignInAccount acc = result.getSignInAccount();
        if(result.isSuccess() && acc != null) {
            SocialAccount.Builder builder = new SocialAccount.Builder();
            builder.provider("google");
            builder.email(acc.getEmail());
            builder.id(acc.getId());
            builder.displayName(acc.getDisplayName());
            builder.familyName(acc.getFamilyName());
            builder.givenName(acc.getGivenName());
            builder.idToken(acc.getIdToken());
            if(acc.getPhotoUrl() != null) {
                builder.photo(acc.getPhotoUrl().toString());
            }
            builder.serverAuthCode(acc.getServerAuthCode());
            return builder.build();
        } else {
            return null;
        }
    }
}
