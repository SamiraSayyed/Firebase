package com.example.user.firebasedemo1;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Practise extends AppCompatActivity {
    private EditText etemail;
    private EditText etpassword;
    ProgressDialog progressDialog;
    private Button btnregister;
    private String mail;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnregister=(Button)findViewById(R.id.register);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Register();
            }
        });
    }

        public void Register(){
            progressDialog.show();
        etemail=(EditText)findViewById(R.id.etname);
            mail=etemail.getText().toString();
        etpassword=(EditText)findViewById(R.id.etpass);
            password=etpassword.getText().toString();

        final FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                onUserLeaveHint();
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
