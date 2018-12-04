package com.doransoft.np.homeservice.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.google.gson.Gson;


import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class GeneralUtils {


    //error message from network
    public static String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void showMessage(Activity activity, String message) {

        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
//


    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void statusColorChange(Activity activity, int color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(activity, color));
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getDeviceIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        } else {
            return "0000000000000000";
        }
    }




    public static String contactPicked(Intent data, Activity activity) {

        Cursor cursor = null;
        String phoneNo = null;
        String name = null;

        try {
            // getData() method will have the Content Uri of the selected contact

            Uri uri = data.getData();

            //Query the content uri

            cursor = activity.getContentResolver().query(uri, null, null, null, null);

            cursor.moveToFirst();

            // column index of the phone number

            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            // column index of the contact name

            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

            phoneNo = cursor.getString(phoneIndex);

            name = cursor.getString(nameIndex);


        } catch (Exception e) {

            e.printStackTrace();

        }
        return phoneNo;
    }


    public static boolean numberValidate(String phone, TextView tv_error_success, EditText editTextPhone) {
        if(phone!=null){
            if (phone.startsWith("980") || phone.startsWith("981") || phone.startsWith("982") || phone.startsWith("984") || phone.startsWith("985")) {
                tv_error_success.setVisibility(GONE);
                return true;
            } else {
                editTextPhone.startAnimation(shakeError());
                tv_error_success.startAnimation(shakeError());
                tv_error_success.setVisibility(VISIBLE);
                tv_error_success.setTextColor(Color.RED);
                tv_error_success.setText("Invalid number");

                return false;
            }
        }else {
            return false;
        }

    }


    public static TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(7));
        return shake;
    }

}

