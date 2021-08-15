package com.example.codehiveregistraction

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    var name:String,
    var password:String,
    @SerializedName("phone_number") var phoneNumber:String,
    var email:String,
    var nationality:String,
    @SerializedName("date_of_number") var dob:String,
    @SerializedName("student_id") var studentId:String
)
