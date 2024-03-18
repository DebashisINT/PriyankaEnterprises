package com.fsmpriyankaenterprises.features.meetinglist.api

import com.fsmpriyankaenterprises.app.Pref
import com.fsmpriyankaenterprises.features.meetinglist.model.MeetingListResponseModel
import io.reactivex.Observable

/**
 * Created by Saikat on 21-01-2020.
 */
class MeetingRepo(val apiService: MeetingApi) {
    fun meetingList(): Observable<MeetingListResponseModel> {
        return apiService.getMeetingList(Pref.session_token!!, Pref.user_id!!)
    }
}