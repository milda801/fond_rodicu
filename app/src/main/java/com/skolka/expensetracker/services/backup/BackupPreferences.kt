package com.skolka.expensetracker.services.backup

import android.content.Context
import android.net.Uri

object BackupPreferences {
    private const val FILE = "backup_preferences"
    private const val URI = "automatic_backup_uri"
    private const val LAST_SUCCESS = "last_backup_success"
    private const val LAST_ERROR = "last_backup_error"

    fun saveUri(context: Context, uri: Uri) {
        context.getSharedPreferences(FILE, Context.MODE_PRIVATE).edit().putString(URI, uri.toString()).apply()
    }

    fun getUri(context: Context): Uri? = context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
        .getString(URI, null)?.let(Uri::parse)

    fun saveSuccess(context: Context, timestamp: String) {
        context.getSharedPreferences(FILE, Context.MODE_PRIVATE).edit()
            .putString(LAST_SUCCESS, timestamp).remove(LAST_ERROR).apply()
    }

    fun saveError(context: Context, message: String) {
        context.getSharedPreferences(FILE, Context.MODE_PRIVATE).edit()
            .putString(LAST_ERROR, message).apply()
    }

    fun lastSuccess(context: Context): String? = context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
        .getString(LAST_SUCCESS, null)

    fun lastError(context: Context): String? = context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
        .getString(LAST_ERROR, null)

    fun clear(context: Context) {
        context.getSharedPreferences(FILE, Context.MODE_PRIVATE).edit().clear().apply()
    }
}
