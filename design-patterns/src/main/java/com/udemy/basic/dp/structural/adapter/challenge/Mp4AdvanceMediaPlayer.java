package com.udemy.basic.dp.structural.adapter.challenge;

public class Mp4AdvanceMediaPlayer implements IAdvanceMediaPlayer {
	private String fileName;

	@Override
	public void lisen() {
		System.out.println("Playing Mp4. Name: " + fileName);
	}

	@Override
	public void loadFile(String fileName) {
		this.fileName = fileName;
	}
}