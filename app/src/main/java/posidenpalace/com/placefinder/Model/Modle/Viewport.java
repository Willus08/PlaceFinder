
package posidenpalace.com.placefinder.Model.Modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Viewport implements Serializable, Parcelable
{

    //@JsonProperty("northeast")
    private Northeast northeast;
    //@JsonProperty("southwest")
    private Southwest southwest;
    public final static Parcelable.Creator<Viewport> CREATOR = new Creator<Viewport>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Viewport createFromParcel(Parcel in) {
            Viewport instance = new Viewport();
            instance.northeast = ((Northeast) in.readValue((Northeast.class.getClassLoader())));
            instance.southwest = ((Southwest) in.readValue((Southwest.class.getClassLoader())));
            return instance;
        }

        public Viewport[] newArray(int size) {
            return (new Viewport[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6370390057546852571L;

    //@JsonProperty("northeast")
    public Northeast getNortheast() {
        return northeast;
    }

    //@JsonProperty("northeast")
    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    //@JsonProperty("southwest")
    public Southwest getSouthwest() {
        return southwest;
    }

    //@JsonProperty("southwest")
    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(northeast);
        dest.writeValue(southwest);
    }

    public int describeContents() {
        return  0;
    }

}
