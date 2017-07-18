
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Close implements Serializable, Parcelable
{

    private Integer day;
    private String time;
    public final static Parcelable.Creator<Close> CREATOR = new Creator<Close>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Close createFromParcel(Parcel in) {
            Close instance = new Close();
            instance.day = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.time = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Close[] newArray(int size) {
            return (new Close[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2381322228890999893L;

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
