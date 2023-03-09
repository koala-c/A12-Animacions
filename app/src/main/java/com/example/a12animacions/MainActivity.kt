package com.example.a12animacions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.animation.doOnRepeat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.a12animacions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        splashScreen.setKeepOnScreenCondition{false}

        binding.pilotaPlatja.setOnClickListener { startAnimation() }
    }

    private fun startAnimation(){
        val end = binding.constraintLayout.right * 0.8f
        val top = binding.constraintLayout.height * 0.88f
        val left = binding.constraintLayout.left * 0.8f
        val down = binding.constraintLayout.minHeight * 0.8f
        val finishPos = binding.constraintLayout.right / 2.5f
        val animatorToRight = ObjectAnimator.ofFloat(binding.pilotaPlatja, "translationX", end)
        val animatorToTop = ObjectAnimator.ofFloat(binding.pilotaPlatja, "translationY", -top)
        val animatorToLeft = ObjectAnimator.ofFloat(binding.pilotaPlatja, "translationX", -left)
        val animatorDown = ObjectAnimator.ofFloat(binding.pilotaPlatja, "translationY", down)
        val animatorFinishMiddle = ObjectAnimator.ofFloat(binding.pilotaPlatja, "translationX", finishPos)
        val animatorFinishTop = ObjectAnimator.ofFloat(binding.pilotaPlatja, "translationY", -top)
        animatorToRight.duration = 1000
        animatorToTop.duration = 1000
        animatorToLeft.duration = 1000
        animatorDown.duration = 1000
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(animatorToRight, animatorToTop, animatorToLeft, animatorDown, animatorFinishMiddle, animatorFinishTop)
        animatorSet.start()
    }

}
