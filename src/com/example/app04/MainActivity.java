package com.example.app04;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	private MyAlarm alarm;
	private ToggleButton tBtn;
	private TimePicker timePicker;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		timePicker = (TimePicker)findViewById(R.id.timePicker1);
		tBtn = (ToggleButton)findViewById(R.id.toggleButton1);
		timePicker.setIs24HourView(true);
		AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
		alarm = new MyAlarm(MainActivity.this, alarmManager);
		
	}
	
	
	
	public long getTimePickerTime(){
		
		Calendar calendar = Calendar.getInstance();
		
		int hour = timePicker.getCurrentHour();
		int minute = timePicker.getCurrentMinute();
		
		long time = calendar.getTimeInMillis() ;
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		time -= calendar.getTimeInMillis();
		if (time > 0){
			calendar.add(Calendar.DATE, 1);
		}
		return calendar.getTimeInMillis();
	}

	public void toggleBtn(View v){
		if(tBtn.isChecked()){
			long time = getTimePickerTime();
			alarm.setTime(time);
		} else {
			
			alarm.turnOff();
		}
			
	}

	public void exit(){
		finish();
	}
}
