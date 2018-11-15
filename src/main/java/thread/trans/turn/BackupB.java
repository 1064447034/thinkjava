package thread.trans.turn;

public class BackupB extends Thread {
	private DBTools dbtools;
	public BackupB(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}
	@Override
	public void run() {
		super.run();
		dbtools.backupB();
	}
}
