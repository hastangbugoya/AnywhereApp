package com.example.anywhereapp.network

import com.example.myanywhereapplication.simpsons.model.APIResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Response

class MyRetrofitTest {
    @Test
    fun `test Retrofit base URL`() {
        val retrofit = MyRetrofit.MakeRetrofit()
        val baseUrl = retrofit.baseUrl().toString()
        assert(baseUrl == "http://api.duckduckgo.com/")
    }

    @Test
    fun `test Retrofit service`() {
        runBlocking {
            val response: Response<APIResponse> = MyRetrofit.getService().getCharacters()
            assert(response.isSuccessful)
            assertNotNull(response.body())
        }
    }

    @Test
    fun `test RetrofitService interface`() {
        val service = MyRetrofit.getService()
        assertTrue(service is RetrofitService)
    }
}