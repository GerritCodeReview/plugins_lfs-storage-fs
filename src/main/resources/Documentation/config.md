Plugin @PLUGIN@ configuration
======================

The following options can be configured in `$GERRIT_SITE/etc/@PLUGIN@.config`

Section `storage`
-------------------------

```
  [storage]
    directory = [path to data directory]
```

Path to directory where large files should be stored.
If not configured, defaults to the plugin's data directory:
`$GERRIT_SITE/data/@PLUGIN@`