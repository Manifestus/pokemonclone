package game;

import java.util.*;
import java.awt.Image;
import javax.swing.*;

/**
 *A prototype for generating a wild pokemon, evolving a pokemon, or viewing pokedex data.
 */
public class Species {
	
	private String name;
	private int generation; //1=RBY,2=GSC,3,4
	private String description;
	private Image image32, image80, imageFront, imageBack;
	private int number;
	private Type type1, type2;
	private int hp, attack, defense, spAttack, spDefense, speed; 
	private Map<Move,Integer> moves = new HashMap<Move,Integer>();
	//condition(level,trade,stone)-->pokedexpokemon
	private Map<String,Species> evolutions = new HashMap<String,Species>();
	private List<TM> tms = new LinkedList<TM>();
	private List<HM> hms = new LinkedList<HM>();
	private String GrowthRate;
	private int BaseExp;
	
	public String name(){return name;}
	public int generation(){return generation;}
	public String description(){return description;}
	public Image image32(){return image32;}
	public Image image80(){return image80;}
	public Image imageFront(){return imageFront;}
	public Image imageBack(){return imageBack;}
	public int number(){return number;}
	public int BaseExp(){return BaseExp;};
	public String GrowthRate(){return GrowthRate;}
	
	/**
	*E.g., 004
	*/
	public String paddedNumber(){
		String x = number+"";
		while(x.length()<3) x="0"+x;
		return x;
	}
	public void cry()
	{
		try
		{
			java.io.File f = new java.io.File("./species/cries/"+paddedNumber()+"Cry.mp3");
		
			javazoom.jl.player.advanced.AdvancedPlayer p = new javazoom.jl.player.advanced.AdvancedPlayer( new java.io.FileInputStream(f) );
			p.play();
		}
		catch(Exception ex)
		{
			System.err.println(name());
			ex.printStackTrace();
		}
	}
	
	public Type type(){return type1;}
	/**
	*Null for pokemon with only one type.
	*/
	public Type type2(){return type2;}
	
	public int baseHp(){return hp;}
	public int baseAttack(){return attack;}
	public int baseDefense(){return defense;}
	public int baseSpAttack(){return spAttack;}
	public int baseSpDefense(){return spDefense;}
	public int baseSpeed(){return speed;}
	
	public List<TM> learnableTMs(){return tms;}
	public List<HM> learnableHMs(){return hms;}
	
	public boolean canLearnTM(TM t){return tms.contains(t);}
	public boolean canLearnHM(HM h){return hms.contains(h);}
	
	//public Species firstForm(){return null;}
	
	/**
	*MOVELEARNED==>LEVELLEARNED.
	*/
	public Map<Move,Integer> movesLearned(){return moves;}
	public List<Move> movesLearnedAtLevel(int level)
	{
		LinkedList<Move> ms = new LinkedList<Move>();
		for(Move m: moves.keySet())
		{
			int l = moves.get(m);
			if(l==level) ms.add(m);
		}
		return ms;
	}
	
	/**
	*EVOLVECONDITION(level,trade,stone)==>POKEMONEVOLVEDINTO.
	*/
	public Map<String,Species> evolutions(){return evolutions;}
		
	private Species(XmlElement e)
	{	
		number = e.icontentOf("number");
		generation = e.icontentOf("generation");
		name = e.contentOf("name");
		image32 = Game.jarImage(e.contentOf("image32"));
		image80 = Game.jarImage(e.contentOf("image80"));
		imageFront = Game.jarImage(e.contentOf("imageFront"));
		imageBack = Game.jarImage(e.contentOf("imageBack"));
		
		description = e.contentOf("description");
		type1 = Type.named(e.contentOf("type"));
		type2 = Type.named(e.contentOf("type2"));
		GrowthRate = e.contentOf("growthRate");
		BaseExp = e.icontentOf("baseExperience");
		
		hp = e.icontentOf("baseHp");
		attack = e.icontentOf("baseAttack");
		defense = e.icontentOf("baseDefense");
		spAttack = e.icontentOf("baseSpAttack");
		spDefense = e.icontentOf("baseSpDefense");
		speed = e.icontentOf("baseSpeed");
		
		for(XmlElement en: e.children("evolution")){
			String condition = en.contentOf("level");
			String evolvedForm = en.contentOf("target");
			if(evolvedForm.equals("")) continue;
			evolutions.put( condition, Species.named(evolvedForm) );
		}
		
		
		for(XmlElement mn: e.children("move"))
		{
			moves.put(
				Move.named(mn.contentOf("name")) , mn.icontentOf("level")
			);
		}
		
		String[] tmsStr = e.contentOf("TMs").trim().split(",");
		for(String tmStr: tmsStr)
		{
			if(tmStr.equals("")) continue;
			tms.add( TM.numbered(new Integer(tmStr)) );
		}
		
		String[] hmsStr = e.contentOf("HMs").trim().split(",");
		for(String hmStr: hmsStr)
		{
			if(hmStr.equals("")) continue;
			hms.add( HM.numbered(new Integer(hmStr)) );
		}
	}
	
	public Pokemon makeWildAtLevel(int level)
	{
		return new Pokemon(this,level);
	}
		
	private static ArrayList<Species> species = new ArrayList<Species>();
	static { 
		try{
			XmlElement root = XmlElement.documentRootFrom(Game.jarStream("species/diamondSpecies.xml"));
			System.out.println(root.children().size());
			for(XmlElement e : root.children("species"))
				species.add(new Species(e));

			Collections.reverse(species);
			System.out.println(species.size()+" species!");
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	public static List<Species> all(){
		return species;
	}
	
	/**
	*Case insensitive.
	*/
	public static Species named(String name){
		for(Species s: species)
			if(s.name.equalsIgnoreCase(name))return s;
		System.out.println("No species named "+name);
		return null;
	}
	public static Species withNumber(int no){
		for(Species s: species)
			if(s.number==no)return s;
		System.out.println("No species numbered "+no);
		return null;
	}

}