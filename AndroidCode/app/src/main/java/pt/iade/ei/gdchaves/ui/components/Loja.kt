package pt.iade.ei.gdchaves.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.gdchaves.R

@Composable
fun Loja(
    navController: NavHostController,
    cartViewModel: CartViewModel
) {
    val itemsForSale = listOf(
        Item(R.drawable.camisola_principal, "Camisola Principal 24/25", 60.00),
        Item(R.drawable.camisola_alternativa, "Camisola Alternativa 24/25", 60.00),
        Item(R.drawable.camisola_3, "3º Equipamento 24/25", 60.00),
        Item(R.drawable.camisola_treino, "Camisola de Treino 24/25", 45.00),
        Item(R.drawable.fato_treino_2425, "Fato de Treino 24/25", 75.00),
        Item(R.drawable.kispo_2425, "Kispo 24/25", 60.00),
        Item(R.drawable.parka_branca, "Parka Branco", 50.00),
        Item(R.drawable.pullover, "Pullover", 40.0),
        Item(R.drawable.cachecol_gdchaves, "Cachecol GD Chaves", 7.50),
        Item(R.drawable.cachecol_valentes, "Cachecol Valentes Transmontanos", 7.50),
        Item(R.drawable.cachecol_brasao, "Cachecol com Brasão", 7.50),
        Item(R.drawable.bola_2425, "Bola 24/25", 20.00),
        Item(R.drawable.mochila, "Mochila", 20.00),
        Item(R.drawable.caneca_gdchaves, "Caneca GD Chaves", 7.50),
        Item(R.drawable.caneca_valentes, "Caneca Valentes Transmontanos", 7.50),
        Item(R.drawable.gorro, "Gorro", 7.50)
    )

    Column(
        modifier = Modifier
            .background(Color(0xFF001E62))
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            IconButton(onClick = {
                navController.popBackStack()
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
                text = "Loja",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("carrinho")
                    } // Navegar para o ecrã do carrinho
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "Carrinho",
                        tint = Color.White,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
        ) {
            items(itemsForSale) { item ->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.name,
                            modifier = Modifier
                                .size(250.dp),
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            text = item.name,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = "${item.price}€",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        )
                        Button(
                            onClick = { cartViewModel.addItemToCart(item) },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF001E62),
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp).fillMaxWidth()
                        ) {
                            Text(
                                text = "Comprar",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun LojaPreview() {
    Loja(
        navController = rememberNavController(),
        cartViewModel = CartViewModel()
    )
}

