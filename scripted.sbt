ScriptedPlugin.scriptedSettings

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx2G", "-XX:MaxPermSize=512M", "-Dplugin.version=" + version.value)
}

scriptedBufferLog := false
