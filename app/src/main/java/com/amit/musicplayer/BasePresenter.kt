package com.amit.musicplayer


/*<V : com.amit.musicplayer.BaseView>: This is a type parameter declaration.
It means that the class is generic, and the generic type V must be a subtype
of com.amit.musicplayer.BaseView. The angle brackets (< >) denote the declaration of a generic type.

constructor(val view: V): This is the primary constructor of the class.
It takes a single parameter named view, of type V. The val keyword denotes that view is a read-only property.*/
abstract class BasePresenter<V : com.amit.musicplayer.BaseView> constructor(val view: V)