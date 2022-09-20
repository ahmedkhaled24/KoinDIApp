package com.momentum.learnkoindi.repository

class CustomRepository: BaseRepository {


    override fun giveRepository(): String {
        return this.toString()
    }

    override fun giveHello(): String {
        return "Hello KOIN"
    }
}