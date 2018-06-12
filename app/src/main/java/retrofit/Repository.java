package retrofit;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.anushka.androidarchiechture.GlobalApplication;

import java.util.ArrayList;
import java.util.List;

import database.UserDatabase;
import pojo.Datum;
import pojo.User;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Anushka on 13-04-2018.
 */

public class Repository {

    private APIInterface apiInterface;
    private UserDatabase roomDatabase;

    public Repository(UserDatabase roomDatabase)
    {
        this.roomDatabase=roomDatabase;
        apiInterface= GlobalApplication.getRetrofitClient().create(APIInterface.class);
    }

    public void getFeaturedAppsViaAPI()
    {

        Call<User> call=apiInterface.getData();

        call.enqueue(new retrofit2.Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                System.out.println("API response "+response);
                User appData=response.body();
                ArrayList<Datum> featuredApps=new ArrayList<>();
                if(appData!=null)
                featuredApps=appData.getData();

                // inserting data to roomDatabase got through api callback
                roomDatabase.getUserDao().insertAllDatum(featuredApps);

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {

                System.out.println("API response fail "+t);

            }
        });

    }


}
