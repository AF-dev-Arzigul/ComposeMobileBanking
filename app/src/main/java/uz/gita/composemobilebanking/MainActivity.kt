package uz.gita.composemobilebanking

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import uz.gita.composemobilebanking.navigation.AppNavigator
import uz.gita.composemobilebanking.screen.splash.SplashScreen
import uz.gita.composemobilebanking.ui.theme.ComposeMobileBankingTheme
import javax.inject.Inject

/*
 * Arzigul Nazarbaeva
 * 1/10/2023, Tuesday, 5:18 PM
*/


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMobileBankingTheme {
                Navigator(SplashScreen()) { navigator ->
                    LaunchedEffect(key1 = navigator) {
                        appNavigator.navigationFlow
                            .onEach { it(navigator) }
                            .collect()
                    }
                    CurrentScreen()
                }
            }
        }
    }
}