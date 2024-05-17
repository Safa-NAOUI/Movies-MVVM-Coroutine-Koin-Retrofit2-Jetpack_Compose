package com.example.moviesapp

import com.example.moviesapp.data.model.MovieModel
import com.example.moviesapp.data.remote.MovieRemoteDataSource
import com.example.moviesapp.data.repository.MovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class MovieRepositoryTest {

    @Mock
    private lateinit var remoteDataSource: MovieRemoteDataSource

    private lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        movieRepository = MovieRepository(remoteDataSource)
    }

    /**
     * Test that getMovies should call remoteDataSource and return the data.
     */
    @Test
    fun `getMovies should call remoteDataSource and return the data`() {
        val page = 1
        val genreId = "action"
        val expectedMovies = listOf(
            MovieModel(
                "https://tinybeans.com/wp-content/uploads/2020/12/The-one-and-only-ivan-seattle-movies-cc-disney-plus-e1608669265978.jpeg?w=566",
                "Movie Title",
                "overview",
                0.0
            )
        )
        runBlocking {
            `when`(remoteDataSource.getMovies(page, genreId)).thenReturn(expectedMovies)
            val actualMovies = movieRepository.getMovies(page, genreId)
            assertEquals(expectedMovies, actualMovies)
        }
    }

    /**
     * Test that getMovies should propagate error from remoteDataSource.
     */
    @Test
    fun `getMovies should propagate error from remoteDataSource`() {
        val page = 1
        val genreId = "action"
        val expectedError = RuntimeException("Network Error")
        runBlocking {
            `when`(remoteDataSource.getMovies(page, genreId)).thenThrow(expectedError)
            try {
                movieRepository.getMovies(page, genreId)
                fail("An exception should have been thrown")
            } catch (e: Exception) {
                assertEquals(expectedError, e)
            }
        }
    }

    /**
     * Test that getMovies should return an empty list when no movies are found.
     */
    @Test
    fun `getMovies should return an empty list when no movies are found`() {
        val page = 1
        val genreId = "action"
        val expectedMovies = emptyList<MovieModel>()

        runBlocking {
            `when`(remoteDataSource.getMovies(page, genreId)).thenReturn(expectedMovies)
            val actualMovies = movieRepository.getMovies(page, genreId)
            assertEquals(expectedMovies, actualMovies)
        }
    }

    /**
     * Test that getMovies should return movies from multiple pages.
     */
    @Test
    fun `getMovies should return movies from multiple pages`() {
        val page1 = 1
        val page2 = 2
        val genreId = "action"
        val moviesPage1 = listOf(MovieModel("url1", "Title1", "overview1", 1.0))
        val moviesPage2 = listOf(MovieModel("url2", "Title2", "overview2", 2.0))

        runBlocking {
            `when`(remoteDataSource.getMovies(page1, genreId)).thenReturn(moviesPage1)
            `when`(remoteDataSource.getMovies(page2, genreId)).thenReturn(moviesPage2)
            val actualMoviesPage1 = movieRepository.getMovies(page1, genreId)
            val actualMoviesPage2 = movieRepository.getMovies(page2, genreId)
            assertEquals(moviesPage1, actualMoviesPage1)
            assertEquals(moviesPage2, actualMoviesPage2)
        }
    }

    /**
     * Test that getMovies should throw exception for empty genreId.
     */
    @Test(expected = IllegalArgumentException::class)
    fun `getMovies should throw exception for empty genreId`() {
        val page = 1
        val genreId = ""
        runBlocking {
            movieRepository.getMovies(page, genreId)
        }
    }

    /**
     * Test that getMovies should handle list with null values.
     */
    @Test
    fun `getMovies should handle list with null values`() {
        val page = 1
        val genreId = "action"
        val moviesWithNulls: List<MovieModel?> = listOf(
            MovieModel("url1", "Title1", "overview1", 1.0),
            null,
            MovieModel("url2", "Title2", "overview2", 2.0)
        )

        runBlocking {
            `when`(
                remoteDataSource.getMovies(
                    page,
                    genreId
                )
            ).thenReturn(moviesWithNulls as List<MovieModel>?)
            val actualMovies = movieRepository.getMovies(page, genreId)
            assertEquals(moviesWithNulls, actualMovies)
        }
    }
}