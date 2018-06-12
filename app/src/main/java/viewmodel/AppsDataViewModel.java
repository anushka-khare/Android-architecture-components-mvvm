package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import com.anushka.androidarchiechture.GlobalApplication;

import java.util.ArrayList;
import java.util.List;

import database.UserDatabase;
import pojo.AppData;
import pojo.Datum;
import pojo.FeaturedApp;
import retrofit.Repository;

/**
 * Created by Anushka on 13-04-2018.
 */

public class AppsDataViewModel extends AndroidViewModel {

    private LiveData<List<Datum>> listLiveData;

    private Repository repository;
    private Context context;
    private UserDatabase roomDatabase;

    public AppsDataViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        roomDatabase = ((GlobalApplication) context).getRoomDatabase();
    }

    public LiveData<List<Datum>> getAppMutableLiveData() {

        if (listLiveData == null) {
            listLiveData = new MutableLiveData<>();
            //passing roomDatabase object passing to repository to store fetched data through api
            repository = new Repository(roomDatabase);
            repository.getFeaturedAppsViaAPI();
        }


        // fetching data through roomDatabase and setting to liveData object
        if (roomDatabase.getUserDao().getAllDatum() != null)
            listLiveData=roomDatabase.getUserDao().getAllDatum();


        return listLiveData;
    }


}
