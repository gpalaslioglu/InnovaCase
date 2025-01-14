package com.gizempalaslioglu.innovacase.core

interface Mapper<in Input, out Output> {

    fun map(input: Input): Output
}
