package com.gorani.jetpack_workmanager_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

/**
 * WorkManager Chaining
 *
 * ex.
 * A -> 순서 상관없이 실행되도 괜찮은 작업.
 * B -> 순서 상관없이 실행되도 괜찮은 작업.
 * C -> 반드시 A와 B 의 작업이 모두 실행이 완료된 뒤에 실행 되어야하는 작업.
 * => A 와 B 작업으로부터 데이터를 다 받아온 뒤에 C 작업에서 데이터를 가공해야할 때.
 *
 * https://developer.android.com/topic/libraries/architecture/workmanager/how-to/chain-work?hl=ko
 *
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().build()
        val workManagerC = OneTimeWorkRequestBuilder<WorkManagerC>().build()

        // 일반적인 WorkManager 실행 (순서 상관없이 실행)
        WorkManager.getInstance(this).enqueue(workManagerA)
        WorkManager.getInstance(this).enqueue(workManagerB)
        WorkManager.getInstance(this).enqueue(workManagerC)

    }
}