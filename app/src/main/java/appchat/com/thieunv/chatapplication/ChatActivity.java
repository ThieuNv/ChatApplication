package appchat.com.thieunv.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import Util.ProgressGenerator;
import data.ChatAdapter;
import model.Message;

public class ChatActivity extends AppCompatActivity {

    private EditText message;
    private Button btnSend;
    private ProgressGenerator progressGenerator;

    public static final String USER_ID_KEY = "userId";
    private String currentUserId;
    private ListView listView;
    private ArrayList<Message> mMessage;
    private ChatAdapter mAdapter;
    private Handler handler = new Handler();

    private static final int MAX_CHAT_MSG_TO_SHOW = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        getCurrentUser();

        handler.postDelayed(runnable, 100);
    }

    private void getCurrentUser() {
        this.currentUserId = ParseUser.getCurrentUser().getObjectId();
        messagePosting();
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            receiveMessage();
            handler.postDelayed(this, 100);
        }
    };

    private void messagePosting() {
        message = (EditText) findViewById(R.id.edtMessages);
        btnSend = (Button) findViewById(R.id.buttonSend);
        listView = (ListView) findViewById(R.id.listViewChat);

        mMessage = new ArrayList<Message>();
        mAdapter = new ChatAdapter(ChatActivity.this, currentUserId, mMessage);
        listView.setAdapter(mAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!message.getText().toString().equals("")) {
                    Message msg = new Message();
                    msg.setUserId(currentUserId);
                    msg.setBody(message.getText().toString());

                    msg.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            receiveMessage();
                        }
                    });

                   // message.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Empty messages", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void receiveMessage() {
        ParseQuery<Message> query = ParseQuery.getQuery(Message.class);
        query.setLimit(MAX_CHAT_MSG_TO_SHOW);
        query.orderByAscending("createdAt");

        query.findInBackground(new FindCallback<Message>() {
            @Override
            public void done(List<Message> messages, ParseException e) {
                if (e == null) {
                    mMessage.clear();
                    mMessage.addAll(messages);
                    mAdapter.notifyDataSetChanged();
                    listView.invalidate();      //allow listview to be redrawn

                } else {
                    Log.v("Error", "Error:" + e.getMessage());
                }
            }
        });
    }
    private void refreshMessage() {
        receiveMessage();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }


    //Xu ly logout khi user thoat ra ngoai
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            ParseUser.logOutInBackground(new LogOutCallback() {
                @Override
                public void done(ParseException e) {

                    if(e == null) {
                        startActivity(new Intent(ChatActivity.this, MainActivity.class));
                    } else {

                    }
                }
            });

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
