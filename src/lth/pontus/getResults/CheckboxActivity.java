package lth.pontus.getResults;

import java.util.ArrayList;

import com.example.getresults2.R;
import com.example.getresults2.R.layout;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CheckboxActivity extends Activity {
	
	MyCustomAdapter dataAdapter = null;
	private int position;
	private String todayday = null;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_checkbox);
		
		Intent intent = getIntent();
		position = intent.getIntExtra("STRING_I_NEED", -1);
		todayday = intent.getStringExtra("DAY_I_NEED");
		setTitle(todayday);
		Spinner spinner = (Spinner) findViewById(R.id.exercise_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.bodyparts_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		displayListView();
		 
		  checkButtonClick();
		 
		 }
	
	@Override
	public void onPause(){
		super.onPause();
	}
	
		 
		 private void displayListView() {
		 
		  //Array list of exercises
		  ArrayList<Exercise> currentList = MainActivity.exercisel.getExercises(position);
		
		  //create an ArrayAdaptar from the String Array
		  dataAdapter = new MyCustomAdapter(this,
		    R.layout.checkbox_item_layout, currentList);
		  ListView listView = (ListView) findViewById(R.id.listView1);
		  // Assign adapter to ListView
		  listView.setAdapter(dataAdapter);
		 
		 
		  listView.setOnItemClickListener(new OnItemClickListener() {
		   public void onItemClick(AdapterView<?> parent, View view,
		     int position, long id) {
		   
		   }
		  });
		 
		 }
		 
		 private class MyCustomAdapter extends ArrayAdapter<Exercise> {
		 
		  private ArrayList<Exercise> currentList;
		 
		  public MyCustomAdapter(Context context, int textViewResourceId, 
				  ArrayList<Exercise> currentList) {
		   super(context, textViewResourceId, currentList);
		   this.currentList = new ArrayList<Exercise>();
		   this.currentList.addAll(currentList);
		  }
		 
		  private class ViewHolder {
		   CheckBox name;
		  }
		 
		  @Override
		  public View getView(int position, View convertView, ViewGroup parent) {
		 
		   ViewHolder holder = null;
		   Log.v("ConvertView", String.valueOf(position));
		 
		   if (convertView == null) {
		   LayoutInflater vi = (LayoutInflater)getSystemService(
		     Context.LAYOUT_INFLATER_SERVICE);
		   convertView = vi.inflate(R.layout.checkbox_item_layout, null);
		 
		   holder = new ViewHolder();

		   holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
		   convertView.setTag(holder);
		 
		    holder.name.setOnClickListener( new View.OnClickListener() {  
		     public void onClick(View v) {  
		      CheckBox cb = (CheckBox) v ;  
		      Exercise exercise = (Exercise) cb.getTag();  
		     
		      exercise.setSelected(cb.isChecked());
		     }  
		    });  
		   } 
		   else {
		    holder = (ViewHolder) convertView.getTag();
		   }
		 
		   Exercise exercise = currentList.get(position);
		   holder.name.setText(exercise.getName());
		   holder.name.setChecked(exercise.isSelected());
		   holder.name.setTag(exercise);
		 
		   return convertView;
		 
		  }
		 
		 }
		 
		 private void checkButtonClick() {
		 
		 
		  Button myButton = (Button) findViewById(R.id.findSelected);
		  myButton.setOnClickListener(new OnClickListener() {
		 
		   @Override
		   public void onClick(View v) {
		 
		    StringBuffer responseText = new StringBuffer();
		    responseText.append("The following were selected...\n");
		 
		    ArrayList<Exercise> currentList = dataAdapter.currentList;
		    for(int i=0;i<currentList.size();i++){
		     Exercise exercise = currentList.get(i);
		     if(exercise.isSelected()){
		      responseText.append("\n" + exercise.getName());
		     }
		    }
		 
		   /** Toast.makeText(getApplicationContext(),
		      responseText, Toast.LENGTH_LONG).show();**/
		    MainActivity.exercisel.insertList(currentList, position);
		    TextView row = (TextView) MainActivity.WeekdayRow.findViewById(R.id.textView_counter_number);
		    int counter = 0;
		    for(int i = 0;i<=(currentList.size()-1); i++){
		    	if(currentList.get(i).isSelected()){
		    		counter++;
		    	}
		    }
		    if(counter == 0){
		    	row.setText("Rest");
		    }else{
		    row.setText(String.valueOf(counter));	
		    }
		    
		    finish();
		   }
		  });
		 
		 }
		   
		 
		
}
