package com.konovalov;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LoadThread implements Runnable {
	private Action action;
	private File in;

	public LoadThread(Action action, File in) {
		super();
		this.action = action;
		this.in = in;

	}

	@Override
	public synchronized void run() {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		try (FileInputStream fis = new FileInputStream(this.in)) {
			for (; (readByte = fis.read(buffer)) > 0;) {
				for (; this.action.isFlag() == true;) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				this.action.setBuffer(buffer);
				this.action.setReadbyte(readByte);
				this.action.setFlag(true);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.action.setStop(true);

	}

}
