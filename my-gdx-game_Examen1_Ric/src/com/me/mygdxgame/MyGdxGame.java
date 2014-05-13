package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private Texture texture_circulo;
	private Sprite sprite_circulo;
	private Texture texture_rectangulo;
	private Sprite sprite_rectangulo;
	private Texture texture_estrella;
	private Sprite sprite_estrella;
	Stage stage;
	Image image;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		texture_circulo = new Texture(Gdx.files.internal("data/circulo.png"));
		texture_rectangulo = new Texture(Gdx.files.internal("data/rectangulo.png"));
		texture_estrella = new Texture(Gdx.files.internal("data/estrella.png"));
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite_circulo= new Sprite(texture_circulo,512,512); 
		sprite_circulo.setPosition(-0.4f,-0.2f); 
		sprite_circulo.setSize(0.4f,0.4f);
		sprite_circulo.setX(-0.1f);
		
		sprite_rectangulo= new Sprite(texture_rectangulo,512,512); 
		sprite_rectangulo.setPosition(-0.1f,-0.2f); 
		sprite_rectangulo.setSize(0.4f,0.4f);
		sprite_rectangulo.setRotation(0);
		
		sprite_estrella= new Sprite(texture_estrella,512,512); 
		sprite_estrella.setPosition(-0.4f,-0.2f); 
		sprite_estrella.setSize(0.4f,0.4f);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		stage = new Stage();
		image = new Image(region);
		
		sprite_circulo.setX(sprite_circulo.getX()-0.1f);
	
		//image.setRotation(45);
		//if(sprite_rectangulo.getX()>700)//
			//sprite_rectangulo.setX(-500);//
		//image.setX(50);//
		
		stage.addActor(image);
		
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite_circulo.draw(batch);
		sprite_circulo.setX(-0.1f);
		sprite_rectangulo.draw(batch);
		sprite_rectangulo.setRotation(0);
		//sprite.draw(batch);//
		batch.end();
		
		sprite_circulo.setX(sprite_circulo.getX()+0.01f);
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
}
