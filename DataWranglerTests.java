import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

//--== CS400 File Header Information ==--
//Author: Sean Erickson
//Email: smerickson4@wisc.edu
//Team: blue
//Role: Front end developer
//TA: hang
//Lecturer: Gary
//Notes: This is the test class for the data wranglers implementation
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
		pokemonList = test.readDataSet();
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
		pokemonList = test.readDataSet();

																								
																										
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
		pokemonList = test.readDataSet();
																		
																										
								
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
		pokemonList = test.readDataSet();
																	
								
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
		pokemonList = test.readDataSet();
																										
							
		assertEquals(false, pokemonList.get(0).isLegendary());
		assertEquals(false, pokemonList.get(1).isLegendary());
		assertEquals(true, pokemonList.get(426).isLegendary());
		
		}
		catch(FileNotFoundException e) {
			fail();
		}
	}
}
