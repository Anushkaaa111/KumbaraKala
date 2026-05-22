package com.example.kumbarakala.share

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.kumbarakala.data.ArtisanProfile
import com.example.kumbarakala.data.BenefitTemplate
import com.example.kumbarakala.data.CardLanguage
import com.example.kumbarakala.data.Product
import java.io.File
import java.io.FileOutputStream

object ShareHelper {

    private const val FILE_PROVIDER_AUTHORITY = "com.example.kumbarakala.fileprovider"
    private const val WHATSAPP_PACKAGE = "com.whatsapp"
    private const val WHATSAPP_BUSINESS_PACKAGE = "com.whatsapp.w4b"

    fun saveCardToCache(context: Context, bitmap: Bitmap, productId: String): Uri {
        val dir = File(context.cacheDir, "shared_cards").apply { mkdirs() }
        val file = File(dir, "kumbarakala_${productId}_${System.currentTimeMillis()}.png")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
        return FileProvider.getUriForFile(context, FILE_PROVIDER_AUTHORITY, file)
    }

    fun caption(
        product: Product,
        benefit: BenefitTemplate,
        artisan: ArtisanProfile,
        language: CardLanguage = CardLanguage.ENGLISH
    ): String {
        val makerLine = if (artisan.name.isNotBlank() && artisan.village.isNotBlank()) {
            "Handmade by ${artisan.name}, ${artisan.village}"
        } else "Handmade pottery"
        val phoneLine = if (artisan.phone.isNotBlank()) "\nOrder direct: ${artisan.phone}" else ""
        return buildString {
            append("✦ ${product.name} — ${benefit.headlineFor(language)} ✦\n\n")
            append(benefit.bodyFor(language))
            append("\n\n")
            append(makerLine)
            append(phoneLine)
            append("\n\n#KumbaraKala  #LegacyOfClay  #HandmadeInIndia")
        }
    }

    fun shareToWhatsApp(
        context: Context,
        uri: Uri,
        caption: String
    ) {
        val intent = baseShareIntent(uri, caption).apply {
            setPackage(WHATSAPP_PACKAGE)
        }
        try {
            context.startActivity(intent)
            return
        } catch (_: ActivityNotFoundException) {
            // try WhatsApp Business next
        }

        val biz = baseShareIntent(uri, caption).apply { setPackage(WHATSAPP_BUSINESS_PACKAGE) }
        try {
            context.startActivity(biz)
            return
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(
                context,
                "WhatsApp not installed — choose another app.",
                Toast.LENGTH_SHORT
            ).show()
            shareWithChooser(context, uri, caption)
        }
    }

    fun shareWithChooser(context: Context, uri: Uri, caption: String) {
        val chooser = Intent.createChooser(baseShareIntent(uri, caption), "Share Story Card")
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(chooser)
    }

    private fun baseShareIntent(uri: Uri, caption: String): Intent {
        return Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_TEXT, caption)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    }
}
