package temomuko.pl.temomukoretrofitapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rafał Naniewicz on 28.04.2016.
 */
public class ParliamentariansApiResponse {
    @SerializedName("Dataobject") private List<Parliamentarian> mMembersOfParliament;
    @SerializedName("Links") private ParliamentariansApiLinks mParliamentariansApiLinks;

    public List<Parliamentarian> getMembersOfParliament() {
        return mMembersOfParliament;
    }

    public ParliamentariansApiLinks getParliamentariansApiLinks() {
        return mParliamentariansApiLinks;
    }
}
