package com.dapm.registrocriminal.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.dapm.registrocriminal.databinding.FragmentCrimenBinding
import com.dapm.registrocriminal.model.Crimen
import java.util.Date
import java.util.UUID

class CrimenFragment : Fragment() {

    private lateinit var crimen: Crimen

    private var _binding: FragmentCrimenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crimen = Crimen(
            id = UUID.randomUUID(),
            titulo = "",
            fecha = Date(),
            resuelto = false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrimenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtTituloCrimen.doOnTextChanged { texto, _, _, _ ->
            crimen = crimen.copy(titulo = texto?.toString().orEmpty())
        }

        binding.btnFechaCrimen.apply {
            text = crimen.fecha.toString()
            isEnabled = false
        }

        binding.chkCrimenResuelto.setOnCheckedChangeListener { _, seleccionado ->
            crimen = crimen.copy(resuelto = seleccionado)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}