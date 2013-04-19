package com.example.app04;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.view.Menu;
import android.view.View;

public class AlarmActivity extends Activity {
	
	
	
	private MyAlarm alarm;
	private MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		alarm = new MyAlarm(this, alarmManager);
		player = MediaPlayer.create(this, R.raw.song);
		player.start();
	}
	public void setAside(View v){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 5);
		alarm.setTime( calendar.getTimeInMillis() );
		player.stop();
		finish();
	}

	public void Stop(View v){
		alarm.turnOff();
		player.stop();
		finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}

}
