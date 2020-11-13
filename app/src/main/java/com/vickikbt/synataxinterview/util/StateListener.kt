package com.vickikbt.synataxinterview.util

interface StateListener {

    fun onLoading()

    fun onSuccess(message:String)

    fun onFailure(message:String)

}