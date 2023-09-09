package com.phanupan.domain

import base_model.BaseResult
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import model.MovieModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import repository.MovieRepository
import usecase.GetMoviesUseCase

class GetMoviesUseCaseTest {

    private lateinit var useCase: GetMoviesUseCase
    private lateinit var repository: MovieRepository
    private val mockMovies = listOf(
        MovieModel(
            id = 1,
            title = "Movie Title 1",
            posterUrl = "https://example.com/poster1.jpg",
            moveType = "Action",
            releaseDate = "2023-09-09",
            detail = "This is a sample movie."
        ),
        MovieModel(
            id = 2,
            title = "Movie Title 2",
            posterUrl = "https://example.com/poster2.jpg",
            moveType = "Comedy",
            releaseDate = "2023-09-10",
            detail = "Another sample movie."
        )
    )

    @Before
    fun setUp() {
        repository = mock(MovieRepository::class.java)
        useCase = GetMoviesUseCase(repository)
    }

    @Test
    fun `test success case`() = runBlocking {
        `when`(repository.getMovies()).thenReturn(flowOf(BaseResult.Success(mockMovies)))
        val result = useCase.invoke()
        assertEquals(result.first(), BaseResult.Success(mockMovies))
    }

    @Test
    fun `test error case`() = runBlocking {
        val errorMessage = "An error occurred"
        val errorCode = 999

        `when`(repository.getMovies()).thenReturn(flowOf(BaseResult.Error(errorCode, errorMessage)))
        val result = useCase.invoke()
        assertEquals(result.first(), BaseResult.Error(errorCode, errorMessage))
    }


}