package com.raya.curro.pruebaams.ui.view

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.view.View

object ViewAnimations {
    fun showFilterView(view: View) {
        view.animate()
            .setDuration(150)
            .setListener(object : AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    view.visibility = View.VISIBLE
                }

                override fun onAnimationEnd(animation: Animator) {
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }

            })
            .translationY(view.height.toFloat() + 12F).start()
    }

    fun hideFilterView(view: View) {
        view.animate()
            .setDuration(150)
            .setListener(object : AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    view.visibility = View.INVISIBLE
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })
            .translationY(-view.height.toFloat() + 12F).start()
    }
}