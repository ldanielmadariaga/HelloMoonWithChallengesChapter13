package com.example.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {

	private Button playButton;
	private Button pauseButton;

	private Button stopButton;

	private AudioPlayer audioPlayer = new AudioPlayer();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		playButton = (Button) view.findViewById(R.id.hellomoon_playButton);
		playButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				audioPlayer.play(getActivity());
			}
		});

		pauseButton = (Button) view.findViewById(R.id.hellomoon_pauseButton);
		pauseButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				audioPlayer.pause();
			}
		});
		stopButton = (Button) view.findViewById(R.id.hellomoon_stopButton);
		stopButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				audioPlayer.stop();
			}
		});
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		audioPlayer.stop();
	}
}
