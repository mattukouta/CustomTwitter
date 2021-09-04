package com.kouta.customtwitter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.kouta.customtwitter.R
import com.kouta.customtwitter.model.Tweet
import com.kouta.customtwitter.model.fakeTweetItem
import com.kouta.customtwitter.ui.theme.CustomTwitterTheme

@Composable
fun TweetItem(
    modifier: Modifier = Modifier,
    tweetItem: Tweet
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clickable { }
            .padding(vertical = 8.dp)
    ) {
        val (
            userIcon,
            userConstraint,
            tweetDate,
            tweet,
            replyButton,
            retweetButton,
            likeButton,
            shareButton,
            otherButton
        ) = createRefs()

        NetworkImage(
            modifier = modifier
                .size(48.dp)
                .constrainAs(userIcon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, 8.dp)
                }
                .clip(shape = CircleShape),
            url = tweetItem.userIconUrl
        )

        ConstraintLayout(
            modifier = modifier.constrainAs(userConstraint) {
                top.linkTo(userIcon.top)
                start.linkTo(userIcon.end, 8.dp)
                end.linkTo(tweetDate.start, 4.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            val (
                userName,
                userID
            ) = createRefs()

            Text(
                modifier = modifier
                    .constrainAs(userName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                text = tweetItem.userName,
                fontSize = 16.sp,
                maxLines = 1,
                color = MaterialTheme.colors.secondary,
                overflow= TextOverflow.Ellipsis
            )

            Text(
                modifier = modifier
                    .constrainAs(userID) {
                        bottom.linkTo(userName.bottom)
                        start.linkTo(userName.end, 4.dp)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                text = tweetItem.userID,
                fontSize = 14.sp,
                maxLines = 1,
                color = MaterialTheme.colors.secondaryVariant,
                overflow= TextOverflow.Ellipsis
            )
        }

        Text(
            modifier = modifier
                .constrainAs(tweetDate) {
                    top.linkTo(userConstraint.top)
                    end.linkTo(otherButton.start, 4.dp)
                },
            text = tweetItem.tweetDate,
            fontSize = 16.sp,
            color = MaterialTheme.colors.secondaryVariant
        )

        IconButton(
            modifier = modifier
                .size(24.dp)
                .constrainAs(otherButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end, 8.dp)
                },
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Filled.MoreVert,
                "",
                tint = MaterialTheme.colors.secondaryVariant
            )
        }

        Text(
            modifier = modifier
                .constrainAs(tweet) {
                    top.linkTo(userConstraint.bottom, 4.dp)
                    start.linkTo(userIcon.end, 8.dp)
                    end.linkTo(parent.end, 8.dp)
                    width = Dimension.fillToConstraints
                },
            text = tweetItem.tweet,
            fontSize = 16.sp,
            color = MaterialTheme.colors.secondary
        )

        IconButton(
            modifier = modifier
                .size(
                    height = 18.dp,
                    width = 64.dp
                )
                .constrainAs(replyButton) {
                    top.linkTo(tweet.bottom, 8.dp)
                    start.linkTo(tweet.start)
                    end.linkTo(retweetButton.start, 8.dp)
                    bottom.linkTo(parent.bottom, 4.dp)
                },
            onClick = { /*TODO*/ }
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.ic_comment_24),
                    contentDescription = "",
                    tint = MaterialTheme.colors.secondaryVariant
                )

                Text(
                    modifier = modifier.padding(start = 2.dp),
                    text = "1231",
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.secondaryVariant
                )
            }

        }

        IconButton(
            modifier = modifier
                .size(
                    height = 18.dp,
                    width = 64.dp
                )
                .constrainAs(retweetButton) {
                    top.linkTo(replyButton.top)
                    start.linkTo(replyButton.end, 8.dp)
                    end.linkTo(likeButton.start, 8.dp)
                    bottom.linkTo(replyButton.bottom)
                },
            onClick = { /*TODO*/ }
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.ic_retweet_24),
                    contentDescription = "",
                    tint = MaterialTheme.colors.secondaryVariant
                )

                Text(
                    modifier = modifier.padding(start = 2.dp),
                    text = "1231",
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
        }

        IconButton(
            modifier = modifier
                .size(
                    height = 18.dp,
                    width = 64.dp
                )
                .constrainAs(likeButton) {
                    top.linkTo(replyButton.top)
                    start.linkTo(retweetButton.end, 8.dp)
                    end.linkTo(shareButton.start, 8.dp)
                    bottom.linkTo(replyButton.bottom)
                },
            onClick = { /*TODO*/ }
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = modifier.size(18.dp),
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = MaterialTheme.colors.secondaryVariant
                )

                Text(
                    modifier = modifier.padding(start = 2.dp),
                    text = "",
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
        }

        IconButton(
            modifier = modifier
                .size(
                    height = 18.dp,
                    width = 18.dp
                )
                .constrainAs(shareButton) {
                    top.linkTo(replyButton.top)
                    start.linkTo(likeButton.end, 8.dp)
                    end.linkTo(parent.end, 32.dp)
                    bottom.linkTo(replyButton.bottom)
                }.clickable {

                },
            onClick = { /*TODO*/ }
        ) {
            Icon(
                modifier = modifier.size(18.dp),
                imageVector = Icons.Outlined.Share,
                contentDescription = "",
                tint = MaterialTheme.colors.secondaryVariant
            )
        }
    }
}

@Preview
@Composable
fun TweetItemLightPreview() {
    CustomTwitterTheme(
        darkTheme = false
    ) {
        TweetItem(
            Modifier.background(MaterialTheme.colors.background),
            fakeTweetItem
        )
    }
}

@Preview
@Composable
fun TweetItemDarkPreview() {
    CustomTwitterTheme(
        darkTheme = true
    ) {
        TweetItem(
            Modifier.background(MaterialTheme.colors.background),
            fakeTweetItem
        )
    }
}