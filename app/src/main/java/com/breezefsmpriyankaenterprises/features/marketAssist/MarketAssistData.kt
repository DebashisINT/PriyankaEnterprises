package com.breezefsmpriyankaenterprises.features.marketAssist

data class ShopDtls(var shop_id:String="",var shop_name:String="",var address:String="",var owner_name:String="",var owner_contact_number:String="",var shopLat:String="",var shopLong:String="",
                    var shopType:String="",var beatName:String="")

data class SuggestiveProduct(var product_id:String="",var product_name:String="",var qty:String="",var rate:String="",var total_price:String="")

data class ProductOccur(var product_id:String="",var occur:Int=0,var totalQty:String="")

data class SuggestiveProductFinal(var product_id:String="",var product_name:String="",var suggestiveOrdRate:String="",var suggestiveOrdQty:String="")

data class PurchasedProductTotal(var product_id:String="",var product_name:String="",var totalValue:String="",var totalQty:String="")