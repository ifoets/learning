package com.udemy.basic.dp.structural.adapter.challenge;

public class AudioPlayer implements IMediaPlayer {

	// public String audioType
	@Override
	public void play(String audioType, String fileName) {

		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing Mp3. Name: " + fileName);
		} else {
			System.out.println("Invalid Media " + audioType + " format not supported");
		}

	}

}
