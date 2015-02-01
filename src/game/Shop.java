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

public class Shop extends BasicGameState{

	private UnicodeFont fUnicodeFont;
	private UnicodeFont fUnicodeFont2;
	
	Font font;
	public static int getHeight;
	public static int getWidth;
	
	Image menuBG;
	//SHOP VARIABLES
	public static double wSpeed;
	public static double aSpeed;
	public static double gSpeed;
	public static double cSpeed;
	public static double pSpeed;
	
	public static double wdmg;
	public static double admg;
	public static double gdmg;
	public static double cdmg;
	public static double pdmg;
	
	public static int wMaxHealth;
	public static int aMaxHealth;
	public static int gMaxHealth;
	public static int cMaxHealth;
	public static int pMaxHealth;
	
	public int wSpeedCost = 100;
	public int aSpeedCost = 200;
	public int gSpeedCost = 300;
	public int cSpeedCost = 400;
	public int pSpeedCost = 500;
	
	public int wDmgCost = 100;
	public int aDmgCost = 200;
	public int gDmgCost = 300;
	public int cDmgCost = 400;
	public int pDmgCost = 500;
	
	public int wHealthCost = 100;
	public int aHealthCost = 200;
	public int gHealthCost = 300;
	public int cHealthCost = 400;
	public int pHealthCost = 500;
	
	public static int coins;
	
	public int shopSleep;
	//runs "set variables" function once
	public boolean setVariablesV = true;
	public Shop(int state) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
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

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		menuBG = new Image("res/menu.png");
		g.drawImage(menuBG, 0, 0);
		
		g.setColor(Color.orange);
		for(int x = 0; x < 5; x++){
			for(int y = 0; y < 4; y++){
			g.fillRect(150 + x*200, 50 + 100*y, 150, 75);
			}
		}
		//MENU ITEMS
		fUnicodeFont.drawString(180,90,"Warrior",Color.blue);
		fUnicodeFont.drawString(385,90,"Archer",Color.blue);
		fUnicodeFont.drawString(590,90,"Golem",Color.blue);
		fUnicodeFont.drawString(780,90,"Catapult",Color.blue);
		fUnicodeFont.drawString(980,90,"Phoenix",Color.blue);
		
		//MENU UPGRADES
		
		//WARRIOR STUFF
		fUnicodeFont2.drawString(180,165,"Speed : " +(int)Math.ceil((wSpeed)*10),Color.black);
		fUnicodeFont2.drawString(170,265,"Damage : " +(int) Math.ceil(wdmg*100),Color.black);
		fUnicodeFont2.drawString(170,360,"Health : " +(int) (wMaxHealth/10),Color.black);

		fUnicodeFont2.drawString(182,200,"Cost : " + wSpeedCost,Color.gray);
		fUnicodeFont2.drawString(180,300,"Cost : " + wDmgCost,Color.gray);
		fUnicodeFont2.drawString(175,400,"Cost : " + wHealthCost,Color.gray);
		
		//ARCHER STUFF
		fUnicodeFont.drawString(380,165,"Speed : " +(int)Math.ceil((aSpeed)*10),Color.black);
		fUnicodeFont.drawString(370,265,"Damage : " +(int) admg,Color.black);
		fUnicodeFont.drawString(370,360,"Health : " +(int) (aMaxHealth/10),Color.black);

		fUnicodeFont2.drawString(382,200,"Cost : " + aSpeedCost,Color.gray);
		fUnicodeFont2.drawString(380,300,"Cost : " + aDmgCost, Color.gray);
		fUnicodeFont2.drawString(375,400,"Cost : " + aHealthCost,Color.gray);
		
		//GOLEM STUFF
		fUnicodeFont.drawString(580,165,"Speed : " +(int)Math.ceil((gSpeed)*10),Color.black);
		fUnicodeFont.drawString(570,265,"Damage : " +(int) Math.ceil(gdmg*100),Color.black);
		fUnicodeFont.drawString(570,360,"Health : " +(int) (gMaxHealth/10),Color.black);

		fUnicodeFont2.drawString(582,200,"Cost : " + gSpeedCost,Color.gray);
		fUnicodeFont2.drawString(580,300,"Cost : " + gDmgCost,Color.gray);
		fUnicodeFont2.drawString(575,400,"Cost : " + gHealthCost,Color.gray);
		
		//CATAPULT STUFF
		g.setColor(Color.black);
		fUnicodeFont.drawString(780,165,"Speed : " +(int)Math.ceil((cSpeed)*10),Color.black);
		fUnicodeFont.drawString(770,265,"Damage : " +(int) cdmg,Color.black);
		fUnicodeFont.drawString(770,360,"Health : " +(int) (cMaxHealth/10),Color.black);

		fUnicodeFont2.drawString(782,200,"Cost : " + cSpeedCost,Color.gray);
		fUnicodeFont2.drawString(780,300,"Cost : " + cDmgCost,Color.gray);
		fUnicodeFont2.drawString(775,400,"Cost : " + cHealthCost,Color.gray);
		
		//PHOENIX STUFF
		g.setColor(Color.black);
		fUnicodeFont.drawString(980,165,"Speed : " +(int)Math.ceil((pSpeed)*10),Color.black);
		fUnicodeFont.drawString(970,265,"Damage : " +(int) pdmg,Color.black);
		fUnicodeFont.drawString(970,360,"Health : " +(int) (pMaxHealth/10),Color.black);

		fUnicodeFont2.drawString(982,200,"Cost : " + pSpeedCost,Color.gray);
		fUnicodeFont2.drawString(980,300,"Cost : " + pDmgCost,Color.gray);
		fUnicodeFont2.drawString(975,400,"Cost : " + pHealthCost,Color.gray);
		
		//START BUTTON9
		g.setColor(Color.black);
		g.fillRect(550, 550, 150, 75);
		
		fUnicodeFont.drawString(595,590,"Start",Color.white);
		
		//DRAWING COINS
		fUnicodeFont.drawString(575,30,"Coins : " + coins,Color.yellow);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = gc.getHeight()-Mouse.getY();
		
		//625
		//340
		
		if(shopSleep == 0){
			//START BUTTON
			if(mouseX >= begin.toPixelsX(88) && mouseX <= begin.toPixelsX(112)){
				if(mouseY >=begin.toPixelsY(162) && mouseY <= begin.toPixelsY(187)){
					if(input.isMouseButtonDown(0)){
						setVariables();
					sbg.enterState(1);
					}
				}
			}
			if(input.isMouseButtonDown(0)){
			shopSleep = 25;
			}
		//WARRIOR STUFF
		if(mouseX >= begin.toPixelsX(24) && mouseX <= begin.toPixelsX(48)){
			if(mouseY >= begin.toPixelsY(44) && mouseY <= begin.toPixelsY(66)){
				if(input.isMouseButtonDown(0)){
			if(coins >= wSpeedCost){
				coins-=wSpeedCost;
				wSpeed+=.1;
				wSpeedCost+=100;
			}
			}
			}
		}
		if(mouseX >= begin.toPixelsX(24) && mouseX <= begin.toPixelsX(48)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= wDmgCost){
				coins-=wDmgCost;
				wdmg+=.02;
				wDmgCost+=150;
			}
				}
		}
		}
		if(mouseX >= begin.toPixelsX(24) && mouseX <= begin.toPixelsX(48)){
			if(mouseY >= begin.toPixelsY(102) && mouseY <= begin.toPixelsY(125)){
				if(input.isMouseButtonDown(0)){
			if(coins >= wHealthCost){
				coins -= wHealthCost;
				wMaxHealth+=50;
				wHealthCost+=150;
			}
				}
			}
		}
		//ARCHER STUFF
		if(mouseX >= begin.toPixelsX(56) && mouseX <= begin.toPixelsX(80)){
			if(mouseY >= begin.toPixelsY(44) && mouseY <= begin.toPixelsY(66)){
				if(input.isMouseButtonDown(0)){
			if(coins >= aSpeedCost){
				coins-=aSpeedCost;
				aSpeed+=.1;
				aSpeedCost+=100;
			}
				}
			}
		}
		if(mouseX >= begin.toPixelsX(56) && mouseX <= begin.toPixelsX(80)){
		if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
			if(input.isMouseButtonDown(0)){
			if(coins >= aDmgCost){
				coins-=aDmgCost;
				admg+=5;
				aDmgCost+=150;
			}
			}
			}
		}
		if(mouseX >= begin.toPixelsX(56) && mouseX <= begin.toPixelsX(80)){
			if(mouseY >= begin.toPixelsY(102) && mouseY <= begin.toPixelsY(125)){
				if(input.isMouseButtonDown(0)){
			if(coins >= aHealthCost){
				coins -= aHealthCost;
				aMaxHealth+=50;
				aHealthCost+=200;
			}
			}
			}
		}
		//GOLEM STUFF
		if(mouseX >= begin.toPixelsX(88) && mouseX <= begin.toPixelsX(112)){
			if(mouseY >= begin.toPixelsY(44) && mouseY <= begin.toPixelsY(66)){
				if(input.isMouseButtonDown(0)){
			if(coins >= gSpeedCost){
				coins-=gSpeedCost;
				gSpeed+=.1;
				gSpeedCost+=100;
			}
			}
			}
		}
		if(mouseX >= begin.toPixelsX(88) && mouseX <= begin.toPixelsX(112)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= gDmgCost){
				coins-=gDmgCost;
				gdmg+=.02;
				gDmgCost+=150;
			}
			}
			}
		}
		if(mouseX >= begin.toPixelsX(88) && mouseX <= begin.toPixelsX(112)){
			if(mouseY >= begin.toPixelsY(102) && mouseY <= begin.toPixelsY(125)){
				if(input.isMouseButtonDown(0)){
			if(coins >= gHealthCost){
				coins -= gHealthCost;
				gMaxHealth+=100;
				gHealthCost+=200;
			}
			}
			}
		}
		//CATAPULT STUFF
		if(mouseX >= begin.toPixelsX(120) && mouseX <= begin.toPixelsX(144)){
			if(mouseY >= begin.toPixelsY(44) && mouseY <= begin.toPixelsY(66)){
				if(input.isMouseButtonDown(0)){
			if(coins >= cSpeedCost){
				coins-=cSpeedCost;
				cSpeed+=.1;
				cSpeedCost+=100;
			}
				}
			}
		}
		if(mouseX >= begin.toPixelsX(120) && mouseX <= begin.toPixelsX(144)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= cDmgCost){
				coins-=cDmgCost;
				cdmg+=2;
				cDmgCost+=150;
			}
				}
			}
		}
		if(mouseX >= begin.toPixelsX(120) && mouseX <= begin.toPixelsX(144)){
			if(mouseY >= begin.toPixelsY(102) && mouseY <= begin.toPixelsY(125)){
				if(input.isMouseButtonDown(0)){
			if(coins >= cHealthCost){
				coins -= cHealthCost;
				cMaxHealth+=20;
				cHealthCost+=200;
			}
			}
			}
		}
		//PHOENIX STUFF
		if(mouseX >= begin.toPixelsX(152) && mouseX <= begin.toPixelsX(176)){
			if(mouseY >= begin.toPixelsY(44) && mouseY <= begin.toPixelsY(66)){
				if(input.isMouseButtonDown(0)){
			if(coins >= pSpeedCost){
				coins-=pSpeedCost;
				pSpeed+=.1;
				pSpeedCost+=100;
			}
				}
			}
		}
		if(mouseX >= begin.toPixelsX(152) && mouseX <= begin.toPixelsX(176)){
			if(mouseY >= begin.toPixelsY(73) && mouseY <= begin.toPixelsY(95)){
				if(input.isMouseButtonDown(0)){
			if(coins >= pDmgCost){
				coins-=pDmgCost;
				pdmg+=2;
				pDmgCost+=150;
			}
				}
			}
		}
		if(mouseX >= begin.toPixelsX(152) && mouseX <= begin.toPixelsX(176)){
			if(mouseY >= begin.toPixelsY(102) && mouseY <= begin.toPixelsY(125)){
				if(input.isMouseButtonDown(0)){
			if(coins >= pHealthCost){
				coins -= pHealthCost;
				pMaxHealth+=20;
				pHealthCost+=200;
			}
			}
			}
		}
		}else{
			shopSleep--;
		}
		getWidth = gc.getWidth();
		getHeight = gc.getHeight();
		if(setVariablesV){
			getVariables();
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

	@Override
	public int getID() {
		return 2;
	}
	public void getVariables(){
		coins = Play.coins;
		wSpeed = Play.wSpeed;
		aSpeed = Play.aSpeed;
		gSpeed = Play.gSpeed;
		cSpeed = Play.cSpeed;
		pSpeed = Play.pSpeed;
		
		wdmg = Play.wdmg;
		admg = Play.admg;
		gdmg = Play.gdmg;
		cdmg = Play.cdmg;
		pdmg = Play.pdmg;
		
		wMaxHealth = Play.wMaxHealth;
		aMaxHealth = Play.aMaxHealth;
		gMaxHealth = Play.gMaxHealth;
		cMaxHealth = Play.cMaxHealth;
		pMaxHealth = Play.pMaxHealth;
		
		setVariablesV = false;
	}
	
	public void setVariables(){
		
		Play.badTowerMaxHealth +=250;
		Play.badTowerHealth = Play.badTowerMaxHealth;
		
		Play.coins = coins;
		
		Play.wSpeed = wSpeed;
		Play.aSpeed = aSpeed;
		Play.gSpeed = gSpeed;
		Play.cSpeed = cSpeed;
		Play.pSpeed = pSpeed;
		
		Play.wdmg = wdmg;
		Play.admg = (int) admg;
		Play.gdmg = gdmg;
		Play.cdmg = (int) cdmg;
		Play.pdmg = (int) pdmg;
		
		Play.wMaxHealth = wMaxHealth;
		Play.aMaxHealth = aMaxHealth;
	    Play.gMaxHealth = gMaxHealth;
		Play.cMaxHealth = cMaxHealth;
		Play.pMaxHealth = pMaxHealth;
		
		Play.playState = true;
		
		Play.level++;
	}

}
