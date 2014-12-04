package com.example.listviewexample;

import java.util.ArrayList;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	ListView list;
	CustomAdapter adapter;
	public MainActivity CustomListView = null;
	public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CustomListView = this;
		setListData();

		list = (ListView) findViewById(R.id.list); 
		list.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				// TODO Auto-generated method stub
				if(view !=null)
				{
					 ListModel tempValues = ( ListModel ) CustomListViewValuesArr.get(position);
				        Toast.makeText(CustomListView,
				                ""+tempValues.getCompanyName()+"Url:"+tempValues.getUrl(),
				                Toast.LENGTH_SHORT).show();
				}
			}
			});
		
		adapter = new CustomAdapter(CustomListView, CustomListViewValuesArr, null);
		list.setAdapter(adapter);
	}

	public void setListData() 
	{
//		final ListModel sched = new ListModel();
//		sched.setCompanyName("Companys ");
//		sched.setUrl("http:\\www." + ".com");
//		CustomListViewValuesArr.add(0, sched);
//		
//		final ListModel sched1 = new ListModel();
//		sched1.setCompanyName("Companys1 ");
//		sched1.setUrl("http:\\www.1" + ".com");
//		CustomListViewValuesArr.add(1, sched1);
		
		for (int i = 0; i < 55; i++)
		{
			final ListModel sched = new ListModel();

			sched.setCompanyName("Company " + i);
			sched.setUrl("http:\\www." + i + ".com");

			CustomListViewValuesArr.add(sched);
		}

	}

}