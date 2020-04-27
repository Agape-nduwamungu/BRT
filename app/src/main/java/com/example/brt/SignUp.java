package com.example.brt;

import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.Window;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import android.app.ProgressDialog;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.signin.SignIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.util.Log.w;
import static android.widget.Toast.makeText;

public class SignUp extends AppCompatActivity {
    EditText firstname,lastname,pass_word,email_address,gender;
    Button signUp;
    TextView signIn;

    //private FirebaseAuth mAuth;
    //private static final String TAG = "SignIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstname = findViewById(R.id.fstname);
        lastname = findViewById(R.id.lstname);
        pass_word = findViewById(R.id.passwrd);
        email_address = findViewById(R.id.emailaddress);
        gender = findViewById(R.id.gender);
        signIn = findViewById(R.id.text2);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Main_Screen.class));

                //mAuth = FirebaseAuth.getInstance();


                signUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String email = email_address.getText().toString().trim();
                        String password = pass_word.getText().toString().trim();

                        if (TextUtils.isEmpty(email)) {
                            makeText(SignUp.this, "Enter Email Address!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(password)) {
                            makeText(SignUp.this, "Enter Password!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (password.length() < 6) {
                            makeText(SignUp.this, "Password too short, enter minimun of 6 characters", Toast.LENGTH_SHORT).show();
                            return;
                        }
                /*mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG,"createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUp.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                                // ...
                            }

                        });*/

                    }
            /*private void updateUI(FirebaseUser user)
            {
                if (user != null)
            {
                startActivity(new Intent(SignUp.this, Main_Screen.class));
                }
            }*/
                });

            }
        });
    }}
