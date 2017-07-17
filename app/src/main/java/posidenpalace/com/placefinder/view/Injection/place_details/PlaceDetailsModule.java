package posidenpalace.com.placefinder.view.Injection.place_details;

import dagger.Module;
import dagger.Provides;
import posidenpalace.com.placefinder.view.activities.place_details.PlaceDetailsPresenter;


/**
 * Created by Android on 7/14/2017.
 */
@Module
public class PlaceDetailsModule {
    @Provides
    public PlaceDetailsPresenter providePlaceDetailsPresenter(){
        return  new PlaceDetailsPresenter();
    }
}
