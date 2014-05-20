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
	/*private OrthographicCamera camera;
	private SpriteBatch batch;*/
	private Texture texture;
	//Aqui declaramos o inicializamos las imagenes que utilizaremos//
	Stage stage;
	Image fondo;
	Image circulo;
	Image rectangulo;
	Image estrella;
	Image triangulo;
	Image pentagono;

	
	boolean izquierda=false;
	boolean derecha=false;


	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		texture = new Texture(Gdx.files.internal("data/circulo.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		TextureRegion region = new TextureRegion(texture, 0, 0, 128, 128);

		//Aqui colocamos la direccion donde tenemos la imagenes en el sistema//
		stage = new Stage();
		circulo = new Image(region);
		stage = new Stage();
		rectangulo = new Image(new Texture(Gdx.files.internal("data/rectangulo.png")));
		estrella = new Image(new Texture(Gdx.files.internal("data/estrella.png")));
		triangulo = new Image(new Texture(Gdx.files.internal("data/triangulo.png")));
		pentagono = new Image(new Texture(Gdx.files.internal("data/pentagono.png")));
		fondo = new Image(new Texture(Gdx.files.internal("data/fondo.png")));


		//Aqui puse la posicion de las figuras//
		fondo.setX(0);
		fondo.setY(-100);
		circulo.setX(100);
		circulo.setY(100);
		rectangulo.setX(400);
		rectangulo.setY(100);
		estrella.setX(200);
		estrella.setY(100);
		pentagono.setX(100);
		pentagono.setY(50);
		
		
		stage.addActor(fondo);
		stage.addActor(circulo);
		stage.addActor(rectangulo);
		stage.addActor(estrella);
		stage.addActor(triangulo);
		stage.addActor(pentagono);

	}

	@Override
	public void dispose() {
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		rectangulo.setRotation(rectangulo.getRotation()-1);
		circulo.setX(circulo.getX()+2);
		pentagono.setY(pentagono.getY()-0.4f);
		pentagono.setX(pentagono.getX()+0.5f);
		pentagono.setY(pentagono.getY()+0.1f);
		pentagono.setX(pentagono.getX()-0.5f);
		estrella.setY(estrella.getY()+3);
		estrella.setX(estrella.getX()-1);
		estrella.setScale(estrella.getScaleX()-0.1f,estrella.getScaleY()+0.01f);

		//Aqui en esta funcion muevo el triangulo en ambas direcciones varias veces//
		if (triangulo.getX()>300)
		{
			izquierda=true;
		}
		
		if(triangulo.getX()<10)
		{
			izquierda = false;
		}

		if (izquierda==true)
		{
			triangulo.setX(triangulo.getX()-10);
		}
		else
		{
			triangulo.setX(triangulo.getX()+10);
		}

		
		/*//PENTAGONO
		if (pentagono.getY()>300)
		{
			izquierda=true;
		}
		else
		{
			pentagono.setX(pentagono.getX()-1f);
		}
		
		if (pentagono.getY()>300)
		{
			izquierda=true;
		}
		else
		{
			pentagono.setY(pentagono.getY()-1f);
		}
		
		
		if (pentagono.getX()>300)
		{
			izquierda=true;
		}

		
		if(pentagono.getY()<1)
		{
			izquierda = false;
		}

		if (izquierda==true)
		{
			pentagono.setX(pentagono.getX()-2);
		}
		else
		{
			pentagono.setX(pentagono.getX()+5);
		}*/
		
		//Con esto imprimimos las imagenes por ejemplo yo las guarde todas en un solo stage//
		stage.draw();
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
