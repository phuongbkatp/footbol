package com.appnet.android.football.sofa.helper;


import android.content.res.Resources;

import com.appnet.android.football.sofa.R;

public final class TransferHelper {

    public static String getTransferType(Resources res, int type) {
        int resId = R.string.transfer_type_default;
        if(type == 1) {
            resId = R.string.transfer_type_loan;
        } else if(type == 2) {
            resId = R.string.transfer_type_end_of_loan;
        }
        return res.getString(resId);
    }
}
