package posidenpalace.com.placefinder.view.activities.place_details;

import android.content.Intent;

import posidenpalace.com.placefinder.Model.PlacesPojo;
import posidenpalace.com.placefinder.view.BasePresenter;
import posidenpalace.com.placefinder.view.BaseView;

/**
 * Created by Android on 7/14/2017.
 */

public interface PlaceDetailsContract {
    interface View extends BaseView{
        void setUp(PlacesPojo place);



    }

    interface Presenter extends BasePresenter<View>{
        void extractData(Intent intent);
    }
}
