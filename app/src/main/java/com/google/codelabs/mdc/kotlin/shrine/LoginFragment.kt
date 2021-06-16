package com.google.codelabs.mdc.kotlin.shrine

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.codelabs.mdc.kotlin.shrine.databinding.ShrLoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: ShrLoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.shr_login_fragment,
            container,
            false
        )

        binding.run {
            nextButton.setOnClickListener {
                if (!isPasswordValid(passwordEditText.text)) {
                    passwordTextInput.error = getString(R.string.shr_error_password)
                } else {
                    passwordTextInput.error = null
                    (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
                }
            }

            passwordEditText.setOnKeyListener { _, _, _ ->
                if (isPasswordValid(passwordEditText.text)) {
                    passwordTextInput.error = null
                }
                false
            }
        }
        return binding.root
    }

    private fun isPasswordValid(text: Editable?) = text != null && text.length >= 8
}
