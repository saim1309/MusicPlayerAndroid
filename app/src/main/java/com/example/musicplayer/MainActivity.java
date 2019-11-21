package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    Button btn_play,btn_pause,btn_stop,btn_fastforward,btn_rewind,btn_power;
    MediaPlayer mediaPlayer;
    int pausePosition;
    int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);
        btn_stop = findViewById(R.id.btn_stop);
        btn_fastforward =findViewById(R.id.btn_fastforward);
        btn_rewind = findViewById(R.id.btn_rewind);
        btn_power = findViewById(R.id.btn_power);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer == null)
                {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);
                    mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(pausePosition);
                    mediaPlayer.start();

                }

            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer!=null)
                {
                    mediaPlayer.pause();
                    pausePosition = mediaPlayer.getCurrentPosition();
                }

            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer!= null){
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }


            }
        });

        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                finish();
                System.exit(0);
            }
        });

        btn_rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mediaPlayer.isPlaying())
                {
                    currentPosition = mediaPlayer.getCurrentPosition() - 10000;
                    mediaPlayer.seekTo(currentPosition);
                    mediaPlayer.start();
                }
            }
        });

        btn_fastforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying())
                {
                    currentPosition = mediaPlayer.getCurrentPosition() + 10000;
                    mediaPlayer.seekTo(currentPosition);
                    mediaPlayer.start();
                }

            }
        });

    }
}
