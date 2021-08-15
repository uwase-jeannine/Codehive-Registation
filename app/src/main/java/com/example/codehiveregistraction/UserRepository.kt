package com.example.codehiveregistraction

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
   suspend  fun registerUser(registrationRequest: RegistrationRequest): Response<RegistrationResponse> =
        withContext(Dispatchers.IO) {
            var response = apiInterface.registerStudent(registrationRequest)

            return@withContext response
        }
}
