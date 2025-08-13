package br.com.clb.testuserlistapp


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUserScreen(navController: NavController) {

    val viewModel: CreateUserViewModel = koinInject()
    val state by viewModel.state.collectAsState()


    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            viewModel.onPhotoUriChange(uri)
        }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Criar Usuário",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                },
                navigationIcon = {
                    IconButton(

                        onClick = {
                            navController.navigate("atv")
                        }) {
                        Icon(Icons.Filled.ArrowBack, "Back", tint = Color.White)
                    }
                    colors(Color.White)
                },
                colors = topAppBarColors(
                    containerColor = Color(0xFF009688)
                ),
            )
        }

    ) { innerPadding ->

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {


            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .clickable {
                        imagePickerLauncher.launch("image/*")
                    }
                    .padding(4.dp)
                    .border(
                        BorderStroke(
                            2.dp,
                            MaterialTheme.colorScheme.primary
                        ),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = Uri.parse(state.photoUri),
                    contentDescription = "Foto do usuário",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    error = painterResource(id = R.drawable.ic_launcher_background)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF009688)
                ),
                shape = shape,
                border = BorderStroke(5.dp, Color.Black)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "Nome", color = Color.White)
                    RegisterTextField(
                        name = state.name,
                        onNameChange = { viewModel.onNameChange(it) }
                    )

                    Text(text = "CPF",color = Color.White)
                    RegisterTextField(
                        name = state.cpf,
                        onNameChange = { viewModel.onCPFChange(it) }

                    )

                    Text(text = "Idade",color = Color.White)
                    RegisterTextField(
                        name = state.age,
                        onNameChange = { viewModel.onAgeChange(it) }
                    )

                    Text(text = "Cidade",color = Color.White)
                    RegisterTextField(
                        name = state.city,
                        onNameChange = { viewModel.onCityChange(it) }
                    )

                }

            }

            Button(
                modifier = Modifier
                    .padding(32.dp)
                    .size(90.dp),
                onClick = {
                    viewModel.registerUser()
                    navController.navigate("atv")
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
            ) {
                Text(text = "Salvar")
            }

        }

    }
}

