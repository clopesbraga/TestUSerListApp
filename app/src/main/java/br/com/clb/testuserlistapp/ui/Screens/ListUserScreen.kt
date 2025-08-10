package br.com.clb.testuserlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.clb.testuserlistapp.ui.theme.TestUserListAppTheme

@Composable
fun ListScreen(navController: NavController){

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate("crt") }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(text = "Tela de Listagem usuario ativos", modifier = Modifier.padding(innerPadding))

        }

    }

}