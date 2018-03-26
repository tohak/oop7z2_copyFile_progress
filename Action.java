package com.konovalov;

public class Action {
	private long progressFinal;
	private byte[] buffer;
	private int readbyte;
	private boolean flag = false;
	private boolean stop = false;

	public Action(long progressFinal) {
		super();
		this.progressFinal = progressFinal;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getReadbyte() {
		return readbyte;
	}

	public void setReadbyte(int readbyte) {
		this.readbyte = readbyte;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	public long getProgressFinal() {
		return progressFinal;
	}

	public void setProgressFinal(long progressFinal) {
		this.progressFinal = progressFinal;
	}

}
