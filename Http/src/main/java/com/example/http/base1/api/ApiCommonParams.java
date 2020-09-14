package com.example.http.base1.api;

import android.content.Context;
import android.text.TextUtils;

import com.example.http.base1.AppApplication;
import com.example.http.base1.util.Util;

import java.util.HashMap;

/**
 * Created by mac on 2020-08-06.
 */
public class ApiCommonParams {

    /**
     * 上下文
     */
    private static Context mContext = null;

    /**
     * 版本号(每个接口调用都需要传)
     */
    private static String mVersion = null;

    /**
     * IMEI
     */
    private static String mImei = null;

    /**
     * android id
     */
    private static String mAndroidId = null;

    /**
     * build_serial
     */
    private static String mBuildSerial = null;

    /**
     * 手机型号
     */
    private static String mPhoneModel = null;

    /**
     * 手机厂商
     */
    private static String mManufacturer = null;

    private static String mUid = "u01234345";

    static {
        mContext = AppApplication.mContext;
        mVersion = Util.getAppVersionName(mContext);
        mImei = Util.getImei(mContext);
        mAndroidId = Util.getAndroidId(mContext);
        mBuildSerial = Util.getBuildSerial(mContext);
        mPhoneModel = Util.getPhoneModel();
        mManufacturer = Util.getManufacturer();
    }

    /**
     * 获取通用公共参数
     */
    public static HashMap<String, String> fetchCommonsParams() {
        HashMap<String, String> params = new HashMap<>();

        params.put("client_type", "android");
        params.put("uid", mUid);


        if (!TextUtils.isEmpty(mAndroidId)) {
            params.put("android_id", mAndroidId);
        }
        if (!TextUtils.isEmpty(mBuildSerial)) {
            params.put("build_serial", mBuildSerial);
        }

        if (!TextUtils.isEmpty(mVersion)) {
            params.put("version", mVersion);
        }

        if (!TextUtils.isEmpty(mManufacturer)) {
            params.put("device_brand", mManufacturer);//厂商
        }
        if (!TextUtils.isEmpty(mPhoneModel)) {
            params.put("device_model", mPhoneModel);//型号
        }
        return params;
    }


}
