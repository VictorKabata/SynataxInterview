package com.vickikbt.synataxinterview.data.pref

import android.content.Context
import com.vickikbt.synataxinterview.util.Constants.SHARED_PREF_KEY
import com.vickikbt.synataxinterview.util.Constants.SHARED_PREF_NAME


class TimePreference constructor(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, 0)
    private val editor = sharedPref.edit()

    fun saveSyncTime(syncTime: Long) {
        editor.putLong(SHARED_PREF_KEY, syncTime)
        editor.commit()
    }

    val getLastSyncTime = sharedPref.getLong(SHARED_PREF_KEY, 0)

}