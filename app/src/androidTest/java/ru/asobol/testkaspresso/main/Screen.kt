package ru.asobol.testkaspresso.main

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.asobol.testkaspresso.R

abstract class KScreen<out T : KScreen<T>> : Screen<T>() {

    abstract val layoutId: Int?
    abstract val viewClass: Class<*>?
}

object MainScreen : KScreen<MainScreen>() {

        override val layoutId = R.layout.activity_main
        override val viewClass: Class<*>? = MainActivity::class.java

        val button = KButton { withId(R.id.testButton) }

        val text = KTextView { withId(R.id.testTextView) }
}