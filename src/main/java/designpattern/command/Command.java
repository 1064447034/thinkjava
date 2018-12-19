package designpattern.command;

public abstract class Command {
	protected Receiver receiver;
	
	public abstract void execute();
	
}
