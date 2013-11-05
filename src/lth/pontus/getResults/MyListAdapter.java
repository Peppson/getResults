package lth.pontus.getResults;

import java.util.ArrayList;

import com.example.getresults2.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MyListAdapter extends ArrayAdapter<String> {

	private Context context;
	private ArrayList<String> weekdays;

	private LayoutInflater mInflater;
	private boolean mNotifyOnChange = true;

	public MyListAdapter(Context context, ArrayList<String> mDays) {
		super(context, R.layout.create_item_layout);
		this.context = context;
		this.weekdays = new ArrayList<String>(mDays);
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return weekdays.size();
	}

	@Override
	public String getItem(int position) {
		return weekdays.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getPosition(String item) {
		return weekdays.indexOf(item);
	}

	@Override
	public int getViewTypeCount() {
		return 1; // Number of types + 1 !!!!!!!!
	}

	@Override
	public int getItemViewType(int position) {
		return 1;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		int type = getItemViewType(position);
		if (convertView == null) {
			holder = new ViewHolder();
			switch (type) {
			case 1:
				convertView = mInflater.inflate(R.layout.create_item_layout,
						parent, false);
				holder.name = (TextView) convertView
						.findViewById(R.id.textView_day);
				break;
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(weekdays.get(position));
		holder.pos = position;

		Button Button1 = (Button) convertView
				.findViewById(R.id.button_add_exercise);

		Button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(context, CheckboxActivity.class);
				intent.putExtra("STRING_I_NEED", position);
				context.startActivity(intent);
			}
		});

		return convertView;
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
		mNotifyOnChange = true;
	}

	public void setNotifyOnChange(boolean notifyOnChange) {
		mNotifyOnChange = notifyOnChange;
	}

	// ---------------static views for each row-----------//
	static class ViewHolder {

		TextView name;
		int pos; // to store the position of the item within the list
	}

}