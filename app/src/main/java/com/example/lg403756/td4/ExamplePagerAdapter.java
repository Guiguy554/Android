package com.example.lg403756.td4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by lg403756 on 26/09/2016.
 */
public class ExamplePagerAdapter extends FragmentStatePagerAdapter {
    Fragment fr1;
    Fragment fr2;

    public ExamplePagerAdapter(FragmentManager fm) {
        super(fm);
        fr1 = new NumperPicker();
        fr2 = new MyFragment();
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new MyFragment();

        switch( i ) {
            case 0 :  {
                fragment = fr1;
                break;
            }
            case 1 : {
                fragment = fr2;
                break;
            }
        }

        return fragment;
    }
    @Override
    public int getCount() {
        //le nombre d’onglet
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String fragment = null;

        switch( position ) {
            case 0 :  {
                fragment = "Nombre";
                break;
            }
            case 1 : {
                fragment = "Texte";
                break;
            }
        }

        return "myFrag";
    }
}
