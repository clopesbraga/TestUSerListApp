package br.com.clb.testuserlistapp


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import org.koin.compose.koinInject


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailUSerScreen(
    navController: NavController,
    name: String?,
    birthDate: String?,
    cpf: String?,
    city: String?
) {

    val viewModel: DetailUserViewModel = koinInject()
    val state by viewModel.state.collectAsState()

    var buttonSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Cyan
            ),
            shape = shape,
            border = BorderStroke(5.dp, Color.Black),


            ) {

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(

                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Nome: ${name}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Nasc: ${birthDate}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                    Text(
                        text = "CPF: ${cpf}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                    Text(
                        text = "Cidade: ${city}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        modifier = Modifier
                            .size(90.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        onClick = {
                            buttonSheet = !buttonSheet
                        },
                    ) {
                        Text(
                            "Editar",
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        )
                    }

                }
            }
        }


    }

    if (buttonSheet) {
        ModalBottomSheet(
            onDismissRequest = { buttonSheet = false },
            sheetState = sheetState
        ) {


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                value = state.name,
                onValueChange = {  viewModel.onNameChange(it) },
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                value = state.birthDate,
                onValueChange = { viewModel.onBirthDateChange(it) },
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                value = state.cpf.toString(),
                onValueChange = { viewModel.onCPFChange(it) },
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                value = state.city,
                onValueChange = {viewModel.onCityChange(it)  },
            )


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = shape,
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            buttonSheet = false
                        }
                        viewModel.UpdateUser()
                        navController.navigate("atv")
                    }
                }) {

                Spacer(modifier = Modifier.height(32.dp))
                Text("Salvar")

            }

        }
    }

}