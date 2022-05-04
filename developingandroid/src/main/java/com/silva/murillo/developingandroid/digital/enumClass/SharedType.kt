package com.silva.murillo.developingandroid.digital.enumClass

import com.silva.murillo.developingandroid.R

enum class SharedType(icProgramFile: Int, title: Int) {
    EMAILSHARED(R.drawable.ic_email, R.string.email_Preferend),
    WPPMENSAGEM(R.drawable.ic_baseline_mode_comment_24, R.string.wpp_Preferend),
    OTHERSHARED(R.drawable.ic_generic_shared, R.string.others_Preferend);

    companion object {
        fun listShared(): MutableList<SharedType> {
            val sharedTypeList = mutableListOf<SharedType>()
            sharedTypeList.add(EMAILSHARED)
            sharedTypeList.add(WPPMENSAGEM)
            sharedTypeList.add(OTHERSHARED)
            return sharedTypeList
        }
    }

}