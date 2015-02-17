package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Font;
public class Menu extends BasicGameState{
	public Menu(int state){
	}
    private UnicodeFont fUnicodeFont;
	Image menuBG;
	
	@SuppressWarnings("unchecked")
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        Font font = new Font("Serif", Font.PLAIN, 20);
        fUnicodeFont = new UnicodeFont(font, 25, true, false);

		fUnicodeFont.getEffects().add(new ColorEffect());
        fUnicodeFont.addAsciiGlyphs();
        fUnicodeFont.loadGlyphs();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg,Graphics g) throws SlickException{

		menuBG = new Image("res/menu.png");
		g.drawImage(menuBG, 0, 0);
		g.setColor(Color.orange);

		for(int x = 0; x <= 2; x++){
			g.fillRect(350 + (x*200), 225, 130, 75);
		}
		//testing mouse input
		fUnicodeFont.drawString(590, 255, "Play",Color.black);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = gc.getHeight()-Mouse.getY();
		
		if(mouseX >= begin.toPixelsX(88) && mouseX <= begin.toPixelsX(110)){
			if(mouseY >= begin.toPixelsY(66) && mouseY <= begin.toPixelsY(88)){
				if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
				}
			}
		}
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			gc.exit();
		}
		
		if(input.isKeyPressed(Input.KEY_R)){
			if(gc.getWidth() > 1200 && gc.getWidth() < 1280){
				begin.resize(937, 510, false);
			}else if(gc.getWidth() >930 && gc.getWidth() < 950){
				begin.resize(625, 340, false);
			}else if(gc.getWidth() > 600 && gc.getWidth() < 650){
				begin.resize(gc.getScreenWidth(), gc.getScreenHeight(), true);
			}else if(gc.getWidth() == gc.getScreenWidth()){
				begin.resize(1250, 680, false);
			}
		}
		
	}
	
	
	public int getID(){
		return 0;
	}
}
