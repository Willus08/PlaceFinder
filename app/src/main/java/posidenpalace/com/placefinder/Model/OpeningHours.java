
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class OpeningHours implements Serializable, Parcelable
{

    private Boolean openNow;
    private List<Period> periods = null;
    private List<String> weekdayText = null;
    public final static Parcelable.Creator<OpeningHours> CREATOR = new Creator<OpeningHours>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OpeningHours createFromParcel(Parcel in) {
            OpeningHours instance = new OpeningHours();
            instance.openNow = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(instance.periods, (posidenpalace.com.placefinder.Model.Period.class.getClassLoader()));
            in.readList(instance.weekdayText, (java.lang.String.class.getClassLoader()));
            return instance;
        }

        public OpeningHours[] newArray(int size) {
            return (new OpeningHours[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4880688774314141258L;

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    public List<String> getWeekdayText() {
        return weekdayText;
    }

    public void setWeekdayText(List<String> weekdayText) {
        this.weekdayText = weekdayText;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(openNow);
        dest.writeList(periods);
        dest.writeList(weekdayText);
    }

    public int describeContents() {
        return  0;
    }

}
