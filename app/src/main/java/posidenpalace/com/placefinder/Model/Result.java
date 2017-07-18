
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;


public class Result implements Serializable, Parcelable
{

    private List<AddressComponent> addressComponents = null;
    private String adrAddress;
    private String formattedAddress;
    private String formattedPhoneNumber;
    private Geometry geometry;
    private String icon;
    private String id;
    private String internationalPhoneNumber;
    private String name;
    private OpeningHours openingHours;
    private List<Photo> photos = null;
    private String placeId;
    private Double rating;
    private String reference;
    private List<Review> reviews = null;
    private String scope;
    private List<String> types = null;
    private String url;
    private Integer utcOffset;
    private String vicinity;
    private String website;
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            Result instance = new Result();
            in.readList(instance.addressComponents, (posidenpalace.com.placefinder.Model.AddressComponent.class.getClassLoader()));
            instance.adrAddress = ((String) in.readValue((String.class.getClassLoader())));
            instance.formattedAddress = ((String) in.readValue((String.class.getClassLoader())));
            instance.formattedPhoneNumber = ((String) in.readValue((String.class.getClassLoader())));
            instance.geometry = ((Geometry) in.readValue((Geometry.class.getClassLoader())));
            instance.icon = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.internationalPhoneNumber = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.openingHours = ((OpeningHours) in.readValue((OpeningHours.class.getClassLoader())));
            in.readList(instance.photos, (posidenpalace.com.placefinder.Model.Photo.class.getClassLoader()));
            instance.placeId = ((String) in.readValue((String.class.getClassLoader())));
            instance.rating = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.reference = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.reviews, (posidenpalace.com.placefinder.Model.Review.class.getClassLoader()));
            instance.scope = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.types, (java.lang.String.class.getClassLoader()));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.utcOffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.vicinity = ((String) in.readValue((String.class.getClassLoader())));
            instance.website = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8468138185967810261L;

    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(String adrAddress) {
        this.adrAddress = adrAddress;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInternationalPhoneNumber() {
        return internationalPhoneNumber;
    }

    public void setInternationalPhoneNumber(String internationalPhoneNumber) {
        this.internationalPhoneNumber = internationalPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(addressComponents);
        dest.writeValue(adrAddress);
        dest.writeValue(formattedAddress);
        dest.writeValue(formattedPhoneNumber);
        dest.writeValue(geometry);
        dest.writeValue(icon);
        dest.writeValue(id);
        dest.writeValue(internationalPhoneNumber);
        dest.writeValue(name);
        dest.writeValue(openingHours);
        dest.writeList(photos);
        dest.writeValue(placeId);
        dest.writeValue(rating);
        dest.writeValue(reference);
        dest.writeList(reviews);
        dest.writeValue(scope);
        dest.writeList(types);
        dest.writeValue(url);
        dest.writeValue(utcOffset);
        dest.writeValue(vicinity);
        dest.writeValue(website);
    }

    public int describeContents() {
        return  0;
    }

}
