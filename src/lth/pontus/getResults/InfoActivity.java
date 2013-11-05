package lth.pontus.getResults;

import com.example.getresults2.R;
import com.example.getresults2.R.layout;
import com.example.getresults2.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class InfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Squats");
		setContentView(R.layout.activity_info);

		findViewById(R.id.button_closeInfo).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						finish();

					}
				});
	}

}
