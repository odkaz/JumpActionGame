package jp.techacademy.kazuma.noda.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Blackhole(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
: GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object {
        val BLACKHOLE_WIDTH = 1f
        val BLACKHOLE_HEIGHT = 1f

        val BLACKHOLE_EXIST = 1
        val BLACKHOLE_GONE = 0
    }

    var mState = BLACKHOLE_EXIST

    init {
        setSize(BLACKHOLE_WIDTH, BLACKHOLE_HEIGHT)
    }

    fun update(delta: Float) {


        if (y < 0) {
            mState = BLACKHOLE_GONE
        }


    }

}