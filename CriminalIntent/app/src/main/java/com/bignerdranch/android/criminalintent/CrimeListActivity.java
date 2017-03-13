package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by ohtong on 2017-02-09.
 */

public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
