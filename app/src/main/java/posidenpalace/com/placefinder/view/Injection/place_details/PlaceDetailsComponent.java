package posidenpalace.com.placefinder.view.Injection.place_details;

import dagger.Component;
import posidenpalace.com.placefinder.view.activities.place_details.PlaceDetails;

/**
 * Created by Android on 7/14/2017.
 */
@Component(modules = PlaceDetailsModule.class)
public interface PlaceDetailsComponent {
    void inject(PlaceDetails placeDetails);
}
