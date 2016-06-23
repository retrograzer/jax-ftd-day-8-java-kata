package com.cooksys.ftd.kata.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import com.cooksys.ftd.kata.ILepidopterologist;
import com.cooksys.ftd.kata.model.Sample;
import com.cooksys.ftd.kata.model.Species;

public class Lepidopterologist implements ILepidopterologist {
	
	private Set<Species> allSpecies = new HashSet<Species>();
	private Map<Species, List<Sample>> mapper = new TreeMap<Species, List<Sample>>();
	
	@Override
	public boolean registerSpecies(Species species) {
		if (isSpeciesRegistered(species) != true) {
			allSpecies.add(species);
			return true;
		}
		return false;
	}

	@Override
	public boolean isSpeciesRegistered(Species species) {
		if (allSpecies.contains(species)) {
			return true;
		}
		return false;
	}

	@Override
	public Optional<Species> findSpeciesForSample(Sample sample) {	
		for (Species s : allSpecies) {
			if (s.isMember(sample.getGrowthModel()) == true) {
				return Optional.of(s);
			} else {
				return Optional.empty();
			}
		}
		return Optional.empty();
	}

	@Override
	public boolean recordSample(Sample sample) {
		Optional<Species> opt = findSpeciesForSample(sample);
		List<Sample> sampleList;
		Species s;
		
		if (opt.isPresent()) {
			s = opt.get();
			if (!mapper.containsKey(s)) {
				sampleList = new ArrayList<Sample>();
				sampleList.add(sample);
				mapper.put(s, sampleList);
			}
			else {
				sampleList = mapper.get(s);
				sampleList.add(sample);
				mapper.put(s, sampleList);
			}			
			return true;
		}		
		
		return false;
	}

	@Override
	public List<Sample> getSamplesForSpecies(Species species) {
		return mapper.get(species);
	}

	@Override
	public List<Species> getRegisteredSpecies() {
		return new ArrayList<Species>(allSpecies);
	}

	@Override
	public Map<Species, List<Sample>> getTaxonomy() {
		List<Sample> sampleList;
		for (Species s : allSpecies) {
			 sampleList = mapper.get(s);
			 Collections.sort(sampleList);
		}
		return mapper;
	}

}