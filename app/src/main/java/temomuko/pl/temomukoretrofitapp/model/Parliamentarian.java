package temomuko.pl.temomukoretrofitapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rafał Naniewicz on 28.04.2016.
 */
public class Parliamentarian {
    @SerializedName("url") private String mUrl;
    @SerializedName("mp_url") private String mProfileUrl;
    @SerializedName("data") private ParliamentarianData mParliamentarianData;

    public ParliamentarianData getParliamentarianData() {
        return mParliamentarianData;
    }

    public String getProfileUrl() {
        return mProfileUrl;
    }

    public String getUrl() {
        return mUrl;
    }
}
