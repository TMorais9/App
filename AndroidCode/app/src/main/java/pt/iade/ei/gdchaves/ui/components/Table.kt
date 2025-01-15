package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LeagueTable(
    modifier: Modifier = Modifier
        .padding(horizontal = 25.dp)
        .padding(bottom = 90.dp),
) {
    val tableData = listOf(
        TableRow(1, "Penafiel", 11, "21:14", 24),
        TableRow(2, "Tondela", 11, "25:11", 23),
        TableRow(3, "Benfica B", 11, "19:11", 23),
        TableRow(4, "Académico Viseu", 11, "17:12", 18),
        TableRow(5, "Leixões", 11, "16:10", 18),
        TableRow(6, "Chaves", 11, "12:10", 18),
        TableRow(7, "Toreense", 11, "13:13", 16),
        TableRow(8, "Feirense", 11, "10:9", 15),
        TableRow(9, "Marítimo", 11, "16:18", 15),
        TableRow(10, "Vizela", 11, "10:8", 13),
        TableRow(11, "Felgueiras 1932", 11, "12:12", 12),
        TableRow(12, "Alverca", 11, "11:15", 12),
        TableRow(13, "União Leiria", 11, "11:13", 12),
        TableRow(14, "Paços de Ferreira", 11, "13:18", 12),
        TableRow(15, "Portimonense", 11, "13:18", 10),
        TableRow(16, "Mafra", 11, "10:17", 10),
        TableRow(17, "Porto B", 11, "10:17", 9),
        TableRow(18, "Oliveirense", 11, "6:19", 6),
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF001E62))
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("#",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.5f),
                textAlign = TextAlign.Center)
            Text("EQUIPA",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(2f))
            Text("PJ",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center)
            Text("G",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center)
            Text("P",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center)
        }

        LazyColumn{
            items(tableData) { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(if (row.position % 2 == 0) Color.Gray else Color.LightGray)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${row.position}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(0.5f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = row.team,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(2f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        "${row.played}",
                        color = Color.Black,
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Center)
                    Text(
                        row.goals,
                        color = Color.Black,
                        modifier = Modifier
                        .weight(1f),
                        textAlign = TextAlign.Center)
                    Text(
                        "${row.points}",
                        color = Color.Black,
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Center)
                }
            }
        }
    }
}

data class TableRow(
    val position: Int,
    val team: String,
    val played: Int,
    val goals: String,
    val points: Int
)

@Preview
@Composable
fun LeagueTablePreview(){
    LeagueTable()
}
