/*
 * *
 *  * Created by Adam Elaoumari on 09/08/20 00:46
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 09/08/20 00:46
 *
 */

package com.adamlbs.reportaggression;

import android.app.Application;
import android.os.Bundle;

import bugbattle.io.bugbattle.BugBattle;
import bugbattle.io.bugbattle.controller.BugBattleActivationMethod;


public class App extends Application {

        public void onCreate() {
            super.onCreate();

            BugBattle.initialise("5f2f25d4d88ab1cafe874a96", BugBattleActivationMethod.SHAKE, this);
        }
    }
