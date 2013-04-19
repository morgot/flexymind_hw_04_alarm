package com.example.app04;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyAlarm {

	private Context context;
	private AlarmManager alarmManager;
	private PendingIntent pendingIntent;
	
	public MyAlarm(Context context, AlarmManager alarmManager) {
		
		this.context = context;
		this.alarmManager = alarmManager;
	}
	
	public void setTime(long time){
		
		Intent intent = new Intent(context, AlarmActivity.class);
		pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
		alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
	}
	public void turnOff(){
		alarmManager.cancel(pendingIntent);
		}
	
	
	
	
}
