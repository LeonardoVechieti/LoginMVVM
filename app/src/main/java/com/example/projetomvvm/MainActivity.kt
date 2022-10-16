package com.example.projetomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.projetomvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonLogin.setOnClickListener(this)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setObservers()
    }

    private fun setObservers() {
        viewModel.welcome().observe(this) {
            binding.titleLogin.text = it
        }
        viewModel.login().observe(this) {
            if (it) {
               Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_login) {
            val email = binding.editUser.text.toString()
            val password = binding.editPassword.text.toString()
            viewModel.doLogin(email, password)

        }
    }
}