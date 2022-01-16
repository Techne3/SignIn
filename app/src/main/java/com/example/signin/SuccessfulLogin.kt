package com.example.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.signin.databinding.SuccessBinding

class SuccessfulLogin : Fragment() {


    // ? after type means nullable
    private var _binding: SuccessBinding? = null
    // !! asserting non null, don't do too often can cause NPE(null pointer exception)
    private val binding: SuccessBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SuccessBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle()

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, ErrorPage::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}