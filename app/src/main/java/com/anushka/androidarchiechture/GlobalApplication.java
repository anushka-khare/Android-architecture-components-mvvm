package com.anushka.androidarchiechture;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import constants.ApplicationConstants;
import database.UserDatabase;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anushka on 13-04-2018.
 */

public class GlobalApplication extends Application {

    private static Retrofit retrofit;
    private static UserDatabase roomDatabase;

    public static Retrofit getRetrofitClient()
    {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApplicationConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public UserDatabase getRoomDatabase()
    {
        if(roomDatabase==null)
        roomDatabase=Room.databaseBuilder(GlobalApplication.this, UserDatabase.class,"userDB").allowMainThreadQueries().build();
        return roomDatabase;
    }

}
