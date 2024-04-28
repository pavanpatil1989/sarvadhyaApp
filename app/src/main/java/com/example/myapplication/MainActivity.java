package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity  {

    private Button loginButton;
    private String TAG="MainActivity";
    private EditText edtuserName,edtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        updateUI();
        SetUpListner();
    }

    public void updateUI(){
        try {
            loginButton = (Button) findViewById(R.id.login);
            edtuserName = (EditText) findViewById(R.id.userName);
            edtPassword = (EditText) findViewById(R.id.password);

        }
        catch (Exception e1){
            Log.e(TAG,"initilaization exception:"+e1.getMessage());
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("value",edtuserName.getText().toString()+" "+edtPassword.getText().toString());
                    if (edtuserName.getText().toString().equalsIgnoreCase("admin") && edtPassword.getText().toString().equals("admin")){
                        Intent i = new Intent(MainActivity.this, BillingActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    Toast.makeText(getApplicationContext(), "Please enter correct credentials", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Log.e("ex",e.getMessage());
                }

            }
        });
    }
    public void SetUpListner(){

    }
    @Override
    protected void onResume() {
        super.onResume();
        getSupportActionBar().hide();

    }


}
