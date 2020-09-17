package com.example.gads;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class SubmitActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtEmailAddress;
    private EditText txtGitLink;
    private Button submitProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        //Hooks
        imageView = findViewById(R.id.arrow);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtEmailAddress = findViewById(R.id.txtEmailAddress);
        txtGitLink = findViewById(R.id.txtGitLink);
        submitProject = findViewById(R.id.btnSubmitProject);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubmitActivity.this, LeaderBoardActivity.class);
                startActivity(intent);
                SubmitActivity.this.finish();
            }
        });

        submitProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDetails();
            }
        });
    }

    //Validate entered data
    private void userDetails() {
        isValidInfo();
    }

    //User input information
    private void isValidInfo() {
        String firstName = txtFirstName.getText().toString().trim();
        String lastName = txtLastName.getText().toString().trim();
        String emailAddress = txtEmailAddress.getText().toString().trim();
        String githubLink = txtGitLink.getText().toString().trim();

        if (firstName.isEmpty()) {
            txtFirstName.setError("Can't be empty");
            txtFirstName.requestFocus();

        } else if (lastName.isEmpty()) {
            txtLastName.setError("Can't be empty");
            txtLastName.requestFocus();

        } else if (emailAddress.isEmpty()) {
            txtEmailAddress.setError("Can't be empty");
            txtEmailAddress.requestFocus();

        } else if (githubLink.isEmpty()) {
            txtGitLink.setError("Can't be empty");
            txtGitLink.requestFocus();

        } else {
            Toast.makeText(this, firstName + lastName + emailAddress + githubLink, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(SubmitActivity.this, LeaderBoardActivity.class);
        startActivity(intent);
        SubmitActivity.this.finish();
    }
}