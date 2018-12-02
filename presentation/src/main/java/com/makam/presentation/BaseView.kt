package com.makam.presentation

interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)

}