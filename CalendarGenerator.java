import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarGenerator {

	public static final int[] MONTH_DAYS = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static final String[] MONTH_NAMES = {
			"January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December"};
	
	public static final String[] DAYS_NAME = {
			"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	
	
	public static List<String> buildCalendar(int startMonth, int startYear, int endMonth, int endYear) {
		List<String> calendar = new ArrayList<String>();
		for (int k = startYear; k <= endYear; k++) {
			for (int i = (k==startYear)?startMonth:0; i<=endMonth; i++) {
				calendar.add(MONTH_NAMES[i]+" "+k);
				Calendar c = Calendar.getInstance();      
				c.set(k, i, 1);  
				int firstDayOfMonth = c.get(Calendar.DAY_OF_WEEK)-1;
				for (int j = 0; j < DAYS_NAME.length; j++) {
					calendar.add(DAYS_NAME[j]);
				}
				for (int j = 0; j < firstDayOfMonth; j++) {
					calendar.add("--");
				}
				for (int j = 1; j < MONTH_DAYS[i]+1; j++) {
					calendar.add(j<10?"0"+j:j+"");
				}
			}
		}
		return calendar;
	}


	public static void printCalendar(List<String> listCalendar) {
	    boolean daysFlag = false;
	    int weekDayCounter = 0;
	    for (int i = 0; i<listCalendar.size(); i++) {
	        String element = listCalendar.get(i);
	        if (element.length()>4) {
	            System.out.println("\n\n"+element);
	            weekDayCounter = 0;
	            daysFlag = true;
	            continue;
	        }
	        if (isInList(DAYS_NAME, element)) {
	            System.out.print(element+" ");
	            continue;
	        }
	        if (daysFlag) {
	            System.out.println();
	            daysFlag = false;
	        }

	        if (element.equals("--")) {
	            weekDayCounter++;
	            System.out.print(element+" ");
	            continue;
	        }
	        else if (weekDayCounter == 7) {
	            System.out.println();
	            weekDayCounter = 0;
	        }
	        System.out.print(element+" ");
	        weekDayCounter++;
	    }
	}
	
	
	public static boolean isInList(String[] myList, String element) {
		for(String s: myList) {
			if (s.equals(element)) { return true; }
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		List<String> listCalendar = buildCalendar(3, 1015, 7, 1017);
		printCalendar(listCalendar);
	}
	
}
