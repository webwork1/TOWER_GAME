package game;

import org.lwjgl.LWJGLException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class begin extends StateBasedGame{
	
	public begin(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Shop(shop));
		this.addState(new bowShop(bowShop));
		this.addState(new resourceShop(resourceShop));
	}
	
	private static AppGameContainer appgc;
	
	static float sizeWidth = 1250;
	static float sizeHeight = 680;
	public static final String gamename = "Tower Game";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int shop = 2;
	public static final int bowShop = 3;
	public static final int resourceShop = 4;
	public static final int DEFAULT_WIDTH = 1250;
	public static final int DEFAULT_HEIGHT = 680;

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(shop).init(gc, this);
		this.getState(bowShop).init(gc, this);
		this.getState(resourceShop).init(gc, this);
		this.enterState(menu);
		
	}
	
	public static void main(String[] args) throws LWJGLException{
		try{
			appgc = new AppGameContainer(new ScalableGame(new begin(gamename), DEFAULT_WIDTH, DEFAULT_HEIGHT, false));
			appgc.setDisplayMode(1250, 680, false);
			appgc.setShowFPS(true);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
		
	}
	
	public static void resize(int width, int height, boolean fullScreen){
		try{
			sizeWidth = width;
			sizeHeight = height;
		appgc.setDisplayMode(width, height, fullScreen);
		}catch(SlickException e){
			
		}
	}
	
	public static float toPixelsX(float worldUnits){
		
		return (sizeWidth/200)*worldUnits;
	}
	public static float toPixelsY(float worldUnits){
		
		return (sizeHeight/200)*worldUnits;
	}
	public static int getSizeHeight(){
		return (int) sizeHeight;
	}
}
