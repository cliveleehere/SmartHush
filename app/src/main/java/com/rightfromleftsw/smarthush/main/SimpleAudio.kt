package com.rightfromleftsw.smarthush.main

import android.media.*
import android.media.AudioAttributes.CONTENT_TYPE_SPEECH
import android.media.AudioAttributes.USAGE_MEDIA
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

class SimpleAudio : AudioListener {
  // Variables
  private var audioRecord: AudioRecord? = null
  private val SAMPLERATE = 8000
  private val CHANNELS = AudioFormat.CHANNEL_IN_STEREO
  private val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT
  private val bufferSize = AudioRecord.getMinBufferSize(SAMPLERATE, CHANNELS, AUDIO_FORMAT)

  override fun setupAudio() {
  }

  override fun startAudio(): Flowable<MainUiModel> {
    audioRecord = AudioRecord(MediaRecorder.AudioSource.MIC, SAMPLERATE, CHANNELS, AUDIO_FORMAT, bufferSize)
    audioRecord?.startRecording()

    val data = ByteArray(bufferSize)
    val minBufferSize = AudioTrack.getMinBufferSize(
        SAMPLERATE,
        CHANNELS,
        AUDIO_FORMAT)

    val audioAttributes = AudioAttributes.Builder()
        .setContentType(CONTENT_TYPE_SPEECH)
        .setUsage(USAGE_MEDIA)
        .build()

    val audioFormat = AudioFormat.Builder()
        .setSampleRate(SAMPLERATE)
        .setEncoding(AUDIO_FORMAT)
        .setChannelMask(CHANNELS)
        .build()

    return Flowable.create<ByteArray>({ emitter ->
      while(true) {
        audioRecord?.read(data, 0, bufferSize)

        emitter.onNext(data)
      }
    }, BackpressureStrategy.LATEST)
        .doOnComplete {
          audioRecord?.stop()
          audioRecord?.release()
        }
        .map {
          val audioTrack = AudioTrack.Builder()
              .setAudioAttributes(audioAttributes)
              .setBufferSizeInBytes(minBufferSize)
              .setAudioFormat(audioFormat)
              .build()
          audioTrack.play()
          audioTrack.write(data, 0, bufferSize)
          audioTrack.stop()
          audioTrack.release()

          MainUiModel(System.currentTimeMillis().toString())
        }
  }

}