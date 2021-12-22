package com.maple.commonlib.widget.imageloader

import android.os.Build
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.loadAny
import coil.transform.*
import com.maple.commonlib.R
import com.maple.commonlib.app.CommonApp
import com.maple.commonlib.ext.gifImageLoader

class ImageLoader {

    /**
     *
     */
    companion object {

        private val gifImageLoader by lazy {
            CommonApp.instance.gifImageLoader
        }

        fun load(
            imageView: ImageView,
            any: Any?,
            enable: Boolean = true,
            @DrawableRes placeholderRes: Int = R.mipmap.ic_default_placeholder,
            @DrawableRes errorPicRes: Int = R.mipmap.ic_default_errorpic
        ) {
            imageView.loadAny(any) {
                crossfade(enable)
                placeholder(placeholderRes)
                error(errorPicRes)
            }
        }

        private fun loadCircle(
            imageView: ImageView,
            any: Any?,
            enable: Boolean = true,
            @DrawableRes placeholderRes: Int = R.mipmap.ic_default_placeholder,
            @DrawableRes errorPicRes: Int = R.mipmap.ic_default_errorpic
        ) {
            imageView.loadAny(any) {
                crossfade(enable)
                placeholder(placeholderRes)
                error(errorPicRes)
                transformations(CircleCropTransformation())
            }
        }

        private fun loadBlur(
            imageView: ImageView,
            any: Any?,
            enable: Boolean = true,
            @DrawableRes placeholderRes: Int = R.mipmap.ic_default_placeholder,
            @DrawableRes errorPicRes: Int = R.mipmap.ic_default_errorpic
        ) {
            imageView.loadAny(any) {
                crossfade(enable)
                placeholder(placeholderRes)
                error(errorPicRes)
                transformations(BlurTransformation(context = CommonApp.instance))
            }
        }

        private fun loadRounded(
            imageView: ImageView,
            any: Any?,
            @Px radius: Float = 12f,
            enable: Boolean = true,
            @DrawableRes placeholderRes: Int = R.mipmap.ic_default_placeholder,
            @DrawableRes errorPicRes: Int = R.mipmap.ic_default_errorpic
        ) {
            imageView.loadAny(any) {
                crossfade(enable)
                placeholder(placeholderRes)
                error(errorPicRes)
                transformations(RoundedCornersTransformation(radius = radius))
            }
        }

        private fun loadGrayscale(
            imageView: ImageView,
            any: Any?,
            enable: Boolean = true,
            @DrawableRes placeholderRes: Int = R.mipmap.ic_default_placeholder,
            @DrawableRes errorPicRes: Int = R.mipmap.ic_default_errorpic
        ) {
            imageView.loadAny(any) {
                crossfade(enable)
                placeholder(placeholderRes)
                error(errorPicRes)
                transformations(GrayscaleTransformation())
            }
        }
    }
}