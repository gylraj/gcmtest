package com.gylraj.gcmtest.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.gylraj.gcmtest.SharedPref;

/**
 * Created by mac on 10/01/2018.
 */

public class MyFirebaseInstanceIDService  extends FirebaseInstanceIdService {

    private static final String TAG = "CsFirebaseIIDService";
    private static final String PREF_APP_VERSION = "appVersion";
    private static final String PREF_GCM_REG_ID = "registration_id";
    public static String FirebaseToken = "";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        //epVzq9Yvyh8:APA91bFmXOn6lnj52VO0eUf3xUu3dfe5VTeYXrOvjWKBQkPO4OlavREEzJ1tj5f460JeLZxqx2hBmOWnEUSpF3RpX0kgxQobNYvEohdbT1aEH9eVvfSC2L3kU3KYAl1Cvc7gWGRP5S_F
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
        SharedPref.write("fcm_token",token);
    }
}
