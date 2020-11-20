/*
 * *
 *  * Created by Adam Elaoumari on 20/11/20 18:20
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 20/11/20 15:03
 *
 */

package com.adamlbs.reportaggression;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

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

    public void setShakyTheme(@StyleRes Integer theme) {
    }

    public void setShakyPopupTheme(@StyleRes Integer theme) {

    }
}

