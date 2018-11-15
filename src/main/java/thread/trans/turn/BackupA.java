package thread.trans.turn;

public class BackupA extends Thread {
	private DBTools dbtools;
	public BackupA(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}
	
	@Override
	public void run() {
		super.run();
		dbtools.backupA();
	}
	
}
