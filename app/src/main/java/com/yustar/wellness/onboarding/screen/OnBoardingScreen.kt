package com.yustar.wellness.onboarding.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yustar.common.R
import com.yustar.common.ui.theme.WellnessTheme
import com.yustar.wellness.onboarding.event.OnBoardingEvent
import com.yustar.wellness.onboarding.widget.OnBoardingButton
import com.yustar.wellness.onboarding.viewmodel.OnBoardingViewModel
import com.yustar.wellness.onboarding.widget.OnBoardingContent

/**
 * Created by Yustar Pramudana on 19/10/25.
 */

@Composable
fun OnBoardingScreen(viewModel: OnBoardingViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(0.9f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (i in 0 .. 4) {
                        Card(
                            modifier = Modifier
                                .width(60.dp)
                                .height(3.5.dp),
                            shape = RoundedCornerShape(2.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (i == viewModel.page.value)
                                    MaterialTheme.colorScheme.secondary
                                else
                                    MaterialTheme.colorScheme.onSecondary
                            )
                        ) {  }
                    }
                }

                Spacer(modifier = Modifier.width(4.dp))

                TextButton(
                    modifier = Modifier.weight(0.1f),
                    contentPadding = PaddingValues(2.dp),
                    onClick = {
                        if (viewModel.page.value < 5)
                            viewModel.onEvent(OnBoardingEvent.OnPageValueChanged(viewModel.page.value + 1))
                    }
                ) {
                    Text(
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSecondary,
                        text = stringResource(R.string.skip),
                    )
                }
            }
        }

        when (viewModel.page.value) {
            0 -> OnBoardingContent(
                img = com.yustar.wellness.R.drawable.ic_personalize,
                title = stringResource(R.string.personalize_your_health),
                description = stringResource(R.string.achieve_your_wellness_goals)
            )
            1 -> OnBoardingContent(
                img = com.yustar.wellness.R.drawable.ic_your_intelligent,
                title = stringResource(R.string.your_intelligent_fitness_companion),
                description = stringResource(R.string.track_your_calories)
            )
            2 -> OnBoardingContent(
                img = com.yustar.wellness.R.drawable.ic_emphatic,
                title = stringResource(R.string.empathic_ai_wellness_chatbot),
                description = stringResource(R.string.experience_compassionate_personalized_care)
            )
            3 -> OnBoardingContent(
                img = com.yustar.wellness.R.drawable.ic_intuitive,
                title = stringResource(R.string.intuitive_nutrition_med_tracker),
                description = stringResource(R.string.easily_track_your_medication_nutrition_with_the_power_of_ai)
            )
            4 -> OnBoardingContent(
                img = com.yustar.wellness.R.drawable.ic_helpfull,
                title = stringResource(R.string.helpfulness_community),
                description = stringResource(R.string.join_a_community_of_5000_users_dedicating_to_healthy_life_with_ai_ml)
            )
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(end = 32.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            OnBoardingButton { }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
fun NightModePreviewOnBoardingScreen() {
    WellnessTheme {
        OnBoardingScreen(viewModel = viewModel())
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Composable
fun LightModePreviewOnBoardingScreen() {
    WellnessTheme {
        OnBoardingScreen(viewModel = viewModel())
    }
}