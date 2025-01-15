@file:Suppress("DEPRECATION")

package pt.iade.ei.gdchaves

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.gdchaves.ui.components.UserViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf(false) }
    val passwordError = remember { mutableStateOf(false) }

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
            Image(
                painter = painterResource(id = R.drawable.logo_chaves),
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp),
            )
            CustomTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                    emailError.value = !it.endsWith("@gmail.com")
                },
                label = "Email",
                isError = emailError.value,
                errorMessage = "Email inválido"
            )
            CustomTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = "Password",
                isPassword = true,
                isError = passwordError.value,
                errorMessage = "Senha não pode estar vazia"
            )

            Button(
                onClick = {
                    emailError.value = !email.value.endsWith("@gmail.com")
                    passwordError.value = password.value.isEmpty()

                    if (!emailError.value && !passwordError.value) {
                        navController.navigate("main") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001E62)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Button(
                onClick = {
                    navController.navigate("create_account")
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Text(
                    text = "Criar Conta",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun CriarConta(
    navController: NavController,
    userViewModel: UserViewModel) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val birthDate = remember { mutableStateOf("") }
    val membershipNumber = remember { mutableStateOf("") }

    val nameError = remember { mutableStateOf(false) }
    val emailError = remember { mutableStateOf(false) }
    val passwordError = remember { mutableStateOf(false) }
    val birthDateError = remember { mutableStateOf(false) }
    val membershipNumberError = remember { mutableStateOf(false) }

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_chaves),
                    contentDescription = "Logo",
                    modifier = Modifier.size(200.dp),
                )
                CustomTextField(
                    value = name.value,
                    onValueChange = {
                        name.value = it
                        nameError.value = it.isEmpty()
                    },
                    label = "Nome",
                    isError = nameError.value,
                    errorMessage = "Nome não pode estar vazio"
                )
                CustomTextField(
                    value = email.value,
                    onValueChange = {
                        email.value = it
                        emailError.value = !it.endsWith("@gmail.com")
                    },
                    label = "Email",
                    isError = emailError.value,
                    errorMessage = "Email inválido"
                )
                CustomTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = "Password",
                    isPassword = true,
                    isError = passwordError.value,
                    errorMessage = "Senha não pode estar vazia"
                )
                CustomTextField(
                    value = birthDate.value,
                    onValueChange = {
                        birthDate.value = it
                        birthDateError.value = !it.matches(Regex("\\d{2}/\\d{2}/\\d{4}"))
                    },
                    label = "Data de Nascimento (dd/mm/aaaa)",
                    isError = birthDateError.value,
                    errorMessage = "Data de nascimento inválida"
                )
                CustomTextField(
                    value = membershipNumber.value,
                    onValueChange = { membershipNumber.value = it },
                    label = "Nº de Sócio",
                    isError = membershipNumberError.value,
                    errorMessage = "Número de sócio não pode estar vazio"
                )

                Button(
                    onClick = {
                        nameError.value = name.value.isEmpty()
                        emailError.value = !email.value.endsWith("@gmail.com")
                        passwordError.value = password.value.isEmpty()
                        birthDateError.value =
                            !birthDate.value.matches(Regex("\\d{2}/\\d{2}/\\d{4}"))
                        membershipNumberError.value = membershipNumber.value.isEmpty()

                        if (!nameError.value &&
                            !emailError.value &&
                            !passwordError.value &&
                            !birthDateError.value &&
                            !membershipNumberError.value
                        ) {
                            // Salvar dados no ViewModel
                            userViewModel.name.value = name.value
                            userViewModel.email.value = email.value
                            userViewModel.password.value = password.value
                            userViewModel.birthDate.value = birthDate.value
                            userViewModel.membershipNumber.value = membershipNumber.value

                            navController.navigate("main") {
                                popUpTo("create_account") { inclusive = true }
                            }
                        }
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001E62)),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Criar",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }

                Button(
                    onClick = { navController.popBackStack() },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    Text(
                        text = "Cancelar",
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
fun CustomTextField(
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
            modifier = Modifier
                .fillMaxWidth(),
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
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val fakeNavController = rememberNavController()
    CriarConta(userViewModel = UserViewModel(),
        navController = rememberNavController
   ())
}
