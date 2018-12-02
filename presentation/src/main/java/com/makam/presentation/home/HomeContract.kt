package com.makam.presentation.home

import com.makam.presentation.BasePresenter
import com.makam.presentation.BaseView
import com.makam.presentation.model.ImgurView

interface HomeContract {
    interface View: BaseView<Presenter>{
        fun showProgress()

        fun hideProgress()

        fun showError()

        fun success(imgurs: List<ImgurView>)
    }

    interface Presenter : BasePresenter{
        fun retrieveData()
    }
}