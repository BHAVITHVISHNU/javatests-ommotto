package com.miniproject.thirdeye;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button submit;
    EditText username, password, confirm_password, email, stick_id;
    RequestQueue requestQueue;
    String insertUrl = "https://app-1488372866.000webhostapp.com/thirdeye/signup.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        confirm_password = (EditText) findViewById(R.id.editText5);
        email = (EditText) findViewById(R.id.editText6);
        stick_id = (EditText) findViewById(R.id.editText7);
        submit = (Button) findViewById(R.id.button3);
        requestQueue = Volley.newRequestQueue(getApplicationContext());


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirm_password.getText().toString().isEmpty() || email.getText().toString().isEmpty() || stick_id.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                } else if (!confirm_password.getText().toString().equals(password.getText().toString())) {

                    AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
                    alertDialog.setTitle("oops!");
                    alertDialog.setMessage("Passwords do not match");
                    alertDialog.show();

                } else


                {
                    Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                    submit_details();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        });

    }
    public void submit_details()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("username", username.getText().toString());
                parameters.put("password", password.getText().toString());
                parameters.put("email", email.getText().toString());
                parameters.put("stick_id", stick_id.getText().toString());

                return parameters;
            }
        };
        requestQueue.add(request);
    }

}

































