package uz.gita.composemobilebanking.screen.intro


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.composemobilebanking.screen.splash.GitaIcon
import uz.gita.composemobilebanking.ui.theme.ComposeMobileBankingTheme


/*
 * Arzigul Nazarbaeva
 * 1/9/2023, Monday, 1:55 PM
*/


class IntroScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        ComposeMobileBankingTheme {
            IntroScreenContent()
        }
    }

}

@Composable
fun IntroScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val acceptPrivacy = remember { mutableStateOf(false) }

        Column {
            Text(
                text = "Sign In",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                GitaIcon(Color.Black)
            }

            Text(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                text = "Сайт рыбатекст поможет дизайнеру, верстальщику, вебмастеру сгенерировать несколько абзацев более менее осмысленного текста рыбы на русском языке, а начинающему оратору отточить навык публичных выступлений в домашних условиях. При создании генератора мы использовали небезизвестный универсальный код речей. Текст генерируется абзацами случайным образом от двух до десяти предложений в абзаце, что позволяет сделать текст более привлекательным и живым для визуально-слухового восприятия",
                color = Color.Black,
                fontSize = 20.sp
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = acceptPrivacy.value, onClick = { acceptPrivacy.value = !acceptPrivacy.value })
                Text(text = "Я согласен со всеми условиями.", color = Color(0xff3862F8))
            }

        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 20.dp)
                .fillMaxWidth()
                .height(48.dp)
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(10.dp),
            enabled = acceptPrivacy.value
        ) {
            Text(text = "Next")
        }
    }
}

@Preview
@Composable
fun IntroScreenPreview() {
    ComposeMobileBankingTheme {
        IntroScreenContent()
    }
}
