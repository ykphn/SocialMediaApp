package com.example.SocialMediaApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.SocialMediaApp.databinding.ActivityLoginBinding;
import com.example.SocialMediaApp.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private UserRepository userRepository;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        userRepository = new UserRepository(this);
        binding.btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.editTextUsername.getText().toString();
                String password = binding.editTextPassword.getText().toString();

                if(email.equals("")||password.equals(""))
                    Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = userRepository.checkEmailPassword(email, password);

                    if(checkCredentials == true){
                        Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "User not found ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        binding.btnKayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.editTextUsername.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                Boolean checkUserEmail = userRepository.checkEmail(email);

                if(email.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Email veya sifre boş olamaz", Toast.LENGTH_SHORT).show();
                    
                } else if (checkUserEmail == false) {
                    Boolean insert = userRepository.insertData(email, password);
                    if(insert == true){
                        Toast.makeText(getApplicationContext(), "Signup Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "User already exists! Please login", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}