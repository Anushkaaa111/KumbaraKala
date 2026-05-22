package com.example.kumbarakala.ui.card

import android.graphics.Bitmap
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material.icons.outlined.SwipeRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kumbarakala.card.BenefitCardRenderer
import com.example.kumbarakala.data.CardLanguage
import com.example.kumbarakala.data.ProductCatalog
import com.example.kumbarakala.share.ShareHelper
import com.example.kumbarakala.ui.ArtisanViewModel
import com.example.kumbarakala.ui.common.KumbaraTopBar
import kotlinx.coroutines.flow.distinctUntilChanged

private data class CacheKey(val page: Int, val lang: CardLanguage)

@Composable
fun CardPreviewScreen(
    productId: String,
    initialBenefitIndex: Int,
    onBack: () -> Unit,
    onAbout: () -> Unit,
    viewModel: ArtisanViewModel = viewModel()
) {
    val product = ProductCatalog.byId(productId)
    val context = LocalContext.current
    val artisan by viewModel.profile.collectAsState()

    if (product == null) {
        Box(
            Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) { Text("Piece not found.") }
        return
    }

    val pagerState = rememberPagerState(
        initialPage = initialBenefitIndex.coerceIn(0, product.benefits.lastIndex),
        pageCount = { product.benefits.size }
    )

    var language by remember { mutableStateOf(CardLanguage.ENGLISH) }
    val bitmaps = remember { mutableStateMapOf<CacheKey, Bitmap>() }

    // Render current + neighbours whenever page, language, or artisan changes.
    LaunchedEffect(pagerState, language, artisan) {
        snapshotFlow { pagerState.currentPage }
            .distinctUntilChanged()
            .collect { page ->
                val pagesToRender = listOf(page, page - 1, page + 1)
                    .filter { it in 0..product.benefits.lastIndex }
                pagesToRender.forEach { idx ->
                    val key = CacheKey(idx, language)
                    if (bitmaps[key] == null) {
                        bitmaps[key] = BenefitCardRenderer.render(
                            context,
                            product,
                            product.benefits[idx],
                            artisan,
                            language
                        )
                    }
                }
            }
    }
    LaunchedEffect(artisan) { bitmaps.clear() }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            KumbaraTopBar(
                title = "Story Card",
                subtitle = product.name,
                onBack = onBack,
                onAbout = onAbout
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(8.dp))

            LanguageToggle(
                selected = language,
                onSelect = { language = it }
            )

            Spacer(Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Swipe to switch angles",
                    style = MaterialTheme.typography.labelMedium.copy(letterSpacing = 3.sp),
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.Outlined.SwipeRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(Modifier.height(10.dp))

            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 28.dp),
                pageSpacing = 16.dp,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1080f / 1350f)
                        .shadow(elevation = 6.dp, shape = RoundedCornerShape(20.dp))
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    val bmp = bitmaps[CacheKey(page, language)]
                    if (bmp != null) {
                        Image(
                            bitmap = bmp.asImageBitmap(),
                            contentDescription = "Story Card ${page + 1}",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                }
            }

            Spacer(Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(product.benefits.size) { index ->
                    val selected = pagerState.currentPage == index
                    val w by animateDpAsState(
                        targetValue = if (selected) 22.dp else 6.dp,
                        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                        label = "dotWidth"
                    )
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .height(6.dp)
                            .width(w)
                            .clip(CircleShape)
                            .background(
                                if (selected) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.outlineVariant
                            )
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = product.benefits[pagerState.currentPage].headlineFor(language),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 28.dp)
            )

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val currentBitmap = bitmaps[CacheKey(pagerState.currentPage, language)]
                Button(
                    onClick = {
                        val bmp = currentBitmap ?: return@Button
                        val benefit = product.benefits[pagerState.currentPage]
                        val uri = ShareHelper.saveCardToCache(context, bmp, product.id)
                        val caption = ShareHelper.caption(product, benefit, artisan, language)
                        ShareHelper.shareToWhatsApp(context, uri, caption)
                    },
                    enabled = currentBitmap != null,
                    shape = RoundedCornerShape(14.dp),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Whatsapp, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Share",
                        style = MaterialTheme.typography.labelLarge.copy(
                            letterSpacing = 1.5.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
                OutlinedButton(
                    onClick = {
                        val bmp = currentBitmap ?: return@OutlinedButton
                        val benefit = product.benefits[pagerState.currentPage]
                        val uri = ShareHelper.saveCardToCache(context, bmp, product.id)
                        val caption = ShareHelper.caption(product, benefit, artisan, language)
                        ShareHelper.shareWithChooser(context, uri, caption)
                    },
                    enabled = currentBitmap != null,
                    shape = RoundedCornerShape(14.dp),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(
                        Icons.Default.Share,
                        contentDescription = "More share options",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun LanguageToggle(
    selected: CardLanguage,
    onSelect: (CardLanguage) -> Unit
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.surface)
            .border(
                width = 0.5.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(50)
            )
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CardLanguage.entries.forEach { lang ->
            val isSelected = lang == selected
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(
                        if (isSelected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.surface
                    )
                    .clickable { onSelect(lang) }
                    .padding(horizontal = 18.dp, vertical = 8.dp)
            ) {
                Text(
                    text = lang.display,
                    style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 1.sp),
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary
                    else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
