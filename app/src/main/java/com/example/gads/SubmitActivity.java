package com.example.gads;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gads.Services.ProjectSubmissionService;
import com.example.gads.Services.ServiceBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtEmailAddress;
    private EditText txtGitLink;
    private Button submitProject;
    private String TAG = "SubmitActivity";
    private SweetAlertDialog sweetAlertDialog;

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
        verifyDetails();
    }

    //Submit project with retrofit
    private void funSubmitProject() {

        sweetAlertDialog = new SweetAlertDialog(SubmitActivity.this,
                SweetAlertDialog.PROGRESS_TYPE);
                sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setTitleText("Please wait")
                .show();

        ProjectSubmissionService projectSubmissionService
                = ServiceBuilder.builderService(ProjectSubmissionService.class);
        Call<Void> submitProjectRequest = projectSubmissionService.submitProject(
                txtFirstName.getText().toString().trim(),
                txtLastName.getText().toString().trim(),
                txtEmailAddress.getText().toString().trim(),
                txtGitLink.getText().toString().trim()
        );

        submitProjectRequest.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Submitted " + response.body());
                    sweetAlertDialog.hide();
                    successDialogue();

                } else {
                    Log.d(TAG, "onResponse: could not submit " + response.body());
                    sweetAlertDialog.hide();
                    failedDialogue();

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d(TAG, "onResponse: Failed to submit " + t.getMessage());
                sweetAlertDialog.hide();
                failedDialogue();

            }
        });
    }

    //Validate user details to prevent empty inputs
    private void verifyDetails() {

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

            sweetAlertDialog = new SweetAlertDialog(SubmitActivity.this,
                    SweetAlertDialog.NORMAL_TYPE);
            sweetAlertDialog.setTitleText("Are you sure?")
                    .setConfirmButton("Yes", new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.hide();
                            funSubmitProject();
                        }
                    })
                    .show();
        }
    }

    //Dialogue to show success in submission
    public void successDialogue() {
        sweetAlertDialog = new SweetAlertDialog(SubmitActivity.this,
                SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setTitleText("Submission Successful")
                .hideConfirmButton()
                .show();
    }

    //Dialogue for failed submission
    public void failedDialogue() {
        sweetAlertDialog = new SweetAlertDialog(SubmitActivity.this,
                SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog
                .setTitleText("Submission not successful")
                .hideConfirmButton()
                .show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(SubmitActivity.this, LeaderBoardActivity.class);
        startActivity(intent);
        SubmitActivity.this.finish();
    }
}