package com.makam.presentation.home

import com.makam.domain.SingleUseCase
import com.makam.domain.model.Imgur
import com.makam.presentation.mapper.ImgurViewMapper
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject
class HomePresenter @Inject constructor(val homeView: HomeContract.View, private val getHottestLinks: SingleUseCase<List<Imgur>, Void>, private val imgurViewMapper: ImgurViewMapper) : HomeContract.Presenter {

    init {
        homeView.setPresenter(this)
        retrieveData()
    }
    override fun retrieveData() {
        homeView.showProgress()
        getHottestLinks.execute(HottestLinksSubscriber())
    }

    override fun stop() {
        getHottestLinks.dispose()
    }

    override fun start() {
        retrieveData()
    }

    internal fun handleGetHottestLinksSuccess(listItems: List<Imgur>){
        homeView.success(listItems.sortedByDescending { it.ups }.map { imgurViewMapper.mapToView(it) })
    }

    inner class HottestLinksSubscriber : DisposableSingleObserver<List<Imgur>>(){

        override fun onSuccess(t: List<Imgur>) {
            homeView.hideProgress()
            handleGetHottestLinksSuccess(t)
        }

        override fun onError(e: Throwable) {
            homeView.hideProgress()
            homeView.showError()
        }


    }

}