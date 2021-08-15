package com.example.codehiveregistraction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.codehiveregistraction.ApiClient.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LogInCtivity : AppCompatActivity() {
    lateinit var etemail:EditText
    lateinit var etpassword:EditText
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_ctivity)
        etemail=findViewById(R.id.etemail)
        etpassword=findViewById(R.id.etpass)
        button=findViewById(R.id.button)

        button.setOnClickListener {
            var email = etemail.text.toString()
            if (email.isEmpty()) {
                etemail.setError("enter name")
            }
            var dob = etpassword.text.toString()
            if (dob.isEmpty()) {
                etpassword.setError("enter your password")
            }

            var rbutton = button.text.toString()
            if (rbutton.isEmpty()) {
                button.setError("Enter Id number")
            }
            var intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)
        }
        var retrofite=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.registerStudent(retrofite)
        request.enqueue(object : Callback<RegistrationResponse> {

            override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, "Your registration is successful", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
fun View.visible(isVisible:Boolean){
    visibility=if (isVisible) View.VISIBLE else View.GONE
}
fun View.enable(enabled:Boolean){
    isEnabled=enabled
}





private fun Retrofit.registerStudent(retrofite: ApiInterface){


}
