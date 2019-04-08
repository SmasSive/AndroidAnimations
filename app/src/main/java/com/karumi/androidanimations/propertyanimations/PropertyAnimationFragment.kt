package com.karumi.androidanimations.propertyanimations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.recyclical.datasource.dataSourceOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.karumi.androidanimations.R
import com.karumi.androidanimations.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_property_animation.*


class PropertyAnimationFragment : BaseFragment() {

    val propertySimpleAnimationBinder = PropertySimpleAnimation.Binder(::requireContext)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_view_animation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureAllAnimations()
    }

    private fun configureAllAnimations() {
        val layoutManager = LinearLayoutManager(requireContext())
        val dataSource = dataSourceOf(
            PropertyAnimation.Translate,
            PropertyAnimation.Path
        )

        allAnimations.setup {
            withLayoutManager(layoutManager)
            withDataSource(dataSource)

            withItem<PropertyAnimation>(R.layout.view_simple_property_animation) {
                onBind(PropertySimpleAnimation::VH) { _, item ->
                    propertySimpleAnimationBinder(this, item)
                }
            }
        }
    }

    enum class PropertyAnimation {
        Translate, Path
    }
}