/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lth.pontus.getResults;

import com.example.getresults2.R;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.GraphViewStyle;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	
	AppSectionsPagerAdapter mAppSectionsPagerAdapter;

	ViewPager mViewPager;

	static DBAdapter MyDb;
	static ExerciseProvider exercisel;
	static DateProvider DateHelper;
	private static Context mContext;
	static View WeekdayRow;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = getApplicationContext();

		// Create the adapter that will return a fragment for each of the three
		// primary sections
		// of the app.
		mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();

		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayUseLogoEnabled(false);

		// Specify that the Home/Up button should not be enabled, since there is
		// no hierarchical
		// parent.
		actionBar.setHomeButtonEnabled(false);

		// Specify that we will be displaying tabs in the action bar.
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		exercisel = new ExerciseProvider();
		DateHelper = new DateProvider();
		openDB();

		// Set up the ViewPager, attaching the adapter and setting up a listener
		// for when the
		// user swipes between sections.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mAppSectionsPagerAdapter);
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						// When swiping between different app sections, select
						// the corresponding tab.
						// We can also use ActionBar.Tab#select() to do this if
						// we have a reference to the
						// Tab.
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter.
			// Also specify this Activity object, which implements the
			// TabListener interface, as the
			// listener for when this tab is selected.
			Tab a = actionBar.newTab().setIcon(
					mAppSectionsPagerAdapter.getPageICon(i));
			a.setTabListener(this);

			actionBar.addTab(a);
		}
	}

	public void onDestroy() {
		super.onDestroy();
		closeDB();
	}

	public void openDB() {
		MyDb = new DBAdapter(this);
		MyDb.open();

	}

	public void closeDB() {
		MyDb.close();
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the primary sections of the app.
	 */
	public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

		public AppSectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			switch (i) {
			case 0:
				// The first section of the app is the most interesting -- it
				// offers
				// a launchpad into the other demonstrations in this example
				// application.
				Fragment0 fragment0 = new Fragment0();
				Bundle args0 = new Bundle();
				args0.putInt(Fragment0.ARG_SECTION_NUMBER, i + 1);
				fragment0.setArguments(args0);
				return fragment0;
			case 1:
				Fragment1 fragment1 = new Fragment1();
				Bundle args1 = new Bundle();
				args1.putInt(Fragment1.ARG_SECTION_NUMBER, i + 1);
				fragment1.setArguments(args1);
				return fragment1;
			case 2:
				Fragment2 fragment2 = new Fragment2();
				Bundle args2 = new Bundle();
				args2.putInt(Fragment2.ARG_SECTION_NUMBER, i + 1);
				fragment2.setArguments(args2);
				return fragment2;
			case 3:
				Fragment3 fragment3 = new Fragment3();
				Bundle args3 = new Bundle();
				args3.putInt(Fragment3.ARG_SECTION_NUMBER, i + 1);
				fragment3.setArguments(args3);
				return fragment3;
			}
			return null;
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return "Training";
			case 1:
				return "Plan";
			case 2:
				return "Overview";
			case 3:
				return "Settings";
			}
			// return "Section " + (position + 1);
			return null;
		}

		public Drawable getPageICon(int position) {
			switch (position) {
			case 0:
				return (Drawable) mContext
						.getResources()
						.getDrawable(
								R.drawable.dumbell);
			case 1:
				return (Drawable) mContext
						.getResources()
						.getDrawable(
								R.drawable.penn);
			case 2:
				return (Drawable) mContext
						.getResources()
						.getDrawable(
								R.drawable.graph);
			case 3:
				return (Drawable) mContext
						.getResources()
						.getDrawable(
								R.drawable.settings);
			}
			// return "Section " + (position + 1);
			return null;
		}
	}

	public static class Fragment0 extends Fragment {

		public static final String ARG_SECTION_NUMBER = "section_number";
		private String exerciseName;
		private long startRowId;
		

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_training,
					container, false);

			// Onclick listener for my Save button
			rootView.findViewById(R.id.btnSave).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							populateListViewByDate(DateHelper.getToday());
							TextView thisday = (TextView) rootView.findViewById(R.id.textView_dateShower);
							thisday.setText(DateHelper.getToday());
						}
					});

			rootView.findViewById(R.id.btnNextDay).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							String day = DateHelper.plusOneDay();
							populateListViewByDate(day);
							TextView thisday = (TextView) rootView.findViewById(R.id.textView_dateShower);
							thisday.setText(day);
							//Toast.makeText(getActivity(), day, 3).show();
						}
					});

			rootView.findViewById(R.id.btnPrevDay).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							String day = DateHelper.minusOneDay();
							populateListViewByDate(day);
							TextView thisday = (TextView) rootView.findViewById(R.id.textView_dateShower);
							thisday.setText(day);
						}
					});

			// Onclick listener for Row in Listview
			ListView listView1 = (ListView) rootView
					.findViewById(R.id.listViewTraining);
			listView1.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> myAdapter, View myView,
						int myItemInt, long mylng) {
					final TextView textView = (TextView) myView
							.findViewById(R.id.textView_name);
					final TextView textViewID = (TextView) myView
							.findViewById(R.id.textView_ID);
					TextView textViewSet = (TextView) myView
							.findViewById(R.id.textView_set);
					TextView textViewRep = (TextView) myView
							.findViewById(R.id.textView_rep);
					TextView textViewWeight = (TextView) myView
							.findViewById(R.id.textView_weight);

					AlertDialog alertDialog = new AlertDialog.Builder(
							getActivity()).create();
					alertDialog.setTitle(textView.getText().toString());
					
					exerciseName = textView.getText().toString();

					// Manipulate and inflate my alertdialog_input view into the
					// dialog
					LayoutInflater inflater = getActivity().getLayoutInflater();
					inflater.inflate(R.layout.exercise_item_layout, null);
					View alertView = (View) inflater.inflate(
							R.layout.alertdialog_input, null);
					NumberPicker editSet = (NumberPicker) alertView
							.findViewById(R.id.numberPicker_Set);
					editSet.setMaxValue(20);
					editSet.setMinValue(0);
					NumberPicker editRep = (NumberPicker) alertView
							.findViewById(R.id.numberPicker_Rep);
					editRep.setMaxValue(100);
					editRep.setMinValue(0);
					NumberPicker editWeight = (NumberPicker) alertView
							.findViewById(R.id.numberPicker_weight);
					editWeight.setMaxValue(300);
					editWeight.setMinValue(0);
					
					editSet.setValue(Integer.parseInt(textViewSet.getText().toString()));
					editRep.setValue(Integer.parseInt(textViewRep.getText().toString()));
					editWeight.setValue(Integer.parseInt(textViewWeight.getText().toString()));
					alertDialog.setView(alertView);

					alertDialog.setButton2("Delete",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									
									MyDb.deleteRow(Integer
											.parseInt(textViewID.getText()
													.toString()));
									populateListViewByDate(DateHelper
											.getCurrentDate());
								}
							});
					
					alertDialog.setButton("Save exercise",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									NumberPicker editset = (NumberPicker) ((AlertDialog) dialog)
											.findViewById(R.id.numberPicker_Set);
									NumberPicker editrep = (NumberPicker) ((AlertDialog) dialog)
											.findViewById(R.id.numberPicker_Rep);
									NumberPicker editWeight = (NumberPicker) ((AlertDialog) dialog)
											.findViewById(R.id.numberPicker_weight);
									
									
									startRowId = Integer.parseInt(textViewID.getText().toString());
									
									MyDb.updateRowNoDate(
											Integer.parseInt(textViewID.getText().toString()), 
											textView.getText().toString(), 
											editset.getValue(), 
											editrep.getValue(), 
											editWeight.getValue());

									Cursor cursor = MyDb.getExerciseAboveId(Long.valueOf(startRowId), exerciseName);
									
									if(cursor.getCount() > 0){
										cursor.move(0);
										
										MyDb.updateRowNoById(cursor.getInt(0), editset.getValue(), editrep.getValue(), editWeight.getValue());
										
										//Toast.makeText(getActivity(), String.valueOf(cursor.getInt(0)), 3).show();
									}
									
									
									
									

									
									
									populateListViewByDate(DateHelper
											.getCurrentDate());
								}
							});
					// Set the Icon for the Dialog
					// alertDialog.setIcon(R.drawable.ic_launcher);
					alertDialog.show();

				}
			});

			return rootView;
		}

		private void populateListViewByDate(String currentDate) {
			Cursor cursor = MyDb.getRowByDate(currentDate);

			getActivity().startManagingCursor(cursor);

			// Setup mapping from cursor to view fields:
			String[] fromFieldNames = new String[] { DBAdapter.KEY_NAME,
					DBAdapter.KEY_SETS, DBAdapter.KEY_REP,
					DBAdapter.KEY_WEIGHT, DBAdapter.KEY_ROWID,
					DBAdapter.KEY_DATES };
			int[] toViewIDs = new int[] { R.id.textView_name,
					R.id.textView_set, R.id.textView_rep, R.id.textView_weight,
					R.id.textView_ID, R.id.textView_listdate };

			// Create adapter to many columns of the DB onto element in the UI
			SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
					this.getActivity(), R.layout.exercise_item_layout, // Row
																		// layout
																		// template
					cursor, // Cursor
					fromFieldNames, // Db column names
					toViewIDs); // View IDs to put information in

			// Set the adapter for the listview
			ListView myList = (ListView) getActivity().findViewById(
					R.id.listViewTraining);
			myList.setAdapter(myCursorAdapter);

		}

		private void populateListViewFromDB() {
			Cursor cursor = MyDb.getAllRows();

			getActivity().startManagingCursor(cursor);

			// Setup mapping from cursor to view fields:
			String[] fromFieldNames = new String[] { DBAdapter.KEY_NAME,
					DBAdapter.KEY_SETS, DBAdapter.KEY_REP,
					DBAdapter.KEY_WEIGHT, DBAdapter.KEY_ROWID,
					DBAdapter.KEY_DATES };
			int[] toViewIDs = new int[] { R.id.textView_name,
					R.id.textView_set, R.id.textView_rep, R.id.textView_weight,
					R.id.textView_ID, R.id.textView_listdate };

			// Create adapter to many columns of the DB onto element in the UI
			SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
					this.getActivity(), R.layout.exercise_item_layout, // Row
																		// layout
																		// template
					cursor, // Cursor
					fromFieldNames, // Db column names
					toViewIDs); // View IDs to put information in

			// Set the adapter for the listview
			ListView myList = (ListView) getActivity().findViewById(
					R.id.listViewTraining);
			myList.setAdapter(myCursorAdapter);
		}

	}

	public static class Fragment1 extends Fragment {

		public static final String ARG_SECTION_NUMBER = "section_number";
		private ArrayList<String> dayList;
		private MyListAdapter mAdapter;

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_create,
					container, false);
			Bundle args = getArguments();

			dayList = new ArrayList<String>();
			dayList.add("Monday");
			dayList.add("Tuesday");
			dayList.add("Wednesday");
			dayList.add("Thursday");
			dayList.add("Friday");
			dayList.add("Saturday");
			dayList.add("Sunday");

			this.mAdapter = new MyListAdapter(getActivity(), dayList);
			final ListView listview1 = (ListView) rootView
					.findViewById(R.id.listView_create);
			listview1.setAdapter(mAdapter);

			listview1.setClickable(true);
			listview1
					.setOnItemClickListener(new AdapterView.OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,
								int position, long arg3) {
							WeekdayRow = arg1;
							Object o = listview1.getItemAtPosition(position);
							String str = (String) o;// As you are using Default
													// String Adapter
							

							Intent intent = new Intent(getActivity(),
									CheckboxActivity.class);
							intent.putExtra("STRING_I_NEED", position);
							intent.putExtra("DAY_I_NEED", str);
							getActivity().startActivity(intent);
						}
					});

			rootView.findViewById(R.id.button_saveweek).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							ArrayList<ArrayList<Exercise>> weeklist = new ArrayList<ArrayList<Exercise>>();
							ArrayList<String> dates = DateHelper
									.getRangeOfDates();
							DateTimeFormatter fmt = DateTimeFormat
									.forPattern("YYYY-MM-dd");
							DateTime dt = fmt.parseDateTime(dates.get(0));
							String dayindex = dt.dayOfWeek().getAsString();
							int daycorrection = Integer.parseInt(dayindex) - 1;

							for (int i = 0; i <= 6; i++) {
								weeklist.add(exercisel.getExercises(i));
							}

							for (int i = 0; i <= dates.size() - 1; i++) {
								int index = (i + daycorrection) % 7;

								ArrayList<Exercise> current = weeklist
										.get(index);
								String tempdate = dates.get(i);
								for (int j = 0; j <= current.size() - 1; j++) {
									if (current.get(j).isSelected()) {
										MyDb.insertRow(
												current.get(j).getName(), 3, 8,
												0, tempdate);
									}
								}
							}

							
						}
					});

			rootView.findViewById(R.id.button_setschedule).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							AlertDialog alertDialog = new AlertDialog.Builder(
									getActivity()).create();
							alertDialog.setTitle("Select period");
							LayoutInflater inflater = getActivity()
									.getLayoutInflater();
							final View alertView = (View) inflater.inflate(
									R.layout.alertdialog_period, null);
							NumberPicker np = (NumberPicker) alertView
									.findViewById(R.id.numberPicker_period);
							np.setMaxValue(100);
							np.setMinValue(1);
							alertDialog.setView(alertView);

							alertDialog.setButton("Save period",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int which) {
											String startDate;
											DatePicker datepicker = (DatePicker) alertView
													.findViewById(R.id.datePicker_schedule);
											int daytemp = datepicker
													.getDayOfMonth();
											String day = null;
											if (daytemp <= 9) {
												day = "0"
														+ String.valueOf(daytemp);
											} else {
												day = String.valueOf(datepicker
														.getDayOfMonth());
											}
											int monthtemp = datepicker
													.getMonth() + 1;
											String month = null;
											if (monthtemp <= 9) {
												month = "0"
														+ String.valueOf(monthtemp);
											} else {
												month = String.valueOf(datepicker
														.getMonth() + 1);
											}
											startDate = String.valueOf(datepicker
													.getYear()
													+ "-"
													+ month
													+ "-" + day);
											DateHelper.setStartDate(startDate);
											NumberPicker numberpicker = (NumberPicker) alertView
													.findViewById(R.id.numberPicker_period);
											int weeks = numberpicker.getValue();
											DateHelper.setWeeks(weeks);
											
											ArrayList<ArrayList<Exercise>> weeklist = new ArrayList<ArrayList<Exercise>>();
											ArrayList<String> dates = DateHelper
													.getRangeOfDates();
											DateTimeFormatter fmt = DateTimeFormat
													.forPattern("YYYY-MM-dd");
											DateTime dt = fmt.parseDateTime(dates.get(0));
											String dayindex = dt.dayOfWeek().getAsString();
											int daycorrection = Integer.parseInt(dayindex) - 1;

											for (int i = 0; i <= 6; i++) {
												weeklist.add(exercisel.getExercises(i));
											}

											for (int i = 0; i <= dates.size() - 1; i++) {
												int index = (i + daycorrection) % 7;

												ArrayList<Exercise> current = weeklist
														.get(index);
												String tempdate = dates.get(i);
												for (int j = 0; j <= current.size() - 1; j++) {
													if (current.get(j).isSelected()) {
														MyDb.insertRow(
																current.get(j).getName(), 3, 8,
																0, tempdate);
													}
												}
											}

										}
									});

							alertDialog.show();

							// displayRecordSet(cursor);
						}
					});
			
			

			return rootView;
		}

		private void populateListViewFromArray() {

		}

		public void OnStart() {

		}

	}

	public static class Fragment2 extends Fragment {

		public static final String ARG_SECTION_NUMBER = "section_number";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_overview,
					container, false);
			Bundle args = getArguments();
			
			
			

			rootView.findViewById(R.id.button_startGraphview).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							Intent intent = new Intent(getActivity(),
									PlotActivity.class);
							getActivity().startActivity(intent);
							
						}
					});
			
			rootView.findViewById(R.id.button_showInfo).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							Intent intent = new Intent(getActivity(),
									InfoActivity.class);
							getActivity().startActivity(intent);
							
						}
					});
			
			Spinner spinner = (Spinner) rootView.findViewById(R.id.exercise_spinner_plot);
			// Create an ArrayAdapter using the string array and a default spinner layout
			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
			        R.array.exercise_array, android.R.layout.simple_spinner_item);
			// Specify the layout to use when the list of choices appears
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// Apply the adapter to the spinner
			spinner.setAdapter(adapter);
			
			spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			        String exercise = (String) parent.getItemAtPosition(pos);
			        TextView setEx = (TextView) rootView.findViewById(R.id.textView_dynamic_exercise);
			        setEx.setText(exercise);
			        
			    }
			    public void onNothingSelected(AdapterView<?> parent) {
			    }
			});
			
			Spinner spinner2 = (Spinner) rootView.findViewById(R.id.exercise_spinner_plot2);
			// Create an ArrayAdapter using the string array and a default spinner layout
			ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
			        R.array.exercise_array, android.R.layout.simple_spinner_item);
			// Specify the layout to use when the list of choices appears
			adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// Apply the adapter to the spinner
			spinner2.setAdapter(adapter2);
			
			spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			        String exercise = (String) parent.getItemAtPosition(pos);
			        
			        
			    }
			    public void onNothingSelected(AdapterView<?> parent) {
			    }
			});
			
			
			
			
			
			return rootView;
		}
	}

	public static class Fragment3 extends Fragment {

		public static final String ARG_SECTION_NUMBER = "section_number";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_settings,
					container, false);
			Bundle args = getArguments();
			return rootView;
		}
	}
}
