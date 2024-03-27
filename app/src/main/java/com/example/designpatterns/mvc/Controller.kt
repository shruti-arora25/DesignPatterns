package com.example.designpatterns.mvc

class Controller(var modal: modal, var view:view) {


//    fun getName():String{
//        return modal.name
//    }
//    fun getroll():String{
//        return modal.rollNo
//    }



    fun setName(namee:String){
        modal.name=namee
    }

    fun setRoll(roll:String){
        modal.rollNo=roll
    }

    fun updateView(){
        view.printDetails(modal.name,modal.rollNo)
    }




}