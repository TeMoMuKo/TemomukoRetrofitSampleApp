package temomuko.pl.temomukoretrofitapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rafał Naniewicz on 28.04.2016.
 */
public class ParliamentariansApiLinks {
    @SerializedName("prev") String mPrevious;
    @SerializedName("next") String mNext;

    public String getNext() {
        return mNext;
    }

    public String getPrevious() {
        return mPrevious;
    }
}
