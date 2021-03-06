package com.sih.conduitclone.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sih.conduitclone.data.UserRepo
import io.realworld.api.models.entities.User
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
     //private is mutable because people can not override from outside
     private val _user = MutableLiveData<User>()
     val user : LiveData<User> = _user

     fun login(email: String, password: String) = viewModelScope.launch {
          UserRepo.login(email, password)?.let {
               _user.postValue(it.user)
          }
     }
}