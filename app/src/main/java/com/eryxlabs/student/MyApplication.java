package com.eryxlabs.student;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.eryxlabs.student.models.User;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration config = new Configuration
                .Builder(this)
                .setDatabaseVersion(3)
                .setDatabaseName("students.db")
                .addModelClass(User.class)
                .create();
        ActiveAndroid.initialize(config);
    }
}
