package retrofit;


import pojo.AppData;
import pojo.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Anushka on 13-04-2018.
 */

public interface APIInterface {


    @GET("//promotion?appid=6&platform=android")
    Call<AppData> getAppData(/*@Query("appid") String appId,@Query("platform") String platform*/);

    @GET("/api/users/")
    Call<User> getData();
}
