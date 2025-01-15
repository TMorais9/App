package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.gdchaves.R
import pt.iade.ei.gdchaves.R.drawable.logo_pacosdeferreira

@Composable
fun Jogos(
    navHostController: NavHostController,
    navControlor: NavController?,
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
                text = "Jogos",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(color = Color(0xFF001E62))
                        .padding(top = 5.dp)
                        .padding(bottom = 10.dp)
                ) {
                    Text(
                        text = "LIGA MEU SUPER 24/25",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,

                        )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_academico_viseu),
                                contentDescription = "Académico",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "2 - 1",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "0 - 0",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_leixoes),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )

                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_maritimo),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "1 - 1",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "0 - 3",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_mafra),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_felgueiras),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "1 - 2",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "2 - 1",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_torreense),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_benficab),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "1 - 0",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "0 - 0",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_feirense),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_oliveirense),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "0 - 3",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .clickable {
                            navControlor?.navigate("Gameinfo")
                        }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column{
                            Text(
                                text = "Próximo Jogo",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(start = 20.dp)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.logo_chaves),
                                    contentDescription = "GD Chaves",
                                    modifier = Modifier
                                        .size(90.dp)
                                        .padding(start = 30.dp),
                                    contentScale = ContentScale.Fit
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "2 MAR",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(
                                    text = "15h30",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier

                                )
                            }
                            Column(
                                modifier = Modifier
                                    .padding(end = 20.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = logo_pacosdeferreira),
                                    contentDescription = "Benfica B",
                                    modifier = Modifier
                                        .size(90.dp)
                                        .padding(end = 20.dp),
                                    contentScale = ContentScale.Fit
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_vizela),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "8/11",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_portimonense),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "30/11",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "8/12",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_portob),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_alverca),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "14/12",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "21/12",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_tondela),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "4/1",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_penafiel),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp)
                        .padding(bottom = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_leiria),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "12/1",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(color = Color(0xFF001E62))
                        .padding(top = 5.dp)
                        .padding(bottom = 10.dp)
                ) {
                    Text(
                        text = "Taça de Portugal 24/25",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,

                        )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_limianos),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "0 - 2",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "2 - 0",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_lusitania),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                        .padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_casa_pia),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "23/11",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_chaves),
                                contentDescription = "GD Chaves",
                                modifier = Modifier
                                    .size(60.dp),
                                contentScale = ContentScale.Inside
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
fun JogosPreview() {
    Jogos(
        navControlor = rememberNavController(),
        navHostController = rememberNavController()
    )
}