package es.florit.android.domain.base

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<PARAMS, RESULT> {

    fun execute(with: PARAMS): Flow<RESULT>
}