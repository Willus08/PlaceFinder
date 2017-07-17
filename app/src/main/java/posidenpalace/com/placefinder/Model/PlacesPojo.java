package posidenpalace.com.placefinder.Model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Android on 7/14/2017.
 */

public class PlacesPojo implements Serializable,Parcelable {

    String name;
    String address;
    String attributions;
    LatLng latLng;
    float rating;
    int priceLevel;
    String Id;
    String phone;
    Uri website;

    public PlacesPojo(String name, String address, String attributions, LatLng latLng, float rating, int priceLevel, String id, String phone, Uri website) {
        this.name = name;
        this.address = address;
        this.attributions = attributions;
        this.latLng = latLng;
        this.rating = rating;
        this.priceLevel = priceLevel;
        Id = id;
        this.phone = phone;
        this.website = website;
    }

    protected PlacesPojo(Parcel in) {
        name = in.readString();
        address = in.readString();
        attributions = in.readString();
        latLng = in.readParcelable(LatLng.class.getClassLoader());
        rating = in.readFloat();
        priceLevel = in.readInt();
        Id = in.readString();
        phone = in.readString();
        website = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<PlacesPojo> CREATOR = new Creator<PlacesPojo>() {
        @Override
        public PlacesPojo createFromParcel(Parcel in) {
            return new PlacesPojo(in);
        }

        @Override
        public PlacesPojo[] newArray(int size) {
            return new PlacesPojo[size];
        }
    };

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(int priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getId() {
        return Id;
    }


    public void setId(String id) {
        Id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Uri getWebsite() {
        return website;
    }

    public void setWebsite(Uri website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public String getAttributions() {
        return attributions;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAttributions(String attributions) {
        this.attributions = attributions;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(attributions);
        dest.writeParcelable(latLng, flags);
        dest.writeFloat(rating);
        dest.writeInt(priceLevel);
        dest.writeString(Id);
        dest.writeString(phone);
        dest.writeParcelable(website, flags);
    }
}
