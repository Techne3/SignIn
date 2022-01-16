package com.example.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.signin.databinding.ErrorPageBinding

class ErrorPage : Fragment() {


    // ? after type means nullable
    private var _binding: ErrorPageBinding? = null
    // !! asserting non null, don't do too often can cause NPE(null pointer exception)
    private val binding: ErrorPageBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ErrorPageBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle()

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, SignIn::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}