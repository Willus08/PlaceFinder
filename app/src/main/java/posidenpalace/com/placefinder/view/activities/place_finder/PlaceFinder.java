package posidenpalace.com.placefinder.view.activities.place_finder;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import posidenpalace.com.placefinder.Model.PlacesPojo;
import posidenpalace.com.placefinder.R;
import posidenpalace.com.placefinder.view.Injection.place_finder.DaggerPlaceFinderComponent;



public class PlaceFinder extends FragmentActivity implements OnMapReadyCallback,PlaceFinderContract.View, LocationListener {
    private static final String TAG = "test";
    @Inject
    PlaceFinderPresenter presenter;
    GoogleApiClient mGoogleApiClient;
    private GoogleMap mMap;
    private static final int LOCATION = 1;
    private Location current;
    RecyclerView recy;
    RecyclerView.LayoutManager layout;
    RecyclerView.ItemAnimator animate;
    RecycleAdapter adapt;
    List<PlacesPojo> places= new ArrayList<>();
    PendingResult<PlaceLikelihoodBuffer> result;
    FusedLocationProviderClient local;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_finder);
        setUpDaggerComponent();
        presenter.addView(this);
        checkForLocationPermission();
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, null)
                .build();

        imageView = (ImageView) findViewById(R.id.ivMap);
        result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient,null);
        Log.d(TAG, "onCreate: " + result);
        recy = (RecyclerView) findViewById(R.id.rvPlacesList);
        layout = new LinearLayoutManager(this);
        animate = new DefaultItemAnimator();
        presenter.setUpAdapter(result,0);

        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
       //
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
       mMap.setMyLocationEnabled(true);

        Log.d(TAG, "onMapReady: " + places);
        local = new FusedLocationProviderClient(this);
        getLocation();
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragmet);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());
                mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getName().toString()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(place.getLatLng()));
//                presenter.addPlace(new PlacesPojo(place.getName().toString(),place.getAddress().toString(),place.getAttributions().toString(),place.getLatLng(),place.getRating(),
//                        place.getPriceLevel(),place.getId(),place.getPhoneNumber().toString(),place.getWebsiteUri()));
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

    }
    @SuppressWarnings("MissingPermission")
    private void getLocation() {
        local = LocationServices.getFusedLocationProviderClient(this);
        local.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        current= location;
                        Log.d(TAG, "onSuccess: " + location);
                        LatLng curentPlace = new LatLng(location.getLatitude(),location.getLongitude());
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(curentPlace));


                    }
                });

    }


    private void setUpDaggerComponent(){
        DaggerPlaceFinderComponent.create().inject(this);
    }

    @Override
    public void showError(String error) {
        switch (error){
            case  "Location not Found":
                LocationManager lm = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
                boolean gps_enabled = false;
                boolean network_enabled = false;

                try {
                    gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
                } catch(Exception ex) {}

                try {
                    network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                } catch(Exception ex) {}

                if(!gps_enabled && !network_enabled) {
                    // notify user
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setMessage("Loctaion is Not on");
                    dialog.setPositiveButton("Turn On", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                            // TODO Auto-generated method stub
                            Intent myIntent = new Intent( Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(myIntent);
                            //get gps
                        }
                    });
                    dialog.setNegativeButton("Leave it off", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                            // TODO Auto-generated method stub

                        }
                    });
                    dialog.show();
                }


        }

    }

    @Override
    public void goToPlaceDetails(Intent intent) {

    }

    @Override
    public void setupRecyclerView(List<PlacesPojo> places) {
        Log.d(TAG, "setupRecyclerView: "+ places);
        this.places = places;
        adapt = new RecycleAdapter(places);
        recy.setAdapter(adapt);
        recy.setItemAnimator(animate);
        recy.setLayoutManager(layout);
        mMap.clear();
        for (int i = 0; i <places.size() ; i++) {
            mMap.addMarker(new MarkerOptions().position(places.get(i).getLatLng()).title(places.get(i).getAddress().toString()));

        }
    }

    @Override
    public void checkForLocationPermission() {
        String[] permissions = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };

        for (int i = 0; i < permissions.length ; i++) {


            if (ContextCompat.checkSelfPermission(this,
                    permissions[i])
                    != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "onCreate: no premission");

                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        permissions[i])) {
                    Log.d(TAG, "onCreate: explain");


                } else {

                    // No explanation needed, we can request the permission.
                    Log.d(TAG, "onCreate: no explain");
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            LOCATION);

                }
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
       this.current= location;
        Log.d(TAG, "onLocationChanged: " + current + location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {


    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    public void filter(View view) {

        switch (view.getId()){
            case R.id.btnFood:
                Toast.makeText(this, "food"+ Place.TYPE_FOOD, Toast.LENGTH_SHORT).show();
                 result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
                presenter.setUpAdapter(result,Place.TYPE_FOOD);
                break;
            case R.id.btnInn:
                Toast.makeText(this, "Inn?"+ Place.TYPE_ROOM, Toast.LENGTH_SHORT).show();
                result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
                presenter.setUpAdapter(result,Place.TYPE_ROOM);
                break;
            case R.id.btnPark:
                Toast.makeText(this, "Park"+ Place.TYPE_PARK, Toast.LENGTH_SHORT).show();
                result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
                presenter.setUpAdapter(result,Place.TYPE_PARK);
                break;
            case R.id.btnMuseum:
                Toast.makeText(this, "Museum"+ Place.TYPE_MUSEUM, Toast.LENGTH_SHORT).show();
                result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
                presenter.setUpAdapter(result,Place.TYPE_MUSEUM);
                break;
            case R.id.btnLandmark:
                Toast.makeText(this, "Point of Intrest"+ Place.TYPE_POINT_OF_INTEREST, Toast.LENGTH_SHORT).show();
                result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
                presenter.setUpAdapter(result,Place.TYPE_POINT_OF_INTEREST);
                break;
            case R.id.btnBank:
                Toast.makeText(this, "Bank"+ Place.TYPE_BANK, Toast.LENGTH_SHORT).show();
                result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
                presenter.setUpAdapter(result,Place.TYPE_BANK);
                break;
            case R.id.btnTheater:
                Toast.makeText(this, "Theater"+ Place.TYPE_MOVIE_THEATER, Toast.LENGTH_SHORT).show();
                result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
                presenter.setUpAdapter(result,Place.TYPE_MOVIE_THEATER);
                break;
        }
    }

  }
