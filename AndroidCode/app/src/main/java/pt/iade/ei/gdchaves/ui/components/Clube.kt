package pt.iade.ei.gdchaves.ui.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.gdchaves.R

@Composable
fun Clube(
    navHostController: NavHostController

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF001E62))
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.Left,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
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
                text = "Clube",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = Color(0xFF001E62))
                ) {
                    Text(
                        text = "HISTÓRIA",
                        fontSize = 35.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 15.dp)
                    )
                Column {
                    Text(
                        text = "No dia 27 de Setembro de 1949, após a vitória do Flávia Sport Clube no Campeonato Distrital, " +
                                "que lhe permitiu o acesso à 3ª Divisão, dá-se a fusão entre os dois clubes rivais da cidade " +
                                "(Atlético Clube Flaviense e Flávia Sport Clube), da qual nasceria o Grupo Desportivo de Chaves dos nossos dias. " +
                                "Primeira equipa: Mário Esteves, Amâncio, Gualter,Raimundo, Bandeira (g.r.) e Chico Barreira, Setas, Flávio Larufas, Barico, Lila Geraldes e Lelo da Tenda. " +
                                "Com tal união deu-se o início da caminhada desportiva, com altos e baixos, onde o Grupo Desportivo de Chaves, centro de projeção de inúmeros talentos, foi conquistando " +
                                "o seu espaço num país que tendia cada vez mais a subestimar as potencialidades desportivas que a Região Transmontana, em especial a cidade de Chaves, tinha para oferecer.",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(top = 10.dp)
                            .padding(bottom = 25.dp)
                    )
                }
            }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.primeira_liga),
                                contentDescription = "Primeira liga",
                                modifier = Modifier
                                    .size(200.dp)
                            )
                            Text(
                                text = "Primeira Liga",
                                textAlign = TextAlign.Justify,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "18 Presenças",
                                textAlign = TextAlign.Justify,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "Melhor: 5ºLugar",
                                textAlign = TextAlign.Justify,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "89/90",
                                textAlign = TextAlign.Justify,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 2.dp)
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(start = 10.dp)
                            .padding(end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color.Black
                    )
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.taca_uefa),
                                contentDescription = "Taça Uefa",
                                modifier = Modifier
                                    .size(200.dp)
                            )
                            Text(
                                text = "Primeira Liga",
                                textAlign = TextAlign.Justify,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "1 Presença",
                                textAlign = TextAlign.Justify,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "Melhor: 2ª Eliminatória",
                                textAlign = TextAlign.Justify,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "87/88",
                                textAlign = TextAlign.Justify,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 2.dp)
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(start = 10.dp)
                            .padding(end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color.Black
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.taca_de_portugal),
                            contentDescription = "Taça de Portugal",
                            modifier = Modifier
                                .size(200.dp)
                        )
                        Text(
                            text = "Taça de Portugal",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "61 Presença",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "Melhor: Finalista",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "2009/10",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 10.dp)
                        .padding(end = 10.dp),
                    thickness = 0.5.dp,
                    color = Color.Black
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.segunda_liga),
                            contentDescription = "Segunda Liga",
                            modifier = Modifier
                                .size(200.dp)
                        )
                        Text(
                            text = "Segunda Liga",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "17 Presenças",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "Melhor: 2º Lugar",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "2015/16",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 10.dp)
                        .padding(end = 10.dp),
                    thickness = 0.5.dp,
                    color = Color.Black
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.segunda_divisao),
                            contentDescription = "Segunda Divisão",
                            modifier = Modifier
                                .size(200.dp)
                        )
                        Text(
                            text = "Segunda Divisão",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "26 Presenças",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "Melhor: Campeão",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "1012/13",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 10.dp)
                        .padding(end = 10.dp),
                    thickness = 0.5.dp,
                    color = Color.Black
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.terceira_divisao),
                            contentDescription = "Terceira Divisão",
                            modifier = Modifier
                                .size(200.dp)
                        )
                        Text(
                            text = "Terceira Divisão",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "17 Presença",
                            textAlign = TextAlign.Justify,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "Melhor: Finalista",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "54/55",
                            textAlign = TextAlign.Justify,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ClubePreview() {
    Clube(
        navHostController = rememberNavController()
    )
}