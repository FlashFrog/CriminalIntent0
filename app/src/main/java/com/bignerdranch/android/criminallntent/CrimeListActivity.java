package com.bignerdranch.android.criminallntent;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Leo on 2017/7/13.
 */

public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks,CrimeFragment.Callbacks {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId(){
        return R.layout.activity_masterdetail;
    }

    public void onCrimeSelected(Crime crime){
        if(findViewById(R.id.detail_fragment_container) == null){
            Intent intent = CrimeActivity.newIntent(this,crime.getId());
            startActivity(intent);
        }else{
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container,newDetail)
                    .commit();
        }
    }

    public void onCrimeUpdated(Crime crime){
        CrimeListFragment listFragment = (CrimeListFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
