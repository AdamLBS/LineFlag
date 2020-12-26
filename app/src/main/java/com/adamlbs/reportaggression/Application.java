/*
 * *
 *  * Created by Adam Elaoumari on 26/12/20 00:59
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 19/12/20 21:42
 *
 */

package com.adamlbs.reportaggression;

import android.util.Log;

import androidx.annotation.NonNull;

import com.linkedin.android.shaky.EmailShakeDelegate;
import com.linkedin.android.shaky.Shaky;
import com.linkedin.android.shaky.ShakyFlowCallback;

import static android.content.ContentValues.TAG;

public class Application extends android.app.Application {
    private Shaky shaky;

    @Override
    public void onCreate() {
        super.onCreate();
        shaky = Shaky.with(this, new EmailShakeDelegate("adam@admlbs.fr") {


        }, new ShakyFlowCallback() {
            @Override
            public void onShakyStarted(@ShakyFlowCallback.ShakyStartedReason int reason) {
                Log.d(TAG, "onShakyStarted: " + reason);
            }

            @Override
            public void onShakyFinished(@ShakyFinishedReason int reason) {
                Log.d(TAG, "onShakyFinished: " + reason);
            }

            @Override
            public void onUserPromptShown() {
                Log.d(TAG, "onUserPromptShown");
            }

            @Override
            public void onCollectingData() {
                Log.d(TAG, "onCollectingData");
            }

            @Override
            public void onConfiguringFeedback() {
                Log.d(TAG, "onConfiguringFeedback");
            }
        });
    }

    @NonNull
    public Shaky getShaky() {
        return shaky;
    }

}

