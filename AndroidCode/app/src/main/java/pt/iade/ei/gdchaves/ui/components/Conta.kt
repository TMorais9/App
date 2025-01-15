package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class UserViewModel : ViewModel() {
    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val birthDate = MutableLiveData("")
    val membershipNumber = MutableLiveData("")
}


@Composable
fun Conta(
    navHostController: NavHostController,
    userViewModel: UserViewModel
) {
    val name = userViewModel.name.value ?: ""
    val email = userViewModel.email.value ?: ""
    val birthDate = userViewModel.birthDate.value ?: ""
    val membershipNumber = userViewModel.membershipNumber.value ?: ""

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
                text = "Conta",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = "Account Icon",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(top = 20.dp, bottom = 16.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        TextFieldContent("Nome:", name)
                        TextFieldContent("Email:", email)
                        TextFieldContent("Data de Nascimento:", birthDate)
                        TextFieldContent("Nº de Sócio:", membershipNumber)
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldContent(label: String, content: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(start = 10.dp)
            )
            OutlinedCard(
                colors = CardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(40.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = content,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun ContaPreview() {
    Conta(
        navHostController = rememberNavController(),
        userViewModel = UserViewModel()
    )
}
