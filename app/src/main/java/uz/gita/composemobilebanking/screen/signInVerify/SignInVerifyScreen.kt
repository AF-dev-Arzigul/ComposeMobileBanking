package uz.gita.composemobilebanking.screen.signInVerify

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.composemobilebanking.ui.theme.ComposeMobileBankingTheme

/*
 * Arzigul Nazarbaeva
 * 1/11/2023, Wednesday, 11:58 AM
*/


class SignInVerifyScreen/*(private val phoneNumber:String)*/ : AndroidScreen() {

    @Composable
    override fun Content() {
        ComposeMobileBankingTheme {
            SignInVerifyScreenContent(/*phoneNumber*/)
        }
    }

}

@Composable
fun SignInVerifyScreenContent(/*phoneNumber: String*/) {
    var password by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            AppBar(hasBackIcon = true)
            Text(
                text = "Код отправлен на номер\n$/*phoneNumber*/",
                color = Color(0xff808080),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                textAlign = TextAlign.Center
            )
            password = groupVerifySmsCodeItem()
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 20.dp)
                .fillMaxWidth()
                .height(48.dp)
                .align(Alignment.BottomEnd),
            shape = RoundedCornerShape(10.dp),
            enabled = password.length == 5
        ) {
            Text(text = "Verify")
        }
    }
}

@Composable
fun groupVerifySmsCodeItem(): String {
    var password by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 50.dp)
        ) {
            password = verifySmsCodeItem()
            password = verifySmsCodeItem()
            password = verifySmsCodeItem()
            password = verifySmsCodeItem()
            password = verifySmsCodeItem()
            password = verifySmsCodeItem()
        }
    }
    Log.d("qqqqq", password)
    return password
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun verifySmsCodeItem(): String {
    var password by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Surface(modifier = Modifier.padding(5.dp)) {
        OutlinedTextField(
            modifier = Modifier
                .width(42.dp)
                .height(50.dp),
            value = password,
            onValueChange = {
                if (password.length < 1) {
                    password = it
                    focusManager.moveFocus(FocusDirection.Next)
                } else {
                    password = it
                    focusManager.moveFocus(FocusDirection.Left)
                }
                Log.d("qqqqq", "item: $it")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                onPrevious = {
                    focusManager.moveFocus(FocusDirection.Previous)
                }
            ),
            singleLine = true,
            maxLines = 1
        )
    }
    return password
}


@Composable
fun AppBar(hasBackIcon: Boolean) {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
    ) {
        if (hasBackIcon) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }
        Text(
            text = "Confirmation",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
    }
}

@Preview
@Composable
fun SignInVerifyScreenPreview() {
    ComposeMobileBankingTheme {
        SignInVerifyScreenContent()
    }
}