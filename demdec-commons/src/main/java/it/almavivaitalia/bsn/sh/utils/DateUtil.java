package it.almavivaitalia.bsn.sh.utils;

import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

	@SuppressWarnings("static-access")
	public static String controllaOra(String data, String ora) throws Throwable{
		String dataFormattata = "";
	    if(!data.isEmpty()){
	        Date date = getDate(data,"dd/MM/yyyy");
	        if(date != null) {
	            if (!ora.isEmpty()) {
	                if(ora.contains(":")){
	                    String ore = ora.substring(0, ora.indexOf(':'));
	                    String minuti = ora.substring(ora.indexOf(':')+1, ora.length());
	                    if((ore.length()==2) && (minuti.length()==2)) {
	                        Short o = Short.parseShort(ore);
	                        Short m = Short.parseShort(minuti);
	                        if((o>=0) && (o<=23) && (m>=0) && (m<=59)) {
	                            Calendar dateCal = Calendar.getInstance();
	                            dateCal.setTime(date);
	                            dateCal.set(dateCal.HOUR_OF_DAY, o.intValue());
	                            dateCal.set(dateCal.MINUTE, m.intValue());
	                            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	                            dataFormattata=dateformat.format(dateCal.getTime());
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return dataFormattata;
	    //System.out.println("Errore di formato ora");
	}

	public static Date getDate(String s, String format) throws Exception {
		if (!isEmpty(s)) {
			return new SimpleDateFormat(format).parse(s);
		} else {
			return null;
		}
	}
	
	public static Date getDate(String s) throws Exception {
		if (!isEmpty(s)) {
			return new SimpleDateFormat("dd/MM/yyyy").parse(s);
		} else {
			return null;
		}
	}	

	public static String getDateString(Date d, String format) {
		if (d != null) {
			return new SimpleDateFormat(format).format(d);
		} else {
			return null;
		}
	}

	public static String getFormattedDate(Date date) {
		String formattedDate = "";
		if (date != null) {
			try {
				formattedDate = DateFormat.getDateInstance(DateFormat.SHORT,
						Locale.ITALY).format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return formattedDate;
	}

	public static int getYear(java.util.Date d) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d);
		int anno = calendar.get(Calendar.YEAR);
		return anno;
	}

	public static int getYearsUntilToday(Date date) {
		Calendar now = Calendar.getInstance();
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
	
		int yearNow = now.get(Calendar.YEAR);
		int yearDate = dateCal.get(Calendar.YEAR);
	
		int years = yearNow - yearDate;
	
		dateCal.set(Calendar.YEAR, yearNow);
	
		if (dateCal.after(now)) {
			years--;
		}
	
		return years;
	
	}

	public static boolean isDate(String dateIn) {
		Pattern p =Pattern.compile("" +
				"^((\\d\\d)/"+										//GIORNO
				"(\\d\\d)/" +										//MESE
				"(\\d\\d\\d\\d)){1}$"+								//ANNO
				"");
		Matcher m=p.matcher(dateIn);
		if(m.find()){
			//controllo validità
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			try {
				sdf.parse(dateIn);
			} catch (Exception e) {
				return false;
			}
		}else{
			return false;
		}
		return true;
	}
	
}
