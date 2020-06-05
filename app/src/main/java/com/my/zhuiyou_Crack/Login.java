package com.my.zhuiyou_Crack;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.izuiyou.network.NetCrypto;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.Arrays;

public class Login {

    private String str = "https://api.izuiyou.com/account/login";

    private String url = null;

    public void load_encrypt_so(View view) {
        JSONObject jSONObject;
        String aYA = "{\"phone\":\"17683927317\",\"pw\":\"fa8393b7153c7f52\",\"region_code\":86}";
        try {
            if (TextUtils.isEmpty(aYA)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(aYA);
            }
            byte[] bytes = jSONObject.toString().getBytes(Charset.forName("utf-8"));
            String originStr = Arrays.toString(bytes);
            Log.e("t1", "originStr:\n" + originStr);
            byte[] encodeAES = NetCrypto.encodeAES(bytes);
            String encodeStr = Arrays.toString(encodeAES);
            Log.e("t1", "encodeStr:\n" + encodeStr);
            byte[] dencodeAES = NetCrypto.decodeAES(encodeAES, false);
            String dencodeStr = Arrays.toString(dencodeAES);
            Log.e("t1", "dencodeStr:\n" + dencodeStr);
            url = NetCrypto.f(str, encodeAES);
            Log.e("t1", "url:\n" + url);

            String header = NetCrypto.getProtocolKey();
            Log.e("t1", "X-Xc-Proto-Req:\n" + header);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
