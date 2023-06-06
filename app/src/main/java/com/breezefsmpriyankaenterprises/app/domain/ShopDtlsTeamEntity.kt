package com.breezefsmpriyankaenterprises.app.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.breezefsmpriyankaenterprises.app.AppConstant

@Entity(tableName = AppConstant.SHOP_DTLS_TEAM)
class ShopDtlsTeamEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "shop_id")
    var shop_id: String? = null

    @ColumnInfo(name = "shop_name")
    var shop_name: String? = null


}