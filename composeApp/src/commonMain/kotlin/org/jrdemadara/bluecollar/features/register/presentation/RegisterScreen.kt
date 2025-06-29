package org.jrdemadara.bluecollar.features.register.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import bluecollar.composeapp.generated.resources.Res
import bluecollar.composeapp.generated.resources.bluecollar
import bluecollar.composeapp.generated.resources.bluecollarnobg
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Phone

import org.jetbrains.compose.resources.painterResource
import org.noziroh.rarenet.core.ui.components.CustomTextField

@Composable
fun RegisterScreen(navController: NavController) {

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    val phone = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFBFB))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.bluecollarnobg),
                contentDescription = "App Logo",
                modifier = Modifier.size(72.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Let's Get Started",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Find the right talent for the job or let the right job find you.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            CustomTextField(
                label = "Email or Phone",
                value = phone.value,
                onValueChange = { phone.value = it },
                modifier = Modifier.focusRequester(focusRequester),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                ),
                keyboardActions = KeyboardActions(onNext = { keyboardController?.hide() }),
                enabled = true,
                leadingIcon = Lucide.Phone
            )
        }
    }

}