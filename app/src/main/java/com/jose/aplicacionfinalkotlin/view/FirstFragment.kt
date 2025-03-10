package com.jose.aplicacionfinalkotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jose.aplicacionfinalkotlin.R


class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root=inflater.inflate(R.layout.fragment_first, container, false)

        val btnGrabadora=root.findViewById<Button>(R.id.btnGrabadora)
        val btnCamara=root.findViewById<Button>(R.id.btnCamara)
        val btnRoom=root.findViewById<Button>(R.id.btnRoom)


        btnGrabadora.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_grabadoraFragment)
        }
        btnCamara.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_camera)
        }
        btnRoom.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_contactFormFragment)
        }

        return root
        }


}