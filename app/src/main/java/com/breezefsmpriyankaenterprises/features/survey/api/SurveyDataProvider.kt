package com.breezefsmpriyankaenterprises.features.survey.api

import com.breezefsmpriyankaenterprises.features.photoReg.api.GetUserListPhotoRegApi
import com.breezefsmpriyankaenterprises.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}