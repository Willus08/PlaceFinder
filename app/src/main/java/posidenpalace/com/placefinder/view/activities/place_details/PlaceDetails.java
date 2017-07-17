package posidenpalace.com.placefinder.view.activities.place_details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import posidenpalace.com.placefinder.Model.PlacesPojo;
import posidenpalace.com.placefinder.R;
import posidenpalace.com.placefinder.view.Injection.place_details.DaggerPlaceDetailsComponent;

public class PlaceDetails extends AppCompatActivity implements PlaceDetailsContract.View {
    @Inject
    PlaceDetailsPresenter presenter;
    TextView name;
    TextView address;
    TextView phone;
    RatingBar rate;
    WebView web;
    TextView price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        setUpDaggerComponent();
        presenter.addView(this);
        name = (TextView) findViewById(R.id.tvName);
        address = (TextView) findViewById(R.id.tvAddress);
        phone= (TextView) findViewById(R.id.tvPhone);
        price= (TextView) findViewById(R.id.tvPriceLevel);
        web= (WebView) findViewById(R.id.wvWebSite);
        rate= (RatingBar) findViewById(R.id.rbRatings);
        presenter.extractData(getIntent());

    }
    private void setUpDaggerComponent(){
        DaggerPlaceDetailsComponent.create().inject(this);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void setUp(PlacesPojo place) {

        if(place.getName() != null)
            name.setText("Name: " +place.getName());
        if(place.getAddress() != null)
            address.setText("Address: "+place.getAddress());
        if(place.getPhone() != null)
            phone.setText("Phone: "+place.getPhone());
        if(place.getPriceLevel() != -1)
            price.setText("Price Level: "+place.getPriceLevel());
        if(place.getWebsite() != null)
            web.loadUrl(place.getWebsite().toString());
        if(place.getRating() != -1){
            rate.setProgress((int) place.getRating());
            rate.setVisibility(View.VISIBLE);
        }
        else
            rate.setVisibility(View.GONE);

    }

    public void GetDirections(View view) {
        Toast.makeText(this, "Comming Soon", Toast.LENGTH_SHORT).show();
    }
}
