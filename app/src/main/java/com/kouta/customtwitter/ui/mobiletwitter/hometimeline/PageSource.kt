package com.kouta.customtwitter.ui.mobiletwitter.hometimeline

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kouta.customtwitter.model.Tweet


class PageSource(
    private val tweets: List<Tweet>
): PagingSource<Int, Tweet>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Tweet> {
        return try {
            val page = params.key ?: 1
            val photoResponse = tweets
            LoadResult.Page(
                data = photoResponse,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Tweet>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

}