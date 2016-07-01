package com.example.ngocthang.ngonngulaptrinh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ngoc Thang on 7/1/2016.
 */
public class MyAdapter extends ArrayAdapter<NgonNgu> {
    public MyAdapter(Context context, int resource, List<NgonNgu> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.dong_ngon_ngu, null);
        }
        NgonNgu nn = getItem(position);
        if(nn != null){
            TextView txtName = (TextView) view.findViewById(R.id.textViewName);
            TextView txtDetail = (TextView) view.findViewById(R.id.textViewDetail);
            ImageView imvThumnai = (ImageView) view.findViewById(R.id.imageViewThumnai);
            txtDetail.setText(nn.getDetail());
            txtName.setText(nn.getName());
            imvThumnai.setImageResource(nn.getImage());
        }
        return view;
    }
}
