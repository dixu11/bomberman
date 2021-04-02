package com.bomberman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

class GameScreen implements Screen {
    private Bomberman game;
    private OrthographicCamera camera;

    GameScreen(Bomberman game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false,Bomberman.WIDTH,Bomberman.HEIGHT);
    }

    @Override
    public void show() {
        //start music
    }

    @Override
    public void render(float delta) {
        SpriteBatch batch = game.getBatch();
        BitmapFont font = game.getFont();

        ScreenUtils.clear(Color.BLACK);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
