/*
 * *
 *  * Created by Adam Elaoumari on 09/08/20 00:46
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 20/01/20 17:50
 *
 */

package com.adamlbs.reportaggression;

import java.util.Date;


public class User {
    String username;
    String fullName;
    Date sessionExpiryDate;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSessionExpiryDate(Date sessionExpiryDate) {
        this.sessionExpiryDate = sessionExpiryDate;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getSessionExpiryDate() {
        return sessionExpiryDate;
    }
}
