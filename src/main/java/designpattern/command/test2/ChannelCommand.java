package designpattern.command.test2;

public class ChannelCommand implements Command {
	private Device device;
	
	public ChannelCommand(Device device) {
		this.device = device;
	}

	@Override
	public void exe() {
		device.channelUp();
	}

	@Override
	public void unexe() {
		device.channelDown();
	}
	
}
