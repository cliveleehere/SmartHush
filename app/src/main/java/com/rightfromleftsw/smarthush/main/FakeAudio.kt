package com.rightfromleftsw.smarthush.main

import android.view.View
import com.rightfromleftsw.smarthush.R
import io.reactivex.Flowable

class FakeAudio : AudioInterface {

  override val layoutId: Int = R.layout.camerax_view_finder

  override fun setupAudio(containerView: View) {

  }

  override fun startAudio(): Flowable<List<MainUiModel>> {

    return Flowable.just(emptyList())
  }

}