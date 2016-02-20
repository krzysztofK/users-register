package org.krzysztof.users.register.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class DBConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "users-register";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }
}