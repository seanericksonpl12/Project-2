//--== CS400 File Header Information ==--
//Author: Sean Erickson
//Email: smerickson4@wisc.edu
//Team: blue
//Role: Front end developer
//TA: hang
//Lecturer: Gary
//Notes: This is the test class for the data wranglers implementation

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

public class DataWranglerTests {

	PokemonDataReader test;

	/*
	 * This tests whether the list stores the correct number of pokemon store from the data given
	 */
	@Test
	public void TestNumberOfPokemon() {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		try {
		pokemonList = test.readDataSet();/*new StringReader(
				"#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n"
						+ "1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n"
						+ "2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n"
						+ "3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n"
						+ "3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False")); */
		assertEquals(432, pokemonList.size());																							
		}
		catch(FileNotFoundException e) {
			fail();
		}
		
	}

	/*
	 * This test checks that the correct name is returned for each pokemon in the list
	 */
	@Test
	public void TestGetName() {
		try {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet() /*new StringReader(
				"#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n"
						+ "1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n"
						+ "2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n"
						+ "3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n"
						+ "3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False"))*/;

																								
																										
		assertEquals("Bulbasaur", pokemonList.get(0).getName());
		assertEquals("Ivysaur", pokemonList.get(1).getName());
		assertEquals("Venusaur", pokemonList.get(2).getName());
		
		}
		catch(FileNotFoundException e) {
			fail();
		}
	}

	/*
	 * This test checks that the HP and Total stats are correct for each pokemon
	 */
	@Test
	public void TestHPAndTotal() {
		try {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet() /*new StringReader(
				"#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n"
						+ "1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n"
						+ "2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n"
						+ "3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n"
						+ "3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False"))*/;
																		
																										
								
		assertEquals(45, pokemonList.get(0).getHP());
		assertEquals(60, pokemonList.get(1).getHP());
		assertEquals(80, pokemonList.get(2).getHP());

		assertEquals(143, pokemonList.get(0).getTotal());
		assertEquals(185, pokemonList.get(1).getTotal());
		assertEquals(245, pokemonList.get(2).getTotal());
		
		}
		catch(FileNotFoundException e) {
			fail();
		}
	}

	/*
	 * This test checks that the attack and defense stats are correct for each pokemon
	 */
	@Test
	public void TestGetAtkDef() {
		try {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet()/*new StringReader(
				"#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n"
						+ "1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n"
						+ "2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n"
						+ "3,Venusaur,Grass,Poison,525,80,82,83,100,100,80,1,False\n"
						+ "3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False"))*/;
																	
								
		assertEquals(49, pokemonList.get(0).getAttack());
		assertEquals(62, pokemonList.get(1).getAttack());
		assertEquals(82, pokemonList.get(2).getAttack());

		assertEquals(49, pokemonList.get(0).getDefense());
		assertEquals(63, pokemonList.get(1).getDefense());
		assertEquals(83, pokemonList.get(2).getDefense());
		
		}
		catch(FileNotFoundException e) {
			fail();
		}
	}

	/*
	 * This test checks that every pokemon has the correct boolean for the is Legendary stat
	 */
	@Test
	public void TestLegendary() {
		try {
		test = new PokemonDataReader();
		List<Pokemon> pokemonList;
		pokemonList = test.readDataSet()/*new StringReader(
				"#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n"
						+ "1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n"
						+ "2,Ivysaur,Grass,Poison,405,60,62,63,80,80,60,1,False\n"
						+ "249,Lugia,Psychic,Flying,680,106,90,130,90,154,110,2,True\n"
						+ "3,VenusaurMega Venusaur,Grass,Poison,625,80,100,123,122,120,80,1,False"))*/;
																										
							
		assertEquals(false, pokemonList.get(0).isLegendary());
		assertEquals(false, pokemonList.get(1).isLegendary());
		assertEquals(true, pokemonList.get(426).isLegendary());
		
		}
		catch(FileNotFoundException e) {
			fail();
		}
	}
}
