
package posidenpalace.com.placefinder.Model.Modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class Result implements Serializable, Parcelable
{

    //@JsonProperty("geometry")
    private Geometry geometry;
    //@JsonProperty("icon")
    private String icon;
    //@JsonProperty("id")
    private String id;
    //@JsonProperty("name")
    private String name;
    //@JsonProperty("opening_hours")
    private OpeningHours openingHours;
    //@JsonProperty("photos")
    private List<Photo> photos = null;
    //@JsonProperty("place_id")
    private String placeId;
    //@JsonProperty("rating")
    private Double rating;
    //@JsonProperty("reference")
    private String reference;
    //@JsonProperty("scope")
    private String scope;
    //@JsonProperty("types")
    private List<String> types = null;
    //@JsonProperty("vicinity")
    private String vicinity;
    //@JsonProperty("price_level")
    private Integer priceLevel;
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            Result instance = new Result();
            instance.geometry = ((Geometry) in.readValue((Geometry.class.getClassLoader())));
            instance.icon = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.openingHours = ((OpeningHours) in.readValue((OpeningHours.class.getClassLoader())));
            in.readList(instance.photos, (posidenpalace.com.placefinder.Model.Modle.Photo.class.getClassLoader()));
            instance.placeId = ((String) in.readValue((String.class.getClassLoader())));
            instance.rating = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.reference = ((String) in.readValue((String.class.getClassLoader())));
            instance.scope = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.types, (java.lang.String.class.getClassLoader()));
            instance.vicinity = ((String) in.readValue((String.class.getClassLoader())));
            instance.priceLevel = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;
    private final static long serialVersionUID = 828317498980095103L;

    //@JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    //@JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    //@JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    //@JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    //JsonProperty("id")
    public String getId() {
        return id;
    }

    //@JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    //@JsonProperty("name")
    public String getName() {
        return name;
    }

    //@JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    //@JsonProperty("opening_hours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    //@JsonProperty("opening_hours")
    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    //@JsonProperty("photos")
    public List<Photo> getPhotos() {
        return photos;
    }

    //@JsonProperty("photos")
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    //@JsonProperty("place_id")
    public String getPlaceId() {
        return placeId;
    }

    //@JsonProperty("place_id")
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    //@JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    //@JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    //@JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    //@JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    //@JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    //@JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    //@JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    //@JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
    }

    //@JsonProperty("vicinity")
    public String getVicinity() {
        return vicinity;
    }

    //@JsonProperty("vicinity")
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    //@JsonProperty("price_level")
    public Integer getPriceLevel() {
        return priceLevel;
    }

    //@JsonProperty("price_level")
    public void setPriceLevel(Integer priceLevel) {
        this.priceLevel = priceLevel;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(geometry);
        dest.writeValue(icon);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(openingHours);
        dest.writeList(photos);
        dest.writeValue(placeId);
        dest.writeValue(rating);
        dest.writeValue(reference);
        dest.writeValue(scope);
        dest.writeList(types);
        dest.writeValue(vicinity);
        dest.writeValue(priceLevel);
    }

    public int describeContents() {
        return  0;
    }

}
