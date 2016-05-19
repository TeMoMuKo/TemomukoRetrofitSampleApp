package temomuko.pl.temomukoretrofitapp.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import temomuko.pl.temomukoretrofitapp.model.Parliamentarian;
import temomuko.pl.temomukoretrofitapp.model.ParliamentariansApiResponse;

/**
 * Created by Rafał Naniewicz on 28.04.2016.
 */
public interface ParliamentarianService {
    @GET("poslowie?_type=objects&page=page")
    Call<ParliamentariansApiResponse> getParliamentariansPage(@Query("page") int page);


    @GET("poslowie/{id}")
    Call<Parliamentarian> getParliamentarianById(@Path("id") int parliamentarianId);
}
