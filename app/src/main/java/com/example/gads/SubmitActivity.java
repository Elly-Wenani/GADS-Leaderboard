package com.example.gads;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(SubmitActivity.this, LeaderBoardActivity.class);
        startActivity(intent);
        SubmitActivity.this.finish();
    }
}