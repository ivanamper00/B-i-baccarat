package com.vietsol.sekond.presentation

import com.dakuinternational.common.DataContent

interface NavigationDelegate {
    fun toHomeDescription(data: DataContent)
    fun onVariationClick(data: DataContent)
}