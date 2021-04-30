package es.florit.android.domain.base

interface BaseUseCase<PARAMS> {

    fun execute(with: PARAMS)
}