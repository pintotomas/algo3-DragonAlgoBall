package reproductorDeSonidos;

import java.util.ArrayList;

public class ReproductorDeSonidos implements Runnable {

	private volatile ArrayList<AudioFile> musicFiles;
	private volatile int currentSongIndex = 0;
	private volatile boolean running;
	private volatile AudioFile currentSong;
	
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
		currentSong = song;
		song.play();
		while(running){
			if(!song.isPlaying()){
				currentSongIndex++;
				if(currentSongIndex >= musicFiles.size()){
					currentSongIndex = 0;
				}
				song = musicFiles.get(currentSongIndex);
				currentSong = song;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			song.play();
		}
	}


	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return running;
	}


	public void changeStatus() {
		running = !running;
		if (!running){
			currentSong.stop();
		}
		else{
			run();
		}
		
	}
}