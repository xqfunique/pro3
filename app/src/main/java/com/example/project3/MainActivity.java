package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signup = findViewById(R.id.signup);
        signup.setOnClickListener(v -> {
            EditText username, password;
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            String usrn = username.getText().toString();
            String pswrd = password.getText().toString();

            if (checkString(pswrd)) {
                Toast.makeText(MainActivity.this, "SignUp Successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Login.class);
                intent.putExtra("username",usrn);
                intent.putExtra("password",pswrd);
                startActivity(intent);
            }else{
                Toast.makeText(MainActivity.this, "Password Should Be Unique", Toast.LENGTH_SHORT).show();
            }

        });
    }
    static boolean checkString(String str) {
        char ch;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialFlag = false;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else if (ch == '#' || ch == '@' || ch == '%' || ch == '_') {
                specialFlag = true;
            }
            if (numberFlag && upperCaseFlag && lowerCaseFlag && specialFlag)
                return true;
        }
        return false;
    }
}