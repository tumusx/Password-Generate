package com.silva.murillo.developingandroid.digital.views.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.silva.murillo.developingandroid.databinding.FragmentBottomSheetListListDialogBinding
import com.silva.murillo.developingandroid.databinding.FragmentBottomSheetListListDialogItemBinding

class BottomSheetList : BottomSheetDialogFragment() {
    val TAG = "BUTTOMSHEETLIST"
    private var _binding: FragmentBottomSheetListListDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetListListDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureClicks()
    }

    private fun configureClicks(): Boolean {
        binding.buttonClose.setOnClickListener {
            dismiss()
        }
        return true
    }

    private inner class ViewHolder internal constructor(binding: FragmentBottomSheetListListDialogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        internal val text: TextView = binding.text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}