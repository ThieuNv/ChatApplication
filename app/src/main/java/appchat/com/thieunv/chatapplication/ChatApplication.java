package appchat.com.thieunv.chatapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import model.Message;

/**
 * Created by nguye on 9/28/2015.
 */
public class ChatApplication extends Application {

    public static final String APP_KEY_ID = "Xbmii154CkTSBZ0YpPnoyxcBpNVOLLGSgSSghVK1";
    public static final String APP_CLIENT_ID = "7r8Qih3oNhcq8lTqeoruOrqdwFcISjKz3XTqXXpw";

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);

        ParseObject.registerSubclass(Message.class);

        Parse.initialize(this, APP_KEY_ID, APP_CLIENT_ID);
    }
}
