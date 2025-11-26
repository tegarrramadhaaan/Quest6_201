package com.example.myarsitektur.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myarsitektur.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    modifier: Modifier = Modifier,
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit
) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textGender by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(textNama, textAlamat, textGender)

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { isiRuang ->

        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 20.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = { textNama = it }
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(12.dp)
                    .width(250.dp),
                thickness = dimensionResource(id = R.dimen.thickness_divider),
                color = Color.Blue
            )

            Row {
                pilihanJK.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textGender == item,
                            onClick = { textGender = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textGender == item,
                            onClick = { textGender = item }
                        )
                        Text(text = item)
                    }
                }
            }

            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 20.dp),
                label = { Text(text = "Alamat Lengkap") },
                onValueChange = { textAlamat = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = textAlamat.isNotEmpty(),
                onClick = { onSubmitButtonClicked(listData) }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}