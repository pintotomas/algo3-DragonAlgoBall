package utils;

import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class ReproductorDeSonidos implements Runnable {

	private ArrayList<String> musicFiles;
	private int currentSongIndex = 0;
	public ReproductorDeSonidos(String... files){
		musicFiles = new ArrayList();
		for(String file: files){
			musicFiles.add(file);
		}
	}
	
	private void playSound(String fileName){
		try{
			System.out.println(fileName);
			URL resource = ReproductorDeSonidos.class.getResource(fileName);
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(resource);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10);
			clip.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		playSound(musicFiles.get(currentSongIndex));
	}

}