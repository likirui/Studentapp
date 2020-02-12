package com.eryxlabs.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eryxlabs.student.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.editEmail)
    EditText editEmail;

    @BindView(R.id.editFullName)
    EditText editFullname;

    @BindView(R.id.editPassword)
    EditText  editPassword;

    @BindView(R.id.editPhone)
    EditText editPhone;

    @BindView(R.id.btnSignup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        //Sign Up click
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateRegisterInput();
            }
        });
    }

    /**
     * We will validate the input
     *
     */
    private void validateRegisterInput() {
        String fullname =  editFullname.getText().toString();
        String phone =  editPhone.getText().toString();
        String email =  editEmail.getText().toString();
        String password =  editPassword.getText().toString();
        if(fullname.equals("") || phone.equals("") || email.equals("") || password.equals("")){
            Toast.makeText(this,"Please fill in all the fields.",
                    Toast.LENGTH_SHORT).show();
        }else{
            // here we will do the saving.
            User user = new User(fullname,phone,email,password);
            user.save();

            Toast.makeText(this,"Saved successfully!.",
                    Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this,StudentListActivity.class));
        }
    }

}
