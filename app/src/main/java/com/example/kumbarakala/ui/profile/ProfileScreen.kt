package com.example.kumbarakala.ui.profile

import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kumbarakala.data.ArtisanProfile
import com.example.kumbarakala.ui.ArtisanViewModel
import com.example.kumbarakala.ui.common.KumbaraTopBar
import com.example.kumbarakala.ui.common.OrnamentDivider
import com.example.kumbarakala.ui.common.SectionLabel
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    onBack: () -> Unit,
    onAbout: () -> Unit,
    viewModel: ArtisanViewModel = viewModel()
) {
    val saved by viewModel.profile.collectAsState()
    var name by remember(saved) { mutableStateOf(saved.name) }
    var village by remember(saved) { mutableStateOf(saved.village) }
    var phone by remember(saved) { mutableStateOf(saved.phone) }
    var heritage by remember(saved) { mutableStateOf(saved.heritageYears) }
    var bio by remember(saved) { mutableStateOf(saved.bio) }

    val snackbar = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            KumbaraTopBar(
                title = "Meet the Maker",
                subtitle = null,
                onBack = onBack,
                onAbout = onAbout
            )
        },
        snackbarHost = {
            SnackbarHost(snackbar) {
                Snackbar(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) { Text(it.visuals.message) }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(28.dp))

            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initialsOf(name),
                    style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(Modifier.height(14.dp))

            Text(
                text = name.ifBlank { "Your name" },
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            if (village.isNotBlank()) {
                Text(
                    text = village,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }

            OrnamentDivider()

            SectionLabel(
                text = "Details that appear on every card",
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
                label = "Years your family has practised pottery"
            )
            Spacer(Modifier.height(14.dp))
            QuietTextField(
                value = bio,
                onChange = { bio = it },
                label = "A line about your craft",
                singleLine = false,
                minLines = 3
            )

            Spacer(Modifier.height(28.dp))

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
                    scope.launch { snackbar.showSnackbar("Profile saved") }
                },
                enabled = name.isNotBlank() && village.isNotBlank() && phone.isNotBlank(),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                contentPadding = PaddingValues(horizontal = 40.dp, vertical = 16.dp)
            ) {
                Text(
                    "Save profile",
                    style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 2.sp)
                )
            }

            Spacer(Modifier.height(56.dp))
        }
    }
}

private fun initialsOf(name: String): String {
    val parts = name.trim().split(" ").filter { it.isNotBlank() }
    return when {
        parts.isEmpty() -> "?"
        parts.size == 1 -> parts[0].take(1).uppercase()
        else -> (parts[0].take(1) + parts.last().take(1)).uppercase()
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
