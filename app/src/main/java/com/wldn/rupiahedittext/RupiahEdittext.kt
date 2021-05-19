package com.wldn.rupiahedittext

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import java.text.NumberFormat
import java.util.*


/**
Created by Wildan Nafian on 03 May 2021
Contact me on  Wildanafian8@gmail.com
 **/


class RupiahEdittext : AppCompatEditText {
    private val editText = this
    private var tempString = ""
    private var local = Locale("id", "ID")
    private val replaceable = String.format("[Rp,.\\s]", NumberFormat.getCurrencyInstance(local))
    private var rupiah = true

    var rawValue = ""

    constructor(context: Context?) : super(context!!) { init() }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) { init() }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) { init() }

    fun setCurrency(value: Boolean) {
        rupiah = value
    }

    private fun init() {
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.filters = arrayOf(InputFilter.LengthFilter(21))
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
                if (s.toString() != tempString) {
                    editText.removeTextChangedListener(this)

                    val cleanString = s.toString().replace(replaceable.toRegex(), "")

                    val parsed = try {
                        cleanString.toDouble()
                    } catch (e: NumberFormatException) {
                        0.00
                    }

                    val formatted = if (rupiah) {
                        if (parsed == 0.00) "" else {
                            NumberFormat.getCurrencyInstance(local).apply {
                                maximumFractionDigits = 0
                                isParseIntegerOnly = true
                            }.format(parsed)
//                            val formatter = NumberFormat.getCurrencyInstance(local)
//                            formatter.maximumFractionDigits = 0
//                            formatter.isParseIntegerOnly = true
//                            formatter.format(parsed)
                        }
                    } else {
                        if (parsed == 0.00) "" else NumberFormat.getIntegerInstance(Locale.GERMANY).format(parsed)
                    }

                    rawValue = cleanString
                    tempString = formatted
                    editText.setText(formatted)
                    editText.setSelection(formatted.length)
                    editText.addTextChangedListener(this)
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }
}