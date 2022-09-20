package com.momentum.learnkoindi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.momentum.learnkoindi.MainAndroidViewModel
import com.momentum.learnkoindi.MainViewModel
import com.momentum.learnkoindi.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Lazy injected MainViewModel
    private val mainViewModel : MainViewModel by viewModel()
    private val mainAndroidViewModel : MainAndroidViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.sayHello().observe(this) { data ->
            text_view_result_view_model.text = data
        }

        mainAndroidViewModel.sayHello().observe(this) { data ->
            text_view_result_android_view_model.text = data
        }
    }
}
