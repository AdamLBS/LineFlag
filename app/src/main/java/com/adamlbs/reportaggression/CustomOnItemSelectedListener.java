/*
 * *
 *  * Created by Adam Elaoumari on 09/08/20 00:46
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 09/08/20 00:46
 *
 */

package com.adamlbs.reportaggression;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;


public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        //
        //
        // TODO Auto-generated method stub
    }

}