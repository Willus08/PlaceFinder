
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class AddressComponent implements Serializable, Parcelable
{

    private String longName;
    private String shortName;
    private List<String> types = null;
    public final static Parcelable.Creator<AddressComponent> CREATOR = new Creator<AddressComponent>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AddressComponent createFromParcel(Parcel in) {
            AddressComponent instance = new AddressComponent();
            instance.longName = ((String) in.readValue((String.class.getClassLoader())));
            instance.shortName = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.types, (java.lang.String.class.getClassLoader()));
            return instance;
        }

        public AddressComponent[] newArray(int size) {
            return (new AddressComponent[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5740787756288159620L;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(longName);
        dest.writeValue(shortName);
        dest.writeList(types);
    }

    public int describeContents() {
        return  0;
    }

}
