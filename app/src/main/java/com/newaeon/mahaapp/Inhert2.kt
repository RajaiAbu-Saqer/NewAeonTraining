package com.newaeon.mahaapp

import android.view.View

class Inhert2: Inhert1(1) {

    var obj=Inhert1(1)
    fun call(){
        obj.firstFunction(object :InterfaceTest{
            override fun maha() {
                TODO("Not yet implemented")
            }
        })

        itemButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }
        })
    }

    companion object

    override fun thirdFunction() {
        TODO("Not yet implemented")
    }

    override fun firstFunction() {
        super.firstFunction()
    }
}