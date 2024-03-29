package com.tektree.simple.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOExample {

	public static void main(String[] args) throws IOException {
		File fileObject = new File("/home/mint/test.txt");
		InputStream stream = null;
		try {
			stream = new FileInputStream(fileObject);
			System.out.println("The stream was created successfully.");
			// read the contents here
			StringBuilder builder = new StringBuilder();
			int input = stream.read();
			System.out.println("First char: " + input);
			while(input != -1) {
				builder.append((char) input);
				input = stream.read();
			}
			System.out.println("-------------------------");
			System.out.println("The contents of the stream are:");
			System.out.println(builder.toString());
			System.out.println("-------------------------");
		} finally {
			if (stream != null) {
				System.out.println("The stream will be closed.");
				stream.close();
			} else {
				System.out.println("The stream was never created.");
			}
		}
	}

	public static void regex() throws IOException {

		String fileContents = readFile();
		String[] lines = fileContents.split("(\\r|\\n)");

		System.out.println("Checking pattern!");
		System.out.println("*************");
		Pattern comment = Pattern.compile("^#.*?$");
		for (int i = 0; i < lines.length; i++) {
			Matcher commentMatcher = comment.matcher(lines[i]);
			if (commentMatcher.matches()) {
				continue;
			}
			// kdfsJGJK_HKGKsdfjk=jks sdl,l skldjh
			System.out.println("This line is a valid property.");
			System.out.println(lines[i]);
		}
	}

	public static void writeFile() throws IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("This "); // "This "
		builder.append("is "); // "This is "
		builder.append("just "); // "This is just "
		builder.append("an ");
		builder.append("example."); // "This is just an example."

		OutputStream fileOutputStream = null;
		try {
			File exampleFile = new File("/home/mint/example.txt");
			fileOutputStream = new FileOutputStream(exampleFile);
			byte[] data = builder.toString().getBytes("UTF-8");
			fileOutputStream.write(data);
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
	}

	public static String readFile() throws IOException {
		File applicationProperties = new File(
				"src/main/resources/application.properties");
		InputStream fileInputStream = null;
		BufferedReader bufferedFileReader = null;
		StringBuilder builder = new StringBuilder();
		try {
			fileInputStream = new FileInputStream(applicationProperties);
			bufferedFileReader = new BufferedReader(new InputStreamReader(
					fileInputStream));
			String readLine = bufferedFileReader.readLine();
			while (readLine != null) {
				builder.append(readLine);
				builder.append("\n");
				readLine = bufferedFileReader.readLine();
			}
			System.out.println(builder.toString());
		} finally {
			if (bufferedFileReader != null) {
				bufferedFileReader.close();
			}
			if (fileInputStream != null) {
				fileInputStream.close();
			}
		}
		return builder.toString();
	}

}
