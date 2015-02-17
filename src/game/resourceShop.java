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

public class resourceShop extends BasicGameState{
	
	Image menuBG;
	Image wIcon;
	private UnicodeFont fUnicodeFont;
	private UnicodeFont fUnicodeFont2;
	
	public static int coins;
	public static int shopSleep = 20;
	
	public static int towerHealth = 500;
	public static int maxMana = 75;
	public static int manaIncome = 0;
	public static int goldIncome = 0;
	public static int unitCdr = 0;
	
	public static int towerHealthCost = 200;
	public static int maxManaCost = 50;
	public static int manaIncomeCost = 350;
	public static int goldIncomeCost = 350;
	public static int unitCdrCost = 400;
	

	public resourceShop(int state) {
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
		
		g.setColor(Color.blue);
		g.fillRect(150, 550, 60, 60);
		g.drawImage(wIcon, 150, 550);
		
		//tower health, max mana, mana income, gold income, cool down reduction for units, 
		
		g.setColor(Color.orange);
		for(int x = 0; x < 5; x++){
			for(int y = 0; y < 2; y++){
			g.fillRect(150 + 200*x, 150 + 100*y, 150, 75);
			}
			}
		
		//TOWER HEALTH
		fUnicodeFont.drawString(162,170,"Tower Health",Color.blue);
		fUnicodeFont2.drawString(170,265,"Current : " + towerHealth,Color.black);
		fUnicodeFont2.drawString(180,300,"Cost : " + towerHealthCost,Color.gray);
		
		//MAX MANA
		fUnicodeFont.drawString(372,170,"Max Mana",Color.blue);
		fUnicodeFont2.drawString(370,265,"Current : " + maxMana,Color.black);
		fUnicodeFont2.drawString(380,300,"Cost : " + maxManaCost ,Color.gray);
		
		//MANA INCOME
		fUnicodeFont.drawString(562,170,"Mana Income",Color.blue);
		fUnicodeFont2.drawString(570,265,"Current : " + manaIncome + "/10",Color.black);
		fUnicodeFont2.drawString(580,300,"Cost : " + manaIncomeCost,Color.gray);
		
		//GOLD INCOME
		fUnicodeFont.drawString(762,170,"Gold Income",Color.blue);
		fUnicodeFont2.drawString(770,265,"Current : " + goldIncome + "/10",Color.black);
		fUnicodeFont2.drawString(780,300,"Cost : " + goldIncomeCost,Color.gray);
		
		//UNIT CDR
		fUnicodeFont.drawString(974,170,"Unit CDR",Color.blue);
		fUnicodeFont2.drawString(970,265,"Current : " + unitCdr + "/10",Color.black);
		fUnicodeFont2.drawString(980,300,"Cost : " + unitCdrCost,Color.gray);
		
		//DRAWING COINS
		fUnicodeFont.drawString(582,130,"Coins : " + coins,Color.yellow);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = gc.getHeight()-Mouse.getY();
		
		if(shopSleep == 0){
		if(input.isMouseButtonDown(0)){
			shopSleep = 25;
			}
		
		//RESOURCE SHOP BUTTON
		if(mouseX >= begin.toPixelsX(24) && mouseX <= begin.toPixelsX(34)){
			if(mouseY >=begin.toPixelsY(162) && mouseY <= begin.toPixelsY(179)){
				if(input.isMouseButtonDown(0)){
					Shop.getresourceShopVariables();
				sbg.enterState(2);
				}
			}
		}
		
		//TOWER HEALTH
		if(mouseX >= begin.toPixelsX(24) && mouseX <= begin.toPixelsX(48)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= towerHealthCost){
				coins-=towerHealthCost;
				towerHealth+=250;
				towerHealthCost+=200;
			}
				}
		}
		}
		
		//MAX MANA
		if(mouseX >= begin.toPixelsX(56) && mouseX <= begin.toPixelsX(80)){
		if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
			if(input.isMouseButtonDown(0)){
			if(coins >= maxManaCost){
				coins-=maxManaCost;
				maxMana+=100;
				maxManaCost+=100;
			}
			}
			}
		}
		
		//MANA INCOME
		if(mouseX >= begin.toPixelsX(88) && mouseX <= begin.toPixelsX(112)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= manaIncomeCost){
				if(manaIncome < 10){
				coins-=manaIncomeCost;
				manaIncome++;
				manaIncomeCost+=250;
			}
			}
			}
			}
		}
		
		//GOLD INCOME
		if(mouseX >= begin.toPixelsX(120) && mouseX <= begin.toPixelsX(144)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= goldIncomeCost){
				if(goldIncome < 10){
				coins-=goldIncomeCost;
				goldIncome++;
				goldIncomeCost+=150;
			}
				}
				}
			}
		}
		
		//UNIT CDR
		if(mouseX >= begin.toPixelsX(152) && mouseX <= begin.toPixelsX(176)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= unitCdrCost){
				if(unitCdr < 10){
				coins-=unitCdrCost;
				unitCdr++;
				unitCdrCost+=200;
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
	public static void setVariables(){
		coins = Shop.coins;
	}

	public int getID() {
		return 4;
	}

}
