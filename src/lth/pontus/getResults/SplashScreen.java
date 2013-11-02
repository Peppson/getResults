package lth.pontus.getResults;

import com.example.getresults2.R;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashThread = new Thread(){
			
			public void run(){
				try{
					sleep(5000);
				}catch (InterruptedException e){
						//do Nothing
					} finally {
						finish();
						Intent i = new Intent();
						i.setClassName("com.example.android.getresults","com.example.android.getresults.MainActivity" );
						startActivity(i);
				}
			}
			
		};
		splashThread.start();
    }
}