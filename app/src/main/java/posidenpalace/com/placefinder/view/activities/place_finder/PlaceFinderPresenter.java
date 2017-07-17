package posidenpalace.com.placefinder.view.activities.place_finder;

import android.location.Location;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import posidenpalace.com.placefinder.Model.PlacesPojo;


/**
 * Created by Android on 7/14/2017.
 */

public class PlaceFinderPresenter implements PlaceFinderContract.Presenter {

    PlaceFinderContract.View view;
    List<PlacesPojo> places = new ArrayList<>();
    public static final String TAG ="test" ;

    @Override
    public void addView(PlaceFinderContract.View view) {
        this.view = view;
    }

    @Override
    public void reomveView() {
        this.view = null;
    }

    @Override
    public void setupForPlaceDetails(Location current, Location selected) {

    }


    @Override
    public void setUpAdapter(final PendingResult< PlaceLikelihoodBuffer > result, final int type) {
        Log.d(TAG, "setUpAdapter: " + result);

        places.removeAll(places);

        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {

            @Override
                public void onResult(@NonNull PlaceLikelihoodBuffer placeLikelihoods) {

                Log.d(TAG, "onResult: " + placeLikelihoods);
                    int i =0;
                Log.d(TAG, "onResult: "+i);
                    int mMaxEntries=20;
                    String[] mLikelyPlaceNames = new String[mMaxEntries];
                    String[] mLikelyPlaceAddresses = new String[mMaxEntries];
                    String[] mLikelyPlaceAttributions = new String[mMaxEntries];
                    LatLng[] mLikelyPlaceLatLngs = new LatLng[mMaxEntries];
                    String[] mLikelyPlacePhones = new String[mMaxEntries];
                    int[] mLikelyPlacePriceLevels = new int[mMaxEntries];
                    Uri[] mLikelyPlaceWebsites = new Uri[mMaxEntries];
                    float[] mLikelyPlaceRatings = new float[mMaxEntries];
                    String[] mLikelyPlaceIDs = new String[mMaxEntries];

                    for (PlaceLikelihood placeLikelihood : placeLikelihoods) {
                        // Build a list of likely places to show the user. Max 5.
                        mLikelyPlaceNames[i] = (String) placeLikelihood.getPlace().getName();
                        mLikelyPlaceAddresses[i] = (String) placeLikelihood.getPlace().getAddress();
                        mLikelyPlaceAttributions[i] = (String) placeLikelihood.getPlace().getAttributions();
                        mLikelyPlaceLatLngs[i] = placeLikelihood.getPlace().getLatLng();
                        mLikelyPlacePhones[i] = placeLikelihood.getPlace().getPhoneNumber().toString();
                        mLikelyPlacePriceLevels[i] = placeLikelihood.getPlace().getPriceLevel();
                        mLikelyPlaceRatings[i] = placeLikelihood.getPlace().getRating();
                        mLikelyPlaceWebsites[i] = placeLikelihood.getPlace().getWebsiteUri();
                        mLikelyPlaceIDs[i] = placeLikelihood.getPlace().getId();
                        Log.d(TAG, "onResult: " + placeLikelihood.getPlace().getPlaceTypes());
                        if (type > 0){
                            boolean typematch = false;
                            for (int j = 0; j <  placeLikelihood.getPlace().getPlaceTypes().size(); j++) {
                             if (type == placeLikelihood.getPlace().getPlaceTypes().get(j)){
                                 typematch = true;
                             }
                            }
                            if(typematch){
                                Log.d("Presenter", "onResult: Filling "+i);
                                places.add(new PlacesPojo(mLikelyPlaceNames[i], mLikelyPlaceAddresses[i],mLikelyPlaceAttributions[i],mLikelyPlaceLatLngs[i],
                                        mLikelyPlaceRatings[i],mLikelyPlacePriceLevels[i],mLikelyPlaceIDs[i],mLikelyPlacePhones[i],mLikelyPlaceWebsites[i]));
                                Log.d(TAG, "onResult: " + places);
                                i++;
                            }
                        }else if( type == 0) {

                            Log.d("Presenter", "onResult: Filling " + i);
                            places.add(new PlacesPojo(mLikelyPlaceNames[i], mLikelyPlaceAddresses[i],mLikelyPlaceAttributions[i],mLikelyPlaceLatLngs[i],
                                    mLikelyPlaceRatings[i],mLikelyPlacePriceLevels[i],mLikelyPlaceIDs[i],mLikelyPlacePhones[i],mLikelyPlaceWebsites[i]));
                            Log.d(TAG, "onResult: " + places);
                            i++;
                        }
                        if (i > (mMaxEntries - 1)) {
                            break;
                        }
                    }
                    Log.d(TAG, "onResult: " + places);
                    view.setupRecyclerView(places);
                    placeLikelihoods.release();
                }

            });
        }

    @Override
    public void addPlace(PlacesPojo placesPojo) {
        places.add(placesPojo);
        view.setupRecyclerView(places);
    }

}

