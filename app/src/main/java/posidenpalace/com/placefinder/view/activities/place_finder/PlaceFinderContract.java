package posidenpalace.com.placefinder.view.activities.place_finder;

import android.content.Intent;
import android.location.Location;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;

import java.util.List;

import posidenpalace.com.placefinder.Model.PlacesPojo;
import posidenpalace.com.placefinder.view.BasePresenter;
import posidenpalace.com.placefinder.view.BaseView;


/**
 * Created by Android on 7/14/2017.
 */

public interface PlaceFinderContract {
    interface View extends BaseView {

        void goToPlaceDetails(Intent intent);


        void setupRecyclerView(List<PlacesPojo> places);
        void checkForLocationPermission();
    }

    interface Presenter extends BasePresenter<PlaceFinderContract.View> {
        void setupForPlaceDetails(Location current, Location selected);


        void setUpAdapter( PendingResult<PlaceLikelihoodBuffer> result , int type);
        void  addPlace(PlacesPojo placesPojo);
    }
}
