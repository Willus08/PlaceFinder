
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Period implements Serializable, Parcelable
{

    private Close close;
    private Open open;
    public final static Parcelable.Creator<Period> CREATOR = new Creator<Period>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Period createFromParcel(Parcel in) {
            Period instance = new Period();
            instance.close = ((Close) in.readValue((Close.class.getClassLoader())));
            instance.open = ((Open) in.readValue((Open.class.getClassLoader())));
            return instance;
        }

        public Period[] newArray(int size) {
            return (new Period[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8260661818495176964L;

    public Close getClose() {
        return close;
    }

    public void setClose(Close close) {
        this.close = close;
    }

    public Open getOpen() {
        return open;
    }

    public void setOpen(Open open) {
        this.open = open;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(close);
        dest.writeValue(open);
    }

    public int describeContents() {
        return  0;
    }

}
