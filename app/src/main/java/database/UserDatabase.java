package database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import dao.UserDao;
import pojo.Datum;

/**
 * Created by Anushka on 29-04-2018.
 */


@Database(entities = {Datum.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();
}
