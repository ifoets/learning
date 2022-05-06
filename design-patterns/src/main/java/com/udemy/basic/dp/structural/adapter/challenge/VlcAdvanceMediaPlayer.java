package com.udemy.basic.dp.structural.adapter.challenge;

public class VlcAdvanceMediaPlayer implements IAdvanceMediaPlayer {
	private String fileName;

	@Override
	public void lisen() {
		System.out.println("Playing Vlc. Name: " + fileName);
	}

	@Override
	public void loadFile(String fileName) {
		this.fileName = fileName;
	}
}
