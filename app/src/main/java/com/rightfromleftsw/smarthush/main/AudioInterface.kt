package com.rightfromleftsw.smarthush.main

import android.view.View
import io.reactivex.Flowable

interface AudioInterface {

  val layoutId: Int

  fun setupAudio(containerView: View)

  fun startAudio(): Flowable<List<MainUiModel>>
}