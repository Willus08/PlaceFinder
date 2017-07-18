
package posidenpalace.com.placefinder.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Review implements Serializable, Parcelable
{

    private String authorName;
    private String authorUrl;
    private String language;
    private String profilePhotoUrl;
    private Integer rating;
    private String relativeTimeDescription;
    private String text;
    private Integer time;
    public final static Parcelable.Creator<Review> CREATOR = new Creator<Review>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Review createFromParcel(Parcel in) {
            Review instance = new Review();
            instance.authorName = ((String) in.readValue((String.class.getClassLoader())));
            instance.authorUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.language = ((String) in.readValue((String.class.getClassLoader())));
            instance.profilePhotoUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.rating = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.relativeTimeDescription = ((String) in.readValue((String.class.getClassLoader())));
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.time = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Review[] newArray(int size) {
            return (new Review[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6250092531395361156L;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRelativeTimeDescription() {
        return relativeTimeDescription;
    }

    public void setRelativeTimeDescription(String relativeTimeDescription) {
        this.relativeTimeDescription = relativeTimeDescription;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(authorName);
        dest.writeValue(authorUrl);
        dest.writeValue(language);
        dest.writeValue(profilePhotoUrl);
        dest.writeValue(rating);
        dest.writeValue(relativeTimeDescription);
        dest.writeValue(text);
        dest.writeValue(time);
    }

    public int describeContents() {
        return  0;
    }

}
