package com.unisafe.shoppinglist.presentation.feature.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unisafe.shoppinglist.util.StringResources.ADD
import com.unisafe.shoppinglist.util.StringResources.ADD_TO_SHOPPING_LIST_TITLE
import com.unisafe.shoppinglist.util.StringResources.CANCEL
import com.unisafe.shoppinglist.util.StringResources.DECREASE_QUANTITY_DESC
import com.unisafe.shoppinglist.util.StringResources.INCREASE_QUANTITY_DESC
import com.unisafe.shoppinglist.util.StringResources.PRODUCT
import com.unisafe.shoppinglist.util.StringResources.PRODUCT_NAME
import com.unisafe.shoppinglist.util.StringResources.QUANTITY

@Composable
fun AddToShoppingListDialog(
    onDismissRequest: () -> Unit,
    onAddClick: (String, Int) -> Unit
) {

    var itemName by remember { mutableStateOf("") }
    var itemCount by remember { mutableStateOf(0) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = ADD_TO_SHOPPING_LIST_TITLE)
        },
        text = {
            Column {
                Text(text = PRODUCT_NAME)
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = itemName,
                    onValueChange = { itemName = it },
                    label = { Text(PRODUCT) },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = QUANTITY, style = MaterialTheme.typography.bodyLarge)
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { if (itemCount > 0) itemCount-- }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = DECREASE_QUANTITY_DESC
                            )
                        }
                        Text(
                            text = itemCount.toString(),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        IconButton(
                            onClick = { itemCount++ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = INCREASE_QUANTITY_DESC
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                if (itemName.isNotBlank() && itemCount > 0) {
                    onAddClick(itemName, itemCount)
                }
            }) {
                Text(ADD)
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text(CANCEL)
            }
        }
    )
}