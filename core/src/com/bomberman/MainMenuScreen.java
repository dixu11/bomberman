package com.bomberman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

class MainMenuScreen implements Screen {

    private Bomberman game;

    private OrthographicCamera camera;

    MainMenuScreen(Bomberman game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false,Bomberman.WIDTH,Bomberman.HEIGHT);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        doRender();
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    private void doRender() {
        ScreenUtils.clear(Color.BLACK);
        camera.update();

        SpriteBatch batch = game.getBatch();
        BitmapFont font = game.getFont();
        // batch.setProjectionMatrix(camera.combined);
        batch.begin();

        font.draw(batch,"! GAME LOGO !",
                Bomberman.WIDTH/2f,Bomberman.HEIGHT*0.75f,1f, Align.center,true);

        font.draw(batch," Click to start :)",
                Bomberman.WIDTH/2f,Bomberman.HEIGHT*0.5f);

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
