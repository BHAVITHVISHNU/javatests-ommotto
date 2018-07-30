package com.miniproject.thirdeye;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button SIGN_IN, SIGN_UP;
    String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        SIGN_IN = (Button) findViewById(R.id.button);
        SIGN_UP = (Button) findViewById(R.id.button2);
        SIGN_IN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()&& password.getText().toString().isEmpty())
                {

                    Toast.makeText(getApplicationContext(),"Enter the values",Toast.LENGTH_SHORT).show();
                }
               else if(username.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Username",Toast.LENGTH_SHORT).show();
                }
                else if (password.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
                }
                else {

                    user = username.getText().toString().trim();
                    pass = password.getText().toString().trim();

                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setMessage("Loading....");
                    progressDialog.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://app-1488372866.000webhostapp.com/thirdeye/login.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if (response.trim().equals("success")) {
                                        progressDialog.dismiss();

                                        Intent intent = new Intent(getApplicationContext(),location.class);
                                        startActivity(intent);


                                    } else {
                                        progressDialog.dismiss();
                                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    progressDialog.dismiss();
                                    Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("username", user);
                            params.put("password", pass);
                            return params;
                        }

                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                    requestQueue.add(stringRequest);
                }
            }
        });
        SIGN_UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
