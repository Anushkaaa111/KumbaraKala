package com.example.kumbarakala.ui.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.SwipeRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.kumbarakala.R
import com.example.kumbarakala.data.BenefitTemplate
import com.example.kumbarakala.data.Product
import com.example.kumbarakala.data.ProductCatalog
import com.example.kumbarakala.ui.common.KumbaraTopBar
import com.example.kumbarakala.ui.common.OrnamentDivider
import com.example.kumbarakala.ui.common.SectionLabel
import kotlinx.coroutines.delay

@Composable
fun ProductDetailScreen(
    productId: String,
    onBack: () -> Unit,
    onAbout: () -> Unit,
    onGenerateCard: (productId: String, benefitIndex: Int) -> Unit
) {
    val product = ProductCatalog.byId(productId)
    if (product == null) {
        Box(
            Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) { Text("Piece not found.") }
        return
    }
    val context = LocalContext.current

    var heroVisible by remember { mutableStateOf(false) }
    var infoVisible by remember { mutableStateOf(false) }
    var pagerVisible by remember { mutableStateOf(false) }
    LaunchedEffect(productId) {
        heroVisible = false; infoVisible = false; pagerVisible = false
        delay(40); heroVisible = true
        delay(80); infoVisible = true
        delay(120); pagerVisible = true
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { KumbaraTopBar(onBack = onBack, onAbout = onAbout) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            AnimatedVisibility(
                visible = heroVisible,
                enter = fadeIn(tween(400)) + slideInVertically(
                    initialOffsetY = { it / 8 },
                    animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                        .aspectRatio(1.05f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(product.imageModel)
                            .crossfade(true)
                            .diskCachePolicy(CachePolicy.ENABLED)
                            .placeholder(R.drawable.ic_pot_placeholder)
                            .error(R.drawable.ic_pot_placeholder)
                            .build(),
                        contentDescription = product.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            AnimatedVisibility(
                visible = infoVisible,
                enter = fadeIn(tween(500)) + slideInVertically(initialOffsetY = { it / 10 })
            ) {
                Column(modifier = Modifier.padding(horizontal = 28.dp)) {
                    Text(
                        text = product.category.display.uppercase(),
                        style = MaterialTheme.typography.labelMedium.copy(letterSpacing = 3.sp),
                        color = MaterialTheme.colorScheme.outline
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = product.name,
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = product.tagline,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Medium
                    )

                    OrnamentDivider()

                    SectionLabel(text = "Origin", modifier = Modifier.padding(bottom = 8.dp))
                    Text(
                        text = product.originStory,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(Modifier.height(28.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        SectionLabel(text = "Story cards · swipe to explore")
                        Spacer(Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Outlined.SwipeRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                }
            }

            AnimatedVisibility(
                visible = pagerVisible,
                enter = fadeIn(tween(500))
            ) {
                BenefitPager(
                    product = product,
                    onGenerate = { idx -> onGenerateCard(product.id, idx) }
                )
            }

            Spacer(Modifier.height(48.dp))
        }
    }
}

@Composable
private fun BenefitPager(
    product: Product,
    onGenerate: (Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { product.benefits.size })

    Column {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 28.dp),
            pageSpacing = 14.dp,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            BenefitPage(
                index = page,
                total = product.benefits.size,
                benefit = product.benefits[page],
                onGenerate = { onGenerate(page) }
            )
        }

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(product.benefits.size) { index ->
                val selected = pagerState.currentPage == index
                val size by animateDpAsState(
                    targetValue = if (selected) 10.dp else 6.dp,
                    animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                    label = "dotSize"
                )
                val width by animateDpAsState(
                    targetValue = if (selected) 22.dp else 6.dp,
                    animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                    label = "dotWidth"
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .height(size)
                        .width(width)
                        .clip(CircleShape)
                        .background(
                            if (selected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.outlineVariant
                        )
                )
            }
        }
    }
}

@Composable
private fun BenefitPage(
    index: Int,
    total: Int,
    benefit: BenefitTemplate,
    onGenerate: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 22.dp, vertical = 22.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Angle 0${index + 1} · of 0$total",
                        style = MaterialTheme.typography.labelMedium.copy(letterSpacing = 2.sp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = benefit.headline,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = benefit.body,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "“${benefit.tagline}”",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontStyle = FontStyle.Italic
                ),
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(Modifier.height(22.dp))

            Button(
                onClick = onGenerate,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Generate Story Card",
                    style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 1.5.sp)
                )
                Spacer(Modifier.width(8.dp))
                Icon(Icons.AutoMirrored.Outlined.ArrowForward, contentDescription = null)
            }
        }
    }
}
