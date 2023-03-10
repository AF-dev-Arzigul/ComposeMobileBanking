package uz.gita.composemobilebanking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.composemobilebanking.navigation.AppNavigationManager
import uz.gita.composemobilebanking.navigation.AppNavigator
import uz.gita.composemobilebanking.navigation.NavigationHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindAppNavigator(impl: AppNavigationManager): AppNavigator

    @Binds
    fun bindNavigationHandler(impl: AppNavigationManager): NavigationHandler
}