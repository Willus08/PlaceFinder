package posidenpalace.com.placefinder.view.activities.place_finder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import posidenpalace.com.placefinder.Model.PlacesPojo;
import posidenpalace.com.placefinder.R;
import posidenpalace.com.placefinder.view.activities.place_details.PlaceDetails;

/**
 * Created by Android on 7/14/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> implements Serializable{
List<PlacesPojo> places = new ArrayList<>();

    public RecycleAdapter(List<PlacesPojo> places) {
        this.places= places;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecycleAdapter.ViewHolder holder, int position) {
        final PlacesPojo place = places.get(position);
        holder.address.setText(place.getAddress());
        holder.id.setText(place.getName());

        TranslateAnimation trans = new TranslateAnimation(10,0,12,0);
        trans.setDuration(500);
        holder.itemView.startAnimation(trans);

        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Passing: "+ place.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), PlaceDetails.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("place" ,  place);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }

        });


    }

    @Override
    public int getItemCount() {
       return places.size() ;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView id;

        LinearLayout linearLayout;
        public ViewHolder(final View itemView) {
            super(itemView);

            address = (TextView) itemView.findViewById(R.id.tvAddress);
            id = (TextView) itemView.findViewById(R.id.tvID);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.llContainer);
        }
    }
}
