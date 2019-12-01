package com.rightfromleftsw.smarthush.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rightfromleftsw.smarthush.R
import com.rightfromleftsw.smarthush.permissions.PermissionDelegate
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainFragment: Fragment() {

  @Inject
  lateinit var audioPermissionsDelegate: PermissionDelegate

  @Inject
  lateinit var audioListener: AudioListener

  private val compositeDisposable: CompositeDisposable = CompositeDisposable()

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    val view = inflater.inflate(R.layout.main_fragment, container, false)
    audioListener.setupAudio()

    if (audioPermissionsDelegate.isAllowedElseRequest()) {
      startAudio()
    }

    return view
  }

  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (audioPermissionsDelegate.onRequestPermissionResult(requestCode)) {
      startAudio()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    compositeDisposable.clear()
  }

  private fun startAudio() {
    compositeDisposable.add(audioListener.startAudio()
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ model ->
          Timber.i(model.emotion.toString())
        }) {
          Timber.w("startAudio didn't return anything useful")
        })
  }
}