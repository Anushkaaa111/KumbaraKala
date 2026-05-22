package com.example.kumbarakala.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kumbarakala.data.ArtisanProfile
import com.example.kumbarakala.ui.ArtisanViewModel
import com.example.kumbarakala.ui.common.OrnamentDivider
import com.example.kumbarakala.ui.common.SectionLabel
import androidx.compose.foundation.text.KeyboardOptions

@Composable
fun OnboardingScreen(
    onDone: () -> Unit,
    viewModel: ArtisanViewModel = viewModel()
) {
    val existing by viewModel.profile.collectAsState()
    var name by remember(existing) { mutableStateOf(existing.name) }
    var village by remember(existing) { mutableStateOf(existing.village) }
    var phone by remember(existing) { mutableStateOf(existing.phone) }
    var heritage by remember(existing) { mutableStateOf(existing.heritageYears) }
    var bio by remember(existing) { mutableStateOf(existing.bio) }

    val canContinue = name.isNotBlank() && village.isNotBlank() && phone.isNotBlank()

    Scaffold(containerColor = MaterialTheme.colorScheme.background) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(56.dp))

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "क",
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(Modifier.height(20.dp))

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

            OrnamentDivider()

            Text(
                text = "Welcome, maker.",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Tell us about your craft. Your name and village will appear on every Story Card you share.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(Modifier.height(32.dp))

            SectionLabel(
                text = "Your details",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, bottom = 12.dp)
            )

            QuietTextField(value = name, onChange = { name = it }, label = "Your name")
            Spacer(Modifier.height(14.dp))
            QuietTextField(value = village, onChange = { village = it }, label = "Village / town")
            Spacer(Modifier.height(14.dp))
            QuietTextField(
                value = phone,
                onChange = { phone = it.filter { c -> c.isDigit() || c == '+' || c == ' ' } },
                label = "Phone (shown on cards)",
                keyboardType = KeyboardType.Phone
            )
            Spacer(Modifier.height(14.dp))
            QuietTextField(
                value = heritage,
                onChange = { heritage = it },
                label = "Years your family has practised pottery (optional)"
            )
            Spacer(Modifier.height(14.dp))
            QuietTextField(
                value = bio,
                onChange = { bio = it },
                label = "A line about your craft (optional)",
                singleLine = false,
                minLines = 3
            )

            Spacer(Modifier.height(32.dp))

            Button(
                onClick = {
                    viewModel.save(
                        ArtisanProfile(
                            name = name,
                            village = village,
                            phone = phone,
                            heritageYears = heritage,
                            bio = bio
                        )
                    )
                    onDone()
                },
                enabled = canContinue,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                contentPadding = PaddingValues(horizontal = 36.dp, vertical = 16.dp)
            ) {
                Text(
                    "Enter the gallery",
                    style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 2.sp)
                )
                Spacer(Modifier.size(8.dp))
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
            }

            Spacer(Modifier.height(56.dp))
        }
    }
}

@Composable
private fun QuietTextField(
    value: String,
    onChange: (String) -> Unit,
    label: String,
    singleLine: Boolean = true,
    minLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = { Text(label) },
        singleLine = singleLine,
        minLines = minLines,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline
        ),
        modifier = Modifier.fillMaxWidth()
    )
}
