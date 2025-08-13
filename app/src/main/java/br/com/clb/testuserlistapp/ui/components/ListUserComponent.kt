package br.com.clb.testuserlistapp


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun UserTextView(usertext:String?){
    Text(
        text = "${usertext}",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

fun sendDetailUser(
    navController: NavController,
    name: String,
    age: String,
    cpf: String,
    city: String
) {
    val encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
    val encodedAge = URLEncoder.encode(age, StandardCharsets.UTF_8.toString())
    val encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8.toString())
    val encodedCpf = URLEncoder.encode(cpf, StandardCharsets.UTF_8.toString())


    navController.navigate(
        "" +
                "det/name/$encodedName" +
                "/age/$encodedAge" +
                "/cpf/$encodedCpf" +
                "/city/$encodedCity"
    )

}