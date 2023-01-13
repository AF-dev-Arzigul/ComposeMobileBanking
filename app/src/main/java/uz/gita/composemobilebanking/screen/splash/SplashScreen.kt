package uz.gita.composemobilebanking.screen.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.composemobilebanking.R
import uz.gita.composemobilebanking.ui.theme.ComposeMobileBankingTheme

@SuppressLint("CustomSplashScreen")
class SplashScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        SplashScreenContent()
    }

}

@Composable
fun SplashScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff102060))
    ) {
        Box(modifier = Modifier.align(Alignment.Center)) {
            GitaIcon(Color.White)
        }
    }
}

@Composable
fun GitaIcon(color: Color) {
    Box {
        Row {
            Image(
                painter = painterResource(id = R.drawable.splash_icon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(50.dp)
            )
            Text(
                text = "GITA BANK",
                color = color,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ComposeMobileBankingTheme {
        SplashScreenContent()
    }
}