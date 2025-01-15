package pt.iade.ei.gdchaves.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
import pt.iade.ei.gdchaves.R

@Composable
fun GameCalendar(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(fraction = 0.1f)
        .padding(horizontal = 25.dp),
)
{
    Row(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(6.dp),
                color = Color.Gray
            )

    ) {
        val days = listOf("25", "26", "27", "28", "29", "1")
        val dayNames = listOf("Sat", "Mon", "Tue", "Wed", "Thu", "Fri", "Sun")

        dayNames
            .zip(days)
            .forEach { (dayName, day) ->
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row{
                    Text(
                        text = dayName,
                        color = Color.Black,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
                Row {
                    Text(
                        text = day,
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                }
            }
            VerticalDivider(
                color = Color.Black
            )
        }

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sun",
                color = Color.Black,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.logo_pacosdeferreira),
                contentDescription = "Benfica B",
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 1.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun VerticalDivider() {
    VerticalDivider(
        color = Color.Black,
        modifier = Modifier
            .fillMaxHeight()
            .width(5.dp)
    )
}



@Preview
@Composable
fun GameCalendarPreview(){
    GameCalendar()
}