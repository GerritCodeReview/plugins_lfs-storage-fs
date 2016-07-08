Plugin @PLUGIN@ configuration
======================

The following options can be configured in `etc/gerrit.config`

Section `plugin.@PLUGIN@`
-------------------------

```
  [plugin "@PLUGIN@"]
    dataDirectory = [path to data directory]
```

Path to directory where large files should be stored. 
If nothing is configured it falls back to the plugin's data directory:
`$GERRIT_SITE/data/@PLUGIN@`