/**
 * 
 */
package com.mastercard.pts.integrated.issuing.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Component
public class DateUtils {
	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	private static final int DEFAULT_KEY_LENGTH = 10;
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	/**
	 * 
	 * @return String Date in the format YYYY/MM/DD HH:mm:ss
	 */
	public static String getDateYYMMDDFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(new Date()).replaceAll("[/,:,\\s+]", "");

	}	
    public static String currentDateddMMyyyy(){
    	Date date = new Date();
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    public static String currentDateYYMMDD(){
    	Date date = new Date();
        String format = "yyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
	
	public static String getDateTimeDDMMYYYYHHMMSS() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		return sdf.format(cal.getTime());
	}
	
	public static String getEffectiveDate(){
		Calendar c = Calendar.getInstance();   
		c.add(Calendar.MONTH, 1);   
		return new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
	} 
	
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateMMDD() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		return sdf.format(cal.getTime());
	}

	public static String getDateyyMMdd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		return sdf.format(cal.getTime());
	}

	public static String getDateddMMyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateddDashMMDashyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(cal.getTime());
	}

	public String getDateyyyyMMdd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(cal.getTime());
	}

	public static String getDateyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateMMyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MMyyyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateYYMM() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYMM");
		return sdf.format(cal.getTime());
	}

	public static String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(cal.getTime());
	}

	public static String getTimeSpecificFormat() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	public static String addressLine(int number) {
		return org.apache.commons.lang.RandomStringUtils.random(number, false, true);
	}
	
	public static String generateStringWithUniqueKey(String text) {
		return generateStringWithUniqueKey(text, DEFAULT_KEY_LENGTH);
	}

	public static String generateStringWithUniqueKey(String text, int keyLength) {
		return text + generateUniqueKey(keyLength);
	}

	public static String generateUniqueKey() {
		return generateUniqueKey(DEFAULT_KEY_LENGTH);
	}

	public static String generateUniqueKey(int keyLength) {
		long ts = new Date().getTime();
		return StringUtils.right(Long.toString(ts), keyLength);
	}
	
	public static String getLocalDateInYYYYMMDD(){
		return	LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}
	public static String getDateDDMMYYFormat() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dateFormat.format(new Date()).replaceAll("[/,:,\\s+]", "");

	}

	public String getDateMMDDFormat() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");

		return dateFormat.format(new Date()).replaceAll("[/,:,\\s+]", "");

	}
	
	public String getDateDDMMFormat() {
		
		return getDateMMDDFormat().substring(2, 4)+getDateMMDDFormat().substring(0, 2);
	}

	public void datePicker(JFrame parent)// create constructor
	{
		d = new JDialog();
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));
		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Previous");
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Next >>");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);
		d.add(p1, BorderLayout.CENTER);
		d.add(p2, BorderLayout.SOUTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);
	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");// set text
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		// create object of SimpleDateFormat
		java.util.Calendar cal = java.util.Calendar.getInstance();
		// create object of java.util.Calendar
		cal.set(year, month, 1); // set year, month and date
		// define variables
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		// condition
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			// set text
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		// set title
		d.setTitle("Date Picker");
	}

	public String setPickedDate() {
		// if condition
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		System.out.println(sdf.format(cal.getTime()));
		return sdf.format(cal.getTime());
	}

	public static String getDateInCalanderFormat(String format) {

		String[] date = format.split("/");

		SimpleDateFormat f = new SimpleDateFormat(date[0]);
		SimpleDateFormat f1 = new SimpleDateFormat(date[1]);
		SimpleDateFormat f2 = new SimpleDateFormat(date[2]);

		return f.format(new Date()) + "/" + f1.format(new Date()) + "/" + f2.format(new Date());
	}

	public static String getDateInCalanderFormat(String format, int additionalDay) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, additionalDay);

		String[] date = format.split("/");
		SimpleDateFormat f = new SimpleDateFormat(date[0]);
		SimpleDateFormat f1 = new SimpleDateFormat(date[1]);
		SimpleDateFormat f2 = new SimpleDateFormat(date[2]);

		return f.format(calendar.getTime()) + "/" + f1.format(calendar.getTime()) + "/" + f2.format(calendar.getTime());
	}


	public static String getDateTimeDDMMYYHHMMSS() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmmss");
		return sdf.format(cal.getTime());
	}

	public static String getDateinDDMMYYYY() {
		Date date = new Date();
		return new SimpleDateFormat("MMMM/dd/yyyy").format(date);
	}
	public static String getNextDateInDDMMYYYY() {
		   Calendar calendar = Calendar.getInstance(); 
		   Date today = calendar.getTime();  
		  calendar.add(Calendar.DAY_OF_YEAR, 1); 
		  Date tomorrow = calendar.getTime(); 
		return new SimpleDateFormat("MMMM/dd/yyyy").format(tomorrow);
	}
	public static String getDateInYYMM(String dateVal) {
		// for format of date to be passed is YYMM .Ex: Input is 10-2022..
		// output should be 2210
		String[] tempArr = dateVal.split("-");
		String tempVal = dateVal.substring(dateVal.length() - 2);
		return tempVal + tempArr[0];
	}

	public static LocalDate convertInstitutionDateInLocalDateFormat(String institutionDate){
		return LocalDate.parse(institutionDate, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
	}
	
	public static int getNextMonthFirstDayDifference(String institutionDate){			
		LocalDate localDate = LocalDate.now();
		logger.info("localDate date : {}" , localDate);
		LocalDate convertedDate = LocalDate.parse(institutionDate, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		logger.info("Coverted Institution date : {} " , convertedDate);
		LocalDate monthLastDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear())) ;
		logger.info("monthLastDate date : {}" ,monthLastDate);
		logger.info("Diffrence Days : {}",ChronoUnit.DAYS.between(localDate, monthLastDate));
		return (int) (ChronoUnit.DAYS.between(localDate, monthLastDate) + 1);
	}
	
	public static int getDaysDifferenceBetweenTwoDates(String fromDate,String toDate){			
		LocalDate convertedDate1 = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		LocalDate convertedDate2 = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		logger.info("Coverted Institution date : {} " , convertedDate1);
		logger.info("Coverted Transaction date : {} " , convertedDate2);
		logger.info("Diffrence Days : {}",ChronoUnit.DAYS.between(convertedDate1, convertedDate2));
		return (int) (ChronoUnit.DAYS.between(convertedDate1, convertedDate2));
	}
	
	public static int noOfDaysInYear(String institutionDate){
		LocalDate convertedDate1 = LocalDate.parse(institutionDate, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		if(convertedDate1.isLeapYear()){
			return 366;
		}
		return 365;
	}
	
	public static int getNextDate(String institutionDate) {
		LocalDate localDate = LocalDate.now();
		logger.info("localDate date : {}", localDate);
		LocalDate convertedDate = LocalDate.parse(institutionDate, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		logger.info("Coverted Institution date : {} ", convertedDate);
		logger.info("Diffrence Days : {}", ChronoUnit.DAYS.between(localDate, convertedDate));
		return (int) (ChronoUnit.DAYS.between(localDate, convertedDate));
	}
	
	public static LocalDate convertTransactionDateInLocalDateFormat(String institutionDate){
		return LocalDate.parse(institutionDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	
	public static LocalDate convertInstitutionCurrentDateInLocalDateFormat(String institutionDate){
		return LocalDate.parse(institutionDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public String getDateDDMMFormat(String currentDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(currentDate, formatter);
		DateTimeFormatter formatterddMM = DateTimeFormatter.ofPattern("ddMM");
		return dateTime.format(formatterddMM);
	}
}
