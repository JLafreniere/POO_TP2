package tests;

import banalytics.Banalyser;
import banalytics.Media;

public class BanalyserTest {
	
	public static void main(String[] args) {
		
		Media music = new Media("The Space Explorers", "Big Falcon Rocket", ".mp3",180000);
		
		Banalyser musicAnalyser = new Banalyser(music);
		
		musicAnalyser.start(0);
		musicAnalyser.pause(30000);
		musicAnalyser.resume(10000);
		musicAnalyser.move(102000);
		musicAnalyser.resume(1000);
		musicAnalyser.buffer(150000);
		musicAnalyser.resume(5000);
		musicAnalyser.stop(180000);
		
		
		System.out.println(musicAnalyser.getTextLog());
		
		Media video = new Media("ESA Channel", "The Beagle hasn't landed", ".mov",953000);
		Banalyser videoAnalyser = new Banalyser(video);
		
		videoAnalyser.start(0);
		videoAnalyser.buffer(5000);
		videoAnalyser.resume(60000);
		videoAnalyser.pause(30000);	
		videoAnalyser.resume(105000);
		videoAnalyser.move(570000);		
		videoAnalyser.resume(1000);
		videoAnalyser.stop(900000);
		
		
		System.out.println(videoAnalyser.getTextLog());
		
	}

}
