package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login1 extends AppCompatActivity {
    private Button enter;
    private EditText account;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_1);

        Button back = (Button) findViewById(R.id.back);
        Button enter = (Button) findViewById(R.id.enter);

        enter.setOnClickListener(listener);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login1.this, Login.class);
                startActivity(intent);
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login1.this, Login2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.enter:
                    String p = password.getText().toString();
                    if (p.equals("123456")) {
                        Toast toast = Toast.makeText(Login1.this, "密碼正確，歡迎使用提款功能", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 50, 0);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(Login1.this, "密碼錯誤，請重新輸入", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 50, 0);
                        toast.show();
                        password.setText("");
                    }
                    break;
            }
        }
    };
}
