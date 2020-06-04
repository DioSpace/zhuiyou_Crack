package com.m4399.framework.helpers;

public class AppNativeHelper {
    public static native int applyPatch(String str, String str2, String str3);

    public static native int delayRestartProcess(String str, String str2, long j);

    public static final native String desCbcDecrypt(String str);

    public static final native String desCbcEncrypt(String str);

    public static native boolean extractSubdir(String str, String str2, String str3);

    public static final native String getDailySignApi(String str);

    public static final native String getFileMd5(String str);

    public static native String getGameBoxApi(String str);

    public static final native String getGiftApi(String str);

    public static final native String getHebiApi(String str);

    public static final native String getMd5(String str);

    public static final native String getServerApi(String str);

    public static native int makePatch(String str, String str2, String str3);

    public static final native String tokenDecrypt(String str);

    public static final native String tokenEncrypt(String str);

    public static native void uninstall(String str, int i, String str2, boolean z);

    static {
        System.loadLibrary("m4399");
    }

}