package posidenpalace.com.placefinder.view.activities.place_finder;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GeoHelper extends IntentService {


    public GeoHelper() {
        super("GeoHelper");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Geocoder geocoder = new Geocoder(this);

        }
    }

    private Address getFromLatLng(double lat, double lng){

        Address address = getFromLatLng(lat,lng);
        return address;
    }

    private Address getFromLocation(String s){
        Address address = getFromLocation(s);
        return address;


    }


}
