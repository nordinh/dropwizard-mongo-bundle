package com.github.nordinh.dropwizard.mongo;

import com.commercehub.dropwizard.mongo.MongoClientFactory;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface MongoConfiguration {
	
	@JsonProperty
	public MongoClientFactory getMongo();

}
