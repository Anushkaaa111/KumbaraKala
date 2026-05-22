package com.example.kumbarakala.card

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.Typeface
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import androidx.core.graphics.scale
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.kumbarakala.data.ArtisanProfile
import com.example.kumbarakala.data.BenefitTemplate
import com.example.kumbarakala.data.CardLanguage
import com.example.kumbarakala.data.Product

object BenefitCardRenderer {

    private const val CARD_WIDTH = 1080
    private const val CARD_HEIGHT = 1350

    private const val PAPER = 0xFFFAF6EF.toInt()
    private const val SAND = 0xFFE6DDCB.toInt()
    private const val STONE = 0xFFCBBDA5.toInt()
    private const val HAIRLINE = 0xFFD9CDB7.toInt()
    private const val CLAY = 0xFFB08968.toInt()
    private const val CLAY_DEEP = 0xFF8A6A4F.toInt()
    private const val COCOA = 0xFF3D2E22.toInt()
    private const val WALNUT = 0xFF5C4A3E.toInt()

    suspend fun render(
        context: Context,
        product: Product,
        benefit: BenefitTemplate,
        artisan: ArtisanProfile,
        language: CardLanguage = CardLanguage.ENGLISH
    ): Bitmap {
        val bitmap = Bitmap.createBitmap(CARD_WIDTH, CARD_HEIGHT, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        drawBackground(canvas)
        val imageBottom = drawProductImage(context, canvas, product)
        drawDivider(canvas, imageBottom + 56f)
        val afterHeadline = drawHeadline(
            canvas,
            benefit.headlineFor(language),
            imageBottom + 96f,
            language
        )
        val afterBody = drawBody(
            canvas,
            benefit.bodyFor(language),
            afterHeadline + 32f,
            language
        )
        drawTagline(canvas, benefit.taglineFor(language), afterBody + 36f, language)
        drawBrandBadge(canvas)
        drawArtisanFooter(canvas, artisan, product)

        return bitmap
    }

    private fun headlineTypeface(language: CardLanguage): Typeface = when (language) {
        CardLanguage.KANNADA -> Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        CardLanguage.ENGLISH -> Typeface.create(Typeface.SERIF, Typeface.BOLD)
    }

    private fun bodyTypeface(language: CardLanguage): Typeface = when (language) {
        CardLanguage.KANNADA -> Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        CardLanguage.ENGLISH -> Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL)
    }

    private fun taglineTypeface(language: CardLanguage): Typeface = when (language) {
        CardLanguage.KANNADA -> Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
        CardLanguage.ENGLISH -> Typeface.create(Typeface.SERIF, Typeface.ITALIC)
    }

    private fun drawBackground(canvas: Canvas) {
        val bgPaint = Paint().apply { color = PAPER }
        canvas.drawRect(0f, 0f, CARD_WIDTH.toFloat(), CARD_HEIGHT.toFloat(), bgPaint)

        val subtle = Paint().apply {
            shader = LinearGradient(
                0f, 0f, 0f, CARD_HEIGHT.toFloat(),
                PAPER, SAND,
                Shader.TileMode.CLAMP
            )
            alpha = 90
        }
        canvas.drawRect(0f, 0f, CARD_WIDTH.toFloat(), CARD_HEIGHT.toFloat(), subtle)

        val border = Paint().apply {
            style = Paint.Style.STROKE
            color = HAIRLINE
            strokeWidth = 3f
            isAntiAlias = true
        }
        val inset = 32f
        canvas.drawRoundRect(
            inset, inset,
            CARD_WIDTH - inset, CARD_HEIGHT - inset,
            28f, 28f, border
        )
    }

    private suspend fun drawProductImage(context: Context, canvas: Canvas, product: Product): Float {
        val left = 80f
        val top = 80f
        val right = CARD_WIDTH - 80f
        val targetWidth = (right - left).toInt()
        val targetHeight = 580
        val bottom = top + targetHeight

        val loader = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data(product.imageModel)
            .allowHardware(false)
            .build()
        val result = loader.execute(request)

        val photo: Bitmap? = if (result is SuccessResult) {
            val drawable = result.drawable
            val src = (drawable as? android.graphics.drawable.BitmapDrawable)?.bitmap
            src?.scale(targetWidth, targetHeight)
        } else null

        val clipPath = Path().apply {
            addRoundRect(
                RectF(left, top, right, bottom),
                20f, 20f,
                Path.Direction.CW
            )
        }
        canvas.save()
        canvas.clipPath(clipPath)

        if (photo != null) {
            canvas.drawBitmap(photo, left, top, null)
        } else {
            val fallback = Paint().apply { color = SAND }
            canvas.drawRect(left, top, right, bottom, fallback)
            val pot = Paint().apply {
                color = CLAY
                isAntiAlias = true
            }
            val cx = (left + right) / 2f
            val cy = (top + bottom) / 2f
            canvas.drawCircle(cx, cy + 30, 110f, pot)
            val rim = Paint().apply {
                color = CLAY_DEEP
                isAntiAlias = true
                style = Paint.Style.FILL
            }
            canvas.drawRoundRect(
                cx - 110, cy - 80, cx + 110, cy - 30,
                12f, 12f, rim
            )
        }
        canvas.restore()

        val frame = Paint().apply {
            style = Paint.Style.STROKE
            color = STONE
            strokeWidth = 2f
            isAntiAlias = true
        }
        canvas.drawRoundRect(left, top, right, bottom, 20f, 20f, frame)

        return bottom
    }

    private fun drawDivider(canvas: Canvas, y: Float) {
        val paint = Paint().apply {
            color = STONE
            strokeWidth = 2f
            isAntiAlias = true
        }
        val center = CARD_WIDTH / 2f
        canvas.drawLine(center - 60f, y, center - 14f, y, paint)
        canvas.drawLine(center + 14f, y, center + 60f, y, paint)
        val dot = Paint().apply {
            color = CLAY
            isAntiAlias = true
        }
        canvas.drawCircle(center, y, 5f, dot)
    }

    private fun drawHeadline(canvas: Canvas, text: String, top: Float, language: CardLanguage): Float {
        val paint = TextPaint().apply {
            color = COCOA
            textSize = if (language == CardLanguage.KANNADA) 56f else 64f
            typeface = headlineTypeface(language)
            isAntiAlias = true
        }
        val layout = staticLayout(text, paint, CARD_WIDTH - 160, Layout.Alignment.ALIGN_CENTER)
        canvas.save()
        canvas.translate(80f, top)
        layout.draw(canvas)
        canvas.restore()
        return top + layout.height
    }

    private fun drawBody(canvas: Canvas, text: String, top: Float, language: CardLanguage): Float {
        val paint = TextPaint().apply {
            color = WALNUT
            textSize = if (language == CardLanguage.KANNADA) 30f else 34f
            typeface = bodyTypeface(language)
            isAntiAlias = true
        }
        val layout = staticLayout(text, paint, CARD_WIDTH - 200, Layout.Alignment.ALIGN_CENTER, 1.3f)
        canvas.save()
        canvas.translate(100f, top)
        layout.draw(canvas)
        canvas.restore()
        return top + layout.height
    }

    private fun drawTagline(canvas: Canvas, text: String, top: Float, language: CardLanguage) {
        val paint = TextPaint().apply {
            color = CLAY_DEEP
            textSize = if (language == CardLanguage.KANNADA) 28f else 32f
            typeface = taglineTypeface(language)
            isAntiAlias = true
        }
        val layout = staticLayout(
            "“$text”",
            paint,
            CARD_WIDTH - 200,
            Layout.Alignment.ALIGN_CENTER,
            1.2f
        )
        canvas.save()
        canvas.translate(100f, top)
        layout.draw(canvas)
        canvas.restore()
    }

    private fun drawBrandBadge(canvas: Canvas) {
        val labelPaint = Paint().apply {
            color = CLAY
            textSize = 26f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            isAntiAlias = true
            letterSpacing = 0.32f
            textAlign = Paint.Align.CENTER
        }
        val y = CARD_HEIGHT - 220f
        canvas.drawText("KUMBARA · KALA", CARD_WIDTH / 2f, y, labelPaint)

        val sub = Paint().apply {
            color = STONE
            textSize = 22f
            typeface = Typeface.create(Typeface.SERIF, Typeface.ITALIC)
            isAntiAlias = true
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("the legacy of clay", CARD_WIDTH / 2f, y + 36f, sub)
    }

    private fun drawArtisanFooter(canvas: Canvas, artisan: ArtisanProfile, product: Product) {
        val footerTop = CARD_HEIGHT - 130f
        val cardPad = 64f

        val bg = Paint().apply {
            color = SAND
            isAntiAlias = true
        }
        canvas.drawRoundRect(
            cardPad, footerTop,
            CARD_WIDTH - cardPad, CARD_HEIGHT - 64f,
            18f, 18f, bg
        )

        val name = artisan.name.ifBlank { "An artisan of India" }
        val village = artisan.village.ifBlank { "village pottery" }
        val phone = artisan.phone

        val namePaint = Paint().apply {
            color = COCOA
            textSize = 30f
            typeface = Typeface.create(Typeface.SERIF, Typeface.BOLD)
            isAntiAlias = true
        }
        canvas.drawText("Made by $name", cardPad + 32f, footerTop + 42f, namePaint)

        val locPaint = Paint().apply {
            color = WALNUT
            textSize = 24f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL)
            isAntiAlias = true
        }
        canvas.drawText("$village  ·  ${product.name}", cardPad + 32f, footerTop + 76f, locPaint)

        if (phone.isNotBlank()) {
            val phonePaint = Paint().apply {
                color = CLAY_DEEP
                textSize = 24f
                typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
                isAntiAlias = true
                textAlign = Paint.Align.RIGHT
            }
            canvas.drawText(phone, CARD_WIDTH - cardPad - 32f, footerTop + 60f, phonePaint)
        }
    }

    @Suppress("DEPRECATION")
    private fun staticLayout(
        text: CharSequence,
        paint: TextPaint,
        width: Int,
        alignment: Layout.Alignment = Layout.Alignment.ALIGN_NORMAL,
        spacingMult: Float = 1.1f
    ): StaticLayout {
        return StaticLayout.Builder.obtain(text, 0, text.length, paint, width)
            .setAlignment(alignment)
            .setLineSpacing(0f, spacingMult)
            .setIncludePad(false)
            .build()
    }
}
