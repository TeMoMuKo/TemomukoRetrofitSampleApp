package temomuko.pl.temomukoretrofitapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rafał Naniewicz on 28.04.2016.
 */
public class ParliamentarianData {
    @SerializedName("ludzie.nazwa") private String mName;
    @SerializedName("sejm_kluby.nazwa") private String mAffiliation;
    @SerializedName("poslowie.wartosc_uposazenia_pln") private Double mSalary;
    @SerializedName("poslowie.frekwencja") private Double mAttendance;

    public String getAffiliation() {
        return mAffiliation;
    }

    public Double getAttendance() {
        return mAttendance;
    }

    public String getName() {
        return mName;
    }

    public Double getSalary() {
        return mSalary;
    }
}
