package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ohtong on 2017-02-09.
 */

public class CrimeLab {
    private static CrimeLab instance;

    private List<Crime> mCrimes;

    public static CrimeLab getInstance(Context context) {
        if (instance == null) {
            instance = new CrimeLab(context);
        }

        return instance;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        /*for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("범죄 #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }*/
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID uuid) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(uuid)) {
                return crime;
            }
        }

        return null;
    }

    public int getIndex(UUID uuid) {
        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(uuid)) {
                return i;
            }
        }

        return -1;
    }
}
