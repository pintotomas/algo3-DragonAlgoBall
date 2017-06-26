package utils.reproductorDeSonidos;

import java.util.ArrayList;

public class ReproductorDeSonidos implements Runnable {

	private volatile ArrayList<AudioFile> musicFiles;
	private volatile int currentSongIndex = 0;
	private volatile boolean running;
	private volatile AudioFile currentSong;
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
		currentSong = musicFiles.get(currentSongIndex);
		
		
		while(this.isPlaying()){
			if (currentSong.isPlaying() && this.isMuted()){
				currentSong.stop();
			}
			if(!currentSong.isPlaying() && !this.isMuted()){
				currentSongIndex++;
				if(currentSongIndex >= musicFiles.size()){
					currentSongIndex = 0;
				}
				currentSong = musicFiles.get(currentSongIndex);
				
				currentSong.play();
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

	public void stop() {
		running = false;
		if (currentSong.isPlaying()){
			currentSong.stop();
		}
	}
	
	public static void playASound(String soundSource, boolean systemWait){
		AudioFile sonidoEspecial = new AudioFile(soundSource);
		sonidoEspecial.play();
		while(sonidoEspecial.isPlaying() && systemWait){
			//espero a que finalize el sonido..
		}
	}

}