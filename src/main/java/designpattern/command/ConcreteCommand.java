package designpattern.command;

public class ConcreteCommand extends Command {
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.doSomething();
	}
	
}
