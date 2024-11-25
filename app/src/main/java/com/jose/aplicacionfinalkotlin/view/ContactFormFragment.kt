package com.jose.aplicacionfinalkotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jose.aplicacionfinalkotlin.Contact
import com.jose.aplicacionfinalkotlin.ContactAdapter
import com.jose.aplicacionfinalkotlin.R
import com.jose.aplicacionfinalkotlin.viewmodel.ContactViewModel


class ContactFormFragment : Fragment() {
    private val viewModel: ContactViewModel by viewModels()
    private lateinit var adapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_form, container, false)

        val etName = view.findViewById<EditText>(R.id.et_name)
        val etPhone = view.findViewById<EditText>(R.id.et_phone)
        val etCity = view.findViewById<EditText>(R.id.et_city)
        val btnSave = view.findViewById<Button>(R.id.btn_save)
        val rvContacts = view.findViewById<RecyclerView>(R.id.rv_contacts)

        adapter = ContactAdapter(
            onEdit = { contact ->
                etName.setText(contact.name)
                etPhone.setText(contact.phone)
                etCity.setText(contact.city)
                viewModel.delete(contact)
            },
            onDelete = { contact ->
                viewModel.delete(contact)
                Toast.makeText(context, "Contacto eliminado", Toast.LENGTH_SHORT).show()
            }
        )

        rvContacts.layoutManager = LinearLayoutManager(context)
        rvContacts.adapter = adapter

        viewModel.allContacts.observe(viewLifecycleOwner) { contacts ->
            adapter.submitList(contacts)
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val phone = etPhone.text.toString()
            val city = etCity.text.toString()

            if (name.isNotBlank() && phone.isNotBlank() && city.isNotBlank()) {
                viewModel.insert(Contact(name = name, phone = phone, city = city))
                etName.text.clear()
                etPhone.text.clear()
                etCity.text.clear()
                Toast.makeText(context, "Contacto guardado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}