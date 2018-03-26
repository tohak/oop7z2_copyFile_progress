package com.konovalov;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveThread implements Runnable {
	private Action action;
	private File out;

	public SaveThread(Action action, File out) {
		super();
		this.action = action;
		this.out = out;
	}

	@Override
	public synchronized void run() {
		try (FileOutputStream fos = new FileOutputStream(this.out)) {
			for (; this.action.isStop() == false;) {
				for (; this.action.isFlag() == false;) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				fos.write(this.action.getBuffer(), 0, this.action.getReadbyte());
				this.action.setFlag(false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
