
package posidenpalace.com.placefinder.Model.Modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Location implements Serializable, Parcelable
{

   // @JsonProperty("lat")
    private Double lat;
   // @JsonProperty("lng")
    private Double lng;
    public final static Parcelable.Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            Location instance = new Location();
            instance.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.lng = ((Double) in.readValue((Double.class.getClassLoader())));
            return instance;
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3405967478548475669L;

    //@JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    //@JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    //@JsonProperty("lng")
    public Double getLng() {
        return lng;
    }

    //@JsonProperty("lng")
    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lat);
        dest.writeValue(lng);
    }

    public int describeContents() {
        return  0;
    }

}
