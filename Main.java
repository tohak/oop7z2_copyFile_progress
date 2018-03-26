package com.konovalov;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File in = new File("a.exe");
		File out = new File("b.exe");
		long inFile = in.length();

		try {
			out.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Action actionFile = new Action(in.length());
		Thread loadFile = new Thread(new LoadThread(actionFile, in));
		Thread saveFile = new Thread(new SaveThread(actionFile, out));

		loadFile.start();
		saveFile.start();

		for (; inFile != out.length();) {
			System.out.println("copy progress: " + out.length() * 100 / inFile + "%");
			try {				
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("the end copy");

	}

}
