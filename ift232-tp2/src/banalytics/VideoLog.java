package banalytics;

import java.util.ArrayList;

/*
 * Journal spécialisé pour les vidéos.
 */

public class VideoLog implements MediaLog {

ArrayList<LogEntry> entries;
	
	public VideoLog(){
		entries = new ArrayList<LogEntry>();
	}
	
	
	@Override
	public void openPlaySegment(long pos) {
		entries.add(new LogEntry(LogEntry.OPENPLAY,pos));
		
	}

	@Override
	public void openPauseEntry(long pos) {
		entries.add(new LogEntry(LogEntry.OPENPAUSE,pos));
		
	}

	@Override
	public void closePauseEntry(long time) {
		entries.add(new LogEntry(LogEntry.CLOSEPAUSE,time));
		
	}

	@Override
	public void closePlaySegment(long pos) {
		entries.add(new LogEntry(LogEntry.CLOSEPLAY,pos));
		
	}

	@Override
	public void openBufferingEntry(long pos) {
		entries.add(new LogEntry(LogEntry.OPENBUFFERING,pos));
		
	}

	@Override
	public void closeBufferingEntry(long time) {
		entries.add(new LogEntry(LogEntry.CLOSEBUFFERING,time));
		
	}

	@Override
	public void addMoveEntry(long pos) {
		entries.add(new LogEntry(LogEntry.MOVE,pos));
		
	}	

	public String toString(){
		
		String res = "----------Video usage log----------\n";
		
		for(LogEntry entry:entries){
			
			res += entry+"\n";
		}
		
		return res;
		
	}

	

}
