package com.fsmpriyankaenterprises.features.survey.api

import com.fsmpriyankaenterprises.features.photoReg.api.GetUserListPhotoRegApi
import com.fsmpriyankaenterprises.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}