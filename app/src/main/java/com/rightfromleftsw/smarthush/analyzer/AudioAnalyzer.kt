package com.rightfromleftsw.smarthush.analyzer


import com.rightfromleftsw.smarthush.analyzer.detector.Cry
import io.reactivex.Flowable

interface AudioAnalyzer {
  fun cries(): Flowable<Cry>
}