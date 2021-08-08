package com.example.project3;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Bundle bundle = getIntent().getExtras();
        String receivedUsername = bundle.getString("username");
        String receivedPassword = bundle.getString("password");


        Button submit = findViewById(R.id.loginsubmit);
        submit.setOnClickListener(v -> {
            EditText t1 = findViewById(R.id.loginusername);
            EditText t2 = findViewById(R.id.loginpassword);
            String s1 = t1.getText().toString().trim();
            String s2 = t2.getText().toString().trim();
            if (s1.equals(receivedUsername) && s2.equals(receivedPassword)) {
                Toast.makeText(this, "Login Granted", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Login.this,Welcome.class));
            } else {
                counter++;
                Toast.makeText(this, "Invalid Creditionals!!2 Attempts Left", Toast.LENGTH_LONG).show();
                if(counter==1){
                    Toast.makeText(this, "Invalid Creditionals!!2 Attempts Left", Toast.LENGTH_LONG).show();
                }
                if (counter == 2) {
                    Toast.makeText(this, "Invalid Creditionals!!1 Attempts Left", Toast.LENGTH_LONG).show();
                }
                if(counter==3){
                    Toast.makeText(this, "Login Attempt Denied!!0 Attempts Left", Toast.LENGTH_LONG).show();
                    submit.setEnabled(false);
                }
            }
        });

    }
}