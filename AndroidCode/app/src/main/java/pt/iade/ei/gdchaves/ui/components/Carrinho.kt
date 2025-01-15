package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Item(val image: Int, val name: String, val price: Double)

class CartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<Item>() // Itens no carrinho
    val total = mutableStateOf(0.0) // Total do carrinho
    val orders = mutableStateListOf<Triple<List<Item>, Double, String>>() // Histórico de encomendas com data/hora

    // Adiciona um item ao carrinho
    fun addItemToCart(item: Item) {
        cartItems.add(item)
        total.value += item.price
    }

    // Remove um item do carrinho
    fun removeItemFromCart(item: Item) {
        cartItems.remove(item)
        total.value -= item.price
    }

    // Finaliza a compra e adiciona aos pedidos
    fun finalizePurchase() {
        if (cartItems.isNotEmpty()) {
            val currentDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
            orders.add(Triple(cartItems.toList(), total.value, currentDateTime))
            cartItems.clear()
            total.value = 0.00
        }
    }
}

@Composable
fun Carrinho(
    navController: NavHostController,
    cartViewModel: CartViewModel
) {
    val cartItems = cartViewModel.cartItems
    val total = cartViewModel.total.value
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF001E62))
    ) {
        // Header
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(35.dp)
                )
            }
            Text(
                text = "Carrinho",
                fontSize = 30.sp,
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 90.dp)
                    .padding(horizontal = 10.dp)
            ) {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.name,
                            modifier = Modifier.size(60.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                text = item.name,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = "${item.price}€",
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                        }
                        Button(
                            onClick = { cartViewModel.removeItemFromCart(item) },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF001E62),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Remover", color = Color.White)
                        }
                    }
                }
            }

            // Total e botão fixo na parte inferior
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Total: ${"%.2f".format(total)}€",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Button(
                    onClick = {
                        cartViewModel.finalizePurchase()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF001E62),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Finalizar Compra",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun CarrinhoPreview() {
    Carrinho(
        navController = rememberNavController(),
        cartViewModel = CartViewModel()
    )
}
