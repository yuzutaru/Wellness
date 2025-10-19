package com.yustar.wellness.onboarding.event

/**
 * Created by Yustar Pramudana on 19/10/25.
 */

sealed class OnBoardingEvent {
    data class OnPageValueChanged(val value: Int): OnBoardingEvent()
}