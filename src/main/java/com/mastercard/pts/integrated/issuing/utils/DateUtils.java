package com.mastercard.pts.integrated.issuing.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

/**
 * Implement this class to will keep common function which is independent
 * 
 * @author e070234
 *
 */
@Component
public class DateUtils {

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

	public static String getDateDDMMYYFormat() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dateFormat.format(new Date()).replaceAll("[/,:,\\s+]", "");

	}

	public String getDateMMDDFormat() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");

		return dateFormat.format(new Date()).replaceAll("[/,:,\\s+]", "");

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

	public static String getDateddMMyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		return sdf.format(cal.getTime());
	}

	public static String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(cal.getTime());
	}

	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateTimeDDMMYYYYHHMMSS() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		return sdf.format(cal.getTime());
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

	public static void main(String[] args) {
		DateUtils date = new DateUtils();
		System.out.println(date.getDateinDDMMYYYY());
	}

}
