package com.m7amdelbana.hanginkotlin.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.m7amdelbana.hanginkotlin.R
import com.m7amdelbana.hanginkotlin.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private var viewModel: ProfileViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_profile)
        initBinding()
    }

    private fun initBinding() {
        val binding =
            DataBindingUtil
                .setContentView<ActivityProfileBinding>(this,
                    R.layout.activity_profile)

        viewModel = ViewModelProviders.of(this)
            .get(ProfileViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel
    }
}
