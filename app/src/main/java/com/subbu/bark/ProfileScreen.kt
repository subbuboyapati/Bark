package com.subbu.bark

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(puppy: Puppy) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxWidth()) {
        BoxWithConstraints {
            androidx.compose.material.Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    //TODO
                    ProfileHeader(
                        puppy = puppy,
                        containerHeight = this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(puppy, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
fun ProfileContent(puppy: Puppy, maxHeight: Dp) {
    Column {
        Title(puppy = puppy)
        ProfileProperty(stringResource(R.string.sex), puppy.sex)
        ProfileProperty(stringResource(R.string.age), puppy.age.toString())
        ProfileProperty(stringResource(R.string.personality), puppy.description)
        Spacer(Modifier.height((maxHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun Title(puppy: Puppy) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = puppy.title, style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)

    }
}

@Composable
fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            overflow = TextOverflow.Visible
        )
    }
}


@Composable
fun ProfileHeader(puppy: Puppy, containerHeight: Dp) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = puppy.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}