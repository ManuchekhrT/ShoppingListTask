package com.unisafe.shoppinglist.presentation.feature.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unisafe.shoppinglist.util.StringResources.CANCEL
import com.unisafe.shoppinglist.util.StringResources.CREATE
import com.unisafe.shoppinglist.util.StringResources.CREATE_SHOPPING_LIST_TITLE
import com.unisafe.shoppinglist.util.StringResources.SHOPPING
import com.unisafe.shoppinglist.util.StringResources.SHOPPING_NAME

@Composable
fun CreateShoppingListDialog(
    onDismissRequest: () -> Unit,
    onCreateClick: (String) -> Unit
) {
    var listName by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = CREATE_SHOPPING_LIST_TITLE)
        },
        text = {
            Column {
                Text(text = SHOPPING_NAME)
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = listName,
                    onValueChange = { listName = it },
                    label = { Text(SHOPPING) },
                    singleLine = true
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                if (listName.isNotBlank()) {
                    onCreateClick(listName)
                }
            }) {
                Text(CREATE)
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text(CANCEL)
            }
        }
    )
}
