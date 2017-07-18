
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Geometry implements Serializable, Parcelable
{

    private Location location;
    private Viewport viewport;
    public final static Parcelable.Creator<Geometry> CREATOR = new Creator<Geometry>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Geometry createFromParcel(Parcel in) {
            Geometry instance = new Geometry();
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            instance.viewport = ((Viewport) in.readValue((Viewport.class.getClassLoader())));
            return instance;
        }

        public Geometry[] newArray(int size) {
            return (new Geometry[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1967901005922735471L;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(location);
        dest.writeValue(viewport);
    }

    public int describeContents() {
        return  0;
    }

}
