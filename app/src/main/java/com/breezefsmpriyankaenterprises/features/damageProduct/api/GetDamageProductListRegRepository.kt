package com.breezefsmpriyankaenterprises.features.damageProduct.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.breezefsmpriyankaenterprises.app.FileUtils
import com.breezefsmpriyankaenterprises.base.BaseResponse
import com.breezefsmpriyankaenterprises.features.NewQuotation.model.*
import com.breezefsmpriyankaenterprises.features.addshop.model.AddShopRequestData
import com.breezefsmpriyankaenterprises.features.addshop.model.AddShopResponse
import com.breezefsmpriyankaenterprises.features.damageProduct.model.DamageProductResponseModel
import com.breezefsmpriyankaenterprises.features.damageProduct.model.delBreakageReq
import com.breezefsmpriyankaenterprises.features.damageProduct.model.viewAllBreakageReq
import com.breezefsmpriyankaenterprises.features.login.model.userconfig.UserConfigResponseModel
import com.breezefsmpriyankaenterprises.features.myjobs.model.WIPImageSubmit
import com.breezefsmpriyankaenterprises.features.photoReg.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class GetDamageProductListRegRepository(val apiService : GetDamageProductListApi) {

    fun viewBreakage(req: viewAllBreakageReq): Observable<DamageProductResponseModel> {
        return apiService.viewBreakage(req)
    }

    fun delBreakage(req: delBreakageReq): Observable<BaseResponse>{
        return apiService.BreakageDel(req.user_id!!,req.breakage_number!!,req.session_token!!)
    }

}