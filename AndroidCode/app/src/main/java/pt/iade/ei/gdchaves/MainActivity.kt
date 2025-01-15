package pt.iade.ei.gdchaves

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.gdchaves.ui.components.GameCalendar
import pt.iade.ei.gdchaves.ui.components.GameCard
import pt.iade.ei.gdchaves.ui.components.LeagueTable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                AppNavigation(navController)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(navController: NavHostController) {
    var isMenuOpen by remember { mutableStateOf(false) }
    var isAccountMenuOpen by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomEnd = 8.dp))
                    .clip(RoundedCornerShape(bottomStart = 8.dp)),
                title = {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 44.dp),
                        contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_chaves),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(60.dp),
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        isMenuOpen = true
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = Color(0xFFB3261E),
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("carrinho")
                        } // Navegar para o ecrã do carrinho
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "Carrinho",
                            tint = Color(0xFFB3261E),
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    IconButton(
                        onClick = {
                            isAccountMenuOpen = true
                        })
                    {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Localized description",
                            tint = Color(0xFFB3261E),
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                },

                colors = topAppBarColors(
                    containerColor = Color(0xFF001E62),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        content = {
            paddingValues ->
            MainScreen(paddingValues, navController = navController)
            if (isMenuOpen) {
                FullScreenMenu(
                    onClose = { isMenuOpen = false },
                    onOptionSelected = { option ->
                        isMenuOpen = false
                        navController.navigate(option)
                })
            }
            if (isAccountMenuOpen) {
                FullScreenAcountMenu(
                    onClose = { isAccountMenuOpen = false },
                    onOptionSelected = { option ->
                        isAccountMenuOpen = false
                        navController.navigate(option)
                    })
            }
        }
    )
}

@Preview
@Composable
fun TopAppBarPreview(){
    MainView(
        rememberNavController()
    )
}

@Composable
fun FullScreenMenu(
    onClose: () -> Unit,
    onOptionSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF001E62)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuItem(
                text = "Clube",
                onClick = {
                    onOptionSelected("clube")
                })
            MenuItem(
                text = "Equipa",
                onClick = {
                    onOptionSelected("equipa")
                })
            MenuItem(
                text = "Loja",
                onClick = {
                    onOptionSelected("loja")
                })
            MenuItem(
                text = "Jogos",
                onClick = {
                    onOptionSelected("jogos")
                })
            Spacer(
                modifier = Modifier
                    .size(20.dp))
            IconButton(onClick = onClose) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Fechar",
                    tint = Color(0xFFB3261E),
                    modifier = Modifier.size(60.dp)
                )
            }
        }
    }
}

@Composable
fun MenuItem(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = text,
            fontSize = 40.sp,
            color = Color.White
        )
    }
}

@Composable
fun FullScreenAcountMenu(
    onClose: () -> Unit,
    onOptionSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF001E62)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AcountMenuItem(
                text = "Conta",
                onClick = {
                    onOptionSelected("conta")
                })
            AcountMenuItem(
                text = "Quotas",
                onClick = {
                    onOptionSelected("quotas")
                })
            AcountMenuItem(
                text = "Encomendas",
                onClick = {
                    onOptionSelected("encomendas")
                })
            Spacer(
                modifier = Modifier
                    .size(20.dp))
            IconButton(onClick = onClose) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Fechar",
                    tint = Color(0xFFB3261E),
                    modifier = Modifier.size(60.dp)
                )
            }
        }
    }
}

@Composable
fun AcountMenuItem(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = text,
            fontSize = 40.sp,
            color = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactBottomSheet() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BottomSheetScaffold(
            sheetContent = {
                Box (modifier = Modifier
                    .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ){
                    Image(
                        painter = painterResource(id = R.drawable.logo_chaves),
                        contentDescription = "GD Chaves",
                    )
                }
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Contactos",
                        fontSize = 25.sp,
                        color = Color.White,
                    )
                    Text(
                        text = "Morada: Av. do Estádio",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Telemóvel: +351 276 011 475",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp),
                    )
                    Text(
                        text = "Email: geral@gdchaves.pt",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            },
            sheetContainerColor = Color(0xFF001E62)
        ) {
        }
    }
}

@Composable
fun MainScreen(
    paddingValues: PaddingValues,
    navController: NavHostController
){
    Column(
        modifier = Modifier
            .padding(paddingValues)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            GameCard(navControlor = navController)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.Center
        ){
            GameCalendar()
        }
        Row (
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
        ){
            LeagueTable()
        }
    }

    ContactBottomSheet()
}

