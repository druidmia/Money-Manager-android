package com.tonight.manage.organization.managingmoneyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 3 on 2016-11-14.
 */

public class Pager extends FragmentStatePagerAdapter {
    int tabCount;
    String eventName;
    String eventnum;

    public Pager(FragmentManager fm, int tabCount , String eventName, String eventnum) {
        super(fm);
        this.tabCount = tabCount;
        this.eventName = eventName;
        this.eventnum = eventnum;
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PaymentFragment paymentFragment = new PaymentFragment();
                Bundle paymentB = new Bundle();
                paymentB.putString("eventName", eventName);
                paymentB.putString("eventnum",eventnum);
                paymentFragment.setArguments(paymentB);
                return paymentFragment;
            case 1:
                UsageFragment userFragment = new UsageFragment();
                Bundle usageB = new Bundle();
                usageB.putString("eventnum",eventnum);
                userFragment.setArguments(usageB);
                return userFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}