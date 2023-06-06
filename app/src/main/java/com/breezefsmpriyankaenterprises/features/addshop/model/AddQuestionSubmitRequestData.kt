package com.breezefsmpriyankaenterprises.features.addshop.model


import com.breezefsmpriyankaenterprises.app.domain.QuestionSubmitEntity


class AddQuestionSubmitRequestData {
    var session_token: String? = null
    var user_id: String? = null
    var shop_id:String? = null
    var Question_list: ArrayList<QuestionSubmit>?= null
}