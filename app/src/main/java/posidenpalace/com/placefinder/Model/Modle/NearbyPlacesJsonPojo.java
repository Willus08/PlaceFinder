
package posidenpalace.com.placefinder.Model.Modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class NearbyPlacesJsonPojo implements Serializable, Parcelable
{

   // @JsonProperty("html_attributions")
    private List<Object> htmlAttributions = null;
    //@JsonProperty("next_page_token")
    private String nextPageToken;
    //@JsonProperty("results")
    private List<Result> results = null;
    //@JsonProperty("status")
    private String status;
    public final static Parcelable.Creator<NearbyPlacesJsonPojo> CREATOR = new Creator<NearbyPlacesJsonPojo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NearbyPlacesJsonPojo createFromParcel(Parcel in) {
            NearbyPlacesJsonPojo instance = new NearbyPlacesJsonPojo();
            in.readList(instance.htmlAttributions, (java.lang.Object.class.getClassLoader()));
            instance.nextPageToken = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.results, (posidenpalace.com.placefinder.Model.Modle.Result.class.getClassLoader()));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public NearbyPlacesJsonPojo[] newArray(int size) {
            return (new NearbyPlacesJsonPojo[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4764199192524157220L;

    //@JsonProperty("html_attributions")
    public List<Object> getHtmlAttributions() {
        return htmlAttributions;
    }

    //@JsonProperty("html_attributions")
    public void setHtmlAttributions(List<Object> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

//    @JsonProperty("next_page_token")
    public String getNextPageToken() {
        return nextPageToken;
    }

  //  @JsonProperty("next_page_token")
    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    //@JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    //@JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    //@JsonProperty("status")
    public String getStatus() {
        return status;
    }

    //@JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(htmlAttributions);
        dest.writeValue(nextPageToken);
        dest.writeList(results);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
