
package posidenpalace.com.placefinder.Model.Modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class OpeningHours implements Serializable, Parcelable
{

   // @JsonProperty("open_now")
    private Boolean openNow;
    //@JsonProperty("weekday_text")
    private List<Object> weekdayText = null;
    public final static Parcelable.Creator<OpeningHours> CREATOR = new Creator<OpeningHours>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OpeningHours createFromParcel(Parcel in) {
            OpeningHours instance = new OpeningHours();
            instance.openNow = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(instance.weekdayText, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public OpeningHours[] newArray(int size) {
            return (new OpeningHours[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8789619555459753502L;

    //@JsonProperty("open_now")
    public Boolean getOpenNow() {
        return openNow;
    }

    //@JsonProperty("open_now")
    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    //@JsonProperty("weekday_text")
    public List<Object> getWeekdayText() {
        return weekdayText;
    }

    //@JsonProperty("weekday_text")
    public void setWeekdayText(List<Object> weekdayText) {
        this.weekdayText = weekdayText;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(openNow);
        dest.writeList(weekdayText);
    }

    public int describeContents() {
        return  0;
    }

}
