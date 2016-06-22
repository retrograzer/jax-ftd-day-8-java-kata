package com.cooksys.ftd.kata.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cooksys.ftd.kata.ILepidopterologist;
import com.cooksys.ftd.kata.model.Sample;
import com.cooksys.ftd.kata.model.Species;

public class Lepidopterologist implements ILepidopterologist {
	
	List<Species> registered = new ArrayList();
	List<Sample> collect = new ArrayList();

	@Override
	public boolean registerSpecies(Species species) {
		if (isSpeciesRegistered(species) != true) {
			registered.add(species);
		} else {
			return true;
		}
		return true;
	}

	@Override
	public boolean isSpeciesRegistered(Species species) {
		return registered.contains(species);
	}

	@Override
	public Optional<Species> findSpeciesForSample(Sample sample) {
		return null;
	}

	@Override
	public boolean recordSample(Sample sample) {
		if (registered.equals(sample)){
			collect.add(sample);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Sample> getSamplesForSpecies(Species species) {
		if (collect.equals(species)) {
			return collect;
		}
		return collect;
	}

	@Override
	public List<Species> getRegisteredSpecies() {
		return registered;
	}

	@Override
	public Map<Species, List<Sample>> getTaxonomy() {
		Map<Species, List<Sample>> output = new HashSet();
		for (Species s : output) {
			
		}
		return null;
	}

}
