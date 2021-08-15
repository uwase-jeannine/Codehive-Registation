package com.example.codehiveregistraction


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.core.app.ActivityManagerCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var etname:EditText
    lateinit var etdob: EditText
    lateinit var etNationality: Spinner
    lateinit var etPassword: EditText
    lateinit var etPhoneNumber : EditText
    lateinit var etEmail: EditText
    lateinit var btnRegister: Button
    lateinit var progress:ProgressBar
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSpinner()


        etname=findViewById(R.id.etname)
        etdob=findViewById(R.id.etdob)
        etNationality=findViewById(R.id.spinner)
        etPhoneNumber=findViewById(R.id.etPhone)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etpass)
        btnRegister=findViewById(R.id.btnRegister)
        progress=findViewById(R.id.progressBar)

        btnRegister.setOnClickListener {
            var name =  etname.text.toString()
            if (name.isEmpty()){
                etname.setError("enter name")

            }
            progress.visibility
            var nationality = etNationality.selectedItem.toString().toUpperCase()
            if (nationality.isEmpty()){

            }

            var dob= etdob.text.toString()
            if (dob.isEmpty()){
                etdob.setError("enter Date of birth")
            }

            var IdNumber= etPassword.text.toString()
            if (IdNumber.isEmpty()){
                etPassword.setError("Enter Id number")
            }
            var phoneNumber= etPhoneNumber.text.toString()
            if (phoneNumber.isEmpty()){
                etPhoneNumber.setError("Enter phone number")
            }
            var email = etEmail.text.toString()
            if(email.isEmpty()){
                etEmail.setError("enter email")
            }
            //var details = Details(name, dob, IdNumber, phoneNumber, email)
            val intent= Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)
            var regRequest=RegistrationRequest(name = name,password = IdNumber, phoneNumber = phoneNumber,email = email,
                dob = dob,nationality = nationality
            )
            var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
            var request= retrofit.registerStudent(regRequest)
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

    fun setupSpinner(){

        etname = findViewById(R.id.etname)
        etdob= findViewById(R.id.etdob)
        etNationality= findViewById(R.id.spinner)
        etPassword= findViewById(R.id.etpass)
        etPhoneNumber = findViewById(R.id.etPhone)
        etEmail= findViewById(R.id.etPhone)
        btnRegister= findViewById(R.id.btnRegister)

        var nationalities= arrayListOf("Kenyan","Rwandan","SouthSudanese","Sudanese","Rwandan","Ugandan")
        var nationalitiesAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_dropdown_item,nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        etNationality.adapter=nationalitiesAdapter



    }
}

class CoursesActivity {

}
//fatorydesign patten
