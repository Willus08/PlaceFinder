
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class PlacesJsonPojo implements Serializable, Parcelable
{

    private List<Object> htmlAttributions = null;
    private Result result;
    private String status;
    public final static Parcelable.Creator<PlacesJsonPojo> CREATOR = new Creator<PlacesJsonPojo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PlacesJsonPojo createFromParcel(Parcel in) {
            PlacesJsonPojo instance = new PlacesJsonPojo();
            in.readList(instance.htmlAttributions, (java.lang.Object.class.getClassLoader()));
            instance.result = ((Result) in.readValue((Result.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public PlacesJsonPojo[] newArray(int size) {
            return (new PlacesJsonPojo[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4453353573521138262L;

    public List<Object> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<Object> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(htmlAttributions);
        dest.writeValue(result);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
