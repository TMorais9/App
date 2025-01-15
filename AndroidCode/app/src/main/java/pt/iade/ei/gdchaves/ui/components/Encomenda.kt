package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Encomendas(navController: NavHostController, cartViewModel: CartViewModel) {
    val orders = cartViewModel.orders // Lista de encomendas, onde cada encomenda tem os itens, total e data/hora

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF001E62)) // Fundo azul da página
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
                text = "Encomendas",
                fontSize = 30.sp,
                color = Color.White
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 10.dp)
                .padding(bottom = 10.dp)
                .background(Color(0xFF001E62)) // Fundo azul da lista
        ) {
            itemsIndexed(orders) { index, order ->
                val items = order.first
                val total = order.second
                val dateTime = order.third
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(5.dp) // Margem interna
                ) {
                    // Items of the order
                    items.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = item.name, fontSize = 18.sp)
                            Text(text = "${item.price}€", fontSize = 16.sp)
                        }
                    }
                    Text(
                        text = "Total: ${"%.2f".format(total)}€",
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = "Data e Hora: $dateTime",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier
                    )
                }

                // Espaço entre os quadrados
                if (index < orders.size - 1) { // Evita espaço extra após o último quadrado
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp) // Espaço entre os quadrados
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EncomendasPreview() {
    val cartViewModel = CartViewModel()
    cartViewModel.orders.add(
        Triple(
            listOf(
                Item(0, "Camisola Principal", 60.00),
                Item(0, "Cachecol", 7.50)
            ),
            67.5,
            "10/01/2025 14:30"
        )
    )
    cartViewModel.orders.add(
        Triple(
            listOf(
                Item(0, "Fato de Treino", 75.00),
                Item(0, "Caneca", 7.50)
            ),
            82.5,
            "11/01/2025 16:45"
        )
    )

    Encomendas(
        navController = rememberNavController(),
        cartViewModel = cartViewModel
    )
}






