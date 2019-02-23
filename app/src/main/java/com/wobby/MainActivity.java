package com.wobby;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int LOGIN_CODE = 1;

    private TextView tv;
    private Button b1;

    private boolean isSignedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isSignedIn = false;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        //startActivityForResult(intent, LOGIN_CODE);

        tv = findViewById(R.id.textView);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(isSignedIn){
                    intent = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(intent);
                }else{
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivityForResult(intent, LOGIN_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case LOGIN_CODE:
                if(resultCode == Activity.RESULT_OK){
                    tv.setText("Welcome back, " + data.getStringExtra("email"));
                    Toast.makeText(this, "tested", Toast.LENGTH_LONG).show();
                    isSignedIn = true;
                }
            break;
        }
    }
}
