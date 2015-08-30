package com.changetheworldfrom2015.arriving;

import com.changetheworldfrom2015.arriving.model.Event;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseTwitterUtils;

/**
 * Created by qiucenzhang on 7/14/15.
 */
public class ArrivalApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Required - Initialize the Parse SDK
        ParseObject.registerSubclass(Event.class);

        Parse.initialize(this);

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        ParseFacebookUtils.initialize(this);

        ParseTwitterUtils.initialize(getString(R.string.twitter_consumer_key),
                getString(R.string.twitter_consumer_secret));
    }
}