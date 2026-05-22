package com.example.kumbarakala.ui.about

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Spa
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kumbarakala.ui.common.KumbaraTopBar
import com.example.kumbarakala.ui.common.OrnamentDivider
import com.example.kumbarakala.ui.common.SectionLabel
import kotlinx.coroutines.delay

@Composable
fun AboutScreen(onBack: () -> Unit) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(60)
        visible = true
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { KumbaraTopBar(title = "About", subtitle = null, onBack = onBack) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn() + slideInVertically(initialOffsetY = { it / 6 }),
                exit = fadeOut()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(Modifier.height(24.dp))

                    Box(
                        modifier = Modifier
                            .size(84.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "क",
                            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = "Kumbara · Kala",
                        style = MaterialTheme.typography.displayMedium.copy(letterSpacing = 3.sp),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "the legacy of clay",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }

            OrnamentDivider()

            Text(
                text = "Rebrand your craft for the modern, health-conscious buyer. Generate beautiful Story Cards for every piece you make and share them on WhatsApp in two taps.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(28.dp))

            SectionLabel(
                text = "What it does",
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
            )

            FeatureRow(
                icon = Icons.Outlined.Brush,
                title = "Twelve curated pieces",
                body = "Gallery of common clay items — dahi handi, matka, kulhad, diya, biryani handi, tawa, surahi, planter, and more."
            )
            Spacer(Modifier.height(10.dp))
            FeatureRow(
                icon = Icons.Outlined.AutoAwesome,
                title = "Story Cards on demand",
                body = "Each piece carries three benefit angles — health, eco, and craft. Pick the angle that matches your buyer."
            )
            Spacer(Modifier.height(10.dp))
            FeatureRow(
                icon = Icons.Outlined.Share,
                title = "One-tap WhatsApp share",
                body = "Cards are stamped with your name, village and phone — share to a customer and they know who to call."
            )
            Spacer(Modifier.height(10.dp))
            FeatureRow(
                icon = Icons.Outlined.Spa,
                title = "Wherever you sell",
                body = "Works offline after the first launch. No subscriptions, no logins, no chasing internet."
            )

            Spacer(Modifier.height(28.dp))

            SectionLabel(
                text = "How to use",
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
            )

            HowToStep(
                step = "01",
                title = "Set up once",
                body = "Add your name, village, and phone. These appear on every Story Card you generate."
            )
            Spacer(Modifier.height(10.dp))
            HowToStep(
                step = "02",
                title = "Open a piece",
                body = "Tap any item in the gallery to read its origin and benefits."
            )
            Spacer(Modifier.height(10.dp))
            HowToStep(
                step = "03",
                title = "Swipe through angles",
                body = "Each piece has three Story Card angles — swipe sideways inside the card preview to switch between them."
            )
            Spacer(Modifier.height(10.dp))
            HowToStep(
                step = "04",
                title = "Share on WhatsApp",
                body = "Tap Share — your customer gets a beautiful card with your contact details ready to call."
            )

            Spacer(Modifier.height(28.dp))

            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.PhoneAndroid,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Tip",
                            style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 1.5.sp),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = "Update your profile any time from the avatar in the top-left of the gallery.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(Modifier.height(48.dp))
        }
    }
}

@Composable
private fun FeatureRow(icon: ImageVector, title: String, body: String) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(14.dp), verticalAlignment = Alignment.Top) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(Modifier.width(14.dp))
            Column(modifier = Modifier.padding(top = 2.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = body,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun HowToStep(step: String, title: String, body: String) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        Text(
            text = step,
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            ),
            color = MaterialTheme.colorScheme.outlineVariant
        )
        Spacer(Modifier.width(16.dp))
        Column(modifier = Modifier.padding(top = 12.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = body,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
