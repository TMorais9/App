package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.gdchaves.R
import pt.iade.ei.gdchaves.R.drawable.logo_pacosdeferreira

@Composable
fun GameCard(
    navControlor: NavController?,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier
            .padding(horizontal = 25.dp)
            .clickable {
                navControlor?.navigate("Gameinfo")
            }
    ){
        Column(
            modifier = modifier
                .background(Color(0xFF006400))
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                Text(
                    text = "LIGA MEU SUPER 24/25",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = modifier
                        .padding(top = 10.dp)
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.logo_chaves),
                        contentDescription = "GD Chaves",
                        modifier = modifier
                            .size(95.dp)
                            .padding(start = 30.dp)
                            .padding(bottom = 5.dp),
                        contentScale = ContentScale.Fit
                    )
                }
                Column(
                    modifier = modifier
                        .padding(bottom = 8.dp),
                    verticalArrangement = Arrangement.Top
                ){
                    Box( modifier = modifier
                        .align(alignment = Alignment.CenterHorizontally),

                        ) {
                        Text(
                            text = "2 MAR",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier
                        )
                        Text(
                            text = "15h30",
                            color = Color.White,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .align(alignment = Alignment.Center)
                                .padding(top = 10.dp)

                            )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo_ligaportugal),
                        contentDescription = "Liga Portugal 2",
                        modifier = modifier
                            .size(40.dp)
                            .clip(CutCornerShape(6.dp))
                            .fillMaxSize(),


                    )
                }
                Image(
                    painter = painterResource(id = logo_pacosdeferreira),
                    contentDescription = "Paços de Ferreira",
                    modifier = modifier
                        .size(95.dp)
                        .padding(top = 8.dp)
                        .padding(bottom = 10.dp)
                        .padding(end = 20.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Row (
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = "GD Chaves VS Paços de Ferreira",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,

                )
            }
        }
    }
}


@Preview
@Composable
fun GameCardPreview(){
    GameCard(navControlor = rememberNavController())
}