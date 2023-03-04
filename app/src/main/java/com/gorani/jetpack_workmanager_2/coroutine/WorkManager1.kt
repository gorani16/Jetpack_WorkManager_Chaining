package com.gorani.jetpack_workmanager_2.coroutine

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * 기존의 일반적인 WorkManager 사용 방법
 */
class WorkManager1(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {

        // 작업

        return Result.success()

    }
}