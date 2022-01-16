package com.example.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.core.widget.addTextChangedListener
import com.example.signin.databinding.SignInPageBinding

class SignIn : Fragment() {


    private var firstNameCheck = "tim@mail.com"
    private var passwordCheck = "1234"

    // ? after type means nullable
    private var _binding: SignInPageBinding ? = null
    // !! asserting non null, don't do too often can cause NPE(null pointer exception)
    private val binding: SignInPageBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignInPageBinding.inflate(inflater, container, false)
        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            firstNameEt.editText?.addTextChangedListener { text ->
                nextBtn.isEnabled = text.toString().isNotEmpty()

            }

            nextBtn.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("First", firstNameEt.editText?.text.toString())
                bundle.putString("Password", passWordEt.editText?.text.toString())

                if ("First" === firstNameCheck && "Password" === passwordCheck) {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, SuccessfulLogin::class.java, bundle)
                        .addToBackStack(null)
                        .commit()


                } else {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, ErrorPage::class.java, bundle)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}