package com.minorius.smilaguide.firebase;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by minorius on 19.09.2017.
 */

public class NewsServiceInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        FirebaseInstanceId.getInstance().getToken();
    }
}
