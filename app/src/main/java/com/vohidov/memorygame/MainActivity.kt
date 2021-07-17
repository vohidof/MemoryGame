package com.vohidov.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var count = -1
    var hasImageOpened = 0
    var imageOpened = -1
    var imageOpenedFram = -1
    var animationProccess = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rasmlar = arrayListOf<Int>(
                R.drawable.img1, R.drawable.img2,
                R.drawable.img3
        )
        val frames = arrayListOf<FrameLayout>(frm1, frm2, frm3, frm4, frm5, frm6)
        val images = arrayListOf<ImageView>(image1, image2, image3, image4, image5, image6)


        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.image_animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                images[countFram].setImageResource(rasmlar[count])
                val animation2 =
                        AnimationUtils.loadAnimation(this@MainActivity, R.anim.image_animation2)
                frames[countFram].startAnimation(animation2)

                animation2.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        println("hasRasmOchildi=$hasImageOpened, ramOchildi=$imageOpened")
                        println("count=$count ")
                        if (hasImageOpened == 2 && imageOpened == count && imageOpenedFram != countFram) {

                            val animationOlibTashlash =
                                    AnimationUtils.loadAnimation(
                                            this@MainActivity,
                                            R.anim.image_animation
                                    )

                            frames[imageOpenedFram].startAnimation(animationOlibTashlash)
                            frames[countFram].startAnimation(animationOlibTashlash)

                            animationOlibTashlash.setAnimationListener(object :
                                    Animation.AnimationListener {
                                override fun onAnimationRepeat(animation: Animation?) {

                                }

                                override fun onAnimationEnd(animation: Animation?) {
                                    frames[imageOpenedFram].visibility = View.INVISIBLE
                                    frames[countFram].visibility = View.INVISIBLE
                                    hasImageOpened = 0
                                    imageOpened = -1
                                    animationProccess = false
                                }

                                override fun onAnimationStart(animation: Animation?) {
                                    animationProccess = true
                                }

                            })


                        } else {
                            println("else =====")
                            if (hasImageOpened == 2) {
                                println("else if ====")

                                val animationNext = AnimationUtils.loadAnimation(
                                        this@MainActivity,
                                        R.anim.image_animation2
                                )
                                frames[imageOpenedFram].startAnimation(animationNext)
                                if (imageOpenedFram != countFram)
                                    frames[countFram].startAnimation(animationNext)
                                images[imageOpenedFram].setImageResource(R.drawable.ic_star)
                                images[countFram].setImageResource(R.drawable.ic_star)
                                hasImageOpened = 0
                                imageOpened = -1
                                animationNext.setAnimationListener(object :
                                        Animation.AnimationListener {
                                    override fun onAnimationRepeat(animation: Animation?) {
                                    }

                                    override fun onAnimationEnd(animation: Animation?) {
                                        animationProccess = false
                                    }

                                    override fun onAnimationStart(animation: Animation?) {
                                    }

                                })
                            }
                        }
                        animationProccess = false
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }

                })


            }

            override fun onAnimationStart(animation: Animation?) {
                animationProccess = true
            }
        })


        var imageNumber = -1

        frm1.setOnClickListener {
            if (!animationProccess) {
                if (imageOpened == -1) {
                    imageOpened = 0
                    imageOpenedFram = 0
                }

                hasImageOpened++
                count = 0
                countFram = 0
                frames[0].startAnimation(animation)
                imageNumber = 0
                imageNumber = 0
            }
        }
        frm2.setOnClickListener {
            if (!animationProccess) {
                if (imageOpened == -1) {
                    imageOpened = 1
                    imageOpenedFram = 1
                }

                hasImageOpened++
                count = 1
                countFram = 1
                frames[1].startAnimation(animation)
                imageNumber = 1
            }
        }
        frm3.setOnClickListener {
            if (!animationProccess) {
                if (imageOpened == -1) {
                    imageOpened = 2
                    imageOpenedFram = 2
                }

                hasImageOpened++
                count = 2
                countFram = 2
                frames[2].startAnimation(animation)
                imageNumber = 2
            }
        }
        frm4.setOnClickListener {
            if (!animationProccess) {
                if (imageOpened == -1) {
                    imageOpened = 0
                    imageOpenedFram = 3
                }

                hasImageOpened++
                count = 0
                countFram = 3
                frames[3].startAnimation(animation)
                imageNumber = 3
            }
        }
        frm5.setOnClickListener {
            if (!animationProccess) {
                if (imageOpened == -1) {
                    imageOpened = 1
                    imageOpenedFram = 4
                }

                hasImageOpened++
                count = 1
                countFram = 4
                frames[4].startAnimation(animation)
                imageNumber = 4
            }
        }
        frm6.setOnClickListener {
            if (!animationProccess) {
                if (imageOpened == -1) {
                    imageOpened = 2
                    imageOpenedFram = 5
                }

                hasImageOpened++
                count = 2
                countFram = 5
                frames[5].startAnimation(animation)
                imageNumber = 5
            }
        }
    }

    var countFram = -1

    fun randomSon(n: Int): Int {
        return Random().nextInt(n)
    }
}