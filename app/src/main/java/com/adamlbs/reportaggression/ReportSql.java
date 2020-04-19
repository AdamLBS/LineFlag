package com.adamlbs.reportaggression;
import android.app.ProgressDialog;
import android.widget.EditText;
import android.widget.ProgressBar;

public class ReportSql {
    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";
    private EditText etUsername;
    private EditText etPassword;
    private String line;
    private String password;
    private ProgressBar pDialog;
    private String login_url = "https://api.aggressionreport.fr/login.php";
    private SessionHandler session;

}
