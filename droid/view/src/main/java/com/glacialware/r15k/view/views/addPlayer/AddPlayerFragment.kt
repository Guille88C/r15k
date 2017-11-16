package com.glacialware.r15k.view.views.addPlayer

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.Components.CustomToast
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.FragmentAddPlayerBinding
import com.glacialware.r15k.view.di.CustomToastComponent
import com.glacialware.r15k.view.di.CustomToastModule
import com.glacialware.r15k.view.di.DaggerCustomToastComponent
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.viewmodel.views.addPlayer.AddPlayerViewModel
import javax.inject.Inject

/**
 * Created by Guille on 10/07/2017.
 */
class AddPlayerFragment : GenericRootFragment() {
    companion object {
        @JvmStatic
        val TAG : String = this :: class.java.canonicalName

        @JvmStatic
        fun newInstance() : AddPlayerFragment {
            val f = AddPlayerFragment()
            val args = Bundle()
            f.arguments = args
            return f
        }
    }

    private val mCustomToastComponent: CustomToastComponent by lazy {
        DaggerCustomToastComponent
                .builder()
                .customToastModule(CustomToastModule(this.activity))
                .build()
    }

    @field:[Inject]
    lateinit var mCustomToast : CustomToast

    private lateinit var binding : FragmentAddPlayerBinding
    private lateinit var viewModel : AddPlayerViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // dagger
        mCustomToastComponent.inject(this)
        // ----
        // view model
        viewModel = ViewModelProviders.of(this).get(AddPlayerViewModel::class.java)
        viewModel.setToast(mCustomToast)
        lifecycle.addObserver(viewModel)
        // ----
        // data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_player, container, false)
        binding.viewModel = viewModel
        // ----
        return binding.root
    }

//    fun initAddPlayer() {
////        this.addPlayerB.setOnClickListener({
////            navigateTo(this.activity.supportFragmentManager, TestFragment.newInstance(), TestFragment.TAG, R.id.activity_add_player_content_frame, false, true)
////        })
//        addPlayerB.setOnClickListener {
//            view ->
//            viewModel.addPlayer()
//        }
//    }
}