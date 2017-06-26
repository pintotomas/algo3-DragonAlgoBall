package utils.reproductorDeSonidos;

import java.util.ArrayList;

public class ReproductorDeSonidos implements Runnable {

	private volatile ArrayList<AudioFile> musicFiles;
	private volatile int currentSongIndex = 0;
	private volatile boolean running;

	private volatile boolean mute;
	public ReproductorDeSonidos(String... files){
		musicFiles = new ArrayList<AudioFile>();
		for(String file: files){
			musicFiles.add(new AudioFile(file));
		}
	}
	

	@Override
	public void run() {
		running = true;
		AudioFile song = musicFiles.get(currentSongIndex);
		
		
		while(isPlaying()){
			if (song.isPlaying() && this.isMuted()){
				song.stop();
			}
			if(!song.isPlaying() && !this.isMuted()){
				currentSongIndex++;
				if(currentSongIndex >= musicFiles.size()){
					currentSongIndex = 0;
				}
				song = musicFiles.get(currentSongIndex);
				
				song.play();
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


	public boolean isMuted() {
		// TODO Auto-generated method stub
		return mute;
	}


	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return running;
	}
	
	public void mute(){
		mute = true;
	}


	public void unMute() {
		mute = false;
		
	}

}