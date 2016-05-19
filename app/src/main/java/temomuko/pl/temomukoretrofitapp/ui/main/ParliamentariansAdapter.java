package temomuko.pl.temomukoretrofitapp.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import temomuko.pl.temomukoretrofitapp.R;
import temomuko.pl.temomukoretrofitapp.model.Parliamentarian;
import temomuko.pl.temomukoretrofitapp.model.ParliamentarianData;

/**
 * Created by Rafał on 16.05.2016.
 */
public class ParliamentariansAdapter extends RecyclerView.Adapter {

    private List<Parliamentarian> mParliamentarians;

    public ParliamentariansAdapter() {
        mParliamentarians = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_parliamentarian_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder ViewHolder = (ViewHolder) holder;
        ParliamentarianData currentParliamentarianData = mParliamentarians.get(position).getParliamentarianData();
        ViewHolder.mTextViewParliamentarianName.setText(currentParliamentarianData.getName());
        ViewHolder.mTextViewParliamentarianSalary.setText(
                String.format(Locale.getDefault(), "%.2f", currentParliamentarianData.getSalary()));
        ViewHolder.mTextViewParliamentarianAffiliation.setText(currentParliamentarianData.getAffiliation());

    }

    @Override
    public int getItemCount() {
        return mParliamentarians.size();
    }

    public void setParliamentarians(List<Parliamentarian> parliamentarians) {
        mParliamentarians = parliamentarians;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_parliamentarian_name) TextView mTextViewParliamentarianName;
        @BindView(R.id.tv_parliamentarian_affiliation) TextView mTextViewParliamentarianAffiliation;
        @BindView(R.id.tv_parliamentarian_salary) TextView mTextViewParliamentarianSalary;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
