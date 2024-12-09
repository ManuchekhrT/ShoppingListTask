package com.unisafe.shoppinglist.presentation.feature.list

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
import androidx.compose.ui.unit.dp
import com.unisafe.shoppinglist.domain.model.ShopListItemModel
import com.unisafe.shoppinglist.presentation.common.theme.SpaceSmall
import com.unisafe.shoppinglist.util.StringResources.REMOVE_ITEM_DESC

@Composable
fun ShopListItem(
    item: ShopListItemModel,
    navigateToDetail: (ShopListItemModel) -> Unit,
    onRemoveClick: (ShopListItemModel) -> Unit
) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navigateToDetail(item)
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
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = item.created,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray
                )
            }

            IconButton(
                onClick = { onRemoveClick(item) },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = REMOVE_ITEM_DESC,
                    tint = MaterialTheme.colorScheme.error,
                )
            }
        }
    }
}