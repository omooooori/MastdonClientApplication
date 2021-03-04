package com.omori.mastdonclientapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import com.omori.mastdonclientapplication.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)
        binding?.textView?.text = "Hello Fragment"

    }

    override fun onDestroy() {
        super.onDestroy()

        binding?.unbind()

    }

}