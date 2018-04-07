package org.ecloga.dynamico;

import android.app.Activity;
import android.util.Log;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

public class Util {

    public static void log(String tag, String msg) {
        Log.d((tag != null && !tag.isEmpty()) ? tag : "EMPTY TAG",
                (msg != null && !msg.isEmpty()) ? msg : "EMPTY MESSAGE");
    }

    public static void showMessage(int message, Context context) {
        showMessage(context.getString(message), context);
    }

    public static void showMessage(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static boolean hasNetworkAccess(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public static void blockTouches(Context context) {
        ((Activity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public static void allowTouches(Context context) {
        ((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public static void removeView(View v) {
        if(v.getParent() != null) {
            ((ViewGroup) v.getParent()).removeView(v);
        }
    }

    public static int dpToPixels(int dp, Context context) {
        return (int) (context.getResources().getDisplayMetrics().density * dp + 0.5f);
    }

    public static int dpStringToInt(String dimension, Context context) {
        String dp = dimension.substring(0, dimension.indexOf("dp"));

        return Util.dpToPixels(Integer.parseInt(dp), context);
    }
}