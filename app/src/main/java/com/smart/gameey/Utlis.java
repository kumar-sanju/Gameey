package com.smart.gameey;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utlis {

    public static int TEMPLATE = 0;

    public static boolean checkConnection(Context mContext) {
        ConnectivityManager conMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null) {
            return false;
        } else {
            return true;
        }
    }

}
