package com.my.zhuiyou_Crack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.izuiyou.network.NetCrypto;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String str = "https://api.izuiyou.com/account/login";
    private byte[] bArr = {-22, 11, -87, -87, -71, -71, -56, -56, -40, -40, -121, -121, -121, -105, -105, -90, 88, -53, -59, 16, 76, -41, 92, 71, -60, -75, -54, -103, 12, 107, -90, 107, 110, -95, -28, 67, -7, -101, -65, -120, 122, -97, -29, 12, 90, -58, 71, -10, 116, 18, 76, -84, -127, 125, -72, 97, 12, 4, -98, -12, 111, 97, -108, 107, 105, 127, 35, 30, 64, -2, 114, -94, -19, 91, -96, 83, -25, 93, -67, 21, -17, -22, 45, 86, -54, 88, 46, -120, -41, 10, 54, 99, -118, 38, 23, -85, 73, 74, -82, -59, -84, 78, 12, 91, -97, 103, -27, -121, -116, 62, -102, -53, 100, 7, -94, -14, -61, 2, -110, 32, 82, -81, 39, -39, 65, -63, -23, -115, 121, -128, -110, 119, -14, -110, -100, -37, -21, 91, -72, 18, -44, 71, 33, 86, 104, 30, -44, -103, -33, -2, 80, 33, -99, 71, 13, -26, 108, 65, 115, 10, 116, 118, 99, -67, 87, 79, 13, 25, 49, -73, 127, -93, 93, -49, 60, 103, 88, -9, -21, 18, 25, 33, 32, 116, 82, 109, -87, -51, -52, -98, -50, -112, 8, -47, -107, -84, -60, -30, 126, -110, 54, 38, 61, 21, -16, 2, -5, 18, -69, 98, 99, -5, -1, 8, 111, 51, 25, 115, -5, 23, -106, -34, -28, -81, -119, -4, -80, 59, 67, 111, -46, -19, 23, 54, 8, 58, 74, -73, -82, 123, 100, 97, 68, -96, -30, 102, 32, 108, -53, -95, 125, -92, -72, -106, 55, 118, -23, 43, -102, 68, -88, -122, 101, 48, -60, -102, 47, 47, 45, -18, 20, -39, -22, -23, 120, 85, -82, 11, 41, -128, 93, 99, 58, -95, -72, -46, -61, 30, 95, -23, -18, -77, -112, -29, -36, -107, -109, 76, 59, -89, -33, 48, -7, 62, 15, -126, 2, 36, -71, -125, -85, -14, 25, -21, -120, 12, 27, 103, 106, 5, 92, 111, -121, 59, -103, -94, -59, -35, -74, 118, -52, 73, 81, -74, 52, 86, -70, 20, 88, 86, 64, 21, -94, 1, -116, -40, -74, -77, 39, -70, -84, 30, 120, -76, 108, 26, 93, 99, -115, 94, 49, -65, -62, -114, -66, -45, -1, -86};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


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
            String result = NetCrypto.f(str, encodeAES);
            Log.e("t1", "result:\n" + result);

//            NetCrypto.setProtocolKey();
            String header = NetCrypto.getProtocolKey();
            Log.e("t1", "X-Xc-Proto-Req:" + header);

            Toast.makeText(this,header,Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}