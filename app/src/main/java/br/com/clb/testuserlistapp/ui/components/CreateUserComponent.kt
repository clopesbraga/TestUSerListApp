package br.com.clb.testuserlistapp


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector




@Composable
fun RegisterTextField(
    name: String,
    onNameChange: (String) -> Unit,
){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        value = name,
        onValueChange = { onNameChange(it) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Yellow,
            unfocusedBorderColor = Color.White,
            disabledBorderColor = Color.Black,
            cursorColor = Color.Black,
            focusedTextColor = Color.White,
        )
    )
}

