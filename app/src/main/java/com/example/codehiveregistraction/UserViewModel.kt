package com.example.codehiveregistraction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel:ViewModel(){
    var userRepository=UserRepository()
    var registationLiveData=UserRepository()

 fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            userRepository.registerUser(registrationRequest)
        }

 }

}
//launch is the one that launch crutine and it is launched in the scope
//thread is the process
//view model is the one that launches crutine and it's launched in it's scope so that in case viewmodel is destoyed even crutine will stop.
// Dispach swiches the context of crutine to allow it to work on io thread which is running on the ui thread.