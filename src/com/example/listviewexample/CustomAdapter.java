package com.example.listviewexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter  {

	private Activity activity;
	private ArrayList<?> data;
	private static LayoutInflater inflater = null;
	public Resources res;
	ListModel tempValues = null;
	int i = 0;

	public CustomAdapter(Activity a, ArrayList<?> d, Resources resLocal)
	{
		activity = a;
		data = d;
		res = resLocal;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() 
	{
		if (data.size() <= 0)
			return 1;
		return data.size();
	}

	public Object getItem(int position)
	{
		return position;
	}

	public long getItemId(int position)
	{
		return position;
	}

	public static class ViewHolder
	{
		public TextView text;
		public TextView text1;
	}

	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View vi = convertView;
		ViewHolder holder;

		if (convertView == null) 
		{
			vi = inflater.inflate(R.layout.tabitem, null);
			holder = new ViewHolder();
			holder.text = (TextView) vi.findViewById(R.id.text);
			holder.text1 = (TextView) vi.findViewById(R.id.text1);
			vi.setTag(holder);
		} 
		else
			holder = (ViewHolder) vi.getTag();

		if (data.size() <= 0) 
		{
			holder.text.setText("No Data");

		} 
		else
		{
			tempValues = null;
			tempValues = (ListModel) data.get(position);

			holder.text.setText(tempValues.getCompanyName());
			holder.text1.setText(tempValues.getUrl());
		}
		return vi;
	}

}