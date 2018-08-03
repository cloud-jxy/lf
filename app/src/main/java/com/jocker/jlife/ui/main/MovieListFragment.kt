package com.jocker.jlife.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jocker.jlife.R
import com.jocker.jlife.adapters.InTheaterAdapter
import com.jocker.jlife.databinding.MainFragmentBinding
import com.jocker.jlife.utilties.InjectUtil

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    private lateinit var viewModel: MovieViewModel
    private var bindingUtil: MainFragmentBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        bindingUtil = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return bindingUtil!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this@MovieListFragment, InjectUtil.getMainFragmentProviderFactory())
                .get(MovieViewModel::class.java)
        val inTheaterAdapter = InTheaterAdapter()
//        在 xml 文件中设置 layoutManger
        bindingUtil!!.mainFragmentRv.adapter = inTheaterAdapter
//        bindingUtil?.mainFragmentSrl?.setOnRefreshListener { viewModel.getInTheaterMovies() }
//        viewModel.getInTheaterMovies()
        viewModel.subjectsBean.observe(viewLifecycleOwner, Observer { subjects ->
            if (subjects.isNotEmpty())
                inTheaterAdapter.submitList(subjects)
            bindingUtil?.mainFragmentPb?.visibility = View.GONE
//            bindingUtil?.mainFragmentSrl?.isRefreshing = false
        })
    }
}
