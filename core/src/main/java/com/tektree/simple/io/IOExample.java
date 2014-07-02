package com.tektree.simple.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class IOExample {

	public static void main(String[] args) {
		// readFile();
		// writeFile();
	}

	public static void writeFile() throws IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("This ");
		builder.append("is ");
		builder.append("just ");
		builder.append("an ");
		builder.append("example.");

		OutputStream fileOutputStream = null;
		try {
			File exampleFile = new File("src/main/resources/example.txt");
			fileOutputStream = new FileOutputStream(exampleFile);
			byte[] data = builder.toString().getBytes("UTF-8");
			fileOutputStream.write(data);
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
	}

	public static void readFile() throws IOException {
		File applicationProperties = new File(
				"src/main/resources/application.properties");
		InputStream fileInputStream = null;
		BufferedReader bufferedFileReader = null;
		try {
			fileInputStream = new FileInputStream(applicationProperties);
			StringBuilder builder = new StringBuilder();
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
	}

}
