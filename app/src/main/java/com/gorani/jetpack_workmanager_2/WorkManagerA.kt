package com.gorani.jetpack_workmanager_2

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerA(private val context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {

        for (i in 0..3) {
            sleep(1000)
            Log.d("WorkManager!!_A", i.toString())
        }

        return Result.success()

    }

}