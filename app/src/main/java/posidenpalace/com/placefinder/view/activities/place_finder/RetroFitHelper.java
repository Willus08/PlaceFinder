package posidenpalace.com.placefinder.view.activities.place_finder;

import posidenpalace.com.placefinder.Model.Modle.NearbyPlacesJsonPojo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public class RetroFitHelper {

    private static String base_Url = "https://maps.googleapis.com/maps/";
    public final static String placeID = "ChIJN1t_tDeuEmsRUsoyG83frY4&";
    public final static String key = "AIzaSyBHpPcRKjVYNqj2UDQpZuY_fDfvpCgyZTU";
    public final static int RADIUS = 500;
    public static Retrofit create() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retro;
    }

    public static Call<NearbyPlacesJsonPojo> jsonPojoCall(String typed ,String latLng){
        Retrofit retrofit = create();
        Services services = retrofit.create(Services.class);
        return services.nearbyPlaces(typed,latLng,RADIUS);

    }

    public static Observable<NearbyPlacesJsonPojo> observable(String type,String latLng){
        Retrofit retrofit = create();
        Services services = retrofit.create(Services.class);
        return services.placesNearby(type,latLng,RADIUS);

    }


    public interface Services{

        @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyCU74rvjWftOWW7AzCsGbySzOYH7hua-e0")
        Call<NearbyPlacesJsonPojo> nearbyPlaces(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);

        @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyCU74rvjWftOWW7AzCsGbySzOYH7hua-e0")
        Observable<NearbyPlacesJsonPojo> placesNearby(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);

    }

}
