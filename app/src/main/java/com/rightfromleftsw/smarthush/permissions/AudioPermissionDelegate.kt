package com.rightfromleftsw.smarthush.permissions

import android.Manifest
import android.app.Activity

class AudioPermissionDelegate(activity: Activity)
  : PermissionDelegate(activity) {
  override val requestCodePermissions = 10
  override val requiredPermissions = arrayOf(Manifest.permission.RECORD_AUDIO)
}