package com.gorani.jetpack_workmanager_2.coroutine

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * WorkManager + Coroutine
 *
 * +a) Dispatchers 사용하기.
 * - CoroutineWorker 를 보면 기본적으로 Dispatchers_Default 를 사용하는 것을 알 수 있다.
 * Default 이외에 것(IO, Main 등) 을 사용하려면 doWork() {..} 안에 withContext() 를 사용하여 ()안에 Dispatchers 종류를 삽입한다.
 * => withContext(Dispatchers.IO)
 * 그리고 이 안에 실행시킬 함수들을 배치시킨다.
 * => withContext(Dispatchers.IO) {
 *      실행시킬 함수A
 *      실행시킬 함수B
 *      ...
 * }
 */
class WorkManager2(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {

        // Dispatchers.IO 사용하여 WorkManager 작업 실행하기.
        withContext(Dispatchers.IO) {
            test1()
            test2()
        }

        return Result.success()
    }

    private suspend fun test1() {
        for (i in 1..3) {
            delay(1000)
            Log.d("WorkManager2_test1", "$i")
        }
    }

    private suspend fun test2() {
        for (i in 1..3) {
            delay(1000)
            Log.d("WorkManager2_test2", "$i")
        }
    }
}