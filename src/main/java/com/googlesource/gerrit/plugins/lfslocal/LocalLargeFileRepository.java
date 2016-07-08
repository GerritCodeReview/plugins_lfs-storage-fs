// Copyright (C) 2015 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.lfslocal;

import com.google.common.base.Strings;
import com.google.gerrit.extensions.annotations.PluginCanonicalWebUrl;
import com.google.gerrit.extensions.annotations.PluginData;
import com.google.gerrit.extensions.annotations.PluginName;
import com.google.gerrit.server.config.PluginConfig;
import com.google.gerrit.server.config.PluginConfigFactory;
import com.google.inject.Inject;

import org.eclipse.jgit.lfs.server.fs.FileLfsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalLargeFileRepository extends FileLfsRepository {
  private static final Logger LOG = LoggerFactory.getLogger(LocalLargeFileRepository.class);

  @Inject
  LocalLargeFileRepository(PluginConfigFactory cfg,
      @PluginName String pluginName,
      @PluginCanonicalWebUrl String url,
      @PluginData Path defaultDataDir) throws IOException {
    super(url, getDataDir(cfg, pluginName, defaultDataDir));
  }

  private static Path getDataDir(PluginConfigFactory cfgFactory, String pluginName,
      Path defaultDataDir) {
    PluginConfig cfg = cfgFactory.getFromGerritConfig(pluginName);
    String dataDir = cfg.getString("dataDirectory", null);
    if (Strings.isNullOrEmpty(dataDir)) {
      return defaultDataDir;
    }

    try {
      Path dataPath = Paths.get(dataDir);
      return Files.createDirectories(dataPath);
    } catch (IOException e) {
      LOG.warn("Ensuring data directory '{}' for plugin '{}' failed."
          + " Falling back to default data directory '{}'.",
          dataDir, pluginName, defaultDataDir, e);
      return defaultDataDir;
    }
  }
}
