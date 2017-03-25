package Server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raulbr on 3/24/17.
 */

public class APIService {
    private static String BASE_URL =  "BASE_URL";

    public APIInterface getAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("BASE_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(APIInterface.class);
    }
}
