package posidenpalace.com.placefinder.view.activities.place_details;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import posidenpalace.com.placefinder.Model.PlacesPojo;

/**
 * Created by Android on 7/14/2017.
 */

public class PlaceDetailsPresenter implements PlaceDetailsContract.Presenter {
    private static final String TAG = "test";
    PlaceDetailsContract.View view;

    @Override
    public void addView(PlaceDetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void reomveView() {
        this.view = null;
    }

    @Override
    public void extractData(Intent intent) {
        Bundle bundle = intent.getExtras();
        PlacesPojo place = bundle.getParcelable("place");
        Log.d(TAG, "extractData: " + place);
        view.setUp(place);

    }
}
