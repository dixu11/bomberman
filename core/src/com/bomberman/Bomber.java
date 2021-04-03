package com.bomberman;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

abstract class Bomber extends Sprite {

    private static final Texture texture;
    private static final TextureRegion region;

    static {
        texture = new Texture("tilemap.png");
        region = new TextureRegion(texture, Bomberman.TILE_SIZE, Bomberman.TILE_SIZE, Bomberman.TILE_SIZE, Bomberman.TILE_SIZE);
    }

    Bomber() {
        super(region);
        setPosition(0, 0);
//        setScale(4);
        setSize(Bomberman.TILE_SIZE*4,Bomberman.TILE_SIZE*4);
    }

    public void update(float delta) {
        placeBomb();
    }

    private void placeBomb() {

    }


}
