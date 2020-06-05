package com.izuiyou.network;

public class NetCrypto {
    public static native byte[] decodeAES(byte[] bArr, boolean z);

    public static native byte[] encodeAES(byte[] bArr);

    public static native String generateSign(byte[] bArr);

    public static native String getProtocolKey();

    private static native void native_init();

    public static native boolean registerDID(byte[] bArr);

    public static native void setProtocolKey(String str);

    public static native String sign(String str, byte[] bArr);

    static {
//        bxa.S(cmh.getAppContext().getApplicationContext(), "net_crypto");
        System.loadLibrary("net_crypto");
        native_init();
    }

    public static String f(String str, byte[] bArr) {
        String str2;
        String sign = sign(str, bArr);
        if (str.contains("?")) {
            StringBuilder sb = new StringBuilder();
            sb.append("&sign=");
            sb.append(sign);
            str2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("?sign=");
            sb2.append(sign);
            str2 = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str2);
        return sb3.toString();
    }

    public static String g(String str, byte[] bArr) {
        String str2;
        String generateSign = generateSign(bArr);
        if (str.contains("?")) {
            StringBuilder sb = new StringBuilder();
            sb.append("&sign=");
            sb.append(generateSign);
            str2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("?sign=");
            sb2.append(generateSign);
            str2 = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str2);
        return sb3.toString();
    }
}