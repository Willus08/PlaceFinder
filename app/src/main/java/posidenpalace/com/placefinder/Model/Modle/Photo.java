
package posidenpalace.com.placefinder.Model.Modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class Photo implements Serializable, Parcelable
{

//    @JsonProperty("height")
    private Integer height;
  //  @JsonProperty("html_attributions")
    private List<String> htmlAttributions = null;
    //@JsonProperty("photo_reference")
    private String photoReference;
    //@JsonProperty("width")
    private Integer width;
    public final static Parcelable.Creator<Photo> CREATOR = new Creator<Photo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photo createFromParcel(Parcel in) {
            Photo instance = new Photo();
            instance.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.htmlAttributions, (java.lang.String.class.getClassLoader()));
            instance.photoReference = ((String) in.readValue((String.class.getClassLoader())));
            instance.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Photo[] newArray(int size) {
            return (new Photo[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1703642700540346749L;

    //@JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    //@JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

//    @JsonProperty("html_attributions")
    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

  //  @JsonProperty("html_attributions")
    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    //@JsonProperty("photo_reference")
    public String getPhotoReference() {
        return photoReference;
    }

    //@JsonProperty("photo_reference")
    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    //@JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    //@JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(height);
        dest.writeList(htmlAttributions);
        dest.writeValue(photoReference);
        dest.writeValue(width);
    }

    public int describeContents() {
        return  0;
    }

}
