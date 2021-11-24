package audio.musicplayer;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Scanner sc = new Scanner(System.in);
		File file = new File("got.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		String s = "";
		
		System.out.println("Music player running........");
		
		while(!s.equalsIgnoreCase("q")) {
			System.out.println("p - play, q - quit, s - stop, r - reset");
			System.out.print("Enter choice : ");
			s = sc.next().toLowerCase();
			
			switch(s) {
			case ("p") : clip.start();
			break;
			case ("s") : clip.stop();
			break;
			case ("q") : clip.close();
			break;
			case ("r") : clip.setMicrosecondPosition(0);
			break;
			default :
				System.out.println("Invalid choice ");
			}
		}
		
		System.out.println("Music player stopped ");
		sc.close();
	}
}
