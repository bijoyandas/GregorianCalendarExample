import java.util.*;

public class MyGreg {
	
	public static void main(String[] args) {
		int day=1,month=1,year=1;
		System.out.println("Enter the day, month and year to display : ");
		Scanner in = new Scanner(System.in);
		try {
			day = in.nextInt();
			month = in.nextInt();
			year = in.nextInt();
			in.close();
			if (day<0 || day>31 || month<0 || month>12 || year < 0){
				throw new Exception();
			}
			printCalendar(day,month,year);
		}
		catch(Exception e){
			System.out.println("Please enter the date properly!");
			System.exit(1);
		}
		
	}
	
	private static void printCalendar(int day,int month,int year){
		Calendar cal = new GregorianCalendar();
		cal.clear();
		cal.set(year, month-1, 1);
		
		int firstDayofWeek = cal.get(Calendar.DAY_OF_WEEK);
		int numOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		int indexDay = 0;
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		
		for(int i=1;i<firstDayofWeek;i++){
			System.out.print("\t");
			indexDay++;
		}
		
		for(int i=1;i<=numOfDays;i++){
			if (day==i){
				System.out.print(i+"*\t");
			}
			else if (day!=i) {
				System.out.print(i+"\t");
			}
			indexDay++;
			
			if(indexDay==7){
				indexDay=0;
				System.out.println();
			}
		}
	}

}
