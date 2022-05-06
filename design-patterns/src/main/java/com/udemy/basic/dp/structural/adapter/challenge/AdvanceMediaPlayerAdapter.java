package com.udemy.basic.dp.structural.adapter.challenge;

public class AdvanceMediaPlayerAdapter implements IMediaPlayer {

	IAdvanceMediaPlayer amp;

	public AdvanceMediaPlayerAdapter(IAdvanceMediaPlayer amp) {
		this.amp = amp;
	}

	@Override
	public void play(String audioType, String fileName) {
		amp.loadFile(fileName);
		amp.lisen();
	}
}
