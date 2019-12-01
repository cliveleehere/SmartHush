package com.rightfromleftsw.smarthush.analyzer.detector

import android.graphics.Rect
import android.media.AudioTrack
import io.reactivex.Single

/**
 * Given a single image, detect any faces in it
 */
interface CryDetector {
  fun detectCry(audioTrack: AudioTrack): Single<Cry>
}

data class Cry(val emotion: Emotion)

enum class Emotion {
  HAPPY, NEUTRAL
}