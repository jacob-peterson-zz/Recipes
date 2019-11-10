package com.jacob.recipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutSize
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.jacob.recipes.composablefunctions.RecipeRow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePage()
        }
    }
}

private val headers = listOf(
    RecipeHeader(
        R.drawable.tacos,
        "Easy Tacos",
        "Steve Mariucci"
    ),
    RecipeHeader(
        R.drawable.burger,
        "The Perfect Burger",
        "Josh Gordon"
    ),
    RecipeHeader(
        R.drawable.power_food_bowl,
        "Super Food Bowl",
        "Grace Vanderwaal"
    ),
    RecipeHeader(
        R.drawable.quinoa_avocado_salad,
        "Quinoa Avocado Salad",
        "Martha Stewart"
    ),
    RecipeHeader(
        R.drawable.oatmeal,
        "3 Minute Oatmeal",
        "Nicole Peterson"
    )
)

@Composable
fun HomePage() {
    MaterialTheme {
        Column(mainAxisSize = LayoutSize.Expand, crossAxisSize = LayoutSize.Expand) {
            RecipeRow("Featured Recipes", headers.shuffled())
            RecipeRow("My recipes", headers.shuffled())
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    HomePage()
}
