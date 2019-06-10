# Stetho with AndroidX [![Build Status](https://travis-ci.org/facebook/stetho.svg?branch=master)](https://travis-ci.org/facebook/stetho)
From: https://github.com/facebook/stetho
[Stetho](https://facebook.github.io/stetho) is a sophisticated debug bridge for Android applications. When enabled,
developers have access to the Chrome Developer Tools feature natively part of
the Chrome desktop browser. Developers can also choose to enable the optional
`dumpapp` tool which offers a powerful command-line interface to application
internals.

Once you complete the set-up instructions below, just start your app and point
your laptop browser to `chrome://inspect`.  Click the "Inspect" button to
begin.

## Set-up

### Download and implementation files
[stetho-x.aar](https://github.com/wert3232/stetho-x/raw/master/out/stetho-x.aar)  
[stetho-x-okhttp3.aar](https://github.com/wert3232/stetho-x/raw/master/out/stetho-x-okhttp3.aar)  

### use
```kotlin
//(Application, maxExecuteResults)
Stetho.initializeWithDefaults(this, 1000)
            OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
