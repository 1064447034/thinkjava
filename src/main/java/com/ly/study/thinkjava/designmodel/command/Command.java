package com.ly.study.thinkjava.designmodel.command;

public abstract class Command {
	protected Receiver receiver;
	
	public abstract void execute();
	
}
