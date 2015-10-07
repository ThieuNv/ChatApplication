package data;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by nguye on 10/6/2015.
 */
public class PageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public PageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        // TODO Auto-generated constructor stub
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return this.fragments.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return this.fragments.size();
    }
}