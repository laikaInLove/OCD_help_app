package com.example.tococd.presentation.screens.psychologist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tococd.di.IoDispatcher
import com.example.tococd.domain.common.fold
import com.example.tococd.domain.repository.DataStoreOperations
import com.example.tococd.domain.repository.PsychologistRepository
import com.example.tococd.presentation.screens.psychologist.state.Effect
import com.example.tococd.presentation.screens.psychologist.state.PsychologistUiState
import com.example.tococd.utils.extension.setEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PsychologistViewModel @Inject constructor(
    private val psychologistRepository: PsychologistRepository,
    private val dataStoreOperations: DataStoreOperations,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _psychologistUiState: MutableStateFlow<PsychologistUiState> = MutableStateFlow(
        PsychologistUiState()
    )
    val psychologistUiState: StateFlow<PsychologistUiState>
        get() = _psychologistUiState.asStateFlow()

    private val _effect: Channel<Effect> = Channel(Channel.UNLIMITED)
    val effect: Flow<Effect> = _effect.receiveAsFlow()

    val psychologistDisplayedFirstTime = dataStoreOperations.getPsychologist()

    fun getPsychologists() {
        _effect.setEffect(Effect.IsLoading(true))
        viewModelScope.launch(dispatcher) {
            psychologistRepository.getPsychologists().fold(
                onSuccess = {
                    _psychologistUiState.update { state -> state.copy(data = it, hasError = false) }
                    _effect.setEffect(Effect.IsLoading(false))
                },
                onError = { code, message ->
                    _psychologistUiState.update { state ->
                        state.copy(
                            data = null,
                            hasError = true
                        )
                    }
                    _effect.setEffect(Effect.IsLoading(false))
                },
                onException = {
                    _psychologistUiState.update { state ->
                        state.copy(
                            data = null,
                            hasError = true
                        )
                    }
                    _effect.setEffect(Effect.IsLoading(false))
                }
            )
        }
    }

    fun saveDisplayedFirstTime() {
        viewModelScope.launch(dispatcher) {
            dataStoreOperations.savePsychologist(true)
        }
    }
}