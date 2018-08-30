package com.example.livingroom.sharedpreferences29aug;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUserName,edtPassword;
    private Button saveButton,showButton;
    private TextView txtCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        saveButton = findViewById(R.id.saveButton);
        showButton = findViewById(R.id.showButton);
        txtCredentials = findViewById(R.id.txtUserCredential);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("UserName",edtUserName.getText().toString());
                editor.putString("Password",edtPassword.getText().toString());
                editor.apply();

                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences("UserInfo",Context.MODE_PRIVATE);
                String name = sharedPref.getString("UserName","");
                String password = sharedPref.getString("Password","");
                txtCredentials.setText(name+" "+password);
            }
        });
    }
}