package com.yustar.wellness.onboarding.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import com.yustar.wellness.onboarding.event.OnBoardingEvent

/**
 * Created by Yustar Pramudana on 19/10/25.
 */

class OnBoardingViewModel: ViewModel() {
    private val _page = mutableIntStateOf(0)
    internal val page: State<Int> = _page

    internal fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.OnPageValueChanged -> _page.value = event.value
        }
    }
}