package com.tektree.simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;

import com.tektree.simple.math.Arithmetic;

public class App {

	public static void main(String[] args) {
		Random random = new Random(234632469);
		System.out.println("Boolean:  " + random.nextBoolean());
		System.out.println("Double:   " + random.nextDouble());
		System.out.println("Float:    " + random.nextFloat());
		System.out.println("Gaussian: " + random.nextGaussian());
		System.out.println("Int:      " + random.nextInt());
		System.out.println("Int:      " + random.nextInt(10));
	}

	public static void dates() {
		Date date = new Date();
		System.out.println("Date:  " + date);

		Calendar clndr = Calendar.getInstance();
		System.out.println("Calendar date:  " + clndr.getTime());

		// reset the date to 72 months from now in the future
		int now = clndr.get(Calendar.MONTH);
		clndr.set(Calendar.MONTH, now + 72);
		System.out.println("Calendar date:  " + clndr.getTime());

		// print the equivalent date/time in Japan time zone
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE MMM dd hh:mm:ss z yyyy");
		format.setTimeZone(timeZone);
		System.out.println("Calendar date:  " + format.format(clndr.getTime()));
	}

	public static void resourceBundle() throws FileNotFoundException,
			IOException {

		ResourceBundle bundle = new PropertyResourceBundle(new FileInputStream(
				"src/main/resources/application.properties"));
		System.out.println("downstream_system_url: "
				+ bundle.getString("downstream_system_url"));
		System.out
				.println("name:                  " + bundle.getString("name"));
		System.out.println("occupation:            "
				+ bundle.getString("occupation"));
		System.out.println("address:               "
				+ bundle.getString("address"));
	}

	public static void scanner(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		String next = scanner.nextLine();
		System.out.println("Your name is " + next);
		scanner.close();
	}

	public static void collections(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("Ahab", "Samsung");
		m.put("Qin", "Thinkpad");
		m.put("Srikanth", "Samsung");
		Set<Entry<String, String>> entrySet = m.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println("-------------------");

		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(-20);
		myList.add(45);
		myList.add(29);
		myList.add(85);

		myList.add(185);

		myList.add(85);
		myList.add(85);
		myList.add(85);
		myList.add(85);
		myList.add(-23);
		myList.add(-1578);

		for (Integer myVar : myList) {
			System.out.print(myVar + "  ");
		}
		System.out.print("\n");
		System.out.println("-------------------");

		myList.remove((Integer) 85);
		for (Integer myVar : myList) {
			System.out.print(myVar + "  ");
		}
		System.out.print("\n");
		System.out.println("-------------------");
	}

	public static void generics(String[] args) {
		Arithmetic<Long> arithmetic = new Arithmetic<Long>();
		Long add = arithmetic.add(1l, 5l);
		System.out.println(add);
		Double subtract = new Arithmetic<Double>().subtract(1d, 5d);
		System.out.println(subtract);
	}

}
