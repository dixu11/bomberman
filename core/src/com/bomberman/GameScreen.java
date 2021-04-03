package com.bomberman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import org.graalvm.compiler.word.Word;

class GameScreen implements Screen {

    //dependencies
    private Bomberman game;

    //render
    private OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //components
    private World world;
    private Bomber bomber;


    GameScreen(Bomberman game) {
        this.game = game;

        //view
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Bomberman.WIDTH, Bomberman.HEIGHT);

        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("map1.tmx");

        renderer = new OrthogonalTiledMapRenderer(map,4); //bath?
        renderer.setView(camera);

        //components
        world = new World(new Vector2(0,-9.8f),true) ; //standardowa grawitacja
        bomber = new HumanBomber(world);

    }

    @Override
    public void show() {


        //start music
    }

    @Override
    public void render(float delta) {
        bomber.update();

        SpriteBatch batch = game.getBatch();
        BitmapFont font = game.getFont();
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        renderer.render();
//        bomber.draw(batch);
        batch.draw(bomber,bomber.getX(),bomber.getY(),bomber.getWidth(),bomber.getHeight());
        batch.end();

        //fizyka
        world.step(Gdx.graphics.getDeltaTime(), 6,2);
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
        map.dispose();
        renderer.dispose();
        bomber.getTexture().dispose();
    }
}
