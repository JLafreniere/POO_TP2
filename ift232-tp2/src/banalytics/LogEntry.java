package banalytics;

/*
 * Classe repr�sentant une entr�e de journal.
 */
public class LogEntry {

	public static final int OPENPLAY = 0;
	public static final int CLOSEPLAY = 1;
	public static final int OPENPAUSE = 2;
	public static final int CLOSEPAUSE = 3;
	public static final int OPENBUFFERING = 4;
	public static final int CLOSEBUFFERING = 5;
	public static final int MOVE = 6;
	
	private static final String typeStrings[]={"Playing segment at: ","Stopping at: ","Pausing at:","Resuming after:","Buffering at:","Resuming after:","Moving to"};
	
	private int type;
	private long time;

	public LogEntry(int type, long time) {
		this.type = type;
		this.time = time;
	}

	public int getType() {
		return type;
	}

	public long getTime() {
		return time;
	}
	
	public String toString(){
		
		long hours=time/(3600*1000);
		long minutes=(time%(3600*1000))/(60*1000);
		long seconds=((time)%(60*1000))/1000;
		
		String res=typeStrings[type]+" "+hours+"h"+minutes+"m"+seconds+"s";;
		
		return res;
	}

}
