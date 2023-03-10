package uz.gita.composemobilebanking.navigation

import cafe.adriel.voyager.core.screen.Screen

interface NavigationHandler {
    suspend fun back()
    suspend fun navigationTo(screen: Screen)
}

