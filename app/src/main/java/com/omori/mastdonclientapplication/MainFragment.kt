package com.omori.mastdonclientapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.omori.mastdonclientapplication.databinding.FragmentMainBinding
import retrofit2.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        private val TAG = MainFragment::class.java.simpleName
        private const val API_BASE_URL = "https://androidbook2020.keiji.io"
    }

    private val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .build()

    private val api = retrofit.create(MastdonApi::class.java)

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind(view)
        binding?.button?.setOnClickListener {
            binding?.button?.text  = "clicked"
            CoroutineScope(Dispatchers.IO).launch {
                val response = api.fetchPublicTimeLine().string()
                Log.d(TAG, response)
                withContext(Dispatchers.Main) {
                    binding?.button?.text = response
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding?.unbind()

    }

}