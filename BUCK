gerrit_plugin(
  name = 'lfs-storage-fs',
  srcs = glob(['src/main/java/**/*.java']),
  resources = glob(['src/main/resources/**/*']),
  manifest_entries = [
    'Gerrit-PluginName: lfs-storage-fs',
    'Gerrit-Module: com.googlesource.gerrit.plugins.lfslocal.Module',
    'Gerrit-HttpModule: com.googlesource.gerrit.plugins.lfslocal.HttpModule',
  ],
  provided_deps = [
    '@jgit//org.eclipse.jgit.lfs:jgit-lfs',
    '@jgit//org.eclipse.jgit.lfs.server:jgit-lfs-server',
  ],
)
