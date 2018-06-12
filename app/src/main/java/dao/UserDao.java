package dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import pojo.Datum;

/**
 * Created by Anushka on 29-04-2018.
 */

@Dao
public interface UserDao {

    // it will return livedata list as any change will be performed to database we will get updated list
    @Query("select * from datum order by firstName")
    public LiveData<List<Datum>> getAllDatum();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAllDatum(ArrayList<Datum> data);
}
