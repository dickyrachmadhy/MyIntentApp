package com.example.myflexiblefragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_option_dialog.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"





/**
 * A simple [Fragment] subclass.
 * Use the [OptionDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OptionDialogFragment : DialogFragment() {

    // kenalkan obyek yang ada di dalam layout
    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOption: RadioGroup
    private lateinit var rbMetronet: RadioButton
    private lateinit var rbHome: RadioButton
    private lateinit var rbGio: RadioButton
    private lateinit var rbDataCenter: RadioButton
    private lateinit var rbWifi: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose =view.findViewById(R.id.btn_choose)
        btnClose =view.findViewById(R.id.btn_close)
        rgOption =view.findViewById(R.id.rg_options)
        rbMetronet =view.findViewById(R.id.rb_metronet)
        rbHome =view.findViewById(R.id.rb_home)
        rbGio =view.findViewById(R.id.rb_gio)
        rbDataCenter =view.findViewById(R.id.rb_data_center)
        rbWifi =view.findViewById(R.id.rb_wifi)

        btn_choose.setOnClickListener{
            val checkedRadioButtonId = rgOption.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var product: String? = null
                when (checkedRadioButtonId) {
                    R.id.rb_metronet -> product = rbMetronet.text.toString().trim()
                    R.id.rb_home -> product = rbHome.text.toString().trim()
                    R.id.rb_gio -> product = rbGio.text.toString().trim()
                    R.id.rb_data_center -> product = rbDataCenter.text.toString().trim()
                    R.id.rb_wifi -> product = rbWifi.text.toString().trim()
                }
//                Log.d("TAG","${rb_metronet.setOnClickListener()}")
                optionDialogListener?.onOptionChosen(product)
                dialog?.dismiss()
            }
        }
        btn_close.setOnClickListener{
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OptionDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OptionDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}