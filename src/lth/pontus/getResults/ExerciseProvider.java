package lth.pontus.getResults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseProvider {
	
	private ArrayList<Exercise> exerciselist;
	private ArrayList<Exercise> exerciselist0;
	private ArrayList<Exercise> exerciselist1;
	private ArrayList<Exercise> exerciselist2;
	private ArrayList<Exercise> exerciselist3;
	private ArrayList<Exercise> exerciselist4;
	private ArrayList<Exercise> exerciselist5;
	private ArrayList<Exercise> exerciselist6;
	
	public ExerciseProvider(){
		exerciselist = new ArrayList<Exercise>();
		exerciselist0 = new ArrayList<Exercise>(); 
		exerciselist1 = new ArrayList<Exercise>(); 
		exerciselist2 = new ArrayList<Exercise>(); 
		exerciselist3 = new ArrayList<Exercise>(); 
		exerciselist4 = new ArrayList<Exercise>(); 
		exerciselist5 = new ArrayList<Exercise>(); 
		exerciselist6 = new ArrayList<Exercise>(); 
		
		exerciselist0.add(new Exercise("Squat",false));
		exerciselist0.add(new Exercise("Sumo squats",false));
		exerciselist0.add(new Exercise("Front leg",false));
		exerciselist0.add(new Exercise("Hamstring",false));
		exerciselist0.add(new Exercise("Lunges",false));
		exerciselist0.add(new Exercise("Calves",false));
		exerciselist0.add(new Exercise("Deadlift",false));
		exerciselist0.add(new Exercise("Lower back",false));
		exerciselist0.add(new Exercise("Rows",false));
		exerciselist0.add(new Exercise("Latheral row",false));
		exerciselist0.add(new Exercise("Sitting row",false));
		exerciselist0.add(new Exercise("Pull up",false));
		exerciselist0.add(new Exercise("Dumbel row",false));
		exerciselist0.add(new Exercise("Benchpress",false));
		exerciselist0.add(new Exercise("Benchpress inc",false));
		exerciselist0.add(new Exercise("Bicep barbel",false));
		exerciselist0.add(new Exercise("Bicep isolate",false));
		exerciselist0.add(new Exercise("Tricep",false));
		exerciselist0.add(new Exercise("Tricep pdowns",false));
		exerciselist0.add(new Exercise("Upright row",false));
		exerciselist0.add(new Exercise("Dumbel flies",false));
		exerciselist0.add(new Exercise("Shoulder press",false));
		exerciselist0.add(new Exercise("Hipp abduction",false));

		


		
		exerciselist1.add(new Exercise("Squat",false));
		exerciselist1.add(new Exercise("Sumo squats",false));
		exerciselist1.add(new Exercise("Front leg",false));
		exerciselist1.add(new Exercise("Hamstring",false));
		exerciselist1.add(new Exercise("Lunges",false));
		exerciselist1.add(new Exercise("Calves",false));
		exerciselist1.add(new Exercise("Deadlift",false));
		exerciselist1.add(new Exercise("Lower back",false));
		exerciselist1.add(new Exercise("Rows",false));
		exerciselist1.add(new Exercise("Latheral row",false));
		exerciselist1.add(new Exercise("Sitting row",false));
		exerciselist1.add(new Exercise("Pull up",false));
		exerciselist1.add(new Exercise("Dumbel row",false));
		exerciselist1.add(new Exercise("Benchpress",false));
		exerciselist1.add(new Exercise("Benchpress inc",false));
		exerciselist1.add(new Exercise("Bicep barbel",false));
		exerciselist1.add(new Exercise("Bicep isolate",false));
		exerciselist1.add(new Exercise("Tricep",false));
		exerciselist1.add(new Exercise("Tricep pdowns",false));
		exerciselist1.add(new Exercise("Upright row",false));
		exerciselist1.add(new Exercise("Dumbel flies",false));
		exerciselist1.add(new Exercise("Shoulder press",false));
		exerciselist1.add(new Exercise("Hipp abduction",false));
		
		exerciselist2.add(new Exercise("Squat",false));
		exerciselist2.add(new Exercise("Sumo squats",false));
		exerciselist2.add(new Exercise("Front leg",false));
		exerciselist2.add(new Exercise("Hamstring",false));
		exerciselist2.add(new Exercise("Lunges",false));
		exerciselist2.add(new Exercise("Calves",false));
		exerciselist2.add(new Exercise("Deadlift",false));
		exerciselist2.add(new Exercise("Lower back",false));
		exerciselist2.add(new Exercise("Rows",false));
		exerciselist2.add(new Exercise("Latheral row",false));
		exerciselist2.add(new Exercise("Sitting row",false));
		exerciselist2.add(new Exercise("Pull up",false));
		exerciselist2.add(new Exercise("Dumbel row",false));
		exerciselist2.add(new Exercise("Benchpress",false));
		exerciselist2.add(new Exercise("Benchpress inc",false));
		exerciselist2.add(new Exercise("Bicep barbel",false));
		exerciselist2.add(new Exercise("Bicep isolate",false));
		exerciselist2.add(new Exercise("Tricep",false));
		exerciselist2.add(new Exercise("Tricep pdowns",false));
		exerciselist2.add(new Exercise("Upright row",false));
		exerciselist2.add(new Exercise("Dumbel flies",false));
		exerciselist2.add(new Exercise("Shoulder press",false));
		exerciselist2.add(new Exercise("Hipp abduction",false));
		
		exerciselist3.add(new Exercise("Squat",false));
		exerciselist3.add(new Exercise("Sumo squats",false));
		exerciselist3.add(new Exercise("Front leg",false));
		exerciselist3.add(new Exercise("Hamstring",false));
		exerciselist3.add(new Exercise("Lunges",false));
		exerciselist3.add(new Exercise("Calves",false));
		exerciselist3.add(new Exercise("Deadlift",false));
		exerciselist3.add(new Exercise("Lower back",false));
		exerciselist3.add(new Exercise("Rows",false));
		exerciselist3.add(new Exercise("Latheral row",false));
		exerciselist3.add(new Exercise("Sitting row",false));
		exerciselist3.add(new Exercise("Pull up",false));
		exerciselist3.add(new Exercise("Dumbel row",false));
		exerciselist3.add(new Exercise("Benchpress",false));
		exerciselist3.add(new Exercise("Benchpress inc",false));
		exerciselist3.add(new Exercise("Bicep barbel",false));
		exerciselist3.add(new Exercise("Bicep isolate",false));
		exerciselist3.add(new Exercise("Tricep",false));
		exerciselist3.add(new Exercise("Tricep pdowns",false));
		exerciselist3.add(new Exercise("Upright row",false));
		exerciselist3.add(new Exercise("Dumbel flies",false));
		exerciselist3.add(new Exercise("Shoulder press",false));
		exerciselist3.add(new Exercise("Hipp abduction",false));
		
		exerciselist4.add(new Exercise("Squat",false));
		exerciselist4.add(new Exercise("Sumo squats",false));
		exerciselist4.add(new Exercise("Front leg",false));
		exerciselist4.add(new Exercise("Hamstring",false));
		exerciselist4.add(new Exercise("Lunges",false));
		exerciselist4.add(new Exercise("Calves",false));
		exerciselist4.add(new Exercise("Deadlift",false));
		exerciselist4.add(new Exercise("Lower back",false));
		exerciselist4.add(new Exercise("Rows",false));
		exerciselist4.add(new Exercise("Latheral row",false));
		exerciselist4.add(new Exercise("Sitting row",false));
		exerciselist4.add(new Exercise("Pull up",false));
		exerciselist4.add(new Exercise("Dumbel row",false));
		exerciselist4.add(new Exercise("Benchpress",false));
		exerciselist4.add(new Exercise("Benchpress inc",false));
		exerciselist4.add(new Exercise("Bicep barbel",false));
		exerciselist4.add(new Exercise("Bicep isolate",false));
		exerciselist4.add(new Exercise("Tricep",false));
		exerciselist4.add(new Exercise("Tricep pdowns",false));
		exerciselist4.add(new Exercise("Upright row",false));
		exerciselist4.add(new Exercise("Dumbel flies",false));
		exerciselist4.add(new Exercise("Shoulder press",false));
		exerciselist4.add(new Exercise("Hipp abduction",false));
		
		exerciselist5.add(new Exercise("Squat",false));
		exerciselist5.add(new Exercise("Sumo squats",false));
		exerciselist5.add(new Exercise("Front leg",false));
		exerciselist5.add(new Exercise("Hamstring",false));
		exerciselist5.add(new Exercise("Lunges",false));
		exerciselist5.add(new Exercise("Calves",false));
		exerciselist5.add(new Exercise("Deadlift",false));
		exerciselist5.add(new Exercise("Lower back",false));
		exerciselist5.add(new Exercise("Rows",false));
		exerciselist5.add(new Exercise("Latheral row",false));
		exerciselist5.add(new Exercise("Sitting row",false));
		exerciselist5.add(new Exercise("Pull up",false));
		exerciselist5.add(new Exercise("Dumbel row",false));
		exerciselist5.add(new Exercise("Benchpress",false));
		exerciselist5.add(new Exercise("Benchpress inc",false));
		exerciselist5.add(new Exercise("Bicep barbel",false));
		exerciselist5.add(new Exercise("Bicep isolate",false));
		exerciselist5.add(new Exercise("Tricep",false));
		exerciselist5.add(new Exercise("Tricep pdowns",false));
		exerciselist5.add(new Exercise("Upright row",false));
		exerciselist5.add(new Exercise("Dumbel flies",false));
		exerciselist5.add(new Exercise("Shoulder press",false));
		exerciselist5.add(new Exercise("Hipp abduction",false));
		
		exerciselist6.add(new Exercise("Squat",false));
		exerciselist6.add(new Exercise("Sumo squats",false));
		exerciselist6.add(new Exercise("Front leg",false));
		exerciselist6.add(new Exercise("Hamstring",false));
		exerciselist6.add(new Exercise("Lunges",false));
		exerciselist6.add(new Exercise("Calves",false));
		exerciselist6.add(new Exercise("Deadlift",false));
		exerciselist6.add(new Exercise("Lower back",false));
		exerciselist6.add(new Exercise("Rows",false));
		exerciselist6.add(new Exercise("Latheral row",false));
		exerciselist6.add(new Exercise("Sitting row",false));
		exerciselist6.add(new Exercise("Pull up",false));
		exerciselist6.add(new Exercise("Dumbel row",false));
		exerciselist6.add(new Exercise("Benchpress",false));
		exerciselist6.add(new Exercise("Benchpress inc",false));
		exerciselist6.add(new Exercise("Bicep barbel",false));
		exerciselist6.add(new Exercise("Bicep isolate",false));
		exerciselist6.add(new Exercise("Tricep",false));
		exerciselist6.add(new Exercise("Tricep pdowns",false));
		exerciselist6.add(new Exercise("Upright row",false));
		exerciselist6.add(new Exercise("Dumbel flies",false));
		exerciselist6.add(new Exercise("Shoulder press",false));
		exerciselist6.add(new Exercise("Hipp abduction",false));

		
		}
	
	public void insertExersice(Exercise Exercise, int position){
		if(position == 0)
		exerciselist0.add(Exercise);
		else if(position == 1){
			exerciselist1.add(Exercise);
		}
	}
	
	public void insertList(ArrayList<Exercise> newList, int position){
		switch (position) {
        case 0:
        	exerciselist0 = newList;
        	break;
        case 1:
        	exerciselist1 = newList;
        	break;
        case 2:
        	exerciselist2 = newList;
        	break;
        case 3:
        	exerciselist3 = newList;
        	break;
        case 4:
        	exerciselist4 = newList;
        	break;
        case 5:
        	exerciselist5 = newList;
        	break;
        case 6:
        	exerciselist6 = newList;
        	break;
		}
	}
	
	public ArrayList<Exercise> getExercises(int position){
		switch (position) {
        case 0:
        	return (ArrayList<Exercise>) exerciselist0;
        case 1:
        	return (ArrayList<Exercise>) exerciselist1;
        case 2:
        	return (ArrayList<Exercise>) exerciselist2;
        case 3:
        	return (ArrayList<Exercise>) exerciselist3;
        case 4:
        	return (ArrayList<Exercise>) exerciselist4;
        case 5:
        	return (ArrayList<Exercise>) exerciselist5;
        case 6:
        	return (ArrayList<Exercise>) exerciselist6;
		}
		return null;
	}
	
}
