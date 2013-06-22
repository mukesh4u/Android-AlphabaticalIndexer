package com.mukesh.aphabaticalview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Alphbatical extends Activity {
	private ListView countryList;
	String item;
	AllDataAdapter adapter;
	int iconName;
	ArrayList<Data> listData = new ArrayList<Data>();

	ArrayList<Data> allPlaceData = new ArrayList<Data>();
	ArrayList<Data> temp = new ArrayList<Data>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		final String[] alphabaticalList = { "All", "A", "B", "C", "D", "E",
				"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		// side list
		final ListView sideList = (ListView) findViewById(R.id.sideIndex);
		ArrayAdapter<String> alphabaticalListAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, alphabaticalList);
		sideList.setAdapter(alphabaticalListAdapter);
		// fill hard coded in array list
		allPlaceData.add(new Data("Afghanistan"));
		allPlaceData.add(new Data("Albania"));
		allPlaceData.add(new Data("Argentina"));
		allPlaceData.add(new Data("Australia"));
		allPlaceData.add(new Data("Austria"));
		allPlaceData.add(new Data("Bangladesh"));
		allPlaceData.add(new Data("Belgium"));
		allPlaceData.add(new Data("Brazil"));
		allPlaceData.add(new Data("China"));
		allPlaceData.add(new Data("Colombia"));
		allPlaceData.add(new Data("Canada"));
		allPlaceData.add(new Data("Denmark"));
		allPlaceData.add(new Data("Dominican"));
		allPlaceData.add(new Data("Egypt"));
		allPlaceData.add(new Data("Ethiopia"));
		allPlaceData.add(new Data("Fiji"));
		allPlaceData.add(new Data("France"));
		allPlaceData.add(new Data("Georgia"));
		allPlaceData.add(new Data("Germany"));
		allPlaceData.add(new Data("Greece"));
		allPlaceData.add(new Data("Hong Kong"));
		allPlaceData.add(new Data("Hungary"));
		allPlaceData.add(new Data("Iceland"));
		allPlaceData.add(new Data("India"));
		allPlaceData.add(new Data("Indonesia"));
		allPlaceData.add(new Data("Iran"));
		allPlaceData.add(new Data("Iraq"));
		allPlaceData.add(new Data("Ireland"));
		allPlaceData.add(new Data("Italy"));
		allPlaceData.add(new Data("Jamaica"));
		allPlaceData.add(new Data("Japan"));
		allPlaceData.add(new Data("Kenya"));
		allPlaceData.add(new Data("Korea, North"));
		allPlaceData.add(new Data("Kuwait"));
		allPlaceData.add(new Data("Lebanon"));
		allPlaceData.add(new Data("Madagascar"));
		allPlaceData.add(new Data("Malaysia"));
		allPlaceData.add(new Data("Mexico"));
		allPlaceData.add(new Data("Nepal"));
		allPlaceData.add(new Data("New Zealand"));
		allPlaceData.add(new Data("Oman"));
		allPlaceData.add(new Data("Pakistan"));
		allPlaceData.add(new Data("Poland"));
		allPlaceData.add(new Data("Qatar"));
		allPlaceData.add(new Data("Romania"));
		allPlaceData.add(new Data("Russia"));
		allPlaceData.add(new Data("Spain"));
		allPlaceData.add(new Data("Sri Lanka"));
		allPlaceData.add(new Data("Switzerland"));
		allPlaceData.add(new Data("Taiwan"));
		allPlaceData.add(new Data("Turkey"));
		allPlaceData.add(new Data("Uganda"));
		allPlaceData.add(new Data("United Kingdom"));
		allPlaceData.add(new Data("Vietnam"));
		allPlaceData.add(new Data("Yemen"));
		allPlaceData.add(new Data("Zambia"));
		allPlaceData.add(new Data("Zimbabwe"));

		adapter = new AllDataAdapter(this, R.layout.home_list, allPlaceData);
		countryList = (ListView) findViewById(R.id.list);
		countryList.setAdapter(adapter);
		temp.addAll(allPlaceData);

		/*
		 * On Item click listener
		 */
		countryList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View v,
					final int position, long id) {
				// TODO Auto-generated method stub

				// show toast
			}
		});

		/*
		 * On click of alphabatical list view item
		 */
		sideList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				item = (String) sideList.getAdapter().getItem(position);
				listData.clear();

				for (int i = 0; i < temp.size(); i++) {
					String name = temp.get(i).title;
					String subName = name.substring(0, 1);
					if (subName.startsWith(item)) {

						listData.add(new Data(name));

					}
					// for all click.........
					if (position == 0) {
						listData.add(new Data(name));
					}

				}
				allPlaceData.clear();
				allPlaceData.addAll(listData);
				AllDataAdapter adapter = new AllDataAdapter(Alphbatical.this,
						R.layout.home_list, allPlaceData);
				countryList.setAdapter(adapter);

			}

		});
	}
}