package com.miniproject.thirdeye;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 01-03-2017.
 */
public class LoginRequest extends StringRequest {
    private static String URL="https://app-1488372866.000webhostapp.com/thirdeye/login.php";
    private Map<String,String> params;
    public LoginRequest(String username,String password,Response.Listener<String> listener) {
        super(Request.Method.POST,URL, listener, null);
        params=new HashMap<>();
        Log.i("Response username", username);
        Log.i("Response password", password);
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
