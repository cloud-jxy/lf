package com.jocker.jlife.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jocker.jlife.databinding.FragmentInTheaterDetailBinding
import com.jocker.jlife.utilties.InjectUtil


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"

/**
 * A simple [Fragment] subclass.
 * Use the [InTheaterDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class InTheaterDetailFragment : Fragment() {
    private var mId: Int? = null
    var mBinding: FragmentInTheaterDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mId = it.getInt(ARG_PARAM1)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = FragmentInTheaterDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return mBinding?.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val detailViewModel = ViewModelProviders
                .of(this, InjectUtil.getDetailFragmentProviderFactory(mId!!))
                .get(DetailViewModel::class.java)
        mBinding!!.vm = detailViewModel
    }
}
