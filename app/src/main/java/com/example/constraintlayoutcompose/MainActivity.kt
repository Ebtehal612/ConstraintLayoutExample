package com.example.constraintlayoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.constraintlayoutcompose.ui.theme.ConstraintLayoutComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding(top = 300.dp)
            ){
                ConstraintLayout (modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
                    .padding()){
                    val (redButton,blueButton,greenButton,blackButton,parentButton)= createRefs()
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White), modifier = Modifier
                        .constrainAs(parentButton) {
                            top.linkTo(parent.top)
                            width=Dimension.value(300.dp)
                            height=Dimension.value(80.dp)
                        }.padding(start = 100.dp)){
                        Text(text = "Choose your fav color", color = Color.Black)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier
                        .constrainAs(redButton) {
                            top.linkTo(parentButton.bottom)
                        }){
                        Text(text = "Red")
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Blue), modifier = Modifier.constrainAs(blueButton){
                        top.linkTo(greenButton.bottom)
                    }) {
                        Text(text = "Blue")
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Green), modifier = Modifier.constrainAs(greenButton){
                        top.linkTo( parentButton.bottom)
                    }) {
                        Text(text = "Green")
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier.constrainAs(blackButton){
                        top.linkTo(greenButton.bottom)
                    }) {
                        Text(text = "Black")
                    }
                    createHorizontalChain(redButton,greenButton, chainStyle = ChainStyle.Spread)
                    createHorizontalChain(blueButton,blackButton, chainStyle = ChainStyle.Spread)

                }
            }

        }
    }
}

/* */