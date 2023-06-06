package com.breezefsmpriyankaenterprises.features.leaveapplynew

import com.breezefsmpriyankaenterprises.features.addAttendence.model.Leave_list_Response


interface ClickonStatus {
    fun OnApprovedclick(obj: Leave_list_Response)
    fun OnRejectclick(obj: Leave_list_Response)
}