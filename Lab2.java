import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

class Lab2{

	public static Firstdate date(Date fromDate, Date toDate){
		// from Date
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(fromDate);
		int fromYear = fromCalendar.get(Calendar.YEAR);
		int fromMonth = fromCalendar.get(Calendar.MONTH) + 1;

		// to Date
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(toDate);
		int toYear = toCalendar.get(Calendar.YEAR);
		int toMonth = toCalendar.get(Calendar.MONTH) + 1;

		// Today's Date
		java.util.Date todayDay = new Date();
		Calendar todayCalendar = Calendar.getInstance();
		todayCalendar.setTime(todayDay);
		int todayYear = todayCalendar.get(Calendar.YEAR);
		int todayMonth = todayCalendar.get(Calendar.MONTH) + 1;

		String FromDateFinal = fromYear + "-" + fromMonth + "-" + "01";
		String ToDateFinal =   toYear + "-" + "12" + "-" + "31";
		if (toYear == todayYear) {
			if (toMonth >= todayMonth) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				ToDateFinal = dateFormat.format(todayDay);
			} else {
				ToDateFinal = toYear + "-" + toMonth + "-" + toCalendar.getActualMaximum(Calendar.DATE);
			}
		} else if (toYear > todayYear) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ToDateFinal = dateFormat.format(todayDay);
		} else {
			ToDateFinal = toYear + "-" + toMonth + "-" + toCalendar.getActualMaximum(Calendar.DATE);
		}
		return new Firstdate(FromDateFinal, ToDateFinal);
	}

	static class Firstdate {
		String fromDate;
		String toDate;
		Firstdate(String fromDate, String toDate) {
			this.fromDate = fromDate;
			this.toDate = toDate;
		}
	}

	public static void main(String[] args) throws Exception {
		String from_date = "2016-09-11";
		String to_date = "2016-02-06";
                
		Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from_date);
		Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(to_date);
		Firstdate date = date(fromDate, toDate);
                System.out.println("input:");
                System.out.println("from_date:"+from_date);
		System.out.println("to_date:"+to_date);
                System.out.println("Output:");
		System.out.println("fromdate: " + date.fromDate);
		System.out.println("todate: " + date.toDate);
	}
}