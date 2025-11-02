package com.yustar.welcome.widget

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yustar.common.ui.theme.WellnessTheme
import com.yustar.welcome.R

/**
 * Created by Yustar Pramudana on 19/10/25.
 */

@Composable
fun OnBoardingContent(img: Int, title: String, description: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSecondary,
                text = title
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onTertiary,
                text = description
            )

            Spacer(modifier = Modifier.height(32.dp))

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(img),
                contentDescription = "ic_personalize"
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
fun NightModeOnBoardingContent() {
    WellnessTheme {
        OnBoardingContent(
            img = R.drawable.ic_personalize,
            title = "Personalize Your Health with Smart AI.",
            description = "Achieve your wellness goals with our AI-powered platform to your unique needs."
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Composable
fun LightModeOnBoardingContent() {
    WellnessTheme {
        OnBoardingContent(
            img = R.drawable.ic_personalize,
            title = "Personalize Your Health with Smart AI.",
            description = "Achieve your wellness goals with our AI-powered platform to your unique needs."
        )
    }
}