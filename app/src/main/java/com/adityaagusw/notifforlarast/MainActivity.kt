package com.adityaagusw.notifforlarast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adityaagusw.notifforlarast.databinding.ActivityMainBinding
import com.adityaagusw.notifforlarast.notification.ReminderBroadcast
import com.adityaagusw.notifforlarast.preferences.PreferencesNotif

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var reminderBroadcast: ReminderBroadcast
    lateinit var preferenceNotif: PreferencesNotif

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reminderBroadcast = ReminderBroadcast()
        preferenceNotif = PreferencesNotif(this)

        onNotifBroadcast()
    }

    private fun onNotifBroadcast() {
        preferenceNotif.setTimeDaily(timeDaily)
        preferenceNotif.setDailyMessage(messageDaily)
        reminderBroadcast.setAlarm(this@MainActivity, "reminderDaily", timeDaily, messageDaily)
    }

    private fun offNotifBroadcast() {
        reminderBroadcast.cancelNotif(this@MainActivity)
    }

    companion object {
        private var timeDaily = "12:36"
        private var messageDaily = "Daily Reminder"
    }
}