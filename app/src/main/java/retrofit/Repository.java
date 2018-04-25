package retrofit;

import android.arch.lifecycle.MutableLiveData;

import com.anushka.androidarchiechture.GlobalApplication;

import java.util.ArrayList;

import pojo.Datum;
import pojo.User;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Anushka on 13-04-2018.
 */

public class Repository {

    private APIInterface apiInterface;
    private ArrayList<Datum> featuredApps;
    private MutableLiveData<ArrayList<Datum>> listLiveData;

    public Repository(MutableLiveData<ArrayList<Datum>> listLiveData)
    {
        this.listLiveData=listLiveData;
        apiInterface= GlobalApplication.getRetrofitClient().create(APIInterface.class);
    }

    public ArrayList<Datum> getFeaturedAppsViaAPI()
    {

//       new GetDataAsync().execute();
        Call<User> call=apiInterface.getData(/*"6","android"*/);

        call.enqueue(new retrofit2.Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                System.out.println("API response "+response);
                User appData=response.body();
//                    Promotions promotions=appData.getPromotions();
                if(appData!=null)
                featuredApps=appData.getData();

                listLiveData.setValue(featuredApps);

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {

                System.out.println("API response fail "+t);

            }
        });

        return featuredApps;
    }


}
