package com.fsmpriyankaenterprises.features.task.api

import com.fsmpriyankaenterprises.features.timesheet.api.TimeSheetApi
import com.fsmpriyankaenterprises.features.timesheet.api.TimeSheetRepo

/**
 * Created by Saikat on 12-Aug-20.
 */
object TaskRepoProvider {
    fun taskRepoProvider(): TaskRepo {
        return TaskRepo(TaskApi.create())
    }
}