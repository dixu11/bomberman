package com.bomberman;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;

abstract class Bomber extends Sprite {

    private static final Texture texture;
    private static final TextureRegion region;

    private World world;
    private Body body;

    static {
        texture = new Texture("tilemap.png");
        region = new TextureRegion(texture, Bomberman.TILE_SIZE, Bomberman.TILE_SIZE, Bomberman.TILE_SIZE, Bomberman.TILE_SIZE);
    }

    Bomber(World world) {
        super(region);
        this.world = world;
        setPosition(0, 0);
//        setScale(4);
        setSize(Bomberman.TILE_SIZE * 4, Bomberman.TILE_SIZE * 4);
        createBody();
    }

    void createBody() {
        //static - nie reaguje na nic
        //kinematic - nie reaguje na grawitacje ale na inne rzeczy tak (popchnięte)
        //dynamic body - reaguje na wszystko

        //create body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set((getX()), getY());
        body = world.createBody(bodyDef);

        //shape
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth(),getHeight());

        //assigning shape to the body to create fixture
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();



    }

    public void update() {
        setPosition(body.getPosition().x,body.getPosition().y);
        placeBomb();
    }

    private void placeBomb() {

    }


}
