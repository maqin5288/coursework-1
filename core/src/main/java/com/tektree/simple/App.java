package com.tektree.simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import com.tektree.simple.math.Arithmetic;

public class App {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		ResourceBundle bundle = new PropertyResourceBundle(new FileInputStream(
				"src/main/resources/application.properties"));
		String url = bundle.getString("downstream_system_url");
		System.out.println("URL: " + url);
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
