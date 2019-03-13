package com.gdn.wisatakuy.ui.base

abstract class BaseContract {

    interface View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
    }

    interface Presenter {
        fun attach()
        fun dettach()
    }
}