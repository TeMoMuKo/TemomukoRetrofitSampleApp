package temomuko.pl.temomukoretrofitapp.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import temomuko.pl.temomukoretrofitapp.R;
import temomuko.pl.temomukoretrofitapp.model.ParliamentariansApiResponse;
import temomuko.pl.temomukoretrofitapp.remote.ApiManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main activity";
    private static final int MAX_RANDOM_PAGE_INDEX = 10;

    private ParliamentariansAdapter mParliamentariansAdapter;
    private Random mRandom;

    @BindView(R.id.recycler_view_parliamentarians) RecyclerView mRecyclerViewParliamentarians;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRandom = new Random();
        mParliamentariansAdapter = new ParliamentariansAdapter();
        setupRecyclerView();
        setupSwipeToRefresh();
        mSwipeRefreshLayout.setRefreshing(true);
        randomParliamentariansPageCall();
    }

    private void setupRecyclerView() {
        mRecyclerViewParliamentarians.setHasFixedSize(true);
        mRecyclerViewParliamentarians.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewParliamentarians.setAdapter(mParliamentariansAdapter);
    }

    private void setupSwipeToRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                randomParliamentariansPageCall();
            }
        });
    }

    private void randomParliamentariansPageCall() {
        ApiManager.getInstance().getParliamentarianService()
                .getParliamentariansPage(mRandom.nextInt(MAX_RANDOM_PAGE_INDEX))
                .enqueue(new Callback<ParliamentariansApiResponse>() {
                    @Override
                    public void onResponse(Call<ParliamentariansApiResponse> call, Response<ParliamentariansApiResponse> response) {
                        mParliamentariansAdapter.setParliamentarians(response.body().getMembersOfParliament());
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Call<ParliamentariansApiResponse> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
    }
}
