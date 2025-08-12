package br.com.clb.testuserlistapp


import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.koin.compose.koinInject
import androidx.core.net.toUri
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ListScreen(navController: NavController) {

    val viewModel: ListUserViewModel = koinInject()
    val state by viewModel.state.collectAsState()
    var flagDetail by remember { mutableStateOf(false) }


    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    flagDetail = !flagDetail


                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) { innerPadding ->

        if (state.isloading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }
        if (state.isSuccess && state.users.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding), contentAlignment = Alignment.Center
            ) {
                Text(text = "Nenhum usuário encontrado")
            }
            return@Scaffold

        }

        if (state.isSuccess) {

            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {

                items(
                    viewModel.state.value.users,
                    key = { user -> user.cpf }

                ) { user ->

                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                flagDetail = !flagDetail
                            }
                    ) {

                        Row(
                            modifier = Modifier
                                .padding(2.dp)
                        ) {
                            AsyncImage(
                                model = user.photo.toUri(),
                                contentDescription = "Foto de ${user.name}",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .padding(2.dp)
                                    .size(80.dp)
                                    .clip(CircleShape),
                                placeholder = painterResource(id = R.drawable.ic_menu_gallery),
                                error = painterResource(id = R.drawable.ic_dialog_alert)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = user.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Nasc: ${user.birthDate}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                                )
                                Text(
                                    text = "CPF: ${user.cpf}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                                )
                                Text(
                                    text = "Cidade: ${user.city}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                                )
                                Switch(
                                    checked = user.status,
                                    onCheckedChange = { newStatus ->
                                        viewModel.onUserStatusChange(user.cpf, newStatus)

                                    }
                                )

                            }
                        }

                    }

                    if (flagDetail) {
                        sendDetailUser(navController, user.name,user.birthDate,user.cpf,user.city)
                    }

                }


            }


        }

    }


}

fun sendDetailUser(navController: NavController,name: String,birthDate: String,cpf: Int,city: String) {
    val encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
    val encodedBirthDate = URLEncoder.encode(birthDate, StandardCharsets.UTF_8.toString())
    val encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8.toString())
    val cpfString = cpf.toString()

    navController.navigate("det/name/$encodedName/birthDate/$encodedBirthDate/cpf/$cpfString/city/$encodedCity")

}