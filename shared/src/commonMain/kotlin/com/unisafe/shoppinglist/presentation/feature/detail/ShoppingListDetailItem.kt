package com.unisafe.shoppinglist.presentation.feature.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.unisafe.shoppinglist.domain.model.ShoppingItemModel
import com.unisafe.shoppinglist.presentation.common.theme.SpaceSmall
import com.unisafe.shoppinglist.util.StringResources.QUANTITY
import com.unisafe.shoppinglist.util.StringResources.REMOVED_SHOPPING_LIST_SUCCESSFULLY

@Composable
fun ShopListDetailItem(
    item: ShoppingItemModel,
    onRemoveClick: (ShoppingItemModel) -> Unit,
    onItemClick: (ShoppingItemModel) -> Unit
) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onItemClick(item)
            },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                val baseItemNameStyle = MaterialTheme.typography.titleLarge
                val itemNameStyle = baseItemNameStyle.withDecorationIf(item.isCrossed)
                Text(
                    text = item.name,
                    style = itemNameStyle
                )

                Spacer(modifier = Modifier.height(SpaceSmall))

                val baseItemQuantityStyle = MaterialTheme.typography.labelLarge
                val itemQuantityStyle = baseItemQuantityStyle.withDecorationIf(item.isCrossed)
                Text(
                    text = "$QUANTITY ${item.created}",
                    style = itemQuantityStyle,
                    color = Color.Gray
                )
            }

            IconButton(
                onClick = { onRemoveClick(item) },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = REMOVED_SHOPPING_LIST_SUCCESSFULLY,
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

private fun TextStyle.withDecorationIf(condition: Boolean): TextStyle {
    return if (condition) {
        this.copy(textDecoration = TextDecoration.LineThrough)
    } else {
        this
    }
}