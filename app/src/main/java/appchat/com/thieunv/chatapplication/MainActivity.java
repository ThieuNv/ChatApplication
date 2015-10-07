package appchat.com.thieunv.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private Button btnCreateNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set fullscreen
        /*requestWindowFeature(Window.FEATURE_SWIPE_TO_DISMISS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.flatBtnLogin);
        btnCreateNewAccount = (Button) findViewById(R.id.flatBtnCreateNewAccount);

        btnLogin.setOnClickListener(this);
        btnCreateNewAccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.flatBtnLogin:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.flatBtnCreateNewAccount:
                startActivity(new Intent(MainActivity.this, CreateAccount.class));
        }
    }

}
