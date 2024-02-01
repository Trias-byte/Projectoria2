package com.example.projectoria

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.components.ViewModelComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {

    @Provides
    fun provideAuthentication(): FirebaseAuth = Firebase.auth

}