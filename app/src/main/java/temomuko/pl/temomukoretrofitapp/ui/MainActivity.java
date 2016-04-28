package temomuko.pl.temomukoretrofitapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import temomuko.pl.temomukoretrofitapp.R;
import temomuko.pl.temomukoretrofitapp.model.Parliamentarian;
import temomuko.pl.temomukoretrofitapp.remote.ApiManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<Parliamentarian> parliamentarianCall = ApiManager.getInstance().getParliamentarianService().getParliamentarianById(1);
        parliamentarianCall.enqueue(new Callback<Parliamentarian>() {
            @Override
            public void onResponse(Call<Parliamentarian> call, Response<Parliamentarian> response) {
                Log.d("A", response.body().toString());
            }

            @Override
            public void onFailure(Call<Parliamentarian> call, Throwable t) {

            }
        });
    }
}
