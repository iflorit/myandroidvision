package es.florit.android.domain.base

import io.reactivex.rxjava3.core.Single

interface BaseUseCase<PARAMS, RESULT> {

    fun execute(with: PARAMS): Single<RESULT>
}