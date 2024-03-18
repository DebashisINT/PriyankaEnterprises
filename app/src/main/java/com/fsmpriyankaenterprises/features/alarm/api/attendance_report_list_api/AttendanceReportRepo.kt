package com.fsmpriyankaenterprises.features.alarm.api.attendance_report_list_api

import com.fsmpriyankaenterprises.app.Pref
import com.fsmpriyankaenterprises.features.alarm.model.AttendanceReportDataModel
import io.reactivex.Observable

/**
 * Created by Saikat on 20-02-2019.
 */
class AttendanceReportRepo(val apiService: AttendanceReportApi) {
    fun getAttendanceReportList(date: String): Observable<AttendanceReportDataModel> {
        return apiService.attendanceReportResponse(Pref.session_token!!, Pref.user_id!!, date)
    }
}