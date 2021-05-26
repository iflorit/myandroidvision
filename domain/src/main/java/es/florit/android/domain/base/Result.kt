package es.florit.android.domain.base

sealed class Result<out A, out E>

data class Success<out A>(val value: A) : Result<A, Any>()
data class Failure<out E>(val error: E) : Result<Any, E>()