package com.breezefsmpriyankaenterprises.features.activities.api

import com.breezefsmpriyankaenterprises.features.member.api.TeamApi
import com.breezefsmpriyankaenterprises.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}