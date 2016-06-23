package com.cooksys.ftd.test.kata;

import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.cooksys.ftd.kata.ILepidopterologist;
import com.cooksys.ftd.kata.model.GrowthModel;
import com.cooksys.ftd.kata.model.Sample;
import com.cooksys.ftd.kata.model.Species;

public class LepidopterologistTest {
	
	ILepidopterologist doctor;
	Set<Species> implementations;
	GrowthModel growy;
	
	@Before
	public void before () {
		Species s1 = new Species("Lil Dicky", new GrowthModel(1.2, 2), 3);
		Species s2 = new Species("Lil Dicky", new GrowthModel(1.2, 2), 3);
		Species s3 = new Species("Lil Dicky", new GrowthModel(1.2, 2), 3);
		Species s4 = new Species("Lil Dicky", new GrowthModel(1.2, 2), 3);
		
		implementations.add(s1);
		implementations.add(s2);
		implementations.add(s3);
		implementations.add(s4);
	}

	@Test
	public void testRegisterSpecies() {
		for (Species species : implementations) {
			//Assert.assertEquals(doctor.registerSpecies(implementations));
		}
	}

	@Test
	public void testIsSpeciesRegistered() {

	}

	@Test
	public void testFindSpeciesForSample() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecordSample() {
		Sample sample = null;
		if (doctor.recordSample(sample)) {
			
		}
	}

	@Test
	public void testGetSamplesForSpecies() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRegisteredSpecies() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTaxonomy() {
		fail("Not yet implemented");
	}

}
