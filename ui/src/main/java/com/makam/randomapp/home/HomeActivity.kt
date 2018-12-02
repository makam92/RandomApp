package com.makam.randomapp.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.app.LoaderManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.makam.presentation.home.HomeContract
import com.makam.presentation.model.ImgurView
import com.makam.randomapp.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.View {
    override fun showError() {
         Snackbar.make(findViewById<CoordinatorLayout>(R.id.home_layout), R.string.error, Snackbar.LENGTH_SHORT).show()
    }

    override fun success(imgurs: List<ImgurView>) {
        recyclerView.apply {
            adapter = ImgurAdapter(imgurs)
        }
    }

    override fun showProgress() {
        imgur_loader.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        imgur_loader.visibility = View.GONE
    }

    @Inject
    lateinit var homePresenter: HomeContract.Presenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun setPresenter(presenter: HomeContract.Presenter) {
        homePresenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        AndroidInjection.inject(this)
        viewManager = LinearLayoutManager(this)
        recyclerView = imgur_recyclerView
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

    }
}
