package com.jacob.recipes.composablefunctions

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.EdgeInsets
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Row
import androidx.ui.layout.Spacing
import androidx.ui.material.surface.Card
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import com.jacob.recipes.RecipeHeader

@Composable
fun RecipeRow(title: String?, recipeHeaders: List<RecipeHeader>) {
    Column(crossAxisSize = LayoutSize.Expand, mainAxisSize = LayoutSize.Expand) {
        title?.let { strongTitle ->
            Container(modifier = Spacing(left = 16.dp, top = 16.dp)) {
                Text(text = strongTitle, style = +themeTextStyle { h5 })
            }
            HeightSpacer(height = 8.dp)
        }

        HorizontalScroller {
            Row(mainAxisSize = LayoutSize.Expand, modifier = Spacing(left = 8.dp)) {
                for (header in recipeHeaders) {
                    Container(width = 160.dp, padding = EdgeInsets(8.dp)) {
                        Column {
                            Card(RoundedCornerShape(4), Color.White, null, 4.dp) {
                                Container(height = 160.dp, width = 160.dp) {
                                    DrawImage(image = +imageResource(header.drawable))
                                }
                            }
                            HeightSpacer(height = 8.dp)
                            Text(
                                text = header.name,
                                style = +themeTextStyle { body1 },
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = header.author,
                                style = (+themeTextStyle { body2 }).withOpacity(0.6f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}