package com.karumi.androidanimations.pathdrawing

import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.karumi.androidanimations.R
import com.karumi.androidanimations.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_path_drawing.*

class PathDrawingFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_path_drawing, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val widthPixels = displayMetrics.widthPixels.toFloat()
        val heightPixels = widthPixels

        val w2 = widthPixels / 2
        val h2 = heightPixels / 2

        val apply = Path().apply {
            moveTo(w2, 0f)
            addArc(RectF(w2, -h2, widthPixels + w2, h2), -180f, -90f)
            lineTo(w2, heightPixels)
            quadTo(w2, h2, 0f, h2)
            lineTo(w2, 0f)
        }

        paintView += apply to Color.RED
    }
}