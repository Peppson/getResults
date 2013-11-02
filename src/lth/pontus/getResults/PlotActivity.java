package lth.pontus.getResults;

import java.util.ArrayList;

import com.example.getresults2.R;
import com.example.getresults2.R.layout;
import com.example.getresults2.R.menu;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PlotActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.graphview_layout);
		ArrayList<Integer> a = new ArrayList<Integer>();
		String squat = "Squat";
		//Cursor cursor = db.rawQuery("SELECT * FROM people WHERE lastname = ?; ", new String[] {"John Kenedy"});
		Cursor cursor = MainActivity.MyDb.getRowByExercise(squat);
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			a.add(cursor.getInt(4));
			
		}
		/**if(cursor.getCount()==0){
			AlertDialog.Builder builder1 = new AlertDialog.Builder(getApplicationContext());
            builder1.setMessage("There are no exercise for choosen period");
            builder1.setCancelable(true);
            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    finish();
                }
            });
           

            AlertDialog alert11 = builder1.create();
            alert11.show();
		}**/
		
		int num = a.size();  
		GraphViewData[] data = new GraphViewData[a.size()];  
		int nbr = 0;
		int i = 0;
		while(i<=(num-1)){
			nbr = a.get(i); 
		   data[i] = new GraphViewData(i, nbr);
		   i++;
		}

		GraphViewSeriesStyle style1 = new GraphViewSeriesStyle(Color.rgb(0, 100, 0),3);
		GraphViewSeries seriesSin = new GraphViewSeries("Squat", style1, data); 
		
		data = new GraphViewData[2];  
		int nbr1 = a.get(0);
		   data[0] = new GraphViewData(0, nbr1);
		   data[1] = new GraphViewData(a.size()-1, 100);
		  
		GraphViewSeriesStyle style2 = new GraphViewSeriesStyle(Color.rgb(100, 149, 237),3);
		GraphViewSeries seriesCos = new GraphViewSeries("Goal", style2, data);

		GraphView graphView = new LineGraphView(this // context
				, "" // heading
		);
		graphView.setShowLegend(true);
		graphView.setLegendAlign(LegendAlign.BOTTOM);
		graphView.addSeries(seriesSin);
		graphView.addSeries(seriesCos);// data
		graphView.setViewPort(1, 5);
		// graphView.setScrollable(true);
		// optional - activate scaling / zooming
		graphView.setScalable(true);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.mygraph4);
		layout.addView(graphView);
		
		findViewById(R.id.button_plot_graph).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						finish();
					}
				});
	}


}
