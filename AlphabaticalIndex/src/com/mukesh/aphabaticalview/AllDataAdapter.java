package com.mukesh.aphabaticalview;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AllDataAdapter extends ArrayAdapter<Data>{
	 Context context;
	    int layoutResourceId;   
	   // BcardImage data[] = null;
	    ArrayList<Data> data=new ArrayList<Data>();
	    public AllDataAdapter(Context context, int layoutResourceId, ArrayList<Data> data) {
	        super(context, layoutResourceId, data);
	        this.layoutResourceId = layoutResourceId;
	        this.context = context;
	        this.data = data;
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View row = convertView;
	        Holder holder = null;
	       
	        if(row == null)
	        {
	            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	            row = inflater.inflate(layoutResourceId, parent, false);
	           
	            holder = new Holder();
	            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
	           
	            row.setTag(holder);
	        }
	        else
	        {
	            holder = (Holder)row.getTag();
	        }
	       
	        Data place = data.get(position);
	        holder.txtTitle.setText(place.title);
	       
	        return row;
	    }
	   
	    static class Holder
	    {
	        TextView txtTitle;
	    }
	}
