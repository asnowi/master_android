package com.maple.commonlib.app

import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import coil.decode.VideoFrameDecoder
import coil.fetch.VideoFrameFileFetcher
import coil.fetch.VideoFrameUriFetcher
import coil.util.CoilUtils
import com.kongqw.network.monitor.NetworkMonitorManager
import com.maple.baselib.app.BaseApp
import com.tencent.mmkv.MMKV
import okhttp3.OkHttpClient

abstract class CommonApp: BaseApp(), ImageLoaderFactory {

    companion object {
        @JvmStatic
        lateinit var instance: CommonApp
            private set
    }

    override fun initApp() {
        super.initApp()
        instance = this
        MMKV.initialize(this)
        NetworkMonitorManager.getInstance().init(this)
    }

    /// coil
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(applicationContext)
            .componentRegistry {
                add(SvgDecoder(applicationContext))
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                    add(ImageDecoderDecoder(applicationContext))
                } else {
                    add(GifDecoder())
                }
                add(VideoFrameFileFetcher(applicationContext))
                add(VideoFrameUriFetcher(applicationContext))
                add(VideoFrameDecoder(applicationContext))
            }.crossfade(true)
            .okHttpClient {
                OkHttpClient.Builder().cache(CoilUtils.createDefaultCache(applicationContext))
                    .build()
            }.build()
    }
}