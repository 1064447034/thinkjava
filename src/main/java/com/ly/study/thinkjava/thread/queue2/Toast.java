package com.ly.study.thinkjava.thread.queue2;

public class Toast {
	public enum Status {
		DRY,
		BUTTERED,
		JAMMED
	}
	private Status status = Status.DRY;
	private final int id;
	public Toast(int idn) {
		this.id = idn;
	}
	public void buffer() {
		status = Status.BUTTERED;
	}
	public void jam() {
		status = Status.JAMMED;
	}
	public Status getStatus() {
		return status;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Toast " + id + ": " + status;
	}
}
