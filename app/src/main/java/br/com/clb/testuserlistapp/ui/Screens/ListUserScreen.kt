package br.com.clb.testuserlistapp


import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import org.koin.compose.koinInject
import androidx.core.net.toUri


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController) {

    val viewModel: ListUserViewModel = koinInject()
    val state by viewModel.state.collectAsState()
    var flagDetail by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Usuarios Ativos",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = Color(0xFF009688)
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("crt") }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },

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
                            .fillMaxWidth()
                            .clickable {
                                flagDetail = !flagDetail
                            },
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF009688)
                        )
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

                                UserTextView(user.name)
                                UserTextView(user.age+" anos" )

                                Spacer(modifier = Modifier.height(4.dp))

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
                        sendDetailUser(
                            navController,
                            user.name,
                            user.age,
                            user.cpf,
                            user.city
                        )
                    }

                }

            }

        }

    }
}
