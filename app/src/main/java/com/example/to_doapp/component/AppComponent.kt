package com.example.to_doapp.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AvTimer
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_doapp.data.SignUpViewModel
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.screens.Add_Task

@Composable
fun NormalTextComponent(value:String) {
    Text(text = value,

        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        )
}
@Composable
fun HeadingTextComponent(value:String) {
    Text(text = value,

        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    )
}

//@OptIn(ExperimentalMaterial3Api::class)?]
@Composable
fun MyTextFiled( imageVector:ImageVector ,labelValue : String,onTextSelected: (String) -> Unit, errorStatus:Boolean= false) {

    val textValue = remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue) },
        value = textValue.value,


        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        leadingIcon = {

            androidx.compose.material3.Icon(imageVector = imageVector, contentDescription ="null" )
        },
        isError = !errorStatus
    )
}
@Composable
fun MyPasswordTextFiled(imageVector:ImageVector, labelValue : String, onTextSelected: (String) -> Unit, errorStatus:Boolean =false) {
val localFocusManger = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = { Text(text = labelValue) },
        value = password.value,

        colors = TextFieldDefaults.colors(Color.Gray),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        keyboardActions = KeyboardActions{
                                         localFocusManger.clearFocus()
        },
        maxLines = 1,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {

            androidx.compose.material3.Icon(imageVector = imageVector, contentDescription ="null" )
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value){
                "Hide Password"
            }else{
                "Show Password"
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value}) {

                Icon(imageVector = iconImage, contentDescription = description)

            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus

    )
}

@Composable
fun MyCheckBox( value: String, onTextSelected: (String) -> Unit, onCheckedChanged:(Boolean) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {

        val checkState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked =checkState.value ,
            onCheckedChange = {

                checkState.value = !checkState.value
             onCheckedChanged.invoke(it)
            } )
        MyClickAbleText(value = value, onTextSelected)
    }

}

@Composable
fun MyClickAbleText(value: String, onTextSelected: (String) -> Unit) {


    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Magenta)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }

        append(andText)
        withStyle(style = SpanStyle(color = Color.Magenta)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }

    }
    ClickableText(text = annotatedString , onClick = { offset ->

        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span ->
                Log.d("MyClickAbleText", "{$span}")

                if((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)){
                    onTextSelected(span.item)
                }
            }
    }
    )

}


@Composable
fun MyButton(value: String, onButtonClicked:()-> Unit, isEnabled: Boolean = false) {

    Button( onClick = {
                      onButtonClicked.invoke()
    },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .background(Color.Transparent),
        contentPadding = PaddingValues(),
        enabled = isEnabled
        ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .background(
                Brush.horizontalGradient(listOf(Color.Magenta, Color.LightGray)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center,
            )

        {

            Text(text = value,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
                )
        }
    }
}

@Composable
fun DividerText(value: String) {

    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.LightGray,
            thickness = 1.dp)


        Text(text = value,
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp),
            color = Color.Black
            )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.LightGray,
            thickness = 1.dp)
    }
}

@Composable
fun MyClickAbleLoginText( tryingToLogin : Boolean,onTextSelected: (String) -> Unit) {

    val initialText = if(tryingToLogin){"Already have an account? "} else {"Doesn't have a Account yet?"}
    val login = if (tryingToLogin){" Login " } else {" Register "}

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Magenta)) {
            pushStringAnnotation(tag = login, annotation = login)
            append(login)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            color = Color.Black
        ),
        text = annotatedString , onClick = { offset ->

        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span ->
                Log.d("MyClickAbleText", "{$span}")

                if((span.item == login) ){
                    onTextSelected(span.item)
                }
            }
       }

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar( toolbarTitle : String , logoutButtonClicked : ()-> Unit) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(Color.Black),
        title = {
                Text(text = toolbarTitle, modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp),
                    style =TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                )
        },

        navigationIcon = {

            Icon(imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                tint = Color.White)
        },

        actions = {

            IconButton(onClick = {
                logoutButtonClicked()
            }) {

                Icon(imageVector = Icons.Filled.Logout,
                    contentDescription ="Log",
                    tint = Color.White
                    )

            }
        }
    )
}
@Preview(showSystemUi = true)
@Composable
fun TaskComponent() {

    Card( colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        modifier = Modifier
            .padding(5.dp)
            .height(75.dp)
        ) {

        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ){

            Text(text = "1",
                modifier = Modifier.fillMaxWidth(0.1f),
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center

                )

            )
            Column( verticalArrangement = Arrangement.spacedBy(1.dp) , modifier = Modifier.fillMaxWidth(0.8f)) {

                Text(text = "Task Name", modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp)
                    .padding(top = 9.dp),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Start,
                        color = Color.Black
                    )

                )
                Text(text = "Description", modifier = Modifier

                    .heightIn(min = 30.dp)
                    .padding(5.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.Start,
                        color = Color.Black
                    )

                )
            }

            Icon(imageVector = Icons.Filled.AccessTime, contentDescription = "timer", modifier = Modifier
                .fillMaxWidth()
                .size(60.dp))
        }
    }

}

@Composable
fun MyFab( onFabClicked : @Composable ()-> Unit) {

    FloatingActionButton(
        onClick = {
            onFabClicked
        },
        modifier = Modifier
            .clip(RoundedCornerShape(60.dp))
            .size(80.dp),
        containerColor = Color.DarkGray,
    ) {

        Image(imageVector = Icons.Filled.Add, contentDescription ="Add Task" , colorFilter = ColorFilter.tint(Color.White), modifier = Modifier.size(30.dp))
    }
}