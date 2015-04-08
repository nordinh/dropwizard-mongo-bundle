package com.github.nordinh.dropwizard.mongo;

import com.commercehub.dropwizard.mongo.ManagedMongoClient;
import com.mongodb.DB;

import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MongoBundle implements ConfiguredBundle<MongoConfiguration> {

	private DB db;

	@Override
	public void run(MongoConfiguration configuration, Environment environment) throws Exception {
		ManagedMongoClient mongoClient = configuration.getMongo().build();
		environment.lifecycle().manage(mongoClient);
		db = mongoClient.getDB(configuration.getMongo().getDbName());
		environment.healthChecks().register("mongoDB", new MongoHealthCheck(db));
	}

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
		// TODO Auto-generated method stub
		
	}
	
	public DB getDb() {
		return db;
	}

}
