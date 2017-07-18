
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Open implements Serializable, Parcelable
{

    private Integer day;
    private String time;
    public final static Parcelable.Creator<Open> CREATOR = new Creator<Open>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Open createFromParcel(Parcel in) {
            Open instance = new Open();
            instance.day = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.time = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Open[] newArray(int size) {
            return (new Open[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7668883209991589801L;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(day);
        dest.writeValue(time);
    }

    public int describeContents() {
        return  0;
    }

}
