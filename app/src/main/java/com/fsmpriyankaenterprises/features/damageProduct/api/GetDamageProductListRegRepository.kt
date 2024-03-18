package com.fsmpriyankaenterprises.features.damageProduct.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.fsmpriyankaenterprises.app.FileUtils
import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.NewQuotation.model.*
import com.fsmpriyankaenterprises.features.addshop.model.AddShopRequestData
import com.fsmpriyankaenterprises.features.addshop.model.AddShopResponse
import com.fsmpriyankaenterprises.features.damageProduct.model.DamageProductResponseModel
import com.fsmpriyankaenterprises.features.damageProduct.model.delBreakageReq
import com.fsmpriyankaenterprises.features.damageProduct.model.viewAllBreakageReq
import com.fsmpriyankaenterprises.features.login.model.userconfig.UserConfigResponseModel
import com.fsmpriyankaenterprises.features.myjobs.model.WIPImageSubmit
import com.fsmpriyankaenterprises.features.photoReg.model.*
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