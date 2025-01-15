@file:Suppress("DEPRECATION")

package pt.iade.ei.gdchaves

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Quotas(
    navHostController: NavHostController
) {
    val email = remember { mutableStateOf("") }
    val socio = remember { mutableStateOf("") }

    val emailError = remember { mutableStateOf(false) }
    val socioError = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF001E62))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            IconButton(onClick = {
                navHostController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(35.dp)
                )
            }
            Text(
                text = "Quotas",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "Account Icon",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(top = 20.dp, bottom = 16.dp)
                )
                QuotasText(
                    value = email.value,
                    onValueChange = {
                        email.value = it
                        emailError.value = !it.endsWith("@gmail.com")
                    },
                    label = "Email",
                    isError = emailError.value,
                    errorMessage = "Este campo não pode estar vazio"
                )
                QuotasText(
                    value = socio.value,
                    onValueChange = { socio.value = it },
                    label = "Nº Sócio",
                    isError = socioError.value,
                    errorMessage = "Este campo não pode estar vazio"
                )

                Button(
                    onClick = {
                        emailError.value = !email.value.endsWith("@gmail.com")
                        socioError.value = socio.value.isEmpty()
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF001E62)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                ) {
                    Text(
                        text = "Pagamento",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotasText(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = ""
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label, color = if (isError) Color.Red else Color.Black) },
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            isError = isError,
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = if (isError) Color.Red else Color.Black,
                containerColor = Color.White,
                focusedIndicatorColor = if (isError) Color.Red else Color.Black,
                unfocusedIndicatorColor = if (isError) Color.Red else Color.Black,
                focusedLabelColor = if (isError) Color.Red else Color.Black
            )
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 2.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuotasPreview() {
    Quotas(navHostController = rememberNavController())
}

