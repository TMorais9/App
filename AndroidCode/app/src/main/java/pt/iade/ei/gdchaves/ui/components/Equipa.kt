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
import androidx.compose.ui.layout.ContentScale
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
fun Equipa(
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
                text = "Equipa",
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Guarda Redes",
                        fontSize = 30.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.vozinha_chaves),
                            contentDescription = "Guarda Redes",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "1",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Vozinha",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.goncalo_pinto_chaves),
                            contentDescription = "Guarda Redes",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "30",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Gonçalo Pinto",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.rodrigo_moura_chaves),
                            contentDescription = "Guarda Redes",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "31",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Rodrigo Moura",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 10.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Text(
                        text = "Defesas",
                        fontSize = 30.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.bruno_rodrigues_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "4",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Bruno Rodrigues",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.aaron_romero_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "5",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Aarón Romero",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.vasco_fernandes_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "13",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Vasco Fernandes",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.carraca_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "15",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Carraça",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.tiago_almeida_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "19",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Tiago Almeida",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.junior_pius_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "40",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Júnior Pius",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.kiko_pereira_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "55",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Kiko Pereira",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.mamadou_tounkara_chaves),
                            contentDescription = "Defesa",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "83",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Mamadou Tounkara",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 10.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Text(
                        text = "Médios",
                        fontSize = 30.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.brice_eboudje_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "6",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Brice Eboudjé",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.pedro_pinho_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "8",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Pedro Pinho",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.pedro_pelagio_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "11",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Pedro Pelágio",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.ktatau_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "12",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Ktatau",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.roan_wilson_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "14",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Roan Wilson",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.david_kusso_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "17",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "David Kusso",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.andre_ricardo_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "20",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "André Ricardo",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.pedro_tiba_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "25",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Pedro Tiba",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.helder_morim_chaves),
                            contentDescription = "Médio",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "70",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Hélder Morim",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 10.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Text(
                        text = "Avançados",
                        fontSize = 30.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.paulo_victor_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "7",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Paulo Victor",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.leandro_sanca_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "10",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Leandro Sanca",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.wellington_carvalho_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "21",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Wellington Carvalho",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.rui_gomes_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "23",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Rui Gomes",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.higor_platiny_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "29",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Higor Platiny",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.rodrigo_melro_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "87",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Rodrigo Melro",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.ruben_pina_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "88",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Rúben Pina",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.paul_ayongo_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "95",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Paul Ayongo",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.jo_batista_chaves),
                            contentDescription = "Avançado",
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "99",
                                fontSize = 25.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Jô Batista",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 10.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Text(
                        text = "Treinador",
                        fontSize = 30.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.marco_alves_treinador_chaves),
                            contentDescription = "Treinador",
                            modifier = Modifier
                                .size(220.dp)
                                .padding(end = 50.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Marco Alves",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun EquipaPreview() {
    Equipa(
        navHostController = rememberNavController()
    )
}