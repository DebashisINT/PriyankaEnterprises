package com.fsmpriyankaenterprises.features.activities.api

import com.fsmpriyankaenterprises.features.member.api.TeamApi
import com.fsmpriyankaenterprises.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}