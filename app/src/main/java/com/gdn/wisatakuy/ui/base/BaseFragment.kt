package com.gdn.wisatakuy.ui.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdn.wisatakuy.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

abstract class BaseFragment : Fragment(), BaseContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        val presenter: BaseContract.Presenter? = getPresenter()
        presenter?.attach()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val presenter: BaseContract.Presenter? = getPresenter()
        presenter?.dettach()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    protected fun getPresenter(): BaseContract.Presenter? {
        return null
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    protected fun showSnackbar(message: String, duration: Int): Snackbar {
        return Snackbar.make(activity!!.findViewById(R.id.container), message, duration)
    }

}