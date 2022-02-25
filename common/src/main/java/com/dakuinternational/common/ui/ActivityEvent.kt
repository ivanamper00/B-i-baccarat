package com.dakuinternational.common.ui

import com.dakuinternational.common.event.UiEvent

sealed class ActivityEvent: UiEvent() {
    object ProcedurePage: UiEvent()
}