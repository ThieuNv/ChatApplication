package manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import appchat.com.thieunv.chatapplication.R;
import data.ListUserAdapter;
import model.User;

/**
 * Created by nguye on 10/6/2015.
 */

public class Page1 extends Fragment {

    private TextView tvTitle;
    private ListView lvUser;
    private ArrayList<User> al;

    private String [] arr_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        tvTitle = (TextView) findViewById(R.id.textViewTitle);
        lvUser = (ListView) findViewById(R.id.listView);

        al = new ArrayList<User>();

        arr_name = getResources().getStringArray(R.array.array_name);
        int yearT[] = {1990, 1991, 1992, 1993, 1995, 1996, 1997, 1989};
        String imgCode[] = {"q", "w", "e" ,"r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "l", "k", "z", "x", "c", "v", "b", "n", "n", "m"};
        int A[] = new int[8];
        for(int j = 1; j < A.length; j++) {
            A[j] = R.drawable.logo +0 ;
        }

        int temp;
//        for(int i = 1; i < 8; i++) {

        al.add(new User(arr_name[1], A[5] , yearT[1]));
        al.add(new User(arr_name[2], A[2], yearT[2]));
        al.add(new User(arr_name[3], A[2] , yearT[4]));
        al.add(new User(arr_name[4], A[1] , yearT[4]));
        al.add(new User(arr_name[5], A[5] , yearT[4]));
        al.add(new User(arr_name[6], A[1] , yearT[5]));
        al.add(new User(arr_name[7], A[1] , yearT[6]));
        al.add(new User(arr_name[1], A[5] , yearT[7]));
        al.add(new User(arr_name[1], A[5] , yearT[7]));
        al.add(new User(arr_name[1], A[5] , yearT[7]));
        al.add(new User(arr_name[1], A[5] , yearT[7]));
        al.add(new User(arr_name[1], A[5] , yearT[7]));
        al.add(new User(arr_name[1], A[5] , yearT[7]));
        al.add(new User(arr_name[1], A[5] , yearT[7]));


        //ListAdapter la = new ListAdapter(Page1.this, R.layout.line_student, al);
        ListUserAdapter la = new ListUserAdapter(getContext(), R.layout.line_student,al);


        lvUser.setAdapter(la);

        if (container == null) {
            return null;
        }

        return (LinearLayout) inflater.inflate(R.layout.page1, container, false);
    }


}

