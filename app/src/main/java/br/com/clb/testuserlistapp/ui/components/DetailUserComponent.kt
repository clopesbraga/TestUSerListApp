package br.com.clb.testuserlistapp


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun UserDetailTextView(detailfield:String,usertext:String?){
    Text(
        text = "${detailfield}: ${usertext}",
        style = MaterialTheme.typography.titleLarge,
        color = Color.White
    )
}

@Composable
fun UpdateUserTextField(
    name: String,
    onNameChange: (String) -> Unit,
){
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        value = name,
        onValueChange = { onNameChange(it)},
    )

}
