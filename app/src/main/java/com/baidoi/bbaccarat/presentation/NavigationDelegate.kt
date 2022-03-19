package com.baidoi.bbaccarat.presentation

import com.dakuinternational.common.DataContent

interface NavigationDelegate {
    fun toHomeDescription(data: DataContent)
    fun onVariationClick(data: DataContent)
}