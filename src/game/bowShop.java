package game;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.*;

public class bowShop  extends BasicGameState{

	private UnicodeFont fUnicodeFont;
	private UnicodeFont fUnicodeFont2;
	
	public static int coins;
	
	public static int shopSleep = 20;
	
	public int bowDamageCost = 300;
	public int bowDistanceCost = 500;
	public int bowSpeedCost = 200;
	
	public static int bowDamageLevel;
	public static int bowDistanceLevel;
	public static int bowSpeedLevel;
	
	Image menuBG;
	Image wIcon;
	
	public bowShop(int state) {
	}

	@SuppressWarnings("unchecked")
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Font font = new Font("Serif", Font.PLAIN, 25);
        Font font2 = new Font("Serif", Font.PLAIN, 20);
        
        fUnicodeFont = new UnicodeFont(font, 22, true, false);
		fUnicodeFont.getEffects().add(new ColorEffect());
        fUnicodeFont.addAsciiGlyphs();
        fUnicodeFont.loadGlyphs();
        
        fUnicodeFont2 = new UnicodeFont(font2, 20, true, false);
		fUnicodeFont2.getEffects().add(new ColorEffect());
        fUnicodeFont2.addAsciiGlyphs();
        fUnicodeFont2.loadGlyphs();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		menuBG = new Image("res/menu.png");
		wIcon = new Image("res/wIcon.png");
		
		g.drawImage(menuBG, 0, 0);
		
		g.setColor(Color.orange);
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 2; y++){
			g.fillRect(350 + 200*x, 150 + 100*y, 150, 75);
			}
			}
		
		fUnicodeFont.drawString(582,130,"Coins : " + coins,Color.yellow);
		
		g.setColor(Color.blue);
		g.fillRect(150, 550, 60, 60);
		g.drawImage(wIcon, 150, 550);
		
		//DISTANCE
		
		fUnicodeFont.drawString(362,170,"Bow Distance",Color.blue);
		fUnicodeFont.drawString(370,260,"Current : " + bowDistanceLevel,Color.black);
		fUnicodeFont2.drawString(382,290,"Cost : " + bowDistanceCost,Color.gray);
		
		//SPEED
		
		fUnicodeFont.drawString(570,170,"Bow Speed",Color.blue);
		fUnicodeFont.drawString(570,260,"Current : " + bowSpeedLevel,Color.black);
		fUnicodeFont2.drawString(582,290,"Cost : " + bowSpeedCost,Color.gray);
		
		//DAMAGE
		
		fUnicodeFont.drawString(762,170,"Bow Damage",Color.blue);
		fUnicodeFont.drawString(770,260,"Current : " + bowDamageLevel,Color.black);
		fUnicodeFont2.drawString(782,290,"Cost : " + bowDamageCost,Color.gray);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = gc.getHeight()-Mouse.getY();
		
		if(shopSleep == 0){
			if(input.isMouseButtonDown(0)){
				shopSleep = 25;
				}
			
		//BOW SHOP BUTTON
		if(mouseX >= begin.toPixelsX(24) && mouseX <= begin.toPixelsX(34)){
			if(mouseY >=begin.toPixelsY(162) && mouseY <= begin.toPixelsY(179)){
				if(input.isMouseButtonDown(0)){
					Shop.getbowShopVariables();
				sbg.enterState(2);
				}
			}
		}
		
		//BOW DISTANCE
		if(mouseX >= begin.toPixelsX(56) && mouseX <= begin.toPixelsX(80)){
		if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
			if(input.isMouseButtonDown(0)){
			if(coins >= bowDistanceCost){
				if(bowDistanceLevel < 10){
				coins-=bowDistanceCost;
				bowDistanceLevel++;
				bowDistanceCost+=250;
				}
			}
			}
			}
		}
		
		//BOW SPEED
		if(mouseX >= begin.toPixelsX(88) && mouseX <= begin.toPixelsX(112)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= bowSpeedCost){
				if(bowSpeedLevel < 20){
				coins-=bowSpeedCost;
				bowSpeedLevel++;
				bowSpeedCost+=125;
				}
			}
			}
			}
		}
		
		//BOW DAMAGE
		if(mouseX >= begin.toPixelsX(120) && mouseX <= begin.toPixelsX(144)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= bowDamageCost){
				if(bowDamageLevel < 20){
				coins-=bowDamageCost;
				bowDamageLevel++;
				bowDamageCost+=175;
				}
			}
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
	}else{
		shopSleep--;
	}
	}

	public int getID() {
		return 3;
	}
	
	public static void setVariables(){
		coins = Shop.coins;
	}

}
