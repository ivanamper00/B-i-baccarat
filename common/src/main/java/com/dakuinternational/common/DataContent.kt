package com.dakuinternational.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataContent(
    var title: String,
    var description: String,
    var asset: String? = ""
) : Parcelable
