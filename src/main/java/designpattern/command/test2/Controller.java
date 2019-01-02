package designpattern.command.test2;

public class Controller {
	private Command okCommand;
	private Command verticalCommand;
	private Command horizontalCommand;
	
	public void bindOKCommand(Command okCommand) {
		this.okCommand = okCommand;
	}
	
	public void bindVerticalCommand(Command verticalCommand) {
		this.verticalCommand = verticalCommand;
	}
	
	public void bindHorizontalCommand(Command horizontalCommand) {
		this.horizontalCommand = horizontalCommand;
	}
	
	public void buttonOKHold() {
		okCommand.exe();
	}
	
	public void buttonOkClick() {
		okCommand.unexe();
	}
	
	public void buttonUpClick() {
		verticalCommand.exe();
	}
	
	public void buttonDownClick() {
		verticalCommand.unexe();
	}
	
	public void buttonLeftClick() {
		horizontalCommand.unexe();
	}
	
	public void buttonRightClick() {
		horizontalCommand.exe();
	}
	
}
