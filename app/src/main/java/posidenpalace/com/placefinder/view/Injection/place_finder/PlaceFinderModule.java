package posidenpalace.com.placefinder.view.Injection.place_finder;

import dagger.Module;
import dagger.Provides;
import posidenpalace.com.placefinder.view.activities.place_finder.PlaceFinderPresenter;

/**
 * Created by Android on 7/14/2017.
 */
@Module
public class PlaceFinderModule {
    @Provides
    public PlaceFinderPresenter providePlaceFinderPresenter(){
        return  new PlaceFinderPresenter();
    }
}
