package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("LA1ikIeZIFfAib74tnnbqwziC52GqgHXU5YBBJA3")
                .clientKey("DrwuppFu6FYA9ywdWAhgntx0ZyZmA5uCNmfCfebu")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
