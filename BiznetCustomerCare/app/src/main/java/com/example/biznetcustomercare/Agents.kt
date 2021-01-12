package com.example.biznetcustomercare

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Agent (
    var photo: Int,
    var nama: String?,
    var email: String?,
    var no_tlp:String?
):Parcelable
