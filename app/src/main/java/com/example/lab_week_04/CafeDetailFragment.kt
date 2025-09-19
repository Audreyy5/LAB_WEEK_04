package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val TAB_CONTENT_RES_ID = "TAB_CONTENT_RES_ID"
class CafeDetailFragment : Fragment() {
    private var content: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val contentResId = it.getInt(TAB_CONTENT_RES_ID) // Get the Int (resource ID)
            if (contentResId != 0) { // Check if a valid resource ID was passed
                content = getString(contentResId) // Get the actual string using the ID
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.content_description)
            ?.text = content
    }
    companion object {

        fun newInstance(contentResId: Int) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(TAB_CONTENT_RES_ID, contentResId) // Store as an Int
                }
            }
    }
}