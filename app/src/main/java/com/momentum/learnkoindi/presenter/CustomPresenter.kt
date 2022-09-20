package com.momentum.learnkoindi.presenter

import com.momentum.learnkoindi.repository.BaseRepository


class CustomPresenter {

    private lateinit var  customRepository : BaseRepository

    constructor(baseRepository :  BaseRepository) {
        this.customRepository = baseRepository
    }

    fun sayHello() = "${customRepository.giveHello()} from $this"

}