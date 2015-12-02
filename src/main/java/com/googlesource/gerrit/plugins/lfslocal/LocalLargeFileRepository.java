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

import java.io.IOException;

import org.eclipse.jgit.lfs.server.fs.FileLfsRepository;

import com.google.gerrit.extensions.annotations.PluginCanonicalWebUrl;
import com.google.gerrit.extensions.annotations.PluginData;
import com.google.inject.Inject;

public class LocalLargeFileRepository extends FileLfsRepository {

  @Inject
  LocalLargeFileRepository(@PluginCanonicalWebUrl String url,
      @PluginData java.nio.file.Path dataDir) throws IOException {
    super(url, dataDir);
  }
}
