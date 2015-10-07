package appchat.com.thieunv.chatapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import Util.ProgressGenerator;

public class CreateAccount extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {

    private EditText edtEmail;
    private EditText edtUsername;
    private EditText edtPassword;
    private ProgressGenerator progressGenerator;
    private ActionProcessButton btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        /*
        *** Tao nut quay tro ve Man hinh chinh
         */
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1E88E5")));
        //actionBar.setTitle(Html.fromHtml("<font color='#2196F3'>ActionBarTitle </font>"));
        //<item name="colorPrimaryDark">@color/<Color of your choice></item>
        //actionBar.

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtUsername = (EditText) findViewById(R.id.edtAccountName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        progressGenerator = new ProgressGenerator(this);

        btnCreateAccount = (ActionProcessButton) findViewById(R.id.flatBtnUserCreateAccount);
        btnCreateAccount.setMode(ActionProcessButton.Mode.PROGRESS);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

    }

    private void createAccount() {
        final String uEmail = edtEmail.getText().toString();
        final String uName = edtUsername.getText().toString();
        final String uPass = edtPassword.getText().toString();

        if(uEmail.equals("") || uName.equals("") || uPass.equals("")) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(CreateAccount.this);
            dialog.setTitle("Empty Fields");
            dialog.setMessage("Please complete the form");
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } else {
            ParseUser user = new ParseUser();

            //Set core properties
            user.setUsername(uName);
            user.setEmail(uEmail);
            user.setPassword(uPass);

            //set custom properties
            user.put("city", "Ha Noi");

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null) {
                        progressGenerator.start(btnCreateAccount);
                        btnCreateAccount.setEnabled(false);

                        edtEmail.setEnabled(false);
                        edtPassword.setEnabled(false);
                        edtUsername.setEnabled(false);

                        // log them in right away
                        logUserIn(uName, uPass);
                    } else {

                    }
                }
            });
        }
    }

    private void logUserIn(String uName, String uPass) {
        if(!uName.equals("") || !uPass.equals("")) {
            ParseUser.logInInBackground(uName, uPass, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if(e == null) {
                        Log.v("USER LOGGED IN IS:" , parseUser.getUsername());
                    } else {

                    }
                }
            });
        } else {

        }
    }


    @Override       // when create account successful
    public void onComplete() {

        startActivity(new Intent(CreateAccount.this, ManagerUserActivity.class));  // ChatActivity.class
    }

}
