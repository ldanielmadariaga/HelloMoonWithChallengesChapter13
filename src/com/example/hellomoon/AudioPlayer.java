package com.example.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class AudioPlayer {

	private MediaPlayer mediaPlayer;

	public void stop() {
		if (mediaPlayer != null) {
			mediaPlayer.release();
			mediaPlayer = null;

		}
	}

	public void pause() {
		if (mediaPlayer != null) {

			if (mediaPlayer.isPlaying()) {
				mediaPlayer.pause();
			} else {
				mediaPlayer.start();
			}
		}
	}

	public void play(Context context) {
		stop();
		mediaPlayer = MediaPlayer.create(context, R.raw.one_small_step);
		mediaPlayer.setOnCompletionListener(onCompletionListener());
		mediaPlayer.start();
	}

	private OnCompletionListener onCompletionListener() {
		MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				stop();

			}
		};
		return completionListener;
	}

}
