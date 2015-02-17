package game;

import java.awt.Font;
import java.util.Random;

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

public class Play extends BasicGameState{
	
	public Play(int state){
		for(int x = 0; x < 15; x++){
			wArrayX[x] = -400;
			badwArrayX[x] = 1450;
			aArrayX[x] = -400;
			baArrayX[x] = 1450;
			gArrayX[x] = -400;
			badgArrayX[x] = 1450;
			cArrayX[x] = -400;
			bcArrayX[x] = 1450;
			vx[x] = 6;
			t[x] = .5;
			gravity[x] = 2.15;
			bvx[x] = 6;
			bt[x] = .5;
			bgravity[x] = 2.15;
			pArrayX[x] = -400;
			bpArrayX[x] = 1450;
			
			Bvx[x] = 6;
			Bt[x] = .5;
			Bgravity[x] = 2.15;
		}
	}
	
	Image playLeftBG;
	Image playRightBG;
	Image gameMeter;
	
	//GOOD WARRIOR STUFF
	Image w0, w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12,w13,w14;
	Image w020,w120,w220,w320,w420,w520,w620,w720,w820,w920,w1000,w1100,w1200,w1300,w1400;
	Image [] picArray = new Image[15];
	Image [] picArray2 = new Image[15];
	int[] wArrayX = new int[15];
	int[] wHealth = new int[15];
	int[] wAlive = new int[15];
	int[] wCombat = new int[15];
	double[] wCombatAnimation = new double[15];
	public static double wSpeed = 1.3;
	int wcdr;
	int wMaxCdr = 75;
	public static double wdmg = .15;
	public int wdmgcdr =10;
	public static int wMaxHealth = 550;
	int[] warriorSpeedV = new int[15];
	
	//BAD WARRIOR STUFF
	Image badw0, badw1,badw2,badw3,badw4,badw5,badw6,badw7,badw8,badw9,badw10,badw11,badw12,badw13,badw14;
	Image badw020,badw120,badw220,badw320,badw420,badw520,badw620,badw720,badw820,badw920,badw1000,badw1100,badw1200,badw1300,badw1400;
	Image [] badpicArray = new Image[15];
	Image [] badpicArray2 = new Image[15];
	double[] badwArrayX = new double[15];
	int[] badwHealth = new int[15];
	int[] badwAlive = new int[15];
	int[] badwCombat = new int[15];
	double[] badwCombatAnimation = new double[15];
	double badwSpeed = 1.2;
	int badwcdr;
	double badwdmg = .15;
	int badwMaxHealth = 550;
	int badwMaxcdr = 400;
	int warriorRepeater = 50;
	int[] badwarriorSpeedV = new int[15];
	
	//GOOD ARCHER STUFF
	Image a0, a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14;
	Image a02,a120,a22,a32,a42,a52,a62,a72,a82,a92,a1000,a1100,a1200,a1300,a1400;
	Image a002,a0120,a022,a032,a042,a052,a062,a072,a082,a092,a01000,a01100,a01200,a01300,a01400;
	Image a0002,a00120,a0022,a0032,a0042,a0052,a0062,a0072,a0082,a0092,a001000,a001100,a001200,a001300,a001400;
	Image [] apicArray = new Image[15];
	Image [] apicArray2 = new Image[15];
	Image [] apicArray3 = new Image[15];
	Image [] apicArray4 = new Image[15];
	double[] aArrayX = new double[15];
	int[] aHealth = new int[15];
	int[] aAlive = new int[15];
	int[] aCombat = new int[15];
	int[] aCombatAnimation = new int[15];
	public static double aSpeed = 1.5;
	int acdr;
	int aMaxCdr = 60;
	public static int admg = 50;
	public static int aMaxHealth = 500;
	int[] archerSpeedV = new int[15];
	//checking for phoenix
	public int[] aCheckP = new int[15];
	//makes arrows not change between states
	public int[] aStaticP = new int[15];
	
	int aDmgCost = 300;
	int aHealthCost = 100;
	int aSpeedCost = 250;
	
	//ARROW STUFF
	Image ar0,ar1,ar2,ar3,ar4,ar5,ar6,ar7,ar8,ar9,ar10,ar11,ar12,ar13,ar14;
	Image ar00,ar01,ar02,ar03,ar04,ar05,ar06,ar07,ar08,ar09,ar010,ar011,ar012,ar013,ar014;
	Image [] arpicArray = new Image[15];
	Image [] arpicArray2 = new Image[15];
	int[] arArrayX = new int[15];
	int[] arArrayY = new int[15];
	int[] arrowFlight = new int[15];
	double arSpeed =4;
	
	//BAD ARCHER STUFF
	
	Image ba0, ba1,ba2,ba3,ba4,ba5,ba6,ba7,ba8,ba9,ba10,ba11,ba12,ba13,ba14;
	Image ba02,ba120,ba22,ba32,ba42,ba52,ba62,ba72,ba82,ba92,ba1000,ba1100,ba1200,ba1300,ba1400;
	Image ba002,ba0120,ba022,ba032,ba042,ba052,ba062,ba072,ba082,ba092,ba01000,ba01100,ba01200,ba01300,ba01400;
	Image ba0002,ba00120,ba0022,ba0032,ba0042,ba0052,ba0062,ba0072,ba0082,ba0092,ba001000,ba001100,ba001200,ba001300,ba001400;
	Image [] bapicArray = new Image[15];
	Image [] bapicArray2 = new Image[15];
	Image [] bapicArray3 = new Image[15];
	Image [] bapicArray4 = new Image[15];
	double[] baArrayX = new double[15];
	int[] baHealth = new int[15];
	int[] baAlive = new int[15];
	int[] baCombat = new int[15];
	int[] baCombatAnimation = new int[15];
	double baSpeed = 1.5;
	int bacdr;
	int baMaxcdr = 1000;
	public int badmg = 50;
	public int baMaxHealth = 500;
	int[] badarcherSpeedV = new int[15];
	//checking for phoenix
	public int[] baCheckP = new int[15];
	//makes arrows not change between states
	public int[] baStaticP = new int[15];
	
	//ARROW STUFF
	Image bar0,bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar9,bar10,bar11,bar12,bar13,bar14;
	Image bar00,bar01,bar02,bar03,bar04,bar05,bar06,bar07,bar08,bar09,bar010,bar011,bar012,bar013,bar014;
	Image [] barpicArray = new Image[15];
	Image [] barpicArray2 = new Image[15];
	int[] barArrayX = new int[15];
	int[] barArrayY = new int[15];
	int[] barrowFlight = new int[15];
	double barSpeed =4;
	
	//GOOD GOLEM STUFF
			Image g0, g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14;
			Image g020,g120,g220,g320,g420,g520,g620,g720,g820,g920,g1000,g1100,g1200,g1300,g1400;
			Image [] gpicArray = new Image[15];
			Image [] gpicArray2 = new Image[15];
			double[] gArrayX = new double[15];
			int[] gHealth = new int[15];
			int[] gAlive = new int[15];
			int[] gCombat = new int[15];
			double[] gCombatAnimation = new double[15];
			public static double gSpeed = 1.1;
			int gcdr;
			int gMaxCdr = 90;
			public static double gdmg = .05;
			int gdmgcdr =10;
			public static int gMaxHealth = 3000;
			
			int gSpeedCost = 300;
			int gDmgCost = 500;
			int gHealthCost = 500;
			int[] golemSpeedV = new int[15];
			
			//BAD GOLEM STUFF
			Image badg0, badg1,badg2,badg3,badg4,badg5,badg6,badg7,badg8,badg9,badg10,badg11,badg12,badg13,badg14;
			Image badg020,badg120,badg220,badg320,badg420,badg520,badg620,badg720,badg820,badg920,badg1000,badg1100,badg1200,badg1300,badg1400;
			Image [] badgpicArray = new Image[15];
			Image [] badgpicArray2 = new Image[15];
			double[] badgArrayX = new double[15];
			int[] badgHealth = new int[15];
			int[] badgAlive = new int[15];
			int[] badgCombat = new int[15];
			double[] badgCombatAnimation = new double[15];
			double badgSpeed = 1.1;
			int badgcdr;
			double badgdmg = .05;
			int badgMaxHealth = 2000;
			int badgMaxcdr = 3000;
			int[] badgolemSpeedV = new int[15];
			
			//GOOD CATAPULT STUFF
			Image c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14;
			Image c02,c120,c22,c32,c42,c52,c62,c72,c82,c92,c1000,c1100,c1200,c1300,c1400;
			Image [] cpicArray = new Image[15];
			Image [] cpicArray2 = new Image[15];
			double[] cArrayX = new double[15];
			int[] cHealth = new int[15];
			int[] cAlive = new int[15];
			int[] cCombat = new int[15];
			double[] cCombatAnimation = new double[15];
			public static double cSpeed = 1.5;
			int ccdr;
			int cMaxCdr = 120;
			public static int cdmg = 125;
			int cdmgcdr =10;
			public static int cMaxHealth = 1000;
			int[] catapultSpeedV = new int[15];
			
			int cDmgCost = 300;
			int cHealthCost = 100;
			int cSpeedCost = 250;
			
			//arc and trajectory stuff
			int[] idX = new int[15];
			double[] vx = new double[15];//6
			double[] t = new double[15];//0.5
			double[] gravity = new double[15];//2.5 to start
			int[] caArrayY = new int[15];
			
			//CATAPULT STUFF
			Image ca0,ca1,ca2,ca3,ca4,ca5,ca6,ca7,ca8,ca9,ca10,ca11,ca12,ca13,ca14;
			Image [] capicArray = new Image[15];
			int[] caArrayX = new int[15];
			int[] catapultFlight = new int[15];
			double caSpeed =4;
			
			//BAD CATAPULT STUFF
			
			Image bc0, bc1,bc2,bc3,bc4,bc5,bc6,bc7,bc8,bc9,bc10,bc11,bc12,bc13,bc14;
			Image bc02,bc120,bc22,bc32,bc42,bc52,bc62,bc72,bc82,bc92,bc1000,bc1100,bc1200,bc1300,bc1400;
			Image [] bcpicArray = new Image[15];
			Image [] bcpicArray2 = new Image[15];
			double[] bcArrayX = new double[15];
			int[] bcHealth = new int[15];
			int[] bcAlive = new int[15];
			int[] bcCombat = new int[15];
			double[] bcCombatAnimation = new double[15];
			double bcSpeed = 1.5;
			int bccdr;
			int bcMaxcdr = 1200;
			int bcdmg = 100;
			int bcMaxHealth = 500;
			int[] badcatapultSpeedV = new int[15];
			
			//arc and trajectory stuff
			int[] bidX = new int[15];
			double[] bvx = new double[15];//6
			double[] bt = new double[15];//0.5
			double[] bgravity = new double[15];//2.5 to start
			int[] bcaArrayY = new int[15];
			
			//CATAPULT STUFF
			Image bca0,bca1,bca2,bca3,bca4,bca5,bca6,bca7,bca8,bca9,bca10,bca11,bca12,bca13,bca14;
			Image [] bcapicArray = new Image[15];
			int[] bcaArrayX = new int[15];
			int[] bcatapultFlight = new int[15];
			double bcaSpeed =4;
			
			//GOOD PHOENIX STUFF
			Image p0, p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
			Image p02,p120,p22,p32,p42,p52,p62,p72,p82,p92,p1000,p1100,p1200,p1300,p1400;
			Image [] ppicArray = new Image[15];
			Image [] ppicArray2 = new Image[15];
			double[] pArrayX = new double[15];
			int[] pHealth = new int[15];
			int[] pAlive = new int[15];
			int[] pCombat = new int[15];
			int[] pCombatAnimation = new int[15];
			public static double pSpeed = 1.5;
			int pcdr;
			int pMaxCdr = 150;
			public static int pdmg = 150;
			public static int pMaxHealth = 400;
			
			int pDmgCost = 300;
			int pHealthCost = 100;
			int pSpeedCost = 250;
			int[] pSpeedV = new int[15];
			
			//FIREBALL STUFF
			Image pr0,pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8,pr9,pr10,pr11,pr12,pr13,pr14;
			Image pr00,pr01,pr02,pr03,pr04,pr05,pr06,pr07,pr08,pr09,pr010,pr011,pr012,pr013,pr014;
			Image [] prpicArray = new Image[15];
			Image [] prpicArray2 = new Image[15];
			int[] prArrayX = new int[15];
			int[] prArrayY = new int[15];
			int[] pFlight = new int[15];
			double prSpeed =4;
			//checking for phoenix
			public int[] pCheckP = new int[15];
			//makes arrows not change between states
			public int[] pStaticP = new int[15];
																							
			//BAD PHOENIX STUFF
			Image bp0, bp1,bp2,bp3,bp4,bp5,bp6,bp7,bp8,bp9,bp10,bp11,bp12,bp13,bp14;
			Image bp02,bp120,bp22,bp32,bp42,bp52,bp62,bp72,bp82,bp92,bp1000,bp1100,bp1200,bp1300,bp1400;
			Image [] bppicArray = new Image[15];
			Image [] bppicArray2 = new Image[15];
			double[] bpArrayX = new double[15];
			int[] bpHealth = new int[15];
			int[] bpAlive = new int[15];
			int[] bpCombat = new int[15];
			int[] bpCombatAnimation = new int[15];
			public double bpSpeed = 1.5;
			int bpcdr;
			int bpMaxCdr = 1600;
			public int bpdmg = 15;
			public int bpMaxHealth = 400;
			
			int bpDmgCost = 300;
			int bpHealthCost = 100;
			int bpSpeedCost = 250;
			int[] bpSpeedV = new int[15];
			
			//FIREBALL STUFF
			Image bpr0,bpr1,bpr2,bpr3,bpr4,bpr5,bpr6,bpr7,bpr8,bpr9,bpr10,bpr11,bpr12,bpr13,bpr14;
			Image bpr00,bpr01,bpr02,bpr03,bpr04,bpr05,bpr06,bpr07,bpr08,bpr09,bpr010,bpr011,bpr012,bpr013,bpr014;
			Image [] bprpicArray = new Image[15];
			Image [] bprpicArray2 = new Image[15];
			int[] bprArrayX = new int[15];
			int[] bprArrayY = new int[15];
			int[] bpFlight = new int[15];
			double bprSpeed =4;
			//checking for phoenix
			public int[] bpCheckP = new int[15];
			//makes arrows not change between states
			public int[] bpStaticP = new int[15];
			
			//BOW STUFF
			public static int bowDamageLevel;
			public static int bowDistanceLevel;
			public static int bowSpeedLevel;
			
	//IMAGE ICONS
	Image wIcon;
	Image aIcon;
	Image gIcon;
	Image cIcon;
	Image pIcon;
	
	//COLORS OF ICON BOXES
	int wColorV;
	int aColorV;
	int gColorV;
	int cColorV;
	int pColorV;
	
	//MAIN VARIABLES	
	public static boolean playState;
	//x value of meter
	public int meterX = 621;
	//left screen movement
	public int playLeftX = -625;
	//right screen movement
	public int playRightX = 625;
	//speed of bg movement
	//controls moving speak
	public int moveSpeakTime = 100;
	public double movingSpeed = 7;
	
	//good tower health
	public double goodTowerHealth = 500;
	//good tower X
	public int goodTowerHealthX = -550;
	//bad tower X
	public int badTowerHealthX = 1650;
	//bad tower health
	public static double badTowerHealth = 500;
	//moves good tower red health bar
	public double goodTowerX = 150;
	//moves bad tower red health bar
	public double badTowerX = 150;
	
	public static double goodTowerMaxHealth = 500;
	public static double badTowerMaxHealth = 500;
	
	//DAMAGE DELT TO TOWERS
	public double goodTowerDamage = .05;
	public double badTowerDamage = .05;
	
	//
	public static int manaIncome = 0;
	public static int goldIncome = 0;
	public static int unitCdr = 0;
	
	//COINS
	public static int coins = 0;
	
	//MANA STUFF
	public int mana = 0;
	public static int maxMana = 75;
	public int manaTimer;
	
	//RANDOM NUMBER GENERATOR
	Random randomGenerator = new Random();
	
	//STUFF FOR CUSTOM SPAWNS
	public int customSpawnTimer;
	public int customSpawnCounter;
	public int customSpawnType;
	public int customSpawnDelay;
	
	//BACKGROUND STUFF
	Image frontBack;
	Image farBack;
	Image test;
	public int farBackX = -350;
	
	//PAUSE VARIABLE
	public int pauseTime;
	public boolean pause = false;
	
	private UnicodeFont fUnicodeFont;
	
	//LEVEL VARIABLE
	public static int level = 1;
	
	//GOOD BOW STUFF
	Image goodBow1;
	Image goodBow2;
	//ammo variables
	public int[] goodbowammoX = new int[20];
	public int[] goodbowammoY = new int[20];
	//changing shoot on and off
	public boolean goodBowShoot = false;
	public int shootTime;
	
	public int goodBowAnimation = 80;

	int[] BFlight = new int[30];
	
	public double BSpeed = 5.5;
	
	//arc and trajectory stuff
	int[] BidX = new int[20];
	double[] Bvx = new double[20];//6
	double[] Bt = new double[20];//0.5
	double[] BtV = new double[20];//0.5
	double[] Bgravity = new double[20];//2.5 to start

	Color c = new Color(72, 238, 27);
	
	Image bowMeter;
	public int bowMeterY = 256;
	public int tbdmg = 35;
	
	public static int aTotalCost = 500;
	public static int gTotalCost = 1000;
	public static int cTotalCost = 1500;
	public static int pTotalCost = 2100;
	
	@SuppressWarnings("unchecked")
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        Font font = new Font("Serif", Font.PLAIN, 20);
        fUnicodeFont = new UnicodeFont(font, 25, true, false);
        									
		fUnicodeFont.getEffects().add(new ColorEffect());
        fUnicodeFont.addAsciiGlyphs();
        fUnicodeFont.loadGlyphs();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		frontBack = new Image("res/frontback.png");
		farBack = new Image("res/farback.png");
		playLeftBG = new Image("res/playleftbg.png");
		playRightBG = new Image("res/playrightbg.png");
		gameMeter = new Image("res/gameMeter.png");
		
		//good bow stuff
		goodBow1 = new Image("res/towerbow.png");
		goodBow2 = new Image("res/towerbow2.png");
		bowMeter = new Image("res/powerMeter.png");
		
			///////WARRIOR THINGS///////
			w0 = new Image("res/warrior1.png");
			w1 = new Image("res/warrior1.png");
			w2 = new Image("res/warrior1.png");
			w3 = new Image("res/warrior1.png");
			w4 = new Image("res/warrior1.png");
			w5 = new Image("res/warrior1.png");
			w6 = new Image("res/warrior1.png");
			w7 = new Image("res/warrior1.png");
			w8 = new Image("res/warrior1.png");
			w9 = new Image("res/warrior1.png");
			w10 = new Image("res/warrior1.png");
			w11 = new Image("res/warrior1.png");
			w12 = new Image("res/warrior1.png");
			w13 = new Image("res/warrior1.png");
			w14 = new Image("res/warrior1.png");
			
			w020 = new Image("res/warrior2.png");
			w120 = new Image("res/warrior2.png");
			w220 = new Image("res/warrior2.png");
			w320 = new Image("res/warrior2.png");
			w420 = new Image("res/warrior2.png");
			w520 = new Image("res/warrior2.png");
			w620 = new Image("res/warrior2.png");
			w720 = new Image("res/warrior2.png");
			w820 = new Image("res/warrior2.png");
			w920 = new Image("res/warrior2.png");
			w1000 = new Image("res/warrior2.png");
			w1100 = new Image("res/warrior2.png");
			w1200 = new Image("res/warrior2.png");
			w1300 = new Image("res/warrior2.png");
			w1400 = new Image("res/warrior2.png");
			
				picArray[0] = w0;
				picArray[1] = w1;
				picArray[2] = w2;
				picArray[3] = w3;
				picArray[4] = w4;
				picArray[5] = w5;
				picArray[6] = w6;
				picArray[7] = w7;
				picArray[8] = w8;
				picArray[9] = w9;
				picArray[10] = w10;
				picArray[11] = w11;
				picArray[12] = w12;
				picArray[13] = w13;
				picArray[14] = w14;

				picArray2[0] = w020;
				picArray2[1] = w120;
				picArray2[2] = w220;
				picArray2[3] = w320;
				picArray2[4] = w420;
				picArray2[5] = w520;
				picArray2[6] = w620;
				picArray2[7] = w720;
				picArray2[8] = w820;
				picArray2[9] = w920;
				picArray2[10] = w1000;
				picArray2[11] = w1100;
				picArray2[12] = w1200;
				picArray2[13] = w1300;
				picArray2[14] = w1400;
			
			
				
				wIcon = new Image("res/wIcon.png");
				gIcon = new Image("res/gIcon.png");
				aIcon = new Image("res/aIcon.png");
				cIcon = new Image("res/catapultIcon.png");
				pIcon = new Image("res/pIcon.png");
				
				badw0 = new Image("res/badwarrior1.png");
				badw1 = new Image("res/badwarrior1.png");
				badw2 = new Image("res/badwarrior1.png");
				badw3 = new Image("res/badwarrior1.png");
				badw4 = new Image("res/badwarrior1.png");
				badw5 = new Image("res/badwarrior1.png");
				badw6 = new Image("res/badwarrior1.png");
				badw7 = new Image("res/badwarrior1.png");
				badw8 = new Image("res/badwarrior1.png");
				badw9 = new Image("res/badwarrior1.png");
				badw10 = new Image("res/badwarrior1.png");
				badw11 = new Image("res/badwarrior1.png");
				badw12 = new Image("res/badwarrior1.png");
				badw13 = new Image("res/badwarrior1.png");
				badw14 = new Image("res/badwarrior1.png");
				
				badw020 = new Image("res/badwarrior2.png");
				badw120 = new Image("res/badwarrior2.png");
				badw220 = new Image("res/badwarrior2.png");
				badw320 = new Image("res/badwarrior2.png");
				badw420 = new Image("res/badwarrior2.png");
				badw520 = new Image("res/badwarrior2.png");
				badw620 = new Image("res/badwarrior2.png");
				badw720 = new Image("res/badwarrior2.png");
				badw820 = new Image("res/badwarrior2.png");
				badw920 = new Image("res/badwarrior2.png");
				badw1000 = new Image("res/badwarrior2.png");
				badw1100 = new Image("res/badwarrior2.png");
				badw1200 = new Image("res/badwarrior2.png");
				badw1300 = new Image("res/badwarrior2.png");
				badw1400 = new Image("res/badwarrior2.png");
				
				badpicArray[0] = badw0;
				badpicArray[1] = badw1;
				badpicArray[2] = badw2;
				badpicArray[3] = badw3;
				badpicArray[4] = badw4;
				badpicArray[5] = badw5;
				badpicArray[6] = badw6;
				badpicArray[7] = badw7;
				badpicArray[8] = badw8;
				badpicArray[9] = badw9;
				badpicArray[10] = badw10;
				badpicArray[11] = badw11;
				badpicArray[12] = badw12;
				badpicArray[13] = badw13;
				badpicArray[14] = badw14;
				
				badpicArray2[0] = badw020;
				badpicArray2[1] = badw120;
				badpicArray2[2] = badw220;
				badpicArray2[3] = badw320;
				badpicArray2[4] = badw420;
				badpicArray2[5] = badw520;
				badpicArray2[6] = badw620;
				badpicArray2[7] = badw720;
				badpicArray2[8] = badw820;
				badpicArray2[9] = badw920;	
				badpicArray2[10] = badw1000;
				badpicArray2[11] = badw1100;
				badpicArray2[12] = badw1200;
				badpicArray2[13] = badw1300;
				badpicArray2[14] = badw1400;
				
				//GOOD ARCHER STUFF
				
				a0 = new Image("res/archer1.png");
				a1 = new Image("res/archer1.png");
				a2 = new Image("res/archer1.png");
				a3 = new Image("res/archer1.png");
				a4 = new Image("res/archer1.png");
				a5 = new Image("res/archer1.png");
				a6 = new Image("res/archer1.png");
				a7 = new Image("res/archer1.png");
				a8 = new Image("res/archer1.png");
				a9 = new Image("res/archer1.png");
				a10 = new Image("res/archer1.png");
				a11 = new Image("res/archer1.png");
				a12 = new Image("res/archer1.png");
				a13 = new Image("res/archer1.png");
				a14 = new Image("res/archer1.png");
				
				a02 = new Image("res/archer2.png");
				a120 = new Image("res/archer2.png");
				a22 = new Image("res/archer2.png");
				a32 = new Image("res/archer2.png");
				a42 = new Image("res/archer2.png");
				a52 = new Image("res/archer2.png");
				a62 = new Image("res/archer2.png");
				a72 = new Image("res/archer2.png");
				a82 = new Image("res/archer2.png");
				a92 = new Image("res/archer2.png");
				a1000 = new Image("res/archer2.png");
				a1100 = new Image("res/archer2.png");
				a1200 = new Image("res/archer2.png");
				a1300 = new Image("res/archer2.png");
				a1400 = new Image("res/archer2.png");
				
				a002 = new Image("res/archer3.png");
				a0120 = new Image("res/archer3.png");
				a022 = new Image("res/archer3.png");
				a032 = new Image("res/archer3.png");
				a042 = new Image("res/archer3.png");
				a052 = new Image("res/archer3.png");
				a062 = new Image("res/archer3.png");
				a072 = new Image("res/archer3.png");
				a082 = new Image("res/archer3.png");
				a092 = new Image("res/archer3.png");
				a01000 = new Image("res/archer3.png");
				a01100 = new Image("res/archer3.png");
				a01200 = new Image("res/archer3.png");
				a01300 = new Image("res/archer3.png");
				a01400 = new Image("res/archer3.png");
				
				a0002 = new Image("res/archer4.png");
				a00120 = new Image("res/archer4.png");
				a0022 = new Image("res/archer4.png");
				a0032 = new Image("res/archer4.png");
				a0042 = new Image("res/archer4.png");
				a0052 = new Image("res/archer4.png");
				a0062 = new Image("res/archer4.png");
				a0072 = new Image("res/archer4.png");
				a0082 = new Image("res/archer4.png");
				a0092 = new Image("res/archer4.png");
				a001000 = new Image("res/archer4.png");
				a001100 = new Image("res/archer4.png");
				a001200 = new Image("res/archer4.png");
				a001300 = new Image("res/archer4.png");
				a001400 = new Image("res/archer4.png");
				
				ar0 = new Image("res/arrow.png");
				ar1 = new Image("res/arrow.png");
				ar2 = new Image("res/arrow.png");
				ar3 = new Image("res/arrow.png");
				ar4 = new Image("res/arrow.png");
				ar5 = new Image("res/arrow.png");
				ar6 = new Image("res/arrow.png");
				ar7 = new Image("res/arrow.png");
				ar8 = new Image("res/arrow.png");
				ar9 = new Image("res/arrow.png");
				ar10 = new Image("res/arrow.png");
				ar11 = new Image("res/arrow.png");
				ar12 = new Image("res/arrow.png");
				ar13 = new Image("res/arrow.png");
				ar14 = new Image("res/arrow.png");
				
				ar00 = new Image("res/arrow2.png");
				ar01 = new Image("res/arrow2.png");
				ar02 = new Image("res/arrow2.png");
				ar03 = new Image("res/arrow2.png");
				ar04 = new Image("res/arrow2.png");
				ar05 = new Image("res/arrow2.png");
				ar06 = new Image("res/arrow2.png");
				ar07 = new Image("res/arrow2.png");
				ar08 = new Image("res/arrow2.png");
				ar09 = new Image("res/arrow2.png");
				ar010 = new Image("res/arrow2.png");
				ar011 = new Image("res/arrow2.png");
				ar012 = new Image("res/arrow2.png");
				ar013 = new Image("res/arrow2.png");
				ar014 = new Image("res/arrow2.png");
				
					apicArray[0] = a0;
					apicArray[1] = a1;
					apicArray[2] = a2;
					apicArray[3] = a3;
					apicArray[4] = a4;
					apicArray[5] = a5;
					apicArray[6] = a6;
					apicArray[7] = a7;
					apicArray[8] = a8;
					apicArray[9] = a9;
					apicArray[10] = a10;
					apicArray[11] = a11;
					apicArray[12] = a12;
					apicArray[13] = a13;
					apicArray[14] = a14;

					apicArray2[0] = a02;
					apicArray2[1] = a120;
					apicArray2[2] = a22;
					apicArray2[3] = a32;
					apicArray2[4] = a42;
					apicArray2[5] = a52;
					apicArray2[6] = a62;
					apicArray2[7] = a72;
					apicArray2[8] = a82;
					apicArray2[9] = a92;
					apicArray2[10] = a1000;
					apicArray2[11] = a1100;
					apicArray2[12] = a1200;
					apicArray2[13] = a1300;
					apicArray2[14] = a1400;
					
					apicArray3[0] = a002;
					apicArray3[1] = a0120;
					apicArray3[2] = a022;
					apicArray3[3] = a032;
					apicArray3[4] = a042;
					apicArray3[5] = a052;
					apicArray3[6] = a062;
					apicArray3[7] = a072;
					apicArray3[8] = a082;
					apicArray3[9] = a092;
					apicArray3[10] = a01000;
					apicArray3[11] = a01100;
					apicArray3[12] = a01200;
					apicArray3[13] = a01300;
					apicArray3[14] = a01400;
					
					apicArray4[0] = a0002;
					apicArray4[1] = a00120;
					apicArray4[2] = a0022;
					apicArray4[3] = a0032;
					apicArray4[4] = a0042;
					apicArray4[5] = a0052;
					apicArray4[6] = a0062;
					apicArray4[7] = a0072;
					apicArray4[8] = a0082;
					apicArray4[9] = a0092;
					apicArray4[10] = a001000;
					apicArray4[11] = a001100;
					apicArray4[12] = a001200;
					apicArray4[13] = a001300;
					apicArray4[14] = a001400;
					
					arpicArray[0] = ar0;
					arpicArray[1] = ar1;
					arpicArray[2] = ar2;
					arpicArray[3] = ar3;
					arpicArray[4] = ar4;
					arpicArray[5] = ar5;
					arpicArray[6] = ar6;
					arpicArray[7] = ar7;
					arpicArray[8] = ar8;
					arpicArray[9] = ar9;	
					arpicArray[10] = ar10;
					arpicArray[11] = ar11;
					arpicArray[12] = ar12;
					arpicArray[13] = ar13;
					arpicArray[14] = ar14;
					
					arpicArray2[0] = ar00;
					arpicArray2[1] = ar01;
					arpicArray2[2] = ar02;
					arpicArray2[3] = ar03;
					arpicArray2[4] = ar04;
					arpicArray2[5] = ar05;
					arpicArray2[6] = ar06;
					arpicArray2[7] = ar07;
					arpicArray2[8] = ar08;
					arpicArray2[9] = ar09;	
					arpicArray2[10] = ar010;
					arpicArray2[11] = ar011;
					arpicArray2[12] = ar012;
					arpicArray2[13] = ar013;
					arpicArray2[14] = ar014;
					
					//BAD ARCHER STUFF
					
					ba0 = new Image("res/badarcher1.png");
					ba1 = new Image("res/badarcher1.png");
					ba2 = new Image("res/badarcher1.png");
					ba3 = new Image("res/badarcher1.png");
					ba4 = new Image("res/badarcher1.png");
					ba5 = new Image("res/badarcher1.png");
					ba6 = new Image("res/badarcher1.png");
					ba7 = new Image("res/badarcher1.png");
					ba8 = new Image("res/badarcher1.png");
					ba9 = new Image("res/badarcher1.png");
					ba10 = new Image("res/badarcher1.png");
					ba11 = new Image("res/badarcher1.png");
					ba12 = new Image("res/badarcher1.png");
					ba13 = new Image("res/badarcher1.png");
					ba14 = new Image("res/badarcher1.png");
					
					ba02 = new Image("res/badarcher2.png");
					ba120 = new Image("res/badarcher2.png");
					ba22 = new Image("res/badarcher2.png");
					ba32 = new Image("res/badarcher2.png");
					ba42 = new Image("res/badarcher2.png");
					ba52 = new Image("res/badarcher2.png");
					ba62 = new Image("res/badarcher2.png");
					ba72 = new Image("res/badarcher2.png");
					ba82 = new Image("res/badarcher2.png");
					ba92 = new Image("res/badarcher2.png");
					ba1000 = new Image("res/badarcher2.png");
					ba1100 = new Image("res/badarcher2.png");
					ba1200 = new Image("res/badarcher2.png");
					ba1300 = new Image("res/badarcher2.png");
					ba1400 = new Image("res/badarcher2.png");
					
					ba002 = new Image("res/badarcher3.png");
					ba0120 = new Image("res/badarcher3.png");
					ba022 = new Image("res/badarcher3.png");
					ba032 = new Image("res/badarcher3.png");
					ba042 = new Image("res/badarcher3.png");
					ba052 = new Image("res/badarcher3.png");
					ba062 = new Image("res/badarcher3.png");
					ba072 = new Image("res/badarcher3.png");
					ba082 = new Image("res/badarcher3.png");
					ba092 = new Image("res/badarcher3.png");
					ba01000 = new Image("res/badarcher3.png");
					ba01100 = new Image("res/badarcher3.png");
					ba01200 = new Image("res/badarcher3.png");
					ba01300 = new Image("res/badarcher3.png");
					ba01400 = new Image("res/badarcher3.png");
					
					ba0002 = new Image("res/badarcher4.png");
					ba00120 = new Image("res/badarcher4.png");
					ba0022 = new Image("res/badarcher4.png");
					ba0032 = new Image("res/badarcher4.png");
					ba0042 = new Image("res/badarcher4.png");
					ba0052 = new Image("res/badarcher4.png");
					ba0062 = new Image("res/badarcher4.png");
					ba0072 = new Image("res/badarcher4.png");
					ba0082 = new Image("res/badarcher4.png");
					ba0092 = new Image("res/badarcher4.png");
					ba001000 = new Image("res/badarcher4.png");
					ba001100 = new Image("res/badarcher4.png");
					ba001200 = new Image("res/badarcher4.png");
					ba001300 = new Image("res/badarcher4.png");
					ba001400 = new Image("res/badarcher4.png");
					
					bar0 = new Image("res/badarrow.png");
					bar1 = new Image("res/badarrow.png");
					bar2 = new Image("res/badarrow.png");
					bar3 = new Image("res/badarrow.png");
					bar4 = new Image("res/badarrow.png");
					bar5 = new Image("res/badarrow.png");
					bar6 = new Image("res/badarrow.png");
					bar7 = new Image("res/badarrow.png");
					bar8 = new Image("res/badarrow.png");
					bar9 = new Image("res/badarrow.png");
					bar10 = new Image("res/badarrow.png");
					bar11 = new Image("res/badarrow.png");
					bar12 = new Image("res/badarrow.png");
					bar13 = new Image("res/badarrow.png");
					bar14 = new Image("res/badarrow.png");
					
					bar00 = new Image("res/badarrow2.png");
					bar01 = new Image("res/badarrow2.png");
					bar02 = new Image("res/badarrow2.png");
					bar03 = new Image("res/badarrow2.png");
					bar04 = new Image("res/badarrow2.png");
					bar05 = new Image("res/badarrow2.png");
					bar06 = new Image("res/badarrow2.png");
					bar07 = new Image("res/badarrow2.png");
					bar08 = new Image("res/badarrow2.png");
					bar09 = new Image("res/badarrow2.png");
					bar010 = new Image("res/badarrow2.png");
					bar011 = new Image("res/badarrow2.png");
					bar012 = new Image("res/badarrow2.png");
					bar013 = new Image("res/badarrow2.png");
					bar014 = new Image("res/badarrow2.png");
					
						bapicArray[0] = ba0;
						bapicArray[1] = ba1;
						bapicArray[2] = ba2;
						bapicArray[3] = ba3;
						bapicArray[4] = ba4;
						bapicArray[5] = ba5;
						bapicArray[6] = ba6;
						bapicArray[7] = ba7;
						bapicArray[8] = ba8;
						bapicArray[9] = ba9;
						bapicArray[10] = ba10;
						bapicArray[11] = ba11;
						bapicArray[12] = ba12;
						bapicArray[13] = ba13;
						bapicArray[14] = ba14;

						bapicArray2[0] = ba02;
						bapicArray2[1] = ba120;
						bapicArray2[2] = ba22;
						bapicArray2[3] = ba32;
						bapicArray2[4] = ba42;
						bapicArray2[5] = ba52;
						bapicArray2[6] = ba62;
						bapicArray2[7] = ba72;
						bapicArray2[8] = ba82;
						bapicArray2[9] = ba92;
						bapicArray2[10] = ba1000;
						bapicArray2[11] = ba1100;
						bapicArray2[12] = ba1200;
						bapicArray2[13] = ba1300;
						bapicArray2[14] = ba1400;
						
						bapicArray3[0] = ba002;
						bapicArray3[1] = ba0120;
						bapicArray3[2] = ba022;
						bapicArray3[3] = ba032;
						bapicArray3[4] = ba042;
						bapicArray3[5] = ba052;
						bapicArray3[6] = ba062;
						bapicArray3[7] = ba072;
						bapicArray3[8] = ba082;
						bapicArray3[9] = ba092;
						bapicArray3[10] = ba01000;
						bapicArray3[11] = ba01100;
						bapicArray3[12] = ba01200;
						bapicArray3[13] = ba01300;
						bapicArray3[14] = ba01400;
						
						bapicArray4[0] = ba0002;
						bapicArray4[1] = ba00120;
						bapicArray4[2] = ba0022;
						bapicArray4[3] = ba0032;
						bapicArray4[4] = ba0042;
						bapicArray4[5] = ba0052;
						bapicArray4[6] = ba0062;
						bapicArray4[7] = ba0072;
						bapicArray4[8] = ba0082;
						bapicArray4[9] = ba0092;
						bapicArray4[10] = ba001000;
						bapicArray4[11] = ba001100;
						bapicArray4[12] = ba001200;
						bapicArray4[13] = ba001300;
						bapicArray4[14] = ba001400;
						
						barpicArray[0] = bar0;
						barpicArray[1] = bar1;
						barpicArray[2] = bar2;
						barpicArray[3] = bar3;
						barpicArray[4] = bar4;
						barpicArray[5] = bar5;
						barpicArray[6] = bar6;
						barpicArray[7] = bar7;
						barpicArray[8] = bar8;
						barpicArray[9] = bar9;	
						barpicArray[10] = bar10;
						barpicArray[11] = bar11;
						barpicArray[12] = bar12;
						barpicArray[13] = bar13;
						barpicArray[14] = bar14;
						
						barpicArray2[0] = bar00;
						barpicArray2[1] = bar01;
						barpicArray2[2] = bar02;
						barpicArray2[3] = bar03;
						barpicArray2[4] = bar04;
						barpicArray2[5] = bar05;
						barpicArray2[6] = bar06;
						barpicArray2[7] = bar07;
						barpicArray2[8] = bar08;
						barpicArray2[9] = bar09;	
						barpicArray2[10] = bar010;
						barpicArray2[11] = bar011;
						barpicArray2[12] = bar012;
						barpicArray2[13] = bar013;
						barpicArray2[14] = bar014;
					
					//GOOD GOLEM
						g0 = new Image("res/golem.png");
						g1 = new Image("res/golem.png");
						g2 = new Image("res/golem.png");
						g3 = new Image("res/golem.png");
						g4 = new Image("res/golem.png");
						g5 = new Image("res/golem.png");
						g6 = new Image("res/golem.png");
						g7 = new Image("res/golem.png");
						g8 = new Image("res/golem.png");
						g9 = new Image("res/golem.png");
						g10 = new Image("res/golem.png");
						g11 = new Image("res/golem.png");
						g12 = new Image("res/golem.png");
						g13 = new Image("res/golem.png");
						g14 = new Image("res/golem.png");
						
						g020 = new Image("res/golem2.png");
						g120 = new Image("res/golem2.png");
						g220 = new Image("res/golem2.png");
						g320 = new Image("res/golem2.png");
						g420 = new Image("res/golem2.png");
						g520 = new Image("res/golem2.png");
						g620 = new Image("res/golem2.png");
						g720 = new Image("res/golem2.png");
						g820 = new Image("res/golem2.png");
						g920 = new Image("res/golem2.png");
						g1000 = new Image("res/golem2.png");
						g1100 = new Image("res/golem2.png");
						g1200 = new Image("res/golem2.png");
						g1300 = new Image("res/golem2.png");
						g1400 = new Image("res/golem2.png");
						
						gpicArray[0] = g0;
						gpicArray[1] = g1;
						gpicArray[2] = g2;
						gpicArray[3] = g3;
						gpicArray[4] = g4;
						gpicArray[5] = g5;
						gpicArray[6] = g6;
						gpicArray[7] = g7;
						gpicArray[8] = g8;
						gpicArray[9] = g9;
						gpicArray[10] = g10;
						gpicArray[11] = g11;
						gpicArray[12] = g12;
						gpicArray[13] = g13;
						gpicArray[14] = g14;
						
						gpicArray2[0] = g020;
						gpicArray2[1] = g120;
						gpicArray2[2] = g220;
						gpicArray2[3] = g320;
						gpicArray2[4] = g420;
						gpicArray2[5] = g520;
						gpicArray2[6] = g620;
						gpicArray2[7] = g720;
						gpicArray2[8] = g820;
						gpicArray2[9] = g920;
						gpicArray2[10] = g1000;
						gpicArray2[11] = g1100;
						gpicArray2[12] = g1200;
						gpicArray2[13] = g1300;
						gpicArray2[14] = g1400;
						
						//BAD GOLEM
						badg0 = new Image("res/badgolem.png");
						badg1 = new Image("res/badgolem.png");
						badg2 = new Image("res/badgolem.png");
						badg3 = new Image("res/badgolem.png");
						badg4 = new Image("res/badgolem.png");
						badg5 = new Image("res/badgolem.png");
						badg6 = new Image("res/badgolem.png");
						badg7 = new Image("res/badgolem.png");
						badg8 = new Image("res/badgolem.png");
						badg9 = new Image("res/badgolem.png");
						badg10 = new Image("res/badgolem.png");
						badg11 = new Image("res/badgolem.png");
						badg12 = new Image("res/badgolem.png");
						badg13 = new Image("res/badgolem.png");
						badg14 = new Image("res/badgolem.png");
						
						badg020 = new Image("res/badgolem2.png");
						badg120 = new Image("res/badgolem2.png");
						badg220 = new Image("res/badgolem2.png");
						badg320 = new Image("res/badgolem2.png");
						badg420 = new Image("res/badgolem2.png");
						badg520 = new Image("res/badgolem2.png");
						badg620 = new Image("res/badgolem2.png");
						badg720 = new Image("res/badgolem2.png");
						badg820 = new Image("res/badgolem2.png");
						badg920 = new Image("res/badgolem2.png");
						badg1000 = new Image("res/badgolem2.png");
						badg1100 = new Image("res/badgolem2.png");
						badg1200 = new Image("res/badgolem2.png");
						badg1300 = new Image("res/badgolem2.png");
						badg1400 = new Image("res/badgolem2.png");
						
						badgpicArray[0] = badg0;
						badgpicArray[1] = badg1;
						badgpicArray[2] = badg2;
						badgpicArray[3] = badg3;
						badgpicArray[4] = badg4;
						badgpicArray[5] = badg5;
						badgpicArray[6] = badg6;
						badgpicArray[7] = badg7;
						badgpicArray[8] = badg8;
						badgpicArray[9] = badg9;
						badgpicArray[10] = badg10;
						badgpicArray[11] = badg11;
						badgpicArray[12] = badg12;
						badgpicArray[13] = badg13;
						badgpicArray[14] = badg14;
						
						badgpicArray2[0] = badg020;
						badgpicArray2[1] = badg120;
						badgpicArray2[2] = badg220;
						badgpicArray2[3] = badg320;
						badgpicArray2[4] = badg420;
						badgpicArray2[5] = badg520;
						badgpicArray2[6] = badg620;
						badgpicArray2[7] = badg720;
						badgpicArray2[8] = badg820;
						badgpicArray2[9] = badg920;	
						badgpicArray2[10] = badg1000;
						badgpicArray2[11] = badg1100;
						badgpicArray2[12] = badg1200;
						badgpicArray2[13] = badg1300;
						badgpicArray2[14] = badg1400;
						

						//GOOD CATAPULT STUFF
						
						c0 = new Image("res/catapult.png");
						c1 = new Image("res/catapult.png");
						c2 = new Image("res/catapult.png");
						c3 = new Image("res/catapult.png");
						c4 = new Image("res/catapult.png");
						c5 = new Image("res/catapult.png");
						c6 = new Image("res/catapult.png");
						c7 = new Image("res/catapult.png");
						c8 = new Image("res/catapult.png");
						c9 = new Image("res/catapult.png");
						c10 = new Image("res/catapult.png");
						c11 = new Image("res/catapult.png");
						c12 = new Image("res/catapult.png");
						c13 = new Image("res/catapult.png");
						c14 = new Image("res/catapult.png");
						
						c02 = new Image("res/catapult2.png");
						c120 = new Image("res/catapult2.png");
						c22 = new Image("res/catapult2.png");
						c32 = new Image("res/catapult2.png");
						c42 = new Image("res/catapult2.png");
						c52 = new Image("res/catapult2.png");
						c62 = new Image("res/catapult2.png");
						c72 = new Image("res/catapult2.png");
						c82 = new Image("res/catapult2.png");
						c92 = new Image("res/catapult2.png");
						c1000 = new Image("res/catapult2.png");
						c1100 = new Image("res/catapult2.png");
						c1200 = new Image("res/catapult2.png");
						c1300 = new Image("res/catapult2.png");
						c1400 = new Image("res/catapult2.png");
						
						ca0 = new Image("res/catapultammo.png");
						ca1 = new Image("res/catapultammo.png");
						ca2 = new Image("res/catapultammo.png");
						ca3 = new Image("res/catapultammo.png");
						ca4 = new Image("res/catapultammo.png");
						ca5 = new Image("res/catapultammo.png");
						ca6 = new Image("res/catapultammo.png");
						ca7 = new Image("res/catapultammo.png");
						ca8 = new Image("res/catapultammo.png");
						ca9 = new Image("res/catapultammo.png");
						ca10 = new Image("res/catapultammo.png");
						ca11 = new Image("res/catapultammo.png");
						ca12 = new Image("res/catapultammo.png");
						ca13 = new Image("res/catapultammo.png");
						ca14 = new Image("res/catapultammo.png");
						
							cpicArray[0] = c0;
							cpicArray[1] = c1;
							cpicArray[2] = c2;
							cpicArray[3] = c3;
							cpicArray[4] = c4;
							cpicArray[5] = c5;
							cpicArray[6] = c6;
							cpicArray[7] = c7;
							cpicArray[8] = c8;
							cpicArray[9] = c9;
							cpicArray[10] = c10;
							cpicArray[11] = c11;
							cpicArray[12] = c12;
							cpicArray[13] = c13;
							cpicArray[14] = c14;

							cpicArray2[0] = c02;
							cpicArray2[1] = c120;
							cpicArray2[2] = c22;
							cpicArray2[3] = c32;
							cpicArray2[4] = c42;
							cpicArray2[5] = c52;
							cpicArray2[6] = c62;
							cpicArray2[7] = c72;
							cpicArray2[8] = c82;
							cpicArray2[9] = c92;
							cpicArray2[10] = c1000;
							cpicArray2[11] = c1100;
							cpicArray2[12] = c1200;
							cpicArray2[13] = c1300;
							cpicArray2[14] = c1400;
							
							capicArray[0] = ca0;
							capicArray[1] = ca1;
							capicArray[2] = ca2;
							capicArray[3] = ca3;
							capicArray[4] = ca4;
							capicArray[5] = ca5;
							capicArray[6] = ca6;
							capicArray[7] = ca7;
							capicArray[8] = ca8;
							capicArray[9] = ca9;	
							capicArray[10] = ca10;
							capicArray[11] = ca11;
							capicArray[12] = ca12;
							capicArray[13] = ca13;
							capicArray[14] = ca14;
							
							//BAD CATAPULT STUFF
							
							bc0 = new Image("res/badcatapult.png");
							bc1 = new Image("res/badcatapult.png");
							bc2 = new Image("res/badcatapult.png");
							bc3 = new Image("res/badcatapult.png");
							bc4 = new Image("res/badcatapult.png");
							bc5 = new Image("res/badcatapult.png");
							bc6 = new Image("res/badcatapult.png");
							bc7 = new Image("res/badcatapult.png");
							bc8 = new Image("res/badcatapult.png");
							bc9 = new Image("res/badcatapult.png");
							bc10 = new Image("res/badcatapult.png");
							bc11 = new Image("res/badcatapult.png");
							bc12 = new Image("res/badcatapult.png");
							bc13 = new Image("res/badcatapult.png");
							bc14 = new Image("res/badcatapult.png");
							
							bc02 = new Image("res/badcatapult2.png");
							bc120 = new Image("res/badcatapult2.png");
							bc22 = new Image("res/badcatapult2.png");
							bc32 = new Image("res/badcatapult2.png");
							bc42 = new Image("res/badcatapult2.png");
							bc52 = new Image("res/badcatapult2.png");
							bc62 = new Image("res/badcatapult2.png");
							bc72 = new Image("res/badcatapult2.png");
							bc82 = new Image("res/badcatapult2.png");
							bc92 = new Image("res/badcatapult2.png");
							bc1000 = new Image("res/badcatapult2.png");
							bc1100 = new Image("res/badcatapult2.png");
							bc1200 = new Image("res/badcatapult2.png");
							bc1300 = new Image("res/badcatapult2.png");
							bc1400 = new Image("res/badcatapult2.png");
							
							bca0 = new Image("res/badcatapultammo.png");
							bca1 = new Image("res/badcatapultammo.png");
							bca2 = new Image("res/badcatapultammo.png");
							bca3 = new Image("res/badcatapultammo.png");
							bca4 = new Image("res/badcatapultammo.png");
							bca5 = new Image("res/badcatapultammo.png");
							bca6 = new Image("res/badcatapultammo.png");
							bca7 = new Image("res/badcatapultammo.png");
							bca8 = new Image("res/badcatapultammo.png");
							bca9 = new Image("res/badcatapultammo.png");
							bca10 = new Image("res/badcatapultammo.png");
							bca11 = new Image("res/badcatapultammo.png");
							bca12 = new Image("res/badcatapultammo.png");
							bca13 = new Image("res/badcatapultammo.png");
							bca14 = new Image("res/badcatapultammo.png");
							
								bcpicArray[0] = bc0;
								bcpicArray[1] = bc1;
								bcpicArray[2] = bc2;
								bcpicArray[3] = bc3;
								bcpicArray[4] = bc4;
								bcpicArray[5] = bc5;
								bcpicArray[6] = bc6;
								bcpicArray[7] = bc7;
								bcpicArray[8] = bc8;
								bcpicArray[9] = bc9;
								bcpicArray[10] = bc10;
								bcpicArray[11] = bc11;
								bcpicArray[12] = bc12;
								bcpicArray[13] = bc13;
								bcpicArray[14] = bc14;

								bcpicArray2[0] = bc02;
								bcpicArray2[1] = bc120;
								bcpicArray2[2] = bc22;
								bcpicArray2[3] = bc32;
								bcpicArray2[4] = bc42;
								bcpicArray2[5] = bc52;
								bcpicArray2[6] = bc62;
								bcpicArray2[7] = bc72;
								bcpicArray2[8] = bc82;
								bcpicArray2[9] = bc92;
								bcpicArray2[10] = bc1000;
								bcpicArray2[11] = bc1100;
								bcpicArray2[12] = bc1200;
								bcpicArray2[13] = bc1300;
								bcpicArray2[14] = bc1400;
								
								bcapicArray[0] = bca0;
								bcapicArray[1] = bca1;
								bcapicArray[2] = bca2;
								bcapicArray[3] = bca3;
								bcapicArray[4] = bca4;
								bcapicArray[5] = bca5;
								bcapicArray[6] = bca6;
								bcapicArray[7] = bca7;
								bcapicArray[8] = bca8;
								bcapicArray[9] = bca9;	
								bcapicArray[10] =bca10;
								bcapicArray[11] = bca11;
								bcapicArray[12] = bca12;
								bcapicArray[13] = bca13;
								bcapicArray[14] = bca14;
								
								//GOOD PHOENIX STUFF
								
								p0 = new Image("res/phoenix.png");
								p1 = new Image("res/phoenix.png");
								p2 = new Image("res/phoenix.png");
								p3 = new Image("res/phoenix.png");
								p4 = new Image("res/phoenix.png");
								p5 = new Image("res/phoenix.png");
								p6 = new Image("res/phoenix.png");
								p7 = new Image("res/phoenix.png");
								p8 = new Image("res/phoenix.png");
								p9 = new Image("res/phoenix.png");
								p10 = new Image("res/phoenix.png");
								p11 = new Image("res/phoenix.png");
								p12 = new Image("res/phoenix.png");
								p13 = new Image("res/phoenix.png");
								p14 = new Image("res/phoenix.png");
								
								p02 = new Image("res/phoenix2.png");
								p120 = new Image("res/phoenix2.png");
								p22 = new Image("res/phoenix2.png");
								p32 = new Image("res/phoenix2.png");
								p42 = new Image("res/phoenix2.png");
								p52 = new Image("res/phoenix2.png");
								p62 = new Image("res/phoenix2.png");
								p72 = new Image("res/phoenix2.png");
								p82 = new Image("res/phoenix2.png");
								p92 = new Image("res/phoenix2.png");
								p1000 = new Image("res/phoenix2.png");
								p1100 = new Image("res/phoenix2.png");
								p1200 = new Image("res/phoenix2.png");
								p1300 = new Image("res/phoenix2.png");
								p1400 = new Image("res/phoenix2.png");
								
								pr0 = new Image("res/phoenixammo.png");
								pr1 = new Image("res/phoenixammo.png");
								pr2 = new Image("res/phoenixammo.png");
								pr3 = new Image("res/phoenixammo.png");
								pr4 = new Image("res/phoenixammo.png");
								pr5 = new Image("res/phoenixammo.png");
								pr6 = new Image("res/phoenixammo.png");
								pr7 = new Image("res/phoenixammo.png");
								pr8 = new Image("res/phoenixammo.png");
								pr9 = new Image("res/phoenixammo.png");
								pr10 = new Image("res/phoenixammo.png");
								pr11 = new Image("res/phoenixammo.png");
								pr12 = new Image("res/phoenixammo.png");
								pr13 = new Image("res/phoenixammo.png");
								pr14 = new Image("res/phoenixammo.png");
								
								pr00 = new Image("res/phoenixammo2.png");
								pr01 = new Image("res/phoenixammo2.png");
								pr02 = new Image("res/phoenixammo2.png");
								pr03 = new Image("res/phoenixammo2.png");
								pr04 = new Image("res/phoenixammo2.png");
								pr05 = new Image("res/phoenixammo2.png");
								pr06 = new Image("res/phoenixammo2.png");
								pr07 = new Image("res/phoenixammo2.png");
								pr08 = new Image("res/phoenixammo2.png");
								pr09 = new Image("res/phoenixammo2.png");
								pr010 = new Image("res/phoenixammo2.png");
								pr011 = new Image("res/phoenixammo2.png");
								pr012 = new Image("res/phoenixammo2.png");
								pr013 = new Image("res/phoenixammo2.png");
								pr014 = new Image("res/phoenixammo2.png");
								
									ppicArray[0] = p0;
									ppicArray[1] = p1;
									ppicArray[2] = p2;
									ppicArray[3] = p3;
									ppicArray[4] = p4;
									ppicArray[5] = p5;
									ppicArray[6] = p6;
									ppicArray[7] = p7;
									ppicArray[8] = p8;
									ppicArray[9] = p9;
									ppicArray[10] = p10;
									ppicArray[11] = p11;
									ppicArray[12] = p12;
									ppicArray[13] = p13;
									ppicArray[14] = p14;

									ppicArray2[0] = p02;
									ppicArray2[1] = p120;
									ppicArray2[2] = p22;
									ppicArray2[3] = p32;
									ppicArray2[4] = p42;
									ppicArray2[5] = p52;
									ppicArray2[6] = p62;
									ppicArray2[7] = p72;
									ppicArray2[8] = p82;
									ppicArray2[9] = p92;
									ppicArray2[10] = p1000;
									ppicArray2[11] = p1100;
									ppicArray2[12] = p1200;
									ppicArray2[13] = p1300;
									ppicArray2[14] = p1400;
									
									prpicArray[0] = pr0;
									prpicArray[1] = pr1;
									prpicArray[2] = pr2;
									prpicArray[3] = pr3;
									prpicArray[4] = pr4;
									prpicArray[5] = pr5;
									prpicArray[6] = pr6;
									prpicArray[7] = pr7;
									prpicArray[8] = pr8;
									prpicArray[9] = pr9;	
									prpicArray[10] = pr10;
									prpicArray[11] = pr11;
									prpicArray[12] = pr12;
									prpicArray[13] = pr13;
									prpicArray[14] = pr14;
									
									prpicArray2[0] = pr00;
									prpicArray2[1] = pr01;
									prpicArray2[2] = pr02;
									prpicArray2[3] = pr03;
									prpicArray2[4] = pr04;
									prpicArray2[5] = pr05;
									prpicArray2[6] = pr06;
									prpicArray2[7] = pr07;
									prpicArray2[8] = pr08;
									prpicArray2[9] = pr09;	
									prpicArray2[10] = pr010;
									prpicArray2[11] = pr011;
									prpicArray2[12] = pr012;
									prpicArray2[13] = pr013;
									prpicArray2[14] = pr014;
									
									//BAD PHOENIX STUFF
									
									bp0 = new Image("res/badphoenix.png");
									bp1 = new Image("res/badphoenix.png");
									bp2 = new Image("res/badphoenix.png");
									bp3 = new Image("res/badphoenix.png");
									bp4 = new Image("res/badphoenix.png");
									bp5 = new Image("res/badphoenix.png");
									bp6 = new Image("res/badphoenix.png");
									bp7 = new Image("res/badphoenix.png");
									bp8 = new Image("res/badphoenix.png");
									bp9 = new Image("res/badphoenix.png");
									bp10 = new Image("res/badphoenix.png");
									bp11 = new Image("res/badphoenix.png");
									bp12 = new Image("res/badphoenix.png");
									bp13 = new Image("res/badphoenix.png");
									bp14 = new Image("res/badphoenix.png");
									
									bp02 = new Image("res/badphoenix2.png");
									bp120 = new Image("res/badphoenix2.png");
									bp22 = new Image("res/badphoenix2.png");
									bp32 = new Image("res/badphoenix2.png");
									bp42 = new Image("res/badphoenix2.png");
									bp52 = new Image("res/badphoenix2.png");
									bp62 = new Image("res/badphoenix2.png");
									bp72 = new Image("res/badphoenix2.png");
									bp82 = new Image("res/badphoenix2.png");
									bp92 = new Image("res/badphoenix2.png");
									bp1000 = new Image("res/badphoenix2.png");
									bp1100 = new Image("res/badphoenix2.png");
									bp1200 = new Image("res/badphoenix2.png");
									bp1300 = new Image("res/badphoenix2.png");
									bp1400 = new Image("res/badphoenix2.png");
									
									bpr0 = new Image("res/badphoenixammo.png");
									bpr1 = new Image("res/badphoenixammo.png");
									bpr2 = new Image("res/badphoenixammo.png");
									bpr3 = new Image("res/badphoenixammo.png");
									bpr4 = new Image("res/badphoenixammo.png");
									bpr5 = new Image("res/badphoenixammo.png");
									bpr6 = new Image("res/badphoenixammo.png");
									bpr7 = new Image("res/badphoenixammo.png");
									bpr8 = new Image("res/badphoenixammo.png");
									bpr9 = new Image("res/badphoenixammo.png");
									bpr10 = new Image("res/badphoenixammo.png");
									bpr11 = new Image("res/badphoenixammo.png");
									bpr12 = new Image("res/badphoenixammo.png");
									bpr13 = new Image("res/badphoenixammo.png");
									bpr14 = new Image("res/badphoenixammo.png");
									
									bpr00 = new Image("res/badphoenixammo2.png");
									bpr01 = new Image("res/badphoenixammo2.png");
									bpr02 = new Image("res/badphoenixammo2.png");
									bpr03 = new Image("res/badphoenixammo2.png");
									bpr04 = new Image("res/badphoenixammo2.png");
									bpr05 = new Image("res/badphoenixammo2.png");
									bpr06 = new Image("res/badphoenixammo2.png");
									bpr07 = new Image("res/badphoenixammo2.png");
									bpr08 = new Image("res/badphoenixammo2.png");
									bpr09 = new Image("res/badphoenixammo2.png");
									bpr010 = new Image("res/badphoenixammo2.png");
									bpr011 = new Image("res/badphoenixammo2.png");
									bpr012 = new Image("res/badphoenixammo2.png");
									bpr013 = new Image("res/badphoenixammo2.png");
									bpr014 = new Image("res/badphoenixammo2.png");
									
										bppicArray[0] = bp0;
										bppicArray[1] = bp1;
										bppicArray[2] = bp2;
										bppicArray[3] = bp3;
										bppicArray[4] = bp4;
										bppicArray[5] = bp5;
										bppicArray[6] = bp6;
										bppicArray[7] = bp7;
										bppicArray[8] = bp8;
										bppicArray[9] = bp9;
										bppicArray[10] = bp10;
										bppicArray[11] = bp11;
										bppicArray[12] = bp12;
										bppicArray[13] = bp13;
										bppicArray[14] = bp14;

										bppicArray2[0] = bp02;
										bppicArray2[1] = bp120;
										bppicArray2[2] = bp22;
										bppicArray2[3] = bp32;
										bppicArray2[4] = bp42;
										bppicArray2[5] = bp52;
										bppicArray2[6] = bp62;
										bppicArray2[7] = bp72;
										bppicArray2[8] = bp82;
										bppicArray2[9] = bp92;
										bppicArray2[10] = bp1000;
										bppicArray2[11] = bp1100;
										bppicArray2[12] = bp1200;
										bppicArray2[13] = bp1300;
										bppicArray2[14] = bp1400;
										
										bprpicArray[0] = bpr0;
										bprpicArray[1] = bpr1;
										bprpicArray[2] = bpr2;
										bprpicArray[3] = bpr3;
										bprpicArray[4] = bpr4;
										bprpicArray[5] = bpr5;
										bprpicArray[6] = bpr6;
										bprpicArray[7] = bpr7;
										bprpicArray[8] = bpr8;
										bprpicArray[9] = bpr9;	
										bprpicArray[10] = bpr10;
										bprpicArray[11] = bpr11;
										bprpicArray[12] = bpr12;
										bprpicArray[13] = bpr13;
										bprpicArray[14] = bpr14;
										
										bprpicArray2[0] = bpr00;
										bprpicArray2[1] = bpr01;
										bprpicArray2[2] = bpr02;
										bprpicArray2[3] = bpr03;
										bprpicArray2[4] = bpr04;
										bprpicArray2[5] = bpr05;
										bprpicArray2[6] = bpr06;
										bprpicArray2[7] = bpr07;
										bprpicArray2[8] = bpr08;
										bprpicArray2[9] = bpr09;	
										bprpicArray2[10] = bpr010;
										bprpicArray2[11] = bpr011;
										bprpicArray2[12] = bpr012;
										bprpicArray2[13] = bpr013;
										bprpicArray2[14] = bpr014;
									
									
								//PAUSING GAME
								if(pause == false){
								//BG AND METER IMAGES
								g.drawImage(farBack, farBackX, -350);
								g.drawImage(frontBack, playLeftX, 600);
								g.drawImage(playLeftBG, playLeftX, 0);
								g.drawImage(playRightBG, playRightX, 0);
								g.drawImage(gameMeter, 525, 40);
								g.setColor(Color.red);
								g.fillRect(meterX, 60, 8, 30);
								
								//drawing map-speed speed
								if(moveSpeakTime <= 50){
								fUnicodeFont.drawString(535, 120, "MAP SPEED : " + (int) movingSpeed/7,Color.orange);
								moveSpeakTime++;
								}
																			
								//LEVEL DISPLAY
								g.setColor(Color.white);
								g.drawString("Level : " +  level, 8, 30);
								//HEALTH GOOD TOWER
								g.setColor(Color.lightGray);
								g.fillRect( goodTowerHealthX, 50, 150, 30);
								g.setColor(Color.red);
								g.fillRect( goodTowerHealthX, 50,(int) Math.ceil(goodTowerX), 30);
								goodTowerX =((150/goodTowerMaxHealth)*goodTowerHealth);							
								g.setColor(Color.black);
								g.drawString((int) goodTowerHealth + "/" + (int) goodTowerMaxHealth, playLeftX + 115, 55);
								
								//HEALTH BAD TOWER
								g.setColor(Color.lightGray);
								g.fillRect( badTowerHealthX, 50, 150, 30);
								badTowerX =((150/badTowerMaxHealth)*badTowerHealth);
								g.setColor(Color.red);
								g.fillRect( badTowerHealthX, 50,(int) Math.ceil(badTowerX), 30);
								g.setColor(Color.black);
								g.drawString((int) badTowerHealth + "/" +(int) badTowerMaxHealth, playRightX + 1060, 55);
								
								//////////////////////////
								///GOOD CATAPULT STUFF/////
								////////////////////////
								for(int x = 0; x < 15; x++){
									if(cHealth[x] >0){
										if(caArrayX[x] > playRightX+800){
											badTowerHealth-=goodTowerDamage*150;
											caArrayX[x] = -100;
											catapultFlight[x] = 0;
											cCombatAnimation[x] = 0;
										}
											cAlive[x] = 1;
										for(int y = 0; y < 15; y++){
											if(cArrayX[x] < playRightX +750){
										if(cArrayX[x] > badwArrayX[y]-900+x*3 && cArrayX[x] < badwArrayX[y]-400 || catapultFlight[x] == 1){
											
											if(cArrayX[x] > badwArrayX[y]-900 && idX[x] == 0){
												gravity[x] = 1.9;
											}else if(cArrayX[x] > badwArrayX[y]-800 && idX[x] == 0){
												gravity[x] = 1.4;
											}else if(cArrayX[x] > badwArrayX[y]-700 && idX[x] == 0){
												gravity[x] = 1.2;
											}else if(cArrayX[x] > badwArrayX[y]-600 && idX[x] == 0){
												gravity[x] = 0.7;
											}
											
											cCombat[x] = 1;
											if(caArrayX[x] > badwArrayX[y]-35 && caArrayX[x] < badwArrayX[y]+55){
												if(caArrayY[x] > 500){
												caArrayX[x] = -100;
												catapultFlight[x] = 0;
												cCombatAnimation[x] = 0;
											badwHealth[y] -=cdmg;
											if(badwHealth[y] <=0){
												coins +=5 + goldIncome*2;
												mana +=2;
												cCombat[x] = 0;
												badwArrayX[y]= playRightX +2500;
											}
												}
											}
										}
											}else{
												cCombat[x] = 1;
											}
										}
										for(int y = 0; y < 15; y++){
											if(cArrayX[x] < playRightX +750){
									if(cArrayX[x] > baArrayX[y]-900+x*3 && cArrayX[x] < baArrayX[y]-400 || catapultFlight[x] == 1){
										
										if(cArrayX[x] > baArrayX[y]-900 && idX[x] == 0){
											gravity[x] = 1.9;
										}else if(cArrayX[x] > baArrayX[y]-800 && idX[x] == 0){
											gravity[x] = 1.4;
										}else if(cArrayX[x] > baArrayX[y]-700 && idX[x] == 0){
											gravity[x] = 1.2;
										}else if(cArrayX[x] > baArrayX[y]-600 && idX[x] == 0){
											gravity[x] = 0.7;
										}
										
										cCombat[x] = 1;
										if(caArrayX[x] > baArrayX[y]-35 && caArrayX[x] < baArrayX[y]+55){
											if(caArrayY[x] > 500){
											caArrayX[x] = -100;
											catapultFlight[x] = 0;
											cCombatAnimation[x] = 0;
											baHealth[y] -=cdmg;
											if(baHealth[y] <=0){
												baArrayX[y] = playRightX + 2500;
												coins +=5 + goldIncome*2;
												mana +=4;
												cCombat[x] = 0;
											}
										}
										}
											}
											}
										}
										for(int y = 0; y < 15; y++){
											if(cArrayX[x] < playRightX +750){
										if(cArrayX[x] > badgArrayX[y]-900+x*3 && cArrayX[x] < badgArrayX[y]-400 || catapultFlight[x] == 1){
											
											if(cArrayX[x] > badgArrayX[y]-900 && idX[x] == 0){
												gravity[x] = 1.9;
											}else if(cArrayX[x] > badgArrayX[y]-800 && idX[x] == 0){
												gravity[x] = 1.4;	
											}else if(cArrayX[x] > badgArrayX[y]-700 && idX[x] == 0){
												gravity[x] = 1.2;
											}else if(cArrayX[x] > badgArrayX[y]-600 && idX[x] == 0){
												gravity[x] = 0.7;
											}
											
											cCombat[x] = 1;
											if(caArrayX[x] > badgArrayX[y]-75 && caArrayX[x] < badgArrayX[y]+100){
												if(caArrayY[x] > 450){
												caArrayX[x] = -100;
												catapultFlight[x] = 0;
												cCombatAnimation[x] = 0;
											badgHealth[y] -=cdmg;
											if(badgHealth[y] <=0){
												badgArrayX[y] = playRightX + 2500;
												coins +=5 + goldIncome*2;
												mana+=6;
												cCombat[x] = 0;
											}
											}
										}
										}
											}
										}
										for(int y = 0; y < 15; y++){
											if(cArrayX[x] < playRightX +750){
										if(cArrayX[x] > bcArrayX[y]-900+x*3 && cArrayX[x] < bcArrayX[y]-400 || catapultFlight[x] == 1){
											
											if(cArrayX[x] > bcArrayX[y]-900 && idX[x] == 0){
												gravity[x] = 1.9;
											}else if(cArrayX[x] > bcArrayX[y]-800 && idX[x] == 0){
												gravity[x] = 1.4;	
											}else if(cArrayX[x] > bcArrayX[y]-700 && idX[x] == 0){
												gravity[x] = 1.2;
											}else if(cArrayX[x] > bcArrayX[y]-600 && idX[x] == 0){
												gravity[x] = 0.7;
											}
											
											cCombat[x] = 1;
											if(caArrayX[x] > bcArrayX[y]-50 && caArrayX[x] < bcArrayX[y]+305){
												if(caArrayY[x] > 500){
												caArrayX[x] = -100;
												catapultFlight[x] = 0;
												cCombatAnimation[x] = 0;
											bcHealth[y] -=cdmg;
											if(bcHealth[y] <=0){
												bcArrayX[y] = playRightX + 2500;
												coins +=5 + goldIncome*2;
												mana+=8;
												cCombat[x] = 0;
											}
											}
										}
										}
											}
										}
										for(int y = 0; y < 15; y++){
											if(cArrayX[x] < playRightX +750){
										if(cArrayX[x] > bpArrayX[y]-800+x*3 && cArrayX[x] < bpArrayX[y]-400 || catapultFlight[x] == 1){
											
											if(cArrayX[x] > bpArrayX[y]-900 && idX[x] == 0){
												gravity[x] = 2.55;
											}else if(cArrayX[x] > bpArrayX[y]-800 && idX[x] == 0){
												gravity[x] = 2.55;	
											}else if(cArrayX[x] > bpArrayX[y]-700 && idX[x] == 0){
												gravity[x] = 2.55;
											}else if(cArrayX[x] > bpArrayX[y]-600 && idX[x] == 0){
												gravity[x] = 2.55;
											}
											
											cCombat[x] = 1;
											if(caArrayX[x] > bpArrayX[y]-50 && caArrayX[x] < bpArrayX[y]+75){
												if(caArrayY[x] < 250){
												caArrayX[x] = -100;
												catapultFlight[x] = 0;
												cCombatAnimation[x] = 0;
											bpHealth[y] -=cdmg;
											if(bpHealth[y] <=0){
												bpArrayX[y] = playRightX + 2500;
												coins +=5 + goldIncome*2;
												mana+=10;
												cCombat[x] = 0;
											}
											}
										}
										}
											}
										}
									if(cCombat[x] == 1){
										if(cCombatAnimation[x] <=0 && catapultFlight[x] == 0){
										cCombatAnimation[x] = 85;
										}
									}else{
										if(catapultSpeedV[x] <=0){
										cArrayX[x]+=cSpeed;
										catapultSpeedV[x]=1;
										}else{
											catapultSpeedV[x]--;
										}
									}
									}else{
										g.drawImage(cpicArray[x], (float) (cArrayX[x]-3000), 2000);
									}
									if(cAlive[x] == 1){
										if(cCombatAnimation[x] == 1){
											if(caArrayX[x] > playLeftX && caArrayX[x] < playRightX+550){
											catapultFlight[x] = 1;
											}
									g.drawImage(cpicArray2[x], (float) cArrayX[x], 375);
										}else{
											g.drawImage(cpicArray[x], (float) cArrayX[x], 375);
										}
										if(catapultFlight[x] == 1){
										caArrayY[x] = (int) (((vx[x])*(t[x]-gravity[x])*t[x]*(t[x]/2))*40)+395;
										g.drawImage(capicArray[x], (int) (caArrayX[x]+vx[x]*t[x]),caArrayY[x]);
										caArrayX[x]+=caSpeed;
										if(idX[x] == 0){
											idX[x] = 1;
										}
										}
										cAlive[x] = 0;
										if(cCombatAnimation[x] == 2){
											caArrayX[x] = (int) (cArrayX[x]+100);
										}
										if(cCombatAnimation[x] > 0 && catapultFlight[x] == 0){
											cCombatAnimation[x]-=.5;
										}
									}
								}
								for(int x = 0; x < 15; x++){
									caArrayY[x] = (int) (((vx[x])*(t[x]-gravity[x])*t[x]*(t[x]/2))*40)+395;
									if(idX[x] == 1){
										t[x]+=.008;
										}
									//resetting ball if goes below map
									if(caArrayY[x] > 680){
										caArrayY[x] = -200;
										caArrayX[x] = -100;
										catapultFlight[x] = 0;
										cCombatAnimation[x] = 0;
										vx[x] = 6;
										t[x] = 0.5;
										gravity[x] = 2.15;
										idX[x] = 0;
									}
								}
								if(ccdr > 0){
									ccdr--;
								}
								//////////////////////////
								///BAD CATAPULT STUFF/////
								////////////////////////
								
								if(level >= 12){
								for(int x = 0; x < 15; x++){
									if(bcHealth[x] >0){
										if(bcaArrayX[x] < playLeftX+350){
											goodTowerHealth-=badTowerDamage*150;
											bcaArrayX[x] = 2000;
											bcCombat[x] = 0;
											bcatapultFlight[x] = 0;
											bcCombatAnimation[x] = 0;
										}
										bcAlive[x] = 1;
										for(int y = 0; y < 15; y++){
											if(bcArrayX[x] > playLeftX +600){
										if(bcArrayX[x] < wArrayX[y]+900-x*3 && bcArrayX[x] > wArrayX[y]-400){
											
											if(bcArrayX[x] < wArrayX[y]+900 && bidX[x] == 0){
												bgravity[x] = 1.9;
											}else if(bcArrayX[x] < wArrayX[y]+800 && bidX[x] == 0){
												bgravity[x] = 1.4;
											}else if(bcArrayX[x] < wArrayX[y]+700 && bidX[x] == 0){
												bgravity[x] = 1.2;
											}else if(bcArrayX[x] < wArrayX[y]+600 && bidX[x] == 0){
												bgravity[x] = 0.7;
											}
											
											bcCombat[x] = 1;
											if(bcaArrayX[x] < wArrayX[y]+55 && bcaArrayX[x] > wArrayX[y]-35){
												if(bcaArrayY[x] > 500){
												bcaArrayX[x] = 2000;
												bcatapultFlight[x] = 0;
												bcCombatAnimation[x] = 0;
											wHealth[y] -=bcdmg;
											if(wHealth[y] <=0){
												bcCombat[x] = 0;
												wArrayX[y]= playLeftX - 2500;
											}
												}
											}
										}
											}else{
												bcCombat[x] = 1;
											}
										}
										for(int y = 0; y < 15; y++){
											if(bcArrayX[x] > playLeftX +600){
									if(bcArrayX[x] < aArrayX[y]+900-x*3 && bcArrayX[x] > aArrayX[y]-400){
										
										if(bcArrayX[x] < aArrayX[y]+900 && bidX[x] == 0){
											bgravity[x] = 1.9;
										}else if(bcArrayX[x] < aArrayX[y]+800 && bidX[x] == 0){
											bgravity[x] = 1.4;
										}else if(bcArrayX[x] < aArrayX[y]+700 && bidX[x] == 0){
											bgravity[x] = 1.2;
										}else if(bcArrayX[x] < aArrayX[y]+600 && bidX[x] == 0){
											bgravity[x] = 0.7;
										}
										
										bcCombat[x] = 1;
										if(bcaArrayX[x] <aArrayX[y]+55 && bcaArrayX[x] > aArrayX[y]-35){
											if(bcaArrayY[x] > 500){
											bcaArrayX[x] = 2000;
											bcatapultFlight[x] = 0;
											bcCombatAnimation[x] = 0;
											aHealth[y] -=bcdmg;
											if(aHealth[y] <=0){
												bcCombat[x] = 0;
												aArrayX[y]= playLeftX - 2500;
											}
										}
										}
											}
											}
										}
										for(int y = 0; y < 15; y++){
											if(bcArrayX[x] > playLeftX +600){
										if(bcArrayX[x] < gArrayX[y]+900-x*3 && bcArrayX[x] > gArrayX[y]-400){
											
											if(bcArrayX[x] < gArrayX[y]+900 && bidX[x] == 0){
												bgravity[x] = 1.9;
											}else if(bcArrayX[x] < gArrayX[y]+800 && bidX[x] == 0){
												bgravity[x] = 1.4;
											}else if(bcArrayX[x] < gArrayX[y]+700 && bidX[x] == 0){
												bgravity[x] = 1.2;
											}else if(bcArrayX[x] < gArrayX[y]+600 && bidX[x] == 0){
												bgravity[x] = 0.7;
											}
											
											bcCombat[x] = 1;
											if(bcaArrayX[x] < gArrayX[y]+100 && bcaArrayX[x] > gArrayX[y]-30){
												if(bcaArrayY[x] > 450){
												bcaArrayX[x] = 2000;
												bcatapultFlight[x] = 0;
												bcCombatAnimation[x] = 0;
											gHealth[y] -=bcdmg;
											if(gHealth[y] <=0){
												bcCombat[x] = 0;
												gArrayX[y]= playLeftX - 2500;
											}
											}
										}
											}
										}
										}
										for(int y = 0; y < 15; y++){
											if(bcArrayX[x] > playLeftX +600){
										if(bcArrayX[x] < cArrayX[y]+900-x*3 && bcArrayX[x] > cArrayX[y]-400){
											
											if(bcArrayX[x] < cArrayX[y]+900 && bidX[x] == 0){
												bgravity[x] = 1.9;
											}else if(bcArrayX[x] < cArrayX[y]+800 && bidX[x] == 0){
												bgravity[x] = 1.4;
											}else if(bcArrayX[x] < cArrayX[y]+700 && bidX[x] == 0){
												bgravity[x] = 1.2;
											}else if(bcArrayX[x] < cArrayX[y]+600 && bidX[x] == 0){
												bgravity[x] = 0.7;
											}
											
											bcCombat[x] = 1;
											if(bcaArrayX[x] < cArrayX[y]+300 && bcaArrayX[x] > cArrayX[y]-55){
												if(bcaArrayY[x] > 500){
												bcaArrayX[x] = 2000;
												bcatapultFlight[x] = 0;
												bcCombatAnimation[x] = 0;
											cHealth[y] -=bcdmg;
											if(cHealth[y] <=0){
												bcCombat[x] = 0;
												cArrayX[y]= playLeftX - 2500;
											}
											}
										}
										}
											}
										}
										
										for(int y = 0; y < 15; y++){
											if(bcArrayX[x] > playLeftX +600){
										if(bcArrayX[x] < pArrayX[y]+800-x*3 && bcArrayX[x] > pArrayX[y]-400){
											if(bcArrayX[x] < pArrayX[y]+900 && bidX[x] == 0){
												bgravity[x] = 2.55;
											}else if(bcArrayX[x] < pArrayX[y]+800 && bidX[x] == 0){
												bgravity[x] = 2.55;
											}else if(bcArrayX[x] < pArrayX[y]+700 && bidX[x] == 0){
												bgravity[x] = 2.55;
											}else if(bcArrayX[x] < pArrayX[y]+600 && bidX[x] == 0){
												bgravity[x] = 2.55;
											}
											
											bcCombat[x] = 1;
											if(bcaArrayX[x] < pArrayX[y]+75 && bcaArrayX[x] > pArrayX[y]-55){
												if(bcaArrayY[x] < 250){
												bcaArrayX[x] = 2000;
												bcatapultFlight[x] = 0;
												bcCombatAnimation[x] = 0;
											pHealth[y] -=bcdmg;
											if(pHealth[y] <=0){
												bcCombat[x] = 0;
												pArrayX[y]= playLeftX -2500;
											}
											}
										}
										}
											}
										}
										
									if(bcCombat[x] == 1){
										if(bcCombatAnimation[x] <=0 && bcatapultFlight[x] == 0){
										bcCombatAnimation[x] = 85;
										}
									}else{
										if(badcatapultSpeedV[x] <=0){
										bcArrayX[x]-=bcSpeed;
										badcatapultSpeedV[x] = 1;
										}else{
											badcatapultSpeedV[x]--;
										}
									}
									}else{
										g.drawImage(bcpicArray[x], (float) (bcArrayX[x]-3000), 2000);
									}
									if(bcAlive[x] == 1){
										if(bcCombatAnimation[x] == 1){
											if(bcaArrayX[x] > playLeftX && bcaArrayX[x] < playRightX+1200){
											bcatapultFlight[x] = 1;
											}
									g.drawImage(bcpicArray2[x], (float) bcArrayX[x], 375);
										}else{
											g.drawImage(bcpicArray[x], (float) bcArrayX[x], 375);
										}
										if(bcatapultFlight[x] == 1){
										bcaArrayY[x] = (int) (((bvx[x])*(bt[x]-bgravity[x])*bt[x]*(bt[x]/2))*40)+395;
										g.drawImage(bcapicArray[x],  (int) (bcaArrayX[x]+bvx[x]*bt[x]),(int) bcaArrayY[x]);
										bcaArrayX[x]-=bcaSpeed;
										if(bidX[x] == 0){
											bidX[x] = 1;
										}
										}
										if(bcCombatAnimation[x] == 2){
											bcaArrayX[x] = (int) (bcArrayX[x]+120);
										}
										bcAlive[x] = 0;
										if(bcCombatAnimation[x] > 0 && bcatapultFlight[x] == 0){
											bcCombatAnimation[x]-=.5;
										}
									}
								}
								
								
								for(int x = 0; x < 15; x++){
									bcaArrayY[x] = (int) (((bvx[x])*(bt[x]-bgravity[x])*bt[x]*(bt[x]/2))*40)+395;
									if(bidX[x] == 1){
										bt[x]+=.008;
										}
									//resetting ball if goes below map
									if(bcaArrayY[x] > 680){
										bcaArrayY[x] = -200;
										bcaArrayX[x] = -100;
										bcatapultFlight[x] = 0;
										bcCombatAnimation[x] = 0;
										bvx[x] = 6;
										bt[x] = 0.5;
										bgravity[x] = 2.15;
										bidX[x] = 0;
									}
								}
								
								if(bccdr == 0){
									int vvv = 0;
									for(int x = 0; x < 15; x++){
										if(bcHealth[x] <= 0 && vvv == 0){
											bcArrayX[x] = playRightX + 850;
											bcHealth[x] = bcMaxHealth;
											bcCombat[x] = 0;
											bcAlive[x] = 1;
											bcCombat[x] = 0;
											bcCombatAnimation[x] = 0;
											bcatapultFlight[x] = 0;
											bccdr = bcMaxcdr;
											vvv = 1;
										}
									}
								}
								if(bccdr > 0){
									bccdr--;
								}
								}
								
								//////////////////////////////////////
								//////////GOOD GOLEM STUFF//////////
								/////////////////////////////////////
								
								
								for(int x = 0; x < 15; x++){
									if(gHealth[x] >0){
										gAlive[x] = 1;
										for(int y = 0; y < 15; y++){
											if(gArrayX[x] < playRightX +750){
										if(gArrayX[x] > badwArrayX[y]-100 && gArrayX[x] < badwArrayX[y]+100){
											gCombat[x] = 1;
											badwHealth[y] -=gdmg;
											if(badwHealth[y] <=0){
												badwArrayX[y] = playRightX+2500;
												gCombat[x] = 0;
												coins +=5 + goldIncome*2;
												mana+=2;
											}
										}
											}else{
												gCombat[x] = 1;
												badTowerHealth-=goodTowerDamage;
											}
										}
										for(int y = 0; y < 15; y++){
											if(gArrayX[x] < playRightX + 750){
										if(gArrayX[x] >baArrayX[y]-100 && gArrayX[x] < baArrayX[y]+100){
											gCombat[x] = 1;
											baHealth[y] -=gdmg;
											if(baHealth[y] <=0){
												baArrayX[y] = playRightX+2000;
												badwCombat[x] = 0;
												coins +=5 + goldIncome*2;
												mana+=4;
											}
										}
											}
										}
										for(int y = 0; y < 15; y++){
											if(gArrayX[x] < playRightX +750){
										if(gArrayX[x] > badgArrayX[y]-100 && gArrayX[x] < badgArrayX[y]+100){
											gCombat[x] = 1;
											badgHealth[y] -=gdmg;
											if(badgHealth[y] <=0){
												badgArrayX[y] = playRightX+2500;
												gCombat[x] = 0;
												coins +=5 + goldIncome*2;
												mana+=6;
											}
										}
											}
										}
										for(int y = 0; y < 15; y++){
											if(gArrayX[x] < playRightX +750){
										if(gArrayX[x] > bcArrayX[y]-300 && gArrayX[x] < bcArrayX[y]+50){
											gCombat[x] = 1;
											bcHealth[y] -=gdmg;
											if(bcHealth[y] <=0){
												bcArrayX[y] = playRightX+2500;
												gCombat[x] = 0;
												coins +=5 + goldIncome*2;
												mana+=8;
											}
										}
											}
										}
									if(gCombat[x] == 1){
										if(gCombatAnimation[x] <=0){
										gCombatAnimation[x] = 3+randomGenerator.nextInt(10);
										}
									}else{
										if(golemSpeedV[x] <= 0){
										gArrayX[x]+=gSpeed;
										golemSpeedV[x]=1;
										}else{
											golemSpeedV[x]--;
										}
									}
									}else{
										g.drawImage(gpicArray[x], (float) (gArrayX[x]-3000), 2000);
									}
									if(gAlive[x] == 1){
										if(gCombatAnimation[x] <5){
									g.drawImage(gpicArray[x], (float) gArrayX[x], 465);
										}else{
									g.drawImage(gpicArray2[x], (float) gArrayX[x], 465);
										}
										gAlive[x] = 0;
										if(gCombatAnimation[x] > 0){
											gCombatAnimation[x]-=.1;
										}
									}
								}
								
								if(gcdr > 0){
									gcdr--;
								}
								/////////////////////////////
								/////BAD GOLEM STUFF///////
								/////////////////////////////
								
								if(level >= 8){
								for(int x = 0; x < 15; x++){
									if(badgHealth[x] >0){
										badgAlive[x] = 1;
										for(int y = 0; y < 15; y++){
											if(badgArrayX[x] > playLeftX +350){
										if(badgArrayX[x] >wArrayX[y]-100 && badgArrayX[x] < wArrayX[y]+100){
											badgCombat[x] = 1;
											wHealth[y] -=badgdmg;
											if(wHealth[y] <=0){
												badgCombat[x] = 0;
												wArrayX[y]= playLeftX - 2500;
											}
										}
											}else{
												//ONLY NEED THIS ELSE STATEMENT ONCE
												badgCombat[x] = 1;
												goodTowerHealth -=badTowerDamage;
											}
										}
										for(int y = 0; y < 15; y++){
											if(badgArrayX[x] > playLeftX +350){
										if(badgArrayX[x] >gArrayX[y]-100 && badgArrayX[x] < gArrayX[y]+100){
											badgCombat[x] = 1;
											gHealth[y] -=badgdmg;
											if(gHealth[y] <=0){
												badgCombat[x] = 0;
												gArrayX[y]= playLeftX - 2500;
											}
										}
											}
										}
										for(int y = 0; y < 15; y++){
											if(badgArrayX[x] > playLeftX +350){
										if(badgArrayX[x] >aArrayX[y]-100 && badgArrayX[x] < aArrayX[y]+100){
											badgCombat[x] = 1;
											aHealth[y] -=badgdmg;
											if(aHealth[y] <=0){
												badgCombat[x] = 0;
												aArrayX[y]= playLeftX - 2500;
											}
										}
											}
										}
										for(int y = 0; y < 15; y++){
											if(badgArrayX[x] > playLeftX +350){
										if(badgArrayX[x] >cArrayX[y]-20 && badgArrayX[x] < cArrayX[y]+300){
											badgCombat[x] = 1;
											cHealth[y] -=badgdmg;
											if(cHealth[y] <=0){
												badgCombat[x] = 0;
												cArrayX[y]= playLeftX - 2500;
											}
										}
											}
										}
									if(badgCombat[x] == 1){
										if(badgCombatAnimation[x] <=0){
										badgCombatAnimation[x] = 3+randomGenerator.nextInt(10);
										}
									}else{
										if(badgolemSpeedV[x] <=0){
										badgArrayX[x]-=badgSpeed;
										badgolemSpeedV[x]=1;
										}else{
											badgolemSpeedV[x]--;
										}
									}
									}else{
										g.drawImage(badgpicArray[x],(float) (badgArrayX[x]-1000), 2000);

									}
									if(badgAlive[x] == 1){
										if(badgCombatAnimation[x] <5){
											g.drawImage(badgpicArray[x], (float) badgArrayX[x], 465);
										}else{
											g.drawImage(badgpicArray2[x], (float) badgArrayX[x], 465);
										}
										if(badgCombatAnimation[x] > 0){
											badgCombatAnimation[x]-=.1;
										}
										badgAlive[x] = 0;
									}
								}
								
								if(badgcdr <= 0){
									int vv = 0;
									for(int x = 0; x < 15; x++){
										if(badgHealth[x] <= 0 && vv == 0){
											badgArrayX[x] = playRightX+850;
											badgHealth[x] = badgMaxHealth;
											badgCombat[x] = 0;
											badgcdr = badgMaxcdr;
											vv = 1;
										}
									}
								}
								if(badgcdr > 0){
									badgcdr--;
								}
								}
								//////////////////////////
								///GOOD ARCHER STUFF/////
								////////////////////////
								
								for(int x = 0; x < 15; x++){
									if(aHealth[x] >0){
										if(arArrayX[x] > playRightX+800){
											badTowerHealth-=goodTowerDamage*150;
											arArrayX[x] = -100;
											arrowFlight[x] = 0;
											aCombatAnimation[x] = 0;
										}
										aAlive[x] = 1;
										for(int y = 0; y < 15; y++){
											if(aArrayX[x] < playRightX +750){
										if(aArrayX[x] > badwArrayX[y]-500 && aArrayX[x] < badwArrayX[y]+20 && badwHealth[y] > 0 || arrowFlight[x] == 1){
											aCombat[x] = 1;
											if(arArrayX[x] > badwArrayX[y]-15 && arArrayX[x] < badwArrayX[y]+15){
												if(arArrayY[x] > 400){
												arArrayX[x] = -100;
												arrowFlight[x] = 0;
												aCombatAnimation[x] = 0;
											badwHealth[y] -=admg;
											if(badwHealth[y] <=0){
												coins +=5 + goldIncome*2;
												mana+=2;
												aCombat[x] = 0;
												badwArrayX[y]= playRightX +2500;
											}
											}
											}
										}
											}else{
												aCombat[x] = 1;
											}
										}
										for(int y = 0; y < 15; y++){
											if(aArrayX[x] < playRightX +750){
									if(aArrayX[x] > baArrayX[y]-500 && aArrayX[x] < baArrayX[y]+20 && baHealth[y] > 0 || arrowFlight[x] == 1){
										aCombat[x] = 1;
										if(arArrayX[x] > baArrayX[y]-15 && arArrayX[x] < baArrayX[y]+15){
											if(arArrayY[x] > 400){
											arArrayX[x] = -100;
											arrowFlight[x] = 0;
											aCombatAnimation[x] = 0;
											baHealth[y] -=admg;
											if(baHealth[y] <=0){
												coins +=5 + goldIncome*2;
												mana+=4;
												aCombat[x] = 0;
												baArrayX[y]= playRightX +2500;
											}
										}
										}
											}
											}
										}
										for(int y = 0; y < 15; y++){
											if(aArrayX[x] < playRightX +750){
										if(aArrayX[x] > badgArrayX[y]-500 && aArrayX[x] < badgArrayX[y]+20 && badgHealth[y] > 0 || arrowFlight[x] == 1){
											aCombat[x] = 1;
											if(arArrayX[x] > badgArrayX[y]-15 && arArrayX[x] < badgArrayX[y]+15){
												if(arArrayY[x] > 400){
												arArrayX[x] = -100;
												arrowFlight[x] = 0;
												aCombatAnimation[x] = 0;
											badgHealth[y] -=admg;
											if(badgHealth[y] <=0){
												badgArrayX[y] = playRightX+2500;
												coins +=5 + goldIncome*2;
												mana+=6;
												aCombat[x] = 0;
											}
											}
										}
											}
										}
										}
										for(int y = 0; y < 15; y++){
											if(aArrayX[x] < playRightX +750){
										if(aArrayX[x] > bcArrayX[y]-500 && aArrayX[x] < bcArrayX[y]+20 && bcHealth[y] > 0 || arrowFlight[x] == 1){
											aCombat[x] = 1;
											if(arArrayX[x] > bcArrayX[y]-300 && arArrayX[x] < bcArrayX[y]+15){
												if(arArrayY[x] > 400){
												arArrayX[x] = -100;
												arrowFlight[x] = 0;
												aCombatAnimation[x] = 0;
											bcHealth[y] -=admg;
											if(bcHealth[y] <=0){
												bcArrayX[y] = playRightX+2500;
												coins +=5 + goldIncome*2;
												mana+=8;
												aCombat[x] = 0;
											}
											}
										}
										}
											}
										}
										for(int y = 0; y < 15; y++){
											if(aArrayX[x] < playRightX +750){
									if(aArrayX[x] > bpArrayX[y]-550 && aArrayX[x] < bpArrayX[y]-50 && bpHealth[y] > 0 || arrowFlight[x] == 1){
										aCombat[x] = 1;
										if(arArrayX[x] > bpArrayX[y]-65 && arArrayX[x] < bpArrayX[y]+25){
											if(arArrayY[x] < 300){
											arArrayX[x] = 2000;
											arrowFlight[x] = 0;
											aCombatAnimation[x] = 0;
											aStaticP[x] = 0;
											bpHealth[y] -=admg;
											if(bpHealth[y] <=0){
												coins +=5 + goldIncome*2;
												aCombat[x] = 0;
												mana+=10;
												bpArrayX[y]= playLeftX + 250;
											}
										}
										}
											}
											}
										}
										//CHECKING TO SEE IF BAD PHOENIX IS AROUND
										for(int y = 0; y < 15; y ++){
											if(arrowFlight[x] == 0){
											if(aArrayX[x] >= bpArrayX[y]-550 && aArrayX[x] < bpArrayX[y]-50 && bpHealth[y] > 0){
												aCheckP[x]++;
												aStaticP[x] = 1;
										}
											}
										}	
										if(aCombat[x] == 1){
											if(aCombatAnimation[x] <=0 && arrowFlight[x] == 0){
											aCombatAnimation[x] = 35;
											}
										}else{
											if(archerSpeedV[x] <=0){
											aArrayX[x]+=aSpeed;
											archerSpeedV[x]=1;
											}else{
												archerSpeedV[x]--;
											}
										}
										}else{
											g.drawImage(apicArray[x], (float) (aArrayX[x]-3000), 2000);
										}
										if(aAlive[x] == 1){
											if(aCombatAnimation[x] == 1){
												if(arArrayX[x] < playRightX+750 && arArrayX[x] > playLeftX){
												arrowFlight[x] = 1;
												}
												if(aStaticP[x] == 1){
													g.drawImage(apicArray3[x], (float) aArrayX[x], 520);
												}else{
													g.drawImage(apicArray[x], (float) aArrayX[x], 520);
												}
											}else{
												if(aStaticP[x] == 1){
												g.drawImage(apicArray4[x], (float) aArrayX[x], 520);
												}else{
												g.drawImage(apicArray2[x], (float) aArrayX[x], 520);
												}
											}
											if(arrowFlight[x] == 1){
												if(aStaticP[x]  == 0){
													arArrayY[x] = 575;
												}
												if(aArrayX[x] < playRightX + 750 && aStaticP[x] == 1){
													g.drawImage(arpicArray2[x], arArrayX[x], arArrayY[x]);
													arArrayY[x] -=3;
													if(arArrayY[x] < -100 && arArrayY[x] > -150){
														aStaticP[x] = 0;
														arArrayX[x] = 2000;
														arrowFlight[x] = 0;
														aCombatAnimation[x] = 0;
													}
												}else{
													g.drawImage(arpicArray[x], arArrayX[x], arArrayY[x]);
												}
											arArrayX[x]+=arSpeed;
											}
											if(aCombatAnimation[x] == 2){
												if(aStaticP[x] == 1){
												arArrayX[x] = (int) (aArrayX[x]+85);
												arArrayY[x] = 480;
												}else{
												arArrayX[x] = (int) (aArrayX[x]+115);
												arArrayY[x] = 575;
												}
											}
										aAlive[x] = 0;
										if(aCombatAnimation[x] > 0 && arrowFlight[x] == 0){
											aCombatAnimation[x]--;
										}
									}
										aCheckP[x] = 0;
								}
								
								if(acdr > 0){
									acdr--;
								}
								
						//////////////////////////
						///BAD ARCHER STUFF/////
						////////////////////////
								
						if(level >= 5){
						for(int x = 0; x < 15; x++){
							if(baHealth[x] >0){
								if(barArrayX[x] < playLeftX+350){
									goodTowerHealth-=badTowerDamage*150;
									barArrayX[x] = 2000;
									baCombat[x] = 0;
									barrowFlight[x] = 0;
									baCombatAnimation[x] = 0;
								}
								baAlive[x] = 1;
								for(int y = 0; y < 15; y++){
									if(baArrayX[x] > playLeftX +600){
								if(baArrayX[x] < wArrayX[y]+500 && baArrayX[x] > wArrayX[y]-20 && wHealth[y] > 0 || barrowFlight[x] == 1){
									baCombat[x] = 1;
									if(barArrayX[x] < wArrayX[y]+25 && barArrayX[x] > wArrayX[y]-25){
										if(barArrayY[x] > 400){
										barArrayX[x] = 2000;
										barrowFlight[x] = 0;
										baCombatAnimation[x] = 0;
									wHealth[y] -=badmg;
									if(wHealth[y] <=0){
										baCombat[x] = 0;
										wArrayX[y]= playLeftX -2500;
									}
										}
									}
								}
									}else{
										baCombat[x] = 1;
									}
								}
								for(int y = 0; y < 15; y++){
									if(baArrayX[x] > playLeftX +600){
							if(baArrayX[x] < aArrayX[y]+500 && baArrayX[x] > aArrayX[y]-20 && aHealth[y] > 0 || barrowFlight[x] == 1){
								baCombat[x] = 1;
								if(barArrayX[x] <aArrayX[y]+25 && barArrayX[x] > aArrayX[y]-25){
									if(barArrayY[x] > 400){
									barArrayX[x] = 2000;
									barrowFlight[x] = 0;
									baCombatAnimation[x] = 0;
									aHealth[y] -=badmg;
									if(aHealth[y] <=0){
										baCombat[x] = 0;
										aArrayX[y]= playLeftX - 2500;
									}
								}
									}
							}
									}
								}
								for(int y = 0; y < 15; y++){
									if(baArrayX[x] > playLeftX +600){
								if(baArrayX[x] < gArrayX[y]+500 && baArrayX[x] > gArrayX[y]-20 && gHealth[y] > 0 || barrowFlight[x] == 1){
									baCombat[x] = 1;
									if(barArrayX[x] < gArrayX[y]+75 && barArrayX[x] > gArrayX[y]-25){
										if(barArrayY[x] > 400){
										barArrayX[x] = 2000;
										barrowFlight[x] = 0;
										baCombatAnimation[x] = 0;
									gHealth[y] -=badmg;
									if(gHealth[y] <=0){
										baCombat[x] = 0;
										gArrayX[y]= playLeftX -2500;
									}
									}
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(baArrayX[x] > playLeftX +600){
								if(baArrayX[x] < cArrayX[y]+600 && baArrayX[x] > cArrayX[y]-50 && cHealth[y] > 0 || barrowFlight[x] == 1){
									baCombat[x] = 1;
									if(barArrayX[x] < cArrayX[y]+300 && barArrayX[x] > cArrayX[y]-25){
										if(barArrayY[x] > 400){
										barArrayX[x] = 2000;
										barrowFlight[x] = 0;
										baCombatAnimation[x] = 0;
									cHealth[y] -=badmg;
									if(cHealth[y] <=0){
										baCombat[x] = 0;
										cArrayX[y]= playLeftX -2500;
									}
									}
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(baArrayX[x] > playLeftX +600){
							if(baArrayX[x] < pArrayX[y]+560 && baArrayX[x] > pArrayX[y]-50 && pHealth[y] > 0|| barrowFlight[x] == 1){
								baCombat[x] = 1;
								if(barArrayX[x] <pArrayX[y]+65 && barArrayX[x] > pArrayX[y]-25){
									if(barArrayY[x] < 300){
									barArrayX[x] = 2000;
									barrowFlight[x] = 0;
									baCombatAnimation[x] = 0;
									baStaticP[x] = 0;
									pHealth[y] -=badmg;
									if(pHealth[y] <=0){
										baCombat[x] = 0;
										pArrayX[y]= playLeftX - 2500;
									}
								}
								}
									}
									}
								}
								//CHECKING TO SEE IF PHOENIX IS AROUND
								for(int y = 0; y < 15; y ++){
									if(barrowFlight[x] == 0){
									if(baArrayX[x] < pArrayX[y]+560 && baArrayX[x] > pArrayX[y]-50 && pHealth[y] > 0){
										baCheckP[x]++;
										baStaticP[x] = 1;
								}
									}
								}	
							if(baCombat[x] == 1){
								if(baCombatAnimation[x] <=0 && barrowFlight[x] == 0){
								baCombatAnimation[x] = 35;
								}
							}else{
								if(badarcherSpeedV[x] <=0){
								baArrayX[x]-=baSpeed;
								badarcherSpeedV[x]=1;
								}else{
									badarcherSpeedV[x]--;
								}
							}
							}else{
								g.drawImage(bapicArray[x], (float) (baArrayX[x]-3000), 2000);
							}
							if(baAlive[x] == 1){
								if(baCombatAnimation[x] == 1){
									if(barArrayX[x] > playLeftX && barArrayX[x] < playRightX+1200){
									barrowFlight[x] = 1;
									}
									if(baStaticP[x] == 1){
										g.drawImage(bapicArray3[x], (float) baArrayX[x], 520);
									}else{
										g.drawImage(bapicArray[x], (float) baArrayX[x], 520);
									}
								}else{
									if(baStaticP[x] == 1){
									g.drawImage(bapicArray4[x], (float) baArrayX[x], 520);
									}else{
									g.drawImage(bapicArray2[x], (float) baArrayX[x], 520);
									}
								}
								if(barrowFlight[x] == 1){
									if(baStaticP[x]  == 0){
										barArrayY[x] = 575;
									}
									if(baArrayX[x] > playLeftX + 600 && baStaticP[x] == 1){
										g.drawImage(barpicArray2[x], barArrayX[x], barArrayY[x]);
										barArrayY[x] -=3;
										if(barArrayY[x] < -100 && barArrayY[x] > -150){
											baStaticP[x] = 0;
											barArrayX[x] = 2000;
											barrowFlight[x] = 0;
											baCombatAnimation[x] = 0;
										}
									}else{
										g.drawImage(barpicArray[x], barArrayX[x], barArrayY[x]);
									}
								barArrayX[x]-=barSpeed;
								}
								if(baCombatAnimation[x] == 2){
									if(baStaticP[x] == 1){
									barArrayX[x] = (int) (baArrayX[x]-30);
									barArrayY[x] = 480;
									}else{
									barArrayX[x] = (int) (baArrayX[x]-90);
									barArrayY[x] = 575;
									}
								}
								baAlive[x] = 0;
								if(baCombatAnimation[x] > 0 && barrowFlight[x] == 0){
									baCombatAnimation[x]--;
								}
							}
							
							baCheckP[x] = 0;
							
						}

						if(bacdr == 0){
							int vvv = 0;
							for(int x = 0; x < 15; x++){
								if(baHealth[x] <= 0 && vvv == 0){
									baArrayX[x] = playRightX + 850;
									barArrayY[x] = 530;
									baHealth[x] = baMaxHealth;
									baCombat[x] = 0;
									baAlive[x] = 0;
									baCombat[x] = 0;
									baCombatAnimation[x] = 0;
									barrowFlight[x] = 0;
									bacdr = baMaxcdr;
									baStaticP[x] = 0;
									vvv = 1;
								}
							}
						}
						if(bacdr > 0){
							bacdr--;
						}								
						}
						//////////////////////////////////////
						//////////GOOD WARRIOR STUFF//////////
						/////////////////////////////////////
						
						
						for(int x = 0; x < 15; x++){
							if(wHealth[x] >0){
								wAlive[x] = 1;
								for(int y = 0; y < 15; y++){
									if(wArrayX[x] < playRightX +750){
								if(wArrayX[x] > badwArrayX[y]-50 && wArrayX[x] < badwArrayX[y]+50){
									wCombat[x] = 1;
									badwHealth[y] -=wdmg;
									if(badwHealth[y] <=0){
										badwArrayX[y] = playRightX+2500;
										wCombat[x] = 0;
										coins +=5 + goldIncome*2;
										mana+=2;
									}
								}
									}else{
										wCombat[x] = 1;
										badTowerHealth-=goodTowerDamage;
									}
								}
								for(int y = 0; y < 15; y++){
									if(wArrayX[x] < playRightX + 750){
								if(wArrayX[x] >baArrayX[y]-50 && wArrayX[x] < baArrayX[y]+50){
									wCombat[x] = 1;
									baHealth[y] -=wdmg;
									if(baHealth[y] <=0){
										baArrayX[y] = playRightX+2500;
										badwCombat[x] = 0;
										coins +=5 + goldIncome*2;
										mana+=4;
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(wArrayX[x] < playRightX +750){
								if(wArrayX[x] > badgArrayX[y]-100 && wArrayX[x] < badgArrayX[y]+50){
									wCombat[x] = 1;
									badgHealth[y] -=wdmg;
									if(badgHealth[y] <=0){
										badgArrayX[y] = playRightX+2500;
										wCombat[x] = 0;
										coins +=5 + goldIncome*2;
										mana+=6;
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(wArrayX[x] < playRightX +750){
								if(wArrayX[x] > bcArrayX[y]-300 && wArrayX[x] < bcArrayX[y]+50){
									wCombat[x] = 1;
									bcHealth[y] -=wdmg;
									if(bcHealth[y] <=0){
										bcArrayX[y] = playRightX+2500;
										wCombat[x] = 0;
										coins +=5 + goldIncome*2;
										mana+=8;
									}
								}
									}
								}
							if(wCombat[x] == 1){
								if(wCombatAnimation[x] <=0){
								wCombatAnimation[x] = 10;
								}
							}else{
								if(warriorSpeedV[x] <=0){
								warriorSpeedV[x] = 0;
								if(wArrayX[x] >= -1){
									wArrayX[x]+=wSpeed;
								}else{
									wArrayX[x]+=wSpeed/2;
								}
								}else{
									warriorSpeedV[x]--;
								}
							}
							}else{
								g.drawImage(picArray[x], wArrayX[x]-3000, 2000);
							}
							if(wAlive[x] == 1){
								if(wCombatAnimation[x] < 1){
							g.drawImage(picArray[x], wArrayX[x], 520);
								}else{
							g.drawImage(picArray2[x], wArrayX[x], 520);
								}
								wAlive[x] = 0;
								if(wCombatAnimation[x] > 0){
									wCombatAnimation[x]-=.1;
								}
							}
						}
						if(wcdr > 0){
							wcdr--;
						}
						
						/////////////////////////////
						/////BAD WARRIOR STUFF///////
						/////////////////////////////
						
						if(level >= 1){
						for(int x = 0; x < 15; x++){
							if(badwHealth[x] >0){
								badwAlive[x] = 1;
								for(int y = 0; y < 15; y++){
									if(badwArrayX[x] > playLeftX +350){
								if(badwArrayX[x] >wArrayX[y]-50 && badwArrayX[x] < wArrayX[y]+50){
									badwCombat[x] = 1;
									wHealth[y] -=badwdmg;
									if(wHealth[y] <=0){
										badwCombat[x] = 0;
										wArrayX[y]= playLeftX - 2500;
									}
								}
									}else{
										//ONLY NEED THIS ELSE STATEMENT ONCE
										badwCombat[x] = 1;
										goodTowerHealth -=badTowerDamage;
									}
								}
								for(int y = 0; y < 15; y++){
									if(badwArrayX[x] > playLeftX +350){
								if(badwArrayX[x] >gArrayX[y]-50 && badwArrayX[x] < gArrayX[y]+100){
									badwCombat[x] = 1;
									gHealth[y] -=badwdmg;
									if(gHealth[y] <=0){
										badwCombat[x] = 0;
										gArrayX[y]= playLeftX - 2500;
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(badwArrayX[x] > playLeftX +350){
								if(badwArrayX[x] >aArrayX[y]-50 && badwArrayX[x] < aArrayX[y]+50){
									badwCombat[x] = 1;
									aHealth[y] -=badwdmg;
									if(aHealth[y] <=0){
										badwCombat[x] = 0;
										aArrayX[y]= playLeftX - 2500;
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(badwArrayX[x] > playLeftX +350){
								if(badwArrayX[x] >cArrayX[y]-50 && badwArrayX[x] < cArrayX[y]+300){
									badwCombat[x] = 1;
									cHealth[y] -=badwdmg;
									if(cHealth[y] <=0){
										badwCombat[x] = 0;
										cArrayX[y]= playLeftX - 2500;
									}
								}
									}
								}
							if(badwCombat[x] == 1){
								if(badwCombatAnimation[x] <=0){
								badwCombatAnimation[x] = 6+randomGenerator.nextInt(10);
								}
							}else{
								if(badwarriorSpeedV[x] <=0){
								badwArrayX[x]-=badwSpeed;
								badwarriorSpeedV[x] = 1;
								}else{
									badwarriorSpeedV[x]--;
								}
							}
							}else{
								g.drawImage(badpicArray[x],(float) (badwArrayX[x]-1000), 2000);

							}
							if(badwAlive[x] == 1){
								if(badwCombatAnimation[x] <5){
									g.drawImage(badpicArray[x], (float) badwArrayX[x], 520);
								}else{
									g.drawImage(badpicArray2[x], (float) badwArrayX[x], 520);
								}
								if(badwCombatAnimation[x] > 0){
									badwCombatAnimation[x]-=.1;
								}
								badwAlive[x] = 0;
							}
						}
						
						if(badwcdr <= 0){
							int vv = 0;
							for(int x = 0; x < 15; x++){
								if(badwHealth[x] <= 0 && vv == 0){
									badwArrayX[x] = playRightX+850;
									badwHealth[x] = badwMaxHealth;
									badwCombat[x] = 0;
									badwcdr = badwMaxcdr;
									vv = 1;
								}
							}
						}
						if(badwcdr > 0){
							badwcdr--;
						}
						}
						//////////////////////////
						///GOOD PHOENIX STUFF/////
						////////////////////////
						
						for(int x = 0; x < 15; x++){
							if(pHealth[x] >0){
								if(prArrayX[x] > playRightX+800){
									pStaticP[x] = 0;
									badTowerHealth-=goodTowerDamage*150;
									prArrayX[x] = -100;
									pFlight[x] = 0;
									pCombatAnimation[x] = 0;
								}
								pAlive[x] = 1;
								for(int y = 0; y < 15; y++){
									if(pArrayX[x] < playRightX +750){
								if(pArrayX[x] > badwArrayX[y]-500 && pArrayX[x] < badwArrayX[y]+20 && badwHealth[y] > 0|| pFlight[x] == 1){
									if(prArrayY[x] > 500){
									pCombat[x] = 1;
									if(prArrayX[x] > badwArrayX[y]-15 && prArrayX[x] < badwArrayX[y]+25){
										prArrayX[x] = -100;
										pFlight[x] = 0;
										pCombatAnimation[x] = 0;
									badwHealth[y] -=pdmg;
									if(badwHealth[y] <=0){
										coins +=5 + goldIncome*2;
										pCombat[x] = 0;
										badwArrayX[y]= playRightX +2500;
										mana+=2;
									}
									}
									}
								}
									}else{
										pCombat[x] = 1;
									}
								}
								for(int y = 0; y < 15; y++){
									if(pArrayX[x] < playRightX +750){
							if(pArrayX[x] > baArrayX[y]-500 && pArrayX[x] < baArrayX[y]+20 && baHealth[y] > 0 || pFlight[x] == 1){
								pCombat[x] = 1;
								if(prArrayX[x] > baArrayX[y]-15 && prArrayX[x] < baArrayX[y]+25){
									if(prArrayY[x] > 500){
									prArrayX[x] = -100;
									pFlight[x] = 0;
									pCombatAnimation[x] = 0;
									baHealth[y] -=pdmg;
									if(baHealth[y] <=0){
										coins +=5 + goldIncome*2;
										pCombat[x] = 0;
										baArrayX[y]= playRightX +2500;
										mana+=4;
									}
								}
									}
							}
									}
								}
								for(int y = 0; y < 15; y++){
									if(pArrayX[x] < playRightX +750){
								if(pArrayX[x] > badgArrayX[y]-500 && pArrayX[x] < badgArrayX[y]+20 && badgHealth[y] > 0 || pFlight[x] == 1){
									pCombat[x] = 1;
									if(prArrayX[x] > badgArrayX[y]-15 && prArrayX[x] < badgArrayX[y]+85){
										if(prArrayY[x] > 450){
										prArrayX[x] = -100;
										pFlight[x] = 0;
										pCombatAnimation[x] = 0;
									badgHealth[y] -=pdmg;
									if(badgHealth[y] <=0){
										badgArrayX[y] = playRightX+2500;
										coins +=5 + goldIncome*2;
										pCombat[x] = 0;
										mana+=6;
									}
									}
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(pArrayX[x] < playRightX +750){
								if(pArrayX[x] > bcArrayX[y]-600 && pArrayX[x] < bcArrayX[y]+20 && bcHealth[y] > 0 || pFlight[x] == 1){
									pCombat[x] = 1;
									if(prArrayX[x] > bcArrayX[y]-15 && prArrayX[x] < bcArrayX[y]+300){
										if(prArrayY[x] > 500){
										prArrayX[x] = -100;
										pFlight[x] = 0;
										pCombatAnimation[x] = 0;
									bcHealth[y] -=pdmg;
									if(bcHealth[y] <=0){
										bcArrayX[y] = playRightX+2500;
										coins +=5 + goldIncome*2;
										pCombat[x] = 0;
										mana+=8;
									}
									}
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(pArrayX[x] < playRightX +750){
							if(pArrayX[x] > bpArrayX[y]-550 && pArrayX[x] < bpArrayX[y]-50 && bpHealth[y] > 0 || pFlight[x] == 1){
								pCombat[x] = 1;
								if(prArrayX[x] > bpArrayX[y]-65 && prArrayX[x] < bpArrayX[y]+25 && bpHealth[y] > 0){
									if(prArrayY[x] < 300){
									prArrayX[x] = 2000;
									pFlight[x] = 0;
									pCombatAnimation[x] = 0;
									pStaticP[x] = 0;
									bpHealth[y] -=pdmg;
									if(bpHealth[y] <=0){
										coins +=5 + goldIncome*2;
										pCombat[x] = 0;
										bpArrayX[y]= playLeftX + 250;
										mana+=10;
									}
								}
								}
									}
									}
								}
								//CHECKING TO SEE IF BAD PHOENIX IS AROUND
								for(int y = 0; y < 15; y ++){
									if(pFlight[x] == 0){
									if(pArrayX[x] >= bpArrayX[y]-550 && pArrayX[x] < bpArrayX[y]-50 && bpHealth[y] > 0){
										pCheckP[x]++;
										pStaticP[x] = 1;
								}
									}
								}	
							if(pCombat[x] == 1){
								if(pCombatAnimation[x] <=0 && pFlight[x] == 0){
								pCombatAnimation[x] = 50;
								}
							}else{
								if(pSpeedV[x] <=0){
									pSpeedV[x] = 1;
								pArrayX[x]+=pSpeed;
								}else{
									pSpeedV[x]--;
								}
							}
							}else{
								g.drawImage(ppicArray[x], (float) (pArrayX[x]-3000), 2000);
							}
							if(pAlive[x] == 1){
								if(pCombatAnimation[x] == 1){
									if(prArrayX[x] > playLeftX && prArrayX[x] < playRightX+550){
									pFlight[x] = 1;
									}
							g.drawImage(ppicArray2[x], (float) pArrayX[x], 70);
								}else{
									g.drawImage(ppicArray[x], (float) pArrayX[x], 70);
								}
								if(pFlight[x] == 1){
									if(pStaticP[x] == 0){
								g.drawImage(prpicArray[x], prArrayX[x], prArrayY[x]);
								prArrayX[x]+=prSpeed;
								prArrayY[x]+=3;
									}else{
									g.drawImage(prpicArray2[x], prArrayX[x], prArrayY[x]);
									prArrayX[x]+=prSpeed;
								}
								}
								if(pCombatAnimation[x] == 2){
									prArrayX[x] = (int) (pArrayX[x]+90);
									prArrayY[x] = 110;
								}
								pAlive[x] = 0;
								if(pCombatAnimation[x] > 0 && pFlight[x] == 0){
									pCombatAnimation[x]--;
								}
							}
							pCheckP[x] = 0;
						}
						//resetting phoenix fire-ball if goes below map
						for(int x = 0; x < 15; x++){
						if(prArrayY[x] > 680){
							prArrayY[x] = -200;
							prArrayX[x] = -100;
							pFlight[x] = 0;
							pCombatAnimation[x] = 0;
						}
						}
						if(pcdr > 0){
							pcdr--;
						}
						
						//////////////////////////
						///BAD PHOENIX STUFF/////
						////////////////////////
						
						if(level >= 16){
						for(int x = 0; x < 15; x++){
							if(bpHealth[x] >0){
								if(bprArrayX[x] < playLeftX+350){
									goodTowerHealth-=badTowerDamage*150;
									bprArrayX[x] = 2000;
									bpFlight[x] = 0;
									bpCombatAnimation[x] = 0;
									bpStaticP[x] = 0;
								}
								bpAlive[x] = 1;
								for(int y = 0; y < 15; y++){
									if(bpArrayX[x] > playLeftX +600){
								if(bpArrayX[x] < wArrayX[y]+500 && bpArrayX[x] > wArrayX[y]-20 && wHealth[y] > 0 || bpFlight[x] == 1){
									bpCombat[x] = 1;
									if(bprArrayX[x] < wArrayX[y]+25 && bprArrayX[x] > wArrayX[y]-25){
										if(bprArrayY[x] > 500){
										bprArrayX[x] = 2000;
										bpFlight[x] = 0;
										bpCombatAnimation[x] = 0;
									wHealth[y] -=bpdmg;
									if(wHealth[y] <=0){
										bpCombat[x] = 0;
										wArrayX[y]= playLeftX -2500;
									}
										}
									}
								}
									}else{
										bpCombat[x] = 1;
									}
								}
								for(int y = 0; y < 15; y++){
									if(bpArrayX[x] > playLeftX +600){
							if(bpArrayX[x] < aArrayX[y]+500 && bpArrayX[x] > aArrayX[y]-20 && aHealth[y] > 0 || bpFlight[x] == 1){
								bpCombat[x] = 1;
								if(bprArrayX[x] <aArrayX[y]+25 && bprArrayX[x] > aArrayX[y]-25){
									if(bprArrayY[x] > 500){
									bprArrayX[x] = 2000;
									bpFlight[x] = 0;
									bpCombatAnimation[x] = 0;
									aHealth[y] -=bpdmg;
									if(aHealth[y] <=0){
										bpCombat[x] = 0;
										aArrayX[y]= playLeftX - 2500;
									}
								}
									}
							}
									}
								}
								for(int y = 0; y < 15; y++){
									if(bpArrayX[x] > playLeftX +600){
								if(bpArrayX[x] < gArrayX[y]+500 && bpArrayX[x] > gArrayX[y]-20 && gHealth[y] > 0 || bpFlight[x] == 1){
									bpCombat[x] = 1;
									if(bprArrayX[x] < gArrayX[y]+75 && bprArrayX[x] > gArrayX[y]-25){
										if(bprArrayY[x] > 450){
										bprArrayX[x] = 2000;
										bpFlight[x] = 0;
										bpCombatAnimation[x] = 0;
									gHealth[y] -=bpdmg;
									if(gHealth[y] <=0){
										bpCombat[x] = 0;
										gArrayX[y]= playLeftX -2500;
									}
									}
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(bpArrayX[x] > playLeftX +600){
								if(bpArrayX[x] < cArrayX[y]+600 && bpArrayX[x] > cArrayX[y]-50 && cHealth[y] > 0 || bpFlight[x] == 1){
									bpCombat[x] = 1;
									if(bprArrayX[x] < cArrayX[y]+300 && bprArrayX[x] > cArrayX[y]-25){
										if(bprArrayY[x] > 500){
										bprArrayX[x] = 2000;
										bpFlight[x] = 0;
										bpCombatAnimation[x] = 0;
									cHealth[y] -=bpdmg;
									if(cHealth[y] <=0){
										bpCombat[x] = 0;
										cArrayX[y]= playLeftX -2500;
									}
									}
									}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(bpArrayX[x] > playLeftX +600){
							if(bpArrayX[x] < pArrayX[y]+560 && bpArrayX[x] > pArrayX[y]-50 && pHealth[y] > 0 || bpFlight[x] == 1){
								bpCombat[x] = 1;
								if(bprArrayX[x] <pArrayX[y]+65 && bprArrayX[x] > pArrayX[y]-25){
									if(bprArrayY[x] < 300){
									bprArrayX[x] = 2000;
									bpFlight[x] = 0;
									bpCombatAnimation[x] = 0;
									bpStaticP[x] = 0;
									pHealth[y] -=bpdmg;
									if(pHealth[y] <=0){
										bpCombat[x] = 0;
										pArrayX[y]= playLeftX - 2500;
									}
								}
								}
									}
									}
								}
								//CHECKING TO SEE IF PHOENIX IS AROUND
								for(int y = 0; y < 15; y ++){
									if(bpFlight[x] == 0){
									if(bpArrayX[x] < pArrayX[y]+560 && bpArrayX[x] > pArrayX[y]-50 && pHealth[y] > 0){
										bpCheckP[x]++;
										bpStaticP[x] = 1;
								}
									}
								}	
							if(bpCombat[x] == 1){
								if(bpCombatAnimation[x] <=0 && bpFlight[x] == 0){
								bpCombatAnimation[x] = 50;
								}
							}else{
								if(bpSpeedV[x] <=0){
									bpSpeedV[x] = 1;
								bpArrayX[x]-=bpSpeed;
								}else{
									bpSpeedV[x]--;
								}
							}
							}else{
								g.drawImage(bppicArray[x], (float) (bpArrayX[x]-3000), 2000);
							}
							if(bpAlive[x] == 1){
								if(bpCombatAnimation[x] == 1){
									if(bprArrayX[x] > playLeftX && bprArrayX[x] > playLeftX + 600){
									bpFlight[x] = 1;
									}
							g.drawImage(bppicArray2[x], (float) bpArrayX[x], 70);
								}else{
									g.drawImage(bppicArray[x], (float) bpArrayX[x], 70);
								}
								if(bpFlight[x] == 1){
									if(bpStaticP[x] == 0){
								g.drawImage(bprpicArray[x], bprArrayX[x], bprArrayY[x]);
								bprArrayX[x]-=bprSpeed;
								bprArrayY[x]+=3;
									}else{
								g.drawImage(bprpicArray2[x], bprArrayX[x], bprArrayY[x]);
								bprArrayX[x]-=bprSpeed;
									}
								}
								if(bpCombatAnimation[x] == 2){
									if(bpStaticP[x] == 0){
									bprArrayX[x] = (int) (bpArrayX[x]+90);
									bprArrayY[x] = 110;
									}else{
										bprArrayX[x] = (int) (bpArrayX[x]+40);
										bprArrayY[x] = 110;	
									}
								}
								bpAlive[x] = 0;
								if(bpCombatAnimation[x] > 0 && bpFlight[x] == 0){
									bpCombatAnimation[x]--;
								}
							}
							bpCheckP[x] = 0;
						}
						//resetting phoenix fire-ball if goes below map
						for(int x = 0; x < 15; x++){
						if(bprArrayY[x] > 680){
							bprArrayY[x] = -200;
							bprArrayX[x] = -100;
							bpFlight[x] = 0;
							bpCombatAnimation[x] = 0;
							bpStaticP[x] = 0;
						}
						}
						if(bpcdr <= 0){	
							int vv = 0;
							for(int x = 0; x < 15; x++){
								if(bpHealth[x] <= 0 && vv == 0){
									bpArrayX[x] = playRightX+850;
									bpHealth[x] = bpMaxHealth;
									bpCombat[x] = 0;
									bpcdr = bpMaxCdr;
									vv = 1;
								}
							}
						}
						if(bpcdr > 0){
							bpcdr--;
						}
						}
						
						
						///////////////////////
						//GOOD BOW LOGIC//////
						//////////////////////
						if(goodBowShoot){
							goodBowAnimation--;					
							if(goodBowAnimation <= 20){
								g.drawImage(goodBow1,playLeftX + 120, 0);
							}else{
								g.drawImage(goodBow2,playLeftX + 120, 0);
							}
							if(goodBowAnimation > 0){
								goodBowAnimation --;
							}else{
								int bCount = 0;
								for(int x = 0; x < 30; x++){
									if(bCount == 0){
										if(BFlight[x] == 0){
										BFlight[x] = 1;
										goodbowammoX[x] = playLeftX+370;
										Bvx[x] = 6;
										//.019
										BtV[x] = ((.02-(bowDistanceLevel*.0005))*bowMeterY/434);
										Bt[x] = .5;
										Bgravity[x] = 2.15;
										bCount = 1;
										}
									}
								}
								goodBowAnimation = (int) (80 - bowSpeedLevel*2.5);
							}
						}else{
							g.drawImage(goodBow2,playLeftX + 120, 0);
						}
						g.setColor(c);
						for(int x = 0; x < 30; x++){							
							if(BFlight[x] == 1){
								goodbowammoY[x] = (int) (((Bvx[x])*(Bt[x]-Bgravity[x])*Bt[x]*(Bt[x]/2))*32)+148;
								g.fillOval((float) (goodbowammoX[x]+Bvx[x]*Bt[x]),(int) goodbowammoY[x], 24, 24);
								goodbowammoX[x]+=BSpeed;							
								Bt[x]+=BtV[x];
								if(goodbowammoY[x] > 720){
									BFlight[x] = 0;
								}
								
								for(int y = 0; y < 15; y++){
									if(goodbowammoX[x] < playRightX +750){
								if(goodbowammoX[x] > bpArrayX[y]-35 && goodbowammoX[x] < bpArrayX[y]+110 && bpHealth[y] > 0){
									if(goodbowammoY[x] < 250 && goodbowammoY[x] > 150){
									bpHealth[y] -=tbdmg + bowDamageLevel*5;
									BFlight[x] = 0;
									if(bpHealth[y] <=0){									
										bpArrayX[y] = playRightX+2500;
										coins +=5 + goldIncome*2;
										mana+=2;
									}
								}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(goodbowammoX[x] < playRightX +750){
								if(goodbowammoX[x] > bcArrayX[y] && goodbowammoX[x] < bcArrayX[y]+300 && bcHealth[y] > 0){
									if(goodbowammoY[x] > 520){
									bcHealth[y] -=tbdmg + bowDamageLevel*5;
									BFlight[x] = 0;
									if(bcHealth[y] <=0){
										bcArrayX[y] = playRightX+2500;
										coins +=5 + goldIncome*2;
										mana+=4;
									}
								}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(goodbowammoX[x] < playRightX +750){
								if(goodbowammoX[x] > badgArrayX[y]-15 && goodbowammoX[x] < badgArrayX[y]+110 && badgHealth[y] > 0){
									if(goodbowammoY[x] > 450){
									badgHealth[y] -=tbdmg + bowDamageLevel*5;
									BFlight[x] = 0;
									if(badgHealth[y] <=0){
										badgArrayX[y] = playRightX+2500;
										coins +=5 + goldIncome*2;
										mana+=6;
									}
								}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(goodbowammoX[x] < playRightX +750){
								if(goodbowammoX[x] > baArrayX[y]-5 && goodbowammoX[x] < baArrayX[y]+55 && baHealth[y] > 0){
									if(goodbowammoY[x] > 520){
									baHealth[y] -=tbdmg + bowDamageLevel*5;
									BFlight[x] = 0;
									if(baHealth[y] <=0){
										baArrayX[y] = playRightX+2500;
										coins +=5 + goldIncome*2;
										mana+=8;
									}
								}
								}
									}
								}
								for(int y = 0; y < 15; y++){
									if(goodbowammoX[x] < playRightX +750){
								if(goodbowammoX[x] > badwArrayX[y]-5 && goodbowammoX[x] < badwArrayX[y]+55 && badwHealth[y] > 0){
									if(goodbowammoY[x] > 520){
									badwHealth[y] -=tbdmg + bowDamageLevel*5;
									BFlight[x] = 0;
									if(badwHealth[y] <=0){
										badwArrayX[y] = playRightX+2500;
										coins +=5 + goldIncome*2;
										mana+=10;
									}
								}
								}
									}
								}
								}
						}
						
						g.drawImage(bowMeter, 5, 250);
						g.fillRect(17, bowMeterY, 30, 10);
						
						
						//DRAWING BOTTOM BOXES (boxes on bottom)
						for(int x = 0; x< 6; x++){
							g.setColor(Color.white);
							g.fillRect(100 + (90*x), 616, 60, 60);
						}
						
						//WARRIOR DRAWING BOXES
						if(wColorV == 15){
							g.setColor(Color.darkGray);
							g.fillRect(100,616, 60, 60);
							wColorV = 0;
						}else{
							wColorV = 0;
						}
						
						for(int x = 0; x < 15; x++){
							if(wArrayX[x] > playLeftX+251){
								wColorV ++;
							}
						}
						
						//ARCHER DRAWING BOXES
						if(aColorV == 15){
							g.setColor(Color.darkGray);
							g.fillRect(190,616, 60, 60);
							aColorV = 0;
						}else{
							aColorV = 0;
						}
						
						for(int x = 0; x < 15; x++){
							if(aArrayX[x] > playLeftX+251){
								aColorV ++;
							}
						}
						
						//GOLEM DRAWING BOXES
						if(gColorV == 15){
							g.setColor(Color.darkGray);
							g.fillRect(280,616, 60, 60);
							gColorV = 0;
						}else{
							gColorV = 0;
						}
						
						for(int x = 0; x < 15; x++){
							if(gArrayX[x] > playLeftX+251){
								gColorV ++;
							}
						}
						
						//CATAPULT DRAWING BOXES
						if(cColorV == 15){
							g.setColor(Color.darkGray);
							g.fillRect(370,616, 60, 60);
							cColorV = 0;
						}else{
							cColorV = 0;
						}
						
						for(int x = 0; x < 15; x++){
							if(cArrayX[x] > playLeftX+251){
								cColorV ++;
							}
						}
						
						//PHOENIX DRAWING BOXES
						if(pColorV == 15){
							g.setColor(Color.darkGray);
							g.fillRect(460,616, 60, 60);
							pColorV = 0;
						}else{
							pColorV = 0;
						}
						
						for(int x = 0; x < 15; x++){
							if(pArrayX[x] > playLeftX+251){
								pColorV ++;
							}
						}

						g.drawImage(wIcon, 100, 616);
						g.drawImage(aIcon, 190, 616);
						g.drawImage(gIcon, 280, 616);
						g.drawImage(cIcon, 370, 616);
						g.drawImage(pIcon, 460, 616);
						
						//DRAWING COOLDOWN BOXES
						g.setColor(Color.gray);
						g.fillRect(100, 616, 60, wcdr*60/wMaxCdr);
						g.fillRect(190, 616, 60, acdr*60/aMaxCdr);
						g.fillRect(280, 616, 60, gcdr*60/gMaxCdr);
						g.fillRect(370, 616, 60, ccdr*60/cMaxCdr);
						g.fillRect(460, 616, 60, pcdr*60/pMaxCdr);
						
						//COINS VALUE
						fUnicodeFont.drawString(655,10,"Coins : " + coins,Color.yellow);
						
						//MANA VALUE
						fUnicodeFont.drawString(495,10,"Mana : " + mana + "/" + maxMana,Color.blue);
						
						//cost values
						g.setColor(Color.blue);
						//warrior mana cost
						g.drawString("10", 100,600);
						//archer mana cost
						g.drawString("20", 190,600);
						//golem mana cost
						g.drawString("30", 280,600);
						//catapult mana cost
						g.drawString("40", 370,600);
						//phoenix mana cost
						g.drawString("50", 460,600);
						
						//IF GAME IS PAUSED
								}else{
									g.setColor(Color.cyan);
									g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
									fUnicodeFont.drawString(580, 250,"Paused", Color.black);
								}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = 680-Mouse.getY();
		
		//looping custom Spawns
		customSpawns();
				
		//PAUSE STUFF
		if(input.isKeyPressed(Input.KEY_P)){
			if(pauseTime <=0){
				pauseTime = 20;
				if(pause){
					pause = false;
				}else{
					pause = true;
				}
			}
		}
		//EXIT GAME
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			gc.exit();
		}
		pauseTime--;
		
		if(pause == false){
			
			//SHOOTING BOW
			if(input.isKeyPressed(Input.KEY_S)){
				if(shootTime <=0){
					shootTime = 15;
					if(goodBowShoot){
						goodBowShoot = false;
					}else{
						goodBowShoot = true;
					}
				}
			}
			shootTime --;
			
			//CHANGING POWER
			if(bowMeterY > 255 && bowMeterY < 435){
				if(input.isKeyDown(Input.KEY_UP)){
					if(bowMeterY > 256){
					bowMeterY-=1;
					}
				}
				if(input.isKeyDown(Input.KEY_DOWN)){
					if(bowMeterY < 434){
					bowMeterY+=1;
					}
				}
			}
			if(input.isMouseButtonDown(0)){
				if(mouseX >= begin.toPixelsX(1) && mouseX <= begin.toPixelsX(13)){
					if(mouseY >= begin.toPixelsY(76) && mouseY <= begin.toPixelsY(127)){
						if(begin.getSizeHeight() == 680){
						bowMeterY = begin.getSizeHeight()-Mouse.getY();
						}
					}
					}
			}
		if(warriorRepeater >0){
			warriorRepeater--;
		}else{
			for(int x = 0; x < 15; x++){
				if(wArrayX[x] < playRightX +750){
				wCombat[x] = 0;
				}
				if(badwArrayX[x]  >= playLeftX + 350){
				badwCombat[x] = 0;
				}
				if(gArrayX[x] < playRightX +750){
				gCombat[x] = 0;
				}
				if(badgArrayX[x]  >= playLeftX + 350){
				badgCombat[x] = 0;
				}
				if(aArrayX[x] < playRightX +750){
				aCombat[x] = 0;
				}
				if(baArrayX[x] > playLeftX +250){
				baCombat[x] = 0;
				}
				if(cArrayX[x] < playRightX +750){
				cCombat[x] = 0;
				}
				if(bcArrayX[x] > playLeftX +750){
				bcCombat[x] = 0;
				}
				if(pArrayX[x] < playRightX +750){
				pCombat[x] = 0;
				}
				if(bpArrayX[x] > playLeftX +750){
				bpCombat[x] = 0;
				}
			}
			warriorRepeater = 15;
		}
		///////////////////////////////
		//MOVING OBJECTS TO THE RIGHT//
		///////////////////////////////
		if(input.isKeyDown(Input.KEY_LEFT) && playLeftX <=0){
			
			playLeftX+=movingSpeed;
			playRightX+=movingSpeed;
			meterX-=movingSpeed/7;
			
			goodTowerHealthX+=movingSpeed;
			badTowerHealthX+=movingSpeed;

			farBackX+=movingSpeed/7;
			
			for(int x = 0; x < 15; x++){
				wArrayX[x]+=movingSpeed;
				badwArrayX[x]+=movingSpeed;
				aArrayX[x]+=movingSpeed;
				arArrayX[x]+=movingSpeed;
				baArrayX[x]+=movingSpeed;
				barArrayX[x]+=movingSpeed;
				gArrayX[x]+=movingSpeed;
				badgArrayX[x]+=movingSpeed;
				cArrayX[x]+=movingSpeed;
				caArrayX[x]+=movingSpeed;
				bcArrayX[x]+=movingSpeed;
				bcaArrayX[x]+=movingSpeed;
				pArrayX[x]+=movingSpeed;
				prArrayX[x]+=movingSpeed;
				bpArrayX[x]+=movingSpeed;
				bprArrayX[x]+=movingSpeed;
				goodbowammoX[x]+=movingSpeed;
			}
		}
		
		//////////////////////////////
		//MOVING OBJECTS TO THE LEFT//
		/////////////////////////////
		
		if(input.isKeyDown(Input.KEY_RIGHT) && playRightX >=0){
			
			playLeftX-=movingSpeed;
			playRightX-=movingSpeed;
			meterX+=movingSpeed/7;
			
			goodTowerHealthX-=movingSpeed;
			badTowerHealthX-=movingSpeed;
			
			farBackX-=movingSpeed/7;
			
			
			for(int x = 0; x < 15; x++){
				wArrayX[x]-=movingSpeed;
				badwArrayX[x]-=movingSpeed;
				aArrayX[x]-=movingSpeed;
				arArrayX[x]-=movingSpeed;
				baArrayX[x]-=movingSpeed;
				barArrayX[x]-=movingSpeed;
				gArrayX[x]-=movingSpeed;
				badgArrayX[x]-=movingSpeed;
				cArrayX[x]-=movingSpeed;
				caArrayX[x]-=movingSpeed;
				bcArrayX[x]-=movingSpeed;
				bcaArrayX[x]-=movingSpeed;
				pArrayX[x]-=movingSpeed;
				prArrayX[x]-=movingSpeed;
				bpArrayX[x]-=movingSpeed;
				bprArrayX[x]-=movingSpeed;
				goodbowammoX[x]-=movingSpeed;
			}
		} 
		
		
		//LEFT AND RIGHT KEY TESTING
		if(input.isKeyDown(Input.KEY_Q) && movingSpeed <20 && moveSpeakTime > 50){
			movingSpeed+=7;
			moveSpeakTime = 0;
		}
		
		if(input.isKeyDown(Input.KEY_A) && movingSpeed >7 && moveSpeakTime > 50){
			movingSpeed -=7;
			moveSpeakTime = 0;
		}
			
			
			//MANA TIMER
			if(manaTimer < 30 - manaIncome*2.5){
				manaTimer++;
			}else{
				if(mana < maxMana){ 
				manaTimer = 0;
				mana++;
				}else{
					mana = maxMana;
				}
			}
			
			//RESIZING GAME
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
			
			if(cTotalCost == 0){
			if(mouseX >= 370 && mouseX <= 430){
				if(mouseY >616 && mouseY < 676){
					if(input.isMouseButtonDown(0)){
						//CATAPULT MOUSE AND KEY INPUT
					if(mana >= 40 && ccdr == 0){
						int vvv = 0;
					for(int x = 0; x < 15; x++){
						if(cHealth[x] <= 0 && vvv == 0){
							cArrayX[x] = playLeftX+250;
							cHealth[x] = cMaxHealth;
							cAlive[x] = 0;
							cCombatAnimation[x] = 0;
							catapultFlight[x] = 0;
							mana-=40;
							ccdr = cMaxCdr - unitCdr;
							vvv = 1;
						}
					}
					}
					}
				}
				}else{
					if(input.isKeyDown(Input.KEY_4) && ccdr == 0){
						if(mana >= 40 && ccdr == 0){
							int vvv = 0;
						for(int x = 0; x < 15; x++){
							if(cHealth[x] <= 0 && vvv == 0){
								cArrayX[x] = playLeftX+250;
								cHealth[x] = cMaxHealth;
								cAlive[x] = 0;
								cCombatAnimation[x] = 0;
								catapultFlight[x] = 0;
								mana-=40;
								ccdr = cMaxCdr - unitCdr;
								vvv = 1;
							}
						}
						}
					}
				}
			}
			if(gTotalCost == 0){
			//GOLEM MOUSE AND KEY INPUT
			if(mouseX >= 280 && mouseX <= 340){
				if(mouseY >616 && mouseY < 676){
					if(input.isMouseButtonDown(0)){
					if(mana >= 30 && gcdr == 0){
						int vvv = 0;
						for(int x = 0; x < 15; x++){
							if(gHealth[x] <= 0 && vvv == 0){
								gArrayX[x] = playLeftX+250;
								gHealth[x] = gMaxHealth;
								gCombat[x] = 0;
								mana-=30;
								gcdr = gMaxCdr - unitCdr;
								vvv = 1;
							}
						}
						}
					}
				}
				}else{
					if(input.isKeyDown(Input.KEY_3)){
						if(mana >= 30 && gcdr == 0){
							int vvv = 0;
							for(int x = 0; x < 15; x++){
								if(gHealth[x] <= 0 && vvv == 0){
									gArrayX[x] = playLeftX+250;
									gHealth[x] = gMaxHealth;
									gCombat[x] = 0;
									mana-=30;
									gcdr = gMaxCdr - unitCdr;
									vvv = 1;
								}
							}
							}
					}
				}
			}
			//WARRIOR MOUSE AND KEY INPUT
			if(mouseX >= 100 && mouseX < 160){
				if(mouseY >616 && mouseY < 676){
					if(input.isMouseButtonDown(0)){
					if(mana >= 10 && wcdr == 0){
						int vvv = 0;
						for(int x = 0; x < 15; x++){
							if(wHealth[x] <= 0 && vvv == 0){
								wArrayX[x] = playLeftX+250;
								wHealth[x] = wMaxHealth;
								wCombat[x] = 0;
								mana-=10;
								wcdr = wMaxCdr - unitCdr;
								vvv = 1;
							}
						}
						}
						}
				}
			}else{
				if(input.isKeyDown(Input.KEY_1)){
					if(mana >= 10 && wcdr == 0){
						int vvv = 0;
						for(int x = 0; x < 15; x++){
							if(wHealth[x] <= 0 && vvv == 0){
								wArrayX[x] = playLeftX+250;
								wHealth[x] = wMaxHealth;
								wCombat[x] = 0;
								mana-=10;
								wcdr = wMaxCdr - unitCdr;
								vvv = 1;
							}
						}
						}
				}
			}
			if(aTotalCost == 0){
			// ARCHER MOUSE AND KEY INPUT
			if(mouseX >= 190 && mouseX <= 250){
				if(mouseY >616 && mouseY < 676){
					if(mana >= 20 && acdr == 0){
						int vvv = 0;
						for(int x = 0; x < 15; x++){
							if(aHealth[x] <= 0 && vvv == 0){
								aArrayX[x] = playLeftX+250;
								aHealth[x] = aMaxHealth;
								aCombat[x] = 0;
								aAlive[x] = 0;
								aCombat[x] = 0;
								aCombatAnimation[x] = 0;
								arrowFlight[x] = 0;
								mana-=20;
								acdr = aMaxCdr - unitCdr;
								aStaticP[x] = 0;
								vvv = 1;
							}
						}
						}
				}
				}else{
					if(input.isKeyDown(Input.KEY_2)){
						if(mana >= 20 && acdr == 0){
							int vvv = 0;
							for(int x = 0; x < 15; x++){
								if(aHealth[x] <= 0 && vvv == 0){
									aArrayX[x] = playLeftX+250;
									aHealth[x] = aMaxHealth;
									aCombat[x] = 0;
									aAlive[x] = 0;
									aCombat[x] = 0;
									aCombatAnimation[x] = 0;
									arrowFlight[x] = 0;
									mana-=20;
									acdr = aMaxCdr - unitCdr;
									aStaticP[x] = 0;
									vvv = 1;
								}
							}
							}
					}
				}
			}
			if(pTotalCost == 0){
			//PHOENIX MOUSE AND KEY INPUT
			if(mouseX >= 460 && mouseX < 520){
				if(mouseY >616 && mouseY < 676){
					if(input.isMouseButtonDown(0)){
					if(mana >= 50 && pcdr == 0){
						int vvv = 0;
						for(int x = 0; x < 15; x++){
							if(pHealth[x] <= 0 && vvv == 0){
								pArrayX[x] = playLeftX+250;
								pHealth[x] = pMaxHealth;
								pCombat[x] = 0;
								pAlive[x] = 0;
								pCombat[x] = 0;
								pCombatAnimation[x] = 0;
								pFlight[x] = 0;
								mana-=50;
								pcdr = pMaxCdr - unitCdr;
								pStaticP[x] = 0;
								vvv = 1;
							}
						}
						}
						}
				}
			}else{
				if(input.isKeyDown(Input.KEY_5)){
					if(mana >= 50 && pcdr == 0){
						int vvv = 0;
						for(int x = 0; x < 15; x++){
							if(pHealth[x] <= 0 && vvv == 0){
								pArrayX[x] = playLeftX+250;
								pHealth[x] = pMaxHealth;
								pCombat[x] = 0;
								pAlive[x] = 0;
								pCombat[x] = 0;
								pCombatAnimation[x] = 0;
								pFlight[x] = 0;
								mana-=50;
								pcdr = pMaxCdr - unitCdr;
								pStaticP[x] = 0;
								vvv = 1;
							}
						}
						}
				}
			}
			}

			//CHANGING TO STATE 2
			if(badTowerHealth <= 0){
				Shop.setVariablesV = true;
				if(level < 10){
				coins +=30*(level/2) + goldIncome*2;
				}else{
				coins +=50*(level/4) + goldIncome*2;
				}
				sbg.enterState(2);
			}
			
			//RESET MAP
			if(playState){
				for(int x = 0; x < 30; x++){
					BFlight[x] = 0;
				}
				for(int x = 0; x < 15; x++){
					wArrayX[x] = -400;
					wHealth[x] = 0;
					badwArrayX[x] = 1450;
					wAlive[x] = 0;
					wCombat[x] = 0;
					wCombatAnimation[x] = 0;
					
					gArrayX[x] = -400;
					gHealth[x] = 0;
					gAlive[x] = 0;
					gCombat[x] = 0;
					gCombatAnimation[x] = 0;
					
					badwAlive[x] = 0;
					badwCombat[x] = 0;
					badwCombatAnimation[x] = 0;

					aArrayX[x] = -400;
					aHealth[x] = 0;
					aAlive[x] = 0;
					aCombat[x] = 0;
					aCombatAnimation[x] = 0;
					arrowFlight[x] = 0;
					aStaticP[x] = 0;
					
					baArrayX[x] = 1450;
					baHealth[x] = 0;
					baAlive[x] = 0;
					baCombat[x] = 0;
					baCombatAnimation[x] = 0;
					barrowFlight[x] = 0;
					baStaticP[x] = 0;
					
					badgArrayX[x] = 1450;
					badgHealth[x] = 0;
					badgAlive[x] = 0;
					badgCombat[x] = 0;
					badgCombatAnimation[x] = 0;
					
					cArrayX[x] = -400;
					cHealth[x] = 0;
					cAlive[x] = 0;
					cCombat[x] = 0;
					cCombatAnimation[x] = 0;
					catapultFlight[x] = 0;
					vx[x] = 6;
					t[x] = 0.5;
					gravity[x] = 2.5;
					idX[x] = 0;
					
					bcArrayX[x] = 1450;
					bcHealth[x] = 0;
					bcAlive[x] = 0;
					bcCombat[x] = 0;
					bcCombatAnimation[x] = 0;
					bcatapultFlight[x] = 0;
					bvx[x] = 6;
					bt[x] = 0.5;
					bgravity[x] = 2.5;
					bidX[x] = 0;
					
					pArrayX[x] = -400;
					pHealth[x] = 0;
					pAlive[x] = 0;
					pCombat[x] = 0;
					pCombatAnimation[x] = 0;
					pFlight[x] = 0;
					
					bpArrayX[x] = 1450;
					bpHealth[x] = 0;
					bpAlive[x] = 0;
					bpCombat[x] = 0;
					bpCombatAnimation[x] = 0;
					bpFlight[x] = 0;
				}
				meterX = 621;
				playLeftX = -625;
				
				playRightX = 625;
				
				farBackX = -350;
				
				 goodTowerHealthX = -550;
				 badTowerHealthX = 1650;

				goodTowerHealth = goodTowerMaxHealth;
				mana = 0;
				
				//BAD GUY ADDITIONS
				if(level >= 1){
					badwdmg +=.005;
					badwMaxHealth +=10;
					badwMaxcdr -=5;
				}
				
				if(level >= 5){
				badmg +=3;
				baMaxHealth +=10;
				baMaxcdr -=5;
				}
				
				if(level >= 8){
				badgdmg +=.02;
				badgMaxHealth +=10;
				badgMaxcdr -=3;
				}
				
				if(level >= 12){
				bcdmg +=1;
				bcMaxHealth +=10;
				bcMaxcdr -=3;
				bcSpeed +=.2;
				}
				
				if(level >= 16){
				bpdmg +=1;
				bpMaxHealth +=10;
				bpMaxCdr -=3;
				}
				
				playState = false;
			}
			}
	}
	
	public int getID(){
		return 1;
	}
	
	//sets custom spawns
	public void customSpawns(){
		
		//CHOOSING SPAWN TYPE
		if(customSpawnCounter <= 0){
			
			//LEVEL 1 and 2 MAKING DOUBLE WARRIOR WAVES
		if(randomGenerator.nextInt(2000) == 1){
			if(level == 1){
			customSpawnType = 0;
			customSpawnCounter = 2;
			customSpawnDelay = 100;
			}else if(level == 2){
			customSpawnType = 0;
			customSpawnCounter = 3;
			customSpawnDelay = 150;	
			}else if(level == 3){
			customSpawnType = 0;
			customSpawnCounter = 4;
			customSpawnDelay = 100;				
			}else if(level == 4){
			customSpawnType = 0;
			customSpawnCounter = 4;
			customSpawnDelay = 75;				
			}else{
			customSpawnType = 0;
			customSpawnCounter = 3;
			customSpawnDelay = 75;	
			}
			}
		}
		
		//SPAWN TYPE LOGIC
		if(customSpawnTimer <= 0 && customSpawnCounter > 0){
			customSpawnCounter--;
		switch(customSpawnType){
		
		case 0:
			badwcdr = 0;
			break;
			
		case 1:
			break;		
	}
		}
		
		//making execute custom spawns loop
		if(customSpawnTimer <= 0){
			customSpawnTimer = customSpawnDelay;
		}
		if(customSpawnTimer > 0){
			customSpawnTimer--;
		}
	}
			
}
