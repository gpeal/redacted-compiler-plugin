Changelog
=========

1.0.0
-----

_2021-12-24_

Stable release!

While Kotlin IR is not a stable API, the public API of redacted-compiler-plugin is. This project will use semver only 
for its own API but intermediate versions may only work with specific versions of Kotlin (documented in the changelog).

**Changes since 0.10.0**
- Remove remaining obsolete descriptor API usages.
- Update to Kotlin `1.6.10`.

0.10.0
------

_2021-12-20_

This release introduces formal support for Kotlin multiplatform!

There are two parts to this:
- The compiler plugin itself supports all compilation types, not just JVM and Android.
- The first-party annotations artifact is now multiplatform.

The legacy backend support is now removed, IR is required going forward.

0.10.0-RC1
----------

_2021-11-21_

This is a release candidate with support for Kotlin multiplatform. Please test this out and report any issues.

There are two parts to this:
- The compiler plugin itself supports all compilation types, not just JVM and Android.
- The first-party annotations artifact is now multiplatform.

The legacy backend support is now removed, IR is required going forward.

0.9.0
------------

_2021-11-16_

* Formal support for Kotlin 1.6. This plugin requires Kotlin 1.6 now.

0.8.3
------------

_2021-10-15_

* Support for Kotlin 1.6 (built against `1.6.0-RC`). This release should only be used for testing with Kotlin 1.6 previews.

0.8.2
------------

_2021-10-12_

This release was accidentally broken and should not be used! Specifically, the gradle plugin accidentally targeted Java 17.

0.8.1
------------

This release was accidentally broken and should not be used! Specifically, the compiler plugin itself was missing a service file and would not run.

0.8.0
------------

_2021-02-05_

* **Change:** The gradle plugin id is now `dev.zacsweers.redacted`.
* Support (and requires) Kotlin 1.4.30.

_There may be 0.7.x versions on sonatype. Don't use them, they are broken._

0.6.1
------------

_2021-01-10_

* Small IR fixes courtesy of [@DrewHamilton](https://github.com/DrewHamilton)

0.6.0
------------

_2021-01-09_

* Gradle plugin extension now uses modern Gradle `Property` APIs. Minimum Gradle version is now 5.1.
* Android-specific APIs (i.e. `variantFilter`) are now removed. If you still want this, consider
configuring this manually in your own build however you see fit in tandem with the `enabled` property.
* **Fix:** IR supports redacted classes now too.

0.5.0
------------

_2021-01-08_

* **New!** Experimental support for Kotlin IR. Note that IR is still incubating and subject to change.
* Update Kotlin to `1.4.21`.
* Tested up to JDK 15.

0.4.0
------------

_2020-11-27_

**This version requires Kotlin 1.4.20 or higher!**

* Compatible with Kotlin 1.4.20
* Supports Kotlin's new `StringConcatFactory` automatically when `-Xstring-concat` is enabled.
  * See the [Kotlin 1.4.20 announcement post](https://blog.jetbrains.com/kotlin/2020/11/kotlin-1-4-20-released/) for details on `-Xstring-concat`.

0.3.0
------------

_2020-08-15_

This is identical in functionality to 0.2.0 but built against Kotlin 1.4.

0.2.0-1.4
------------

_2020-07-16_

This is identical in functionality to 0.2.0 but built against Kotlin 1.4. This version is not considered
stable and should only be used for testing compatibility with Kotlin 1.4 pre-releases.

0.2.0
-----

_2020-01-25_

**New:** There's now a batteries-included `redacted-compiler-plugin-annotations` artifact with a `@Redacted`
annotation you can use if you don't want to manage your own. The `redacted` Gradle extension now defaults
to this and will automatically add this annotations artifact to your project dependencies if a custom
one isn't set. This means that, if you use the default, then all you need to do to use this plugin
is simply apply the gradle plugin 🎉.

0.1.0
-----

_2020-01-24_

Initial release!
