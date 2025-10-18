package com.yustar.wellness

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yustar.common.ui.theme.Red50
import com.yustar.common.ui.theme.WellnessTheme

/**
 * Created by Yustar Pramudana on 18/10/25.
 */

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(70.dp),
                painter = painterResource(id = R.drawable.app_icon_foreground),
                contentDescription = "app_icon"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSecondary)) {
                        append("${stringResource(id = com.yustar.common.R.string.welcome_to)} ")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append("${stringResource(id = R.string.app_name)} ")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSecondary)) {
                        append("${stringResource(id = com.yustar.common.R.string.ui_kit)} ")
                    }
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_welcome),
                contentDescription = "ic_welcome"
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            GetStartedButton {  }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onTertiary,
                    text = stringResource(com.yustar.common.R.string.already_have_an_account)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    style = MaterialTheme.typography.displayLarge,
                    color = Red50,
                    text = stringResource(com.yustar.common.R.string.sign_in)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
fun NightModePreviewWelcomeScreen() {
    WellnessTheme {
        WelcomeScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Composable
fun LightModePreviewWelcomeScreen() {
    WellnessTheme {
        WelcomeScreen()
    }
}
