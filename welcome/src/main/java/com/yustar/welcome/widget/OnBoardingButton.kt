package com.yustar.welcome.widget

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yustar.common.R
import com.yustar.common.ui.theme.WellnessTheme

/**
 * Created by Yustar Pramudana on 19/10/25.
 */

@Composable
fun OnBoardingButton(onClick: () -> Unit) {
    Button(
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSecondary),
        contentPadding = PaddingValues(top = 16.dp, start = 16.dp, bottom = 16.dp, end = 16.dp),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = R.drawable.ic_getstarted),
            tint = MaterialTheme.colorScheme.surface,
            contentDescription = "ic_getstarted"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4)
@Composable
fun NightModePreviewOnBoardingButton() {
    WellnessTheme {
        OnBoardingButton(onClick = {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Composable
fun LightModePreviewOnBoardingButton() {
    WellnessTheme {
        OnBoardingButton {  }
    }
}