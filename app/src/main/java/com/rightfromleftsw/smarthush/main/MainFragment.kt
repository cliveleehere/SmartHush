package com.rightfromleftsw.smarthush.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rightfromleftsw.smarthush.analyzer.detector.Emotion
import com.rightfromleftsw.smarthush.permissions.PermissionDelegate
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainFragment: Fragment() {

  @Inject
  lateinit var cameraPermissionsDelegate: PermissionDelegate

  @Inject
  lateinit var audio: AudioInterface

  private val compositeDisposable: CompositeDisposable = CompositeDisposable()

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    val view = inflater.inflate(audio.layoutId, container, false)
    audio.setupAudio(view)

    if (cameraPermissionsDelegate.isAllowedElseRequest()) {
      startCamera()
    }

    return view
  }

  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (cameraPermissionsDelegate.onRequestPermissionResult(requestCode)) {
      startCamera()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    compositeDisposable.clear()
  }

  private fun startCamera() {
    compositeDisposable.add(audio.startAudio()
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ models ->
          models.firstOrNull {
            it.emotion == Emotion.HAPPY
          }?.let {
            Toast.makeText(requireContext(), "Smile found!", Toast.LENGTH_SHORT).show()
            Timber.w("Smile found!")
          }
        }) {
          Timber.w("startAudio didn't return anything useful")
        })
  }
}