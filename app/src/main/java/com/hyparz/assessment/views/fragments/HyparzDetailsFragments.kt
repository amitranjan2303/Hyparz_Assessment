package com.hyparz.assessment.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hyparz.assessment.databinding.FragmentHyparzDetailsBinding
import com.hyparz.assessment.utilities.CircleTransform
import com.squareup.picasso.Picasso

class HyparzDetailsFragments : Fragment() {

    private var binding: FragmentHyparzDetailsBinding? = null
    private val args: HyparzDetailsFragmentsArgs by navArgs<HyparzDetailsFragmentsArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHyparzDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.model = args.result
        args.result.picture?.large.let {
            Picasso.get().load(it)
                .transform(CircleTransform())
                .resize(500, 500)
                .into(binding?.image)

        }
    }
}