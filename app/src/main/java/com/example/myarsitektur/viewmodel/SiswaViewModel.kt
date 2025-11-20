package com.example.myarsitektur.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myarsitektur.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {

    private val _statusUI = MutableStateFlow(Siswa())
    val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

    fun setSiswa(ls: List<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls.getOrNull(0) ?: "",
                gender = ls.getOrNull(1) ?: "",
                alamat = ls.getOrNull(2) ?: ""
            )
        }
    }
}
