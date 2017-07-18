
package posidenpalace.com.placefinder.Model.Modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Northeast implements Serializable, Parcelable
{

  //  @JsonProperty("lat")
    private Double lat;
    //@JsonProperty("lng")
    private Double lng;
    public final static Parcelable.Creator<Northeast> CREATOR = new Creator<Northeast>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Northeast createFromParcel(Parcel in) {
            Northeast instance = new Northeast();
            instance.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.lng = ((Double) in.readValue((Double.class.getClassLoader())));
            return instance;
        }

        public Northeast[] newArray(int size) {
            return (new Northeast[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2641077340120308981L;

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
