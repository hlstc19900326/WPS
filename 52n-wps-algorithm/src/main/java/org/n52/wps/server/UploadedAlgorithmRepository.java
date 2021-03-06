/**
 * ﻿Copyright (C) 2007 - 2019 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.wps.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.opengis.wps.x100.ProcessDescriptionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.n52.wps.PropertyDocument.Property;
import org.n52.wps.commons.WPSConfig;

/**
 * A static repository to retrieve the available algorithms.
 * 
 * @author foerster, Bastian Schaeffer, University of Muenster
 * 
 */
public class UploadedAlgorithmRepository implements
		ITransactionalAlgorithmRepository {

	private static Logger LOGGER = LoggerFactory
			.getLogger(LocalAlgorithmRepository.class);
	private Map<String, String> algorithmMap;
	private Map<String, ProcessDescriptionType> processDescriptionMap;

	public UploadedAlgorithmRepository() {
		algorithmMap = new HashMap<String, String>();
		processDescriptionMap = new HashMap<String, ProcessDescriptionType>();

		if (WPSConfig.getInstance().isRepositoryActive(
				this.getClass().getCanonicalName())) {
			Property[] propertyArray = WPSConfig.getInstance()
					.getPropertiesForRepositoryClass(
							this.getClass().getCanonicalName());
			for (Property property : propertyArray) {
				if (property.getName().equalsIgnoreCase("Algorithm")
						&& property.getActive()) {
					addAlgorithm(property.getStringValue());
				}
			}
		} else {
			LOGGER.debug("Local Algorithm Repository is inactive.");
		}

	}

	public boolean addAlgorithms(String[] algorithms) {
		for (String algorithmClassName : algorithms) {
			addAlgorithm(algorithmClassName);
		}
		LOGGER.info("Algorithms registered!");
		return true;

	}

	public IAlgorithm getAlgorithm(String className) {
		try {
			return loadAlgorithm(algorithmMap.get(className));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Collection<IAlgorithm> getAlgorithms() {
		Collection<IAlgorithm> resultList = new ArrayList<IAlgorithm>();
		try {
			for (String algorithmClasses : algorithmMap.values()) {
				resultList
						.add(loadAlgorithm(algorithmMap.get(algorithmClasses)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return resultList;
	}

	public Collection<String> getAlgorithmNames() {
		return new ArrayList<String>(algorithmMap.keySet());
	}

	public boolean containsAlgorithm(String className) {
		return algorithmMap.containsKey(className);
	}

	private IAlgorithm loadAlgorithm(String algorithmClassName)
			throws Exception {
		IAlgorithm algorithm = (IAlgorithm) LocalAlgorithmRepository.class
				.getClassLoader().loadClass(algorithmClassName).newInstance();
		if (!algorithm.processDescriptionIsValid()) {
			LOGGER.warn("Algorithm description is not valid: "
					+ algorithmClassName);
			throw new Exception("Could not load algorithm "
					+ algorithmClassName + ". ProcessDescription Not Valid.");
		}
		return algorithm;
	}

	public boolean addAlgorithm(Object processID) {
		if (!(processID instanceof String)) {
			return false;
		}
		String algorithmClassName = (String) processID;

		algorithmMap.put(algorithmClassName, algorithmClassName);
		LOGGER.info("Algorithm class registered: " + algorithmClassName);

		return true;

	}

	public boolean removeAlgorithm(Object processID) {
		if (!(processID instanceof String)) {
			return false;
		}
		String className = (String) processID;
		if (algorithmMap.containsKey(className)) {
			algorithmMap.remove(className);
			return true;
		}
		return false;
	}

	@Override
	public ProcessDescriptionType getProcessDescription(String processID) {
		if (!processDescriptionMap.containsKey(processID)) {
			processDescriptionMap.put(processID, getAlgorithm(processID)
					.getDescription());
		}
		return processDescriptionMap.get(processID);
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

}
