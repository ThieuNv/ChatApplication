package data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import appchat.com.thieunv.chatapplication.R;
import model.User;

/**
 * Created by nguye on 10/7/2015.
 */
public class ListUserAdapter extends ArrayAdapter<User> {

    public ListUserAdapter(Context context, int resource, List<User> items ) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        Context mContext = getContext();

        if(v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(R.layout.line_student, parent, false);
        }


        User s = getItem(position);

        if(s != null) {
            TextView tvName = (TextView) v.findViewById(R.id.textViewName);
            tvName.setText(s.getName());

            TextView tvYear = (TextView) v.findViewById(R.id.textViewYBorn);
            tvYear.setText(String.valueOf(s.getyBorn()));

            ImageView imgView = (ImageView) v.findViewById(R.id.imageViewStudent);
            imgView.setImageResource(s.getImageId());
        }
        return v;
    }
}