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

import posidenpalace.com.placefinder.Model.Modle.NearbyPlacesJsonPojo;
import posidenpalace.com.placefinder.Model.PlacesPojo;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Android on 7/14/2017.
 */

public class PlaceFinderPresenter implements PlaceFinderContract.Presenter {

    PlaceFinderContract.View view;
    List<PlacesPojo> places = new ArrayList<>();
    public static final String TAG = "test";

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
    public void setUpAdapter(final PendingResult<PlaceLikelihoodBuffer> result, final int type) {
        Log.d(TAG, "setUpAdapter: " + result);

        places.removeAll(places);

        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {

            @Override
            public void onResult(@NonNull PlaceLikelihoodBuffer placeLikelihoods) {

                Log.d(TAG, "onResult: " + placeLikelihoods);
                int i = 0;
                Log.d(TAG, "onResult: " + i);
                int mMaxEntries = 20;
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
                    if (type > 0) {
                        boolean typematch = false;
                        for (int j = 0; j < placeLikelihood.getPlace().getPlaceTypes().size(); j++) {
                            if (type == placeLikelihood.getPlace().getPlaceTypes().get(j)) {
                                typematch = true;
                            }
                        }
                        if (typematch) {
                            Log.d("Presenter", "onResult: Filling " + i);
                            places.add(new PlacesPojo(mLikelyPlaceNames[i], mLikelyPlaceAddresses[i], mLikelyPlaceLatLngs[i],
                                    mLikelyPlaceRatings[i], mLikelyPlacePriceLevels[i], mLikelyPlaceIDs[i], mLikelyPlacePhones[i], mLikelyPlaceWebsites[i]));
                            Log.d(TAG, "onResult: " + places);
                            i++;
                        }
                    } else if (type == 0) {

                        Log.d("Presenter", "onResult: Filling " + i);
                        places.add(new PlacesPojo(mLikelyPlaceNames[i], mLikelyPlaceAddresses[i], mLikelyPlaceLatLngs[i],
                                mLikelyPlaceRatings[i], mLikelyPlacePriceLevels[i], mLikelyPlaceIDs[i], mLikelyPlacePhones[i], mLikelyPlaceWebsites[i]));
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

    @Override
    public void setUpAdapterJSON(String type, String latlng) {
        places.removeAll(places);
        retrofit2.Call<NearbyPlacesJsonPojo> NearbyPlacesJsonPojoCall = RetroFitHelper.jsonPojoCall(type, latlng);
        NearbyPlacesJsonPojoCall.enqueue(new retrofit2.Callback<NearbyPlacesJsonPojo>() {
            @Override
            public void onResponse(Call<NearbyPlacesJsonPojo> call, Response<NearbyPlacesJsonPojo> response) {
//                Log.d(TAG, "onResponse: " + response.body().getResults().get(0).getName());
                for (int i = 0; i < response.body().getResults().size(); i++) {
                    LatLng lat = new LatLng(response.body().getResults().get(i).getGeometry().getLocation().getLat(),
                            response.body().getResults().get(i).getGeometry().getLocation().getLng());
                    String image;
                    if (response.body().getResults().get(i).getPhotos() == null) {
                        image = "";
                    } else {
                        image = response.body().getResults().get(i).getPhotos().get(0).getPhotoReference();
                    }
                    float rate;
                    if (response.body().getResults().get(i).getRating() == null){
                        rate = -1;
                    }
                    else {
                        rate = response.body().getResults().get(i).getRating().floatValue();
                    }
                    int price;
                    if(response.body().getResults().get(i).getPriceLevel() ==  null)
                    {
                        price = -1;
                    }
                    else {
                        price =response.body().getResults().get(i).getPriceLevel();
                    }
                    places.add(new PlacesPojo(
                            response.body().getResults().get(i).getName(),
                            response.body().getResults().get(i).getVicinity(),
                            lat,
                            rate,
                            price,
                            image,
                            response.body().getResults().get(i).getIcon()
                    ));
                    view.setupRecyclerView(places);

                }
                Log.d(TAG, "result: " + places);

            }

            @Override
            public void onFailure(Call<NearbyPlacesJsonPojo> call, Throwable t) {

            }
        });




    }

    @Override
    public void setUpAdapterObserviable(String type, String Latlng) {
        places.removeAll(places);
        Observable<NearbyPlacesJsonPojo> observable = RetroFitHelper.observable(type,Latlng);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NearbyPlacesJsonPojo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NearbyPlacesJsonPojo nearbyPlacesJsonPojo) {
                        for (int i = 0; i < nearbyPlacesJsonPojo.getResults().size(); i++) {
                            LatLng lat = new LatLng(nearbyPlacesJsonPojo.getResults().get(i).getGeometry().getLocation().getLat(),
                                                 nearbyPlacesJsonPojo.getResults().get(i).getGeometry().getLocation().getLng());
                            String image;
                            if (nearbyPlacesJsonPojo.getResults().get(i).getPhotos() == null) {
                                image = "";
                            } else {
                                image = nearbyPlacesJsonPojo.getResults().get(i).getPhotos().get(0).getPhotoReference();
                            }
                            float rate;
                            if (nearbyPlacesJsonPojo.getResults().get(i).getRating() == null){
                                rate = -1;
                            }
                            else {
                                rate = nearbyPlacesJsonPojo.getResults().get(i).getRating().floatValue();
                            }
                            int price;
                            if(nearbyPlacesJsonPojo.getResults().get(i).getPriceLevel() ==  null)
                            {
                                price = -1;
                            }
                            else {
                                price =nearbyPlacesJsonPojo.getResults().get(i).getPriceLevel();
                            }
                            places.add(new PlacesPojo(
                                    nearbyPlacesJsonPojo.getResults().get(i).getName(),
                                    nearbyPlacesJsonPojo.getResults().get(i).getVicinity(),
                                    lat,
                                     rate,
                                     price,
                                    image,
                                    nearbyPlacesJsonPojo.getResults().get(i).getIcon()
                                    ));
                            Log.d(TAG, "onNext: "+places);
                        }
                        view.setupRecyclerView(places);

                    }
                });


    }

}

