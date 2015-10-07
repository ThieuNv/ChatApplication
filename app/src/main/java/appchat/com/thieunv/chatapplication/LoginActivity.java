package appchat.com.thieunv.chatapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText edtLoginUser;
    private EditText edtLoginPass;
    private Button flatBtnUserLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        *** Lam theo cach nay co the an actionbar ma ko can chinh sua trong file Manifest
         */
       /* ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1E88E5")));
        //actionBar.setTitle(Html.fromHtml("<font color='#2196F3'>ActionBarTitle </font>"));

        setContentView(R.layout.activity_login);


        edtLoginPass = (EditText) findViewById(R.id.edtLoginPass);
        edtLoginUser = (EditText) findViewById(R.id.edtLoginUser);
        flatBtnUserLogin = (Button) findViewById(R.id.flatBtnUserLogin);

        flatBtnUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = edtLoginUser.getText().toString();
                String uPass = edtLoginPass.getText().toString();

                if(!uName.equals("") || !uPass.equals("")) {
                    ParseUser.logInInBackground(uName, uPass, new LogInCallback() {
                        @Override
                        public void done(ParseUser parseUser, ParseException e) {
                            if(e == null) {
                                Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, ManagerUserActivity.class));  // ChatActivity.class
                            } else {
                                Toast.makeText(getApplicationContext(), "Not logged in", Toast.LENGTH_SHORT);
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter Username and Password", Toast.LENGTH_SHORT);
                }
            }
        });
    }

}
