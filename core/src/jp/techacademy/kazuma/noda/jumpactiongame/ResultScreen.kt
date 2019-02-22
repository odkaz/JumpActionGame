package jp.techacademy.kazuma.noda.jumpactiongame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class ResultScreen (private val mGame: JumpActionGame, private val mScore: Int): ScreenAdapter(){
    companion object {
        val WORLD_WIDTH = 320f
        val WORLD_HEIGHT = 480f
    }

    private var mGuiCamera: OrthographicCamera
    private val mSprite: Sprite
    private var mViewport: Viewport
    private val mFont: BitmapFont


    init {
        if (mGame.mRequestHandler != null) {
            println("requestHandler")
            mGame.mRequestHandler.showAds(true)
        } else {
            println("requestHandler null")
        }


        mSprite = Sprite(Texture(Gdx.files.internal("resultback.png")), 0, 0, 540, 810)
        mSprite.setSize(WORLD_WIDTH, WORLD_HEIGHT)
        mSprite.setPosition(0f, 0f)

        mGuiCamera = OrthographicCamera()
        mGuiCamera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT)
        mViewport = FitViewport(WORLD_WIDTH, WORLD_HEIGHT, mGuiCamera)

        mFont = BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false)
        mFont.data.setScale(0.8f)


    }


    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mGuiCamera.update()
        mGame.batch.projectionMatrix = mGuiCamera.combined

        mGame.batch.begin()
        mSprite.draw(mGame.batch)
        mFont.draw(mGame.batch, "Game Over", 0f, WORLD_HEIGHT / 2 + 40, WORLD_WIDTH, Align.center, false)
        mFont.draw(mGame.batch, "Score : $mScore", 0f, WORLD_HEIGHT / 2 - 40, WORLD_WIDTH, Align.center, false)

        mGame.batch.end()

        if (Gdx.input.justTouched()) {
            if (mGame.mRequestHandler != null) {
                mGame.mRequestHandler.showAds(false)
            }
            mGame.screen = GameScreen(mGame)


        }
    }



}