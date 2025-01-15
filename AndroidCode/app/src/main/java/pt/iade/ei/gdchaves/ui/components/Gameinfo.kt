package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch
import pt.iade.ei.gdchaves.R
import pt.iade.ei.gdchaves.R.drawable.aaron_romero_chaves
import pt.iade.ei.gdchaves.R.drawable.andre_ricardo_chaves
import pt.iade.ei.gdchaves.R.drawable.bruno_rodrigues_chaves
import pt.iade.ei.gdchaves.R.drawable.carraca_chaves
import pt.iade.ei.gdchaves.R.drawable.david_kusso_chaves
import pt.iade.ei.gdchaves.R.drawable.estadio_chaves
import pt.iade.ei.gdchaves.R.drawable.helder_morim_chaves
import pt.iade.ei.gdchaves.R.drawable.higor_platiny_chaves
import pt.iade.ei.gdchaves.R.drawable.junior_pius_chaves
import pt.iade.ei.gdchaves.R.drawable.kiko_pereira_chaves
import pt.iade.ei.gdchaves.R.drawable.logo_pacosdeferreira
import pt.iade.ei.gdchaves.R.drawable.mamadou_tounkara_chaves
import pt.iade.ei.gdchaves.R.drawable.paul_ayongo_chaves
import pt.iade.ei.gdchaves.R.drawable.paulo_victor_chaves
import pt.iade.ei.gdchaves.R.drawable.pedro_pinho_chaves
import pt.iade.ei.gdchaves.R.drawable.pedro_tiba_chaves
import pt.iade.ei.gdchaves.R.drawable.roan_wilson_chaves
import pt.iade.ei.gdchaves.R.drawable.rodrigo_moura_chaves
import pt.iade.ei.gdchaves.R.drawable.rui_gomes_chaves
import pt.iade.ei.gdchaves.R.drawable.tiago_almeida_chaves
import pt.iade.ei.gdchaves.R.drawable.user_profile
import pt.iade.ei.gdchaves.R.drawable.vozinha_chaves

@Composable
fun GameInfo(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Row {
            IconButton(
                onClick = {
                    navHostController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "LIGA MEU SUPER 24/25",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(top = 10.dp)
                    .padding(end = 45.dp)
                    .weight(1.0F)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = modifier
                    .padding(start = 6.dp)
            ) {
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
            ) {
                Box(
                    modifier = modifier
                        .align(alignment = Alignment.CenterHorizontally),

                    ) {
                    Text(
                        text = "2 NOV",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                    )
                    Text(
                        text = "15h30",
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .align(alignment = Alignment.Center)
                            .padding(top = 15.dp)

                    )
                }
            }
            Image(
                painter = painterResource(id = logo_pacosdeferreira),
                contentDescription = "Benfica B",
                modifier = modifier
                    .size(110.dp)
                    .padding(top = 8.dp)
                    .padding(bottom = 10.dp)
                    .padding(end = 20.dp),
                contentScale = ContentScale.Fit
            )
        }
        val pagerState = rememberPagerState(pageCount = { 4 })
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)

    }
}

@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "Ocorrências" to Icons.Default,
        "Estatísticas" to Icons.Default,
        "11 Inicial" to Icons.Default,
        "Informação" to Icons.Default

    )
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        edgePadding = 0.dp,
        backgroundColor = Color.White,
        selectedTabIndex = pagerState.currentPage,
        contentColor = Color.White,
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions),
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                modifier = Modifier
                    .background(Color.White),
                text = {
                    Text(
                        list[index].first,
                        color = if (pagerState.currentPage == index) Color.Black else Color.Gray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
    HorizontalDivider(
        color = Color.Black,
        thickness = 2.dp,
    )
}

@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> TabContentScreen3(data = "Ocorrências")
            1 -> TabContentScreen2(data = "Estatísticas")
            2 -> TabContentScreen1(data = "11 Inicial")
            3 -> TabContentScreen(data = "Informação")
        }
    }
}

@Composable
fun TabContentScreen(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            painter = painterResource(id = estadio_chaves),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Estádio Chaves",
            alignment = Alignment.TopStart,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = "Estádio Municipal Engenheiro Manuel Branco Teixeira, Chaves",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(start = 4.dp)

        )
    }
}

@Composable
fun TabContentScreen1(data: String) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "GD CHaves",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = vozinha_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "1",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Vozinha",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = carraca_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "15",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Carraça",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = bruno_rodrigues_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "4",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Bruno Rodrigues",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = junior_pius_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp),
                        )
                    }
                    Column{
                        Text(
                            text = "40",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Junior Pius",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = kiko_pereira_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp),
                        )
                    }
                    Column{
                        Text(
                            text = "55",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Kiko Pereira",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = roan_wilson_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "14",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Roan Wilson",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = pedro_tiba_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "25",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Pedro Tiba",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = rui_gomes_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "23",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Rui Gomes",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = andre_ricardo_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp),
                        )
                    }
                    Column{
                        Text(
                            text = "20",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Andre Ricardo",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = paulo_victor_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "7",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Paulo Victor",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = paul_ayongo_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "95",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Paul Ayongo",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(top = 5.dp)
            ) {
                Text(
                    text = "Suplentes",
                    fontSize = 20.sp
                )
            }
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 10.dp)
                    .padding(bottom = 10.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = rodrigo_moura_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "31",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Rodrigo Moura",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = tiago_almeida_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "19",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Tiago Almeida",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = mamadou_tounkara_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "4",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Mamadou Tounkara",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = aaron_romero_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "5",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Aarón Romero",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = pedro_pinho_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "8",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Pedro Pinho",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = david_kusso_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "17",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "David Kusso",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = helder_morim_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "70",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Hélder Morim",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "80",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Ushindi",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .padding(end = 5.dp)
                    ){
                        Image(
                            painter = painterResource(id = higor_platiny_chaves),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column{
                        Text(
                            text = "29",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Higor Platiny",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(top = 5.dp)
            ) {
                Text(
                    text = "Paços de Ferreira",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "28",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Marafona",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "21",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Anilson",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "3",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Diegão",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "23",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Erick Ferigra",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "5",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Antunes",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "6",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "João Caiado",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "7",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Gonçalo Nogueira",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "11",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Ivan Pavlic",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "9",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Uilton Silva",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "19",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Rui Fonte",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "30",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Costinha",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.White
                )
            }

            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 10.dp)
                    .padding(bottom = 10.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "12",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Jeimes Meneses",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "22",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Miguel Mota",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "2",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Ícaro Silva",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "4",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Gonçalo Cardoso",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "18",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Rui Pedro",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .padding(end = 20.dp)
                        ) {
                            Text(
                                text = "17",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Marcos Paulo",
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "8",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Welton Junior",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "51",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Emerson Pata",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painter = painterResource(id = user_profile),
                            contentDescription = "Jogador Chaves",
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "90",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Ronaldo Lumungo",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TabContentScreen2(data: String) {
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        item {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "58%",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Posse de Bola",
                    fontSize = 20.sp,
                )
                Text(
                    text = "42%",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "12",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Tentativas de Golo",
                    fontSize = 20.sp,
                )
                Text(
                    text = "26",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "12",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Remates á Baliza",
                    fontSize = 20.sp,
                )
                Text(
                    text = "17",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "0",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Remates Fora",
                    fontSize = 20.sp,
                )
                Text(
                    text = "9",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "6",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Cantos",
                    fontSize = 20.sp,
                )
                Text(
                    text = "6",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "16",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Defesas",
                    fontSize = 20.sp,
                )
                Text(
                    text = "10",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "24",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Livres",
                    fontSize = 20.sp,
                )
                Text(
                    text = "22",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "1",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Foras de Jogo",
                    fontSize = 20.sp,
                )
                Text(
                    text = "4",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "22",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Faltas",
                    fontSize = 20.sp,
                )
                Text(
                    text = "18",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "2",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Cartões Amarelos",
                    fontSize = 20.sp,
                )
                Text(
                    text = "3",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "27",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Lançamentos",
                    fontSize = 20.sp,
                )
                Text(
                    text = "22",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(start = 10.dp)
                    .padding(end = 10.dp),
                thickness = 2.dp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun TabContentScreen3(data: String) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(top = 5.dp)
            ) {
                Text(
                    text = "GD Chaves",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "1",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Vozinha",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "15",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Carraça",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "G 44'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "4",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Bruno Rodrigues",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "40",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Junior Pius",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "55",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Kiko Pereira",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "14",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Roan Wilson",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "25",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Pedro Tiba",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 53'",
                            )

                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "23",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Rui Gomes",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 91'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "20",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Andre Ricardo",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "AM 13'/S 80'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "7",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Paulo Victor",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "95",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp)
                        ) {
                            Text(
                                text = "Paul Ayongo",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 79'",
                            )
                        }
                    }
                }
            }

            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 10.dp)
                    .padding(bottom = 10.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "31",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Rodrigo Moura",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "19",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Tiago Almeida",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "4",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Mamadou Tounkara",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "5",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Aarón Romero",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "8",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Pedro Pinho",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 53'/AM 71'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "17",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "David Kusso",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "70",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Hélder Morim",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 80'",
                            )

                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "80",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Ushindi",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 91'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "29",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp)
                        ) {
                            Text(
                                text = "Higor Platiny",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 79'",
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(top = 5.dp)
            ) {
                Text(
                    text = "Paços de Ferreira",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "28",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Marafona",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "AM 89'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "21",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Anilson",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "AM 56'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "3",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Diegão",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "AG 91'/AM 76'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(end = 20.dp)
                    ) {
                        Text(
                            text = "23",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Erick Ferigra",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "A 16'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "5",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Antunes",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "6",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "João Caiado",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "7",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Gonçalo Nogueira",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "11",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Ivan Pavlic",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 64'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "9",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Uilton Silva",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 64'",
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "19",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Rui Fonte",
                            fontSize = 18.sp
                        )
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "30",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp)
                        ) {
                            Text(
                                text = "Costinha",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "G 16/S 79'",
                            )
                        }
                    }
                }
            }

            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 10.dp)
                    .padding(bottom = 10.dp)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "12",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Jeimes Meneses",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "22",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Miguel Mota",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "2",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Ícaro Silva",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "4",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Gonçalo Cardoso",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "18",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Rui Pedro",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .padding(end = 20.dp)
                        ) {
                            Text(
                                text = "17",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Marcos Paulo",
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = "S 64'",
                                )
                            }
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "8",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Welton Junior",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 79'",
                            )

                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "51",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Emerson Pata",
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(start = 50.dp)
                        .padding(end = 10.dp),
                    thickness = 2.dp,
                    color = Color.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp).padding(end = 20.dp)
                    ) {
                        Text(
                            text = "90",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp)
                        ) {
                            Text(
                                text = "Ronaldo Lumungo",
                                fontSize = 18.sp
                            )
                            Text(
                                text = "S 64'",
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
fun GameInfoPreview() {
    GameInfo(
        navHostController = rememberNavController()
    )
}