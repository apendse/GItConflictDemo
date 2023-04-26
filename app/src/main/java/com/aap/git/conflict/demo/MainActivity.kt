package com.aap.git.conflict.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aap.git.conflict.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList()
    }

    private fun initList() {
        binding.elements.layoutManager = LinearLayoutManager(this)
        val adapter = ElementAdapter()
        binding.elements.adapter = adapter
        adapter.submitList(Element.values().toMutableList())

    }
}