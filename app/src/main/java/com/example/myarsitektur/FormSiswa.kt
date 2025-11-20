package com.example.myarsitektur

import android.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formsiswa(
    pilihanJK: List<string>,
    onsubmitButtonClicked: (mutableList<string>)
)