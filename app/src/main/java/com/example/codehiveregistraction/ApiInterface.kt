package com.example.codehiveregistraction

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {
@POST("student/register")

 suspend fun registerStudent(@Body registrationRequest: RegistrationRequest):Response<RegistrationResponse>
}
