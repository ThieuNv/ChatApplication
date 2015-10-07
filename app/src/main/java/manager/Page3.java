package manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import appchat.com.thieunv.chatapplication.R;

/**
 * Created by nguye on 10/6/2015.
 */
public class Page3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if(container == null)
        {
            return null;
        }

        return (LinearLayout)inflater.inflate(R.layout.page3, container, false);
    }


}