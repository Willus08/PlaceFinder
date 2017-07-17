package posidenpalace.com.placefinder.view.Injection.place_finder;

import dagger.Component;
import posidenpalace.com.placefinder.view.activities.place_finder.PlaceFinder;

/**
 * Created by Android on 7/14/2017.
 */
@Component(modules = PlaceFinderModule.class)
public interface PlaceFinderComponent {
    void inject(PlaceFinder placeFinder);
}
