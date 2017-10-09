package banalytics;

/*
 * Structure représentant un contenu multimédia.
 */

public class Media {
	final static String VIDEO = ".mov";
	final static String MUSIC = ".mp3";
	
	private String author;
	private String title;
	private String type; // MUSIC or VIDEO
	private long duration;
	
	public String getType(){
		return type;
	}
	
	public Media(String author,String title, String type, long duration){
		
		this.author=author;
		this.title=title;
		this.type=type;
		this.duration=duration;
	}
	
	public String toString(){
		
		String res="";
		
		if(type == MUSIC){
			
			res += "Audio: "; 			
		}
		else{
			res += "Video: "; 	
		}
		
		long hours=duration/(3600*1000);
		long minutes=(duration%(3600*1000))/(60*1000);
		long seconds=((duration)%(60*1000))/1000;
		res+=author+ ": "+title+" ("+hours+"h"+minutes+"m"+seconds+"s)";
		
		return res;	
		
	}
	

}
