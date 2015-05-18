package com.emc.data.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.integration.annotation.Splitter;

public class CarriageReturnSplitter {

	@Splitter
	public List<String> linesSplitter(String payload) {
		return Arrays.asList(payload.split("\\n"));
	}

}
