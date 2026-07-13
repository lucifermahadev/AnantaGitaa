package com.anantagita.ads

import android.app.Activity
import android.content.Context
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

object AdsManager {

    private var interstitialAd: InterstitialAd? = null
    private var isInterstitialLoading = false

    private var premiumUser: Boolean = false

    fun setPremiumStatus(premium: Boolean) {
        premiumUser = premium
    }

    fun isPremiumUser(): Boolean = premiumUser

    fun initialize(context: Context) {
        MobileAds.initialize(context) {}
    }

    fun loadInterstitial(context: Context, adUnitId: String) {
        if (premiumUser || isInterstitialLoading || interstitialAd != null) return
        isInterstitialLoading = true

        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            context,
            adUnitId,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    isInterstitialLoading = false
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    interstitialAd = null
                    isInterstitialLoading = false
                }
            }
        )
    }

    fun showInterstitial(
        activity: Activity,
        adUnitId: String,
        onDismiss: (() -> Unit)? = null
    ) {
        if (premiumUser) {
            onDismiss?.invoke()
            return
        }

        interstitialAd?.let { ad ->
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    interstitialAd = null
                    onDismiss?.invoke()
                    loadInterstitial(activity, adUnitId)
                }

                override fun onAdFailedToShowFullScreenContent(error: AdError) {
                    interstitialAd = null
                    onDismiss?.invoke()
                    loadInterstitial(activity, adUnitId)
                }
            }
            ad.show(activity)
        } ?: run {
            onDismiss?.invoke()
            loadInterstitial(activity, adUnitId)
        }
    }

    // ✅ Adaptive Banner ad creation
    fun createBannerAdView(context: Context, adUnitId: String): AdView? {
        if (premiumUser) return null

        val adView = AdView(context)
        val adSize = AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(
            context,
            context.resources.displayMetrics.widthPixels
        )
        adView.setAdSize(adSize)
        adView.adUnitId = adUnitId
        adView.loadAd(AdRequest.Builder().build())
        return adView
    }

    // ✅ Banner Composable
    @Composable
    fun BannerAdView(
        modifier: Modifier = Modifier,
        adUnitId: String
    ) {
        AndroidView(
            modifier = modifier,
            factory = { context ->
                createBannerAdView(context, adUnitId)?.apply {
                    layoutParams = android.widget.FrameLayout.LayoutParams(
                        MATCH_PARENT,
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
                    )
                } ?: AdView(context) // empty fallback if premium
            }
        )
    }
}