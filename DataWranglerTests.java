import org.junit.Test;
import static org.junit.Assert.*;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

public class DataWranglerTests {
	PokemonDataReader test;
	@Test
	public void TestNumberOfPokemon() {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet(new StringReader("#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n" + 
				"1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n" + 
				"2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n" + 
				"3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n" + 
				"3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False")); //change to put in real data when implemented
		assertEquals(4, pokemonList.size());
	}
	
	@Test
	public void TestGetName() {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet(new StringReader("#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n" + 
				"1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n" + 
				"2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n" + 
				"3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n" + 
				"3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False")); //change to put in real data when implemented
		assertEquals("Bulbasaur", pokemonList.get(0).getName());
		assertEquals("Ivysaur", pokemonList.get(1).getName());
		assertEquals("Venusaur", pokemonList.get(2).getName());
	}
	
	@Test
	public void TestHPAndTotal() {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet(new StringReader("#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n" + 
				"1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n" + 
				"2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n" + 
				"3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n" + 
				"3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False")); //change to put in real data when implemented
		assertEquals(45, pokemonList.get(0).getHP());
		assertEquals(60, pokemonList.get(1).getHP());
		assertEquals(80, pokemonList.get(2).getHP());
		
		assertEquals(143, pokemonList.get(0).getTotal());
		assertEquals(185, pokemonList.get(1).getTotal());
		assertEquals(245, pokemonList.get(2).getTotal());
	}
	
	@Test
	public void TestGetAtkDef() {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet(new StringReader("#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n" + 
				"1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n" + 
				"2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n" + 
				"3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n" + 
				"3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False")); //change to put in real data when implemented
		assertEquals(49, pokemonList.get(0).getAttack());
		assertEquals(62, pokemonList.get(1).getAttack());
		assertEquals(82, pokemonList.get(2).getAttack());
		
		assertEquals(49, pokemonList.get(0).getDefense());
		assertEquals(63, pokemonList.get(1).getDefense());
		assertEquals(83, pokemonList.get(2).getDefense());
	}

	@Test
	public void TestLegendary() {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet(new StringReader("#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n" + 
				"1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n" + 
				"2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n" + 
				"249,Lugia,Psychic,Flying,680,106,90,130,90,154,110,2,True\n" + 
				"3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False")); //change to put in real data when implemented
		assertEquals(false, pokemonList.get(0).isLegendary());
		assertEquals(false, pokemonList.get(1).isLegendary());
		assertEquals(true, pokemonList.get(2).isLegendary());
	}
}
