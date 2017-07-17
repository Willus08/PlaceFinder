package posidenpalace.com.placefinder.view;

/**
 * Created by Android on 7/14/2017.
 */

public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void reomveView();
}
