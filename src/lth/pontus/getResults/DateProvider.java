package lth.pontus.getResults;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateProvider {
	private ArrayList<String> weekdays;
	private String startdate = null;
	private int weeks =0;
	private String currentDate = null;
	
	public DateProvider(){
		//Kunna provida datumar
		//Kunna returnera vilken dag i veckan det är
		//Kunna hantera en datum som inputsträng
		weekdays = new ArrayList<String>();
		weekdays.add("Monday");
		weekdays.add("Tuesday");
		weekdays.add("Wednesday");
		weekdays.add("Thursday");
		weekdays.add("Friday");
		weekdays.add("Saturday");
		weekdays.add("Sunday");
		
	}
	
	public String getToday(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		currentDate = sdf.format(date);
		
		return sdf.format(date);
	}
	public String getCurrentDate(){
		return currentDate;
	}
	
	public ArrayList<String> getRangeOfDates(){
		ArrayList<String> days = new ArrayList<String>();
		int totaldays = (weeks * 7)-1;
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
		DateTime dt = fmt.parseDateTime(startdate);
		days.add(fmt.print(dt));
		String todays = dt.dayOfWeek().getAsString();
		
		for(int i = 0; i < totaldays; i++){
			dt = dt.plusDays(1);
			String timestampOut = fmt.print(dt);
			days.add(timestampOut);
		
		
		
	}
		return days;
	
}
	public String getWeekDay(String dateday){
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
		DateTime dt = fmt.parseDateTime(dateday);
		String dayindex = dt.dayOfWeek().getAsString();
		return weekdays.get((Integer.parseInt(dayindex) -1));
	}
	
	public void setStartDate(String startDate){
		startdate = startDate;
	}
	
	public void setWeeks(int Weeks){
		weeks = Weeks;
	}

	public String plusOneDay(){
		if(currentDate == null){
			currentDate = getToday();
		}
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
		DateTime dt = fmt.parseDateTime(currentDate);
		
		dt = dt.plusDays(1);
		currentDate = fmt.print(dt);
		return currentDate;
	}
	
	public String minusOneDay(){
		if(currentDate == null){
			currentDate = getToday();
		}
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd");
		DateTime dt = fmt.parseDateTime(currentDate);
		
		dt = dt.minusDays(1);
		currentDate = fmt.print(dt);
		return currentDate;
	}
	
}
	
	
