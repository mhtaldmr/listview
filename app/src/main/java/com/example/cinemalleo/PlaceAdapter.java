package com.example.cinemalleo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class PlaceAdapter extends ArrayAdapter <Place> {

    private Context mContext;
    private int mLayoutResourceId;
    private Place[] mData;




    PlaceAdapter(@NonNull Context context, int resource, @NonNull Place[] data) {
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }


    @Nullable
    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @SuppressLint("ViewHolder")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View row = convertView;
        PlaceHolder holder = null;

        if (row==null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new PlaceHolder();

            holder.nameView = (TextView) row.findViewById(R.id.nameTextView);
            holder.zipView = (TextView) row.findViewById(R.id.zipcodeTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
        }
        else
        {
            holder = (PlaceHolder) row.getTag();
        }

        Place place = mData[position];

        holder.imageView.setOnClickListener(PopupListener);


        Integer rowPostion = position;
        holder.imageView.setTag(rowPostion);

        holder.nameView.setText(place.mNameOfPlace);
        holder.zipView.setText(String.valueOf(place.mZipCode));

        /*
        TextView nameView = row.findViewById(R.id.nameTextView);
        TextView zipView =  row.findViewById(R.id.zipcodeTextView);
        ImageView imageView = row.findViewById(R.id.imageView);

        nameView.setText(place.mNameOfPlace);
        zipView.setText(String.valueOf(place.mZipCode));
        */

        int resId = mContext.getResources().getIdentifier(place.mNameOfImage,"drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resId);


        return row;

    }

    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            Place p= mData[viewPosition];
            Toast.makeText(getContext(),p.mPopup,Toast.LENGTH_SHORT).show();
        }
    };


    private class PlaceHolder {
        TextView nameView;
        TextView zipView;
        ImageView imageView;
    }


}
