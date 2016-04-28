package temomuko.pl.temomukoretrofitapp.remote;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import temomuko.pl.temomukoretrofitapp.Constants;

/**
 * Created by Rafał Naniewicz on 28.04.2016.
 */
public class ApiManager {

    private static ApiManager sInstance;
    private ParliamentarianService mParliamentarianService;

    public static ApiManager getInstance() {
        if (sInstance == null) {
            sInstance = new ApiManager();
        }
        return sInstance;
    }

    private ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        mParliamentarianService = retrofit.create(ParliamentarianService.class);
    }

    public ParliamentarianService getParliamentarianService() {
        return mParliamentarianService;
    }
}
