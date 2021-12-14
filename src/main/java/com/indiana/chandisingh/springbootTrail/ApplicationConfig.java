package com.indiana.chandisingh.springbootTrail;

//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.google.gson.Gson;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import javax.sql.DataSource;
//import java.util.Base64;

@Configuration
public class ApplicationConfig {


    private Gson gson =new Gson();

    /*

    @Bean
    public DataSource dataSource(){
        AwsSecrets secrets=getSecret();
        return DataSourceBuilder
                .create()
                //.driverClassName("")
                .url("jdbc:"+ secrets.getEngine() +"://"+ secrets.getHost() + ":" +secrets.getPort()+"/cocktails")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }

     */

    private AwsSecrets getSecret() {

        String secretName = "arn:aws:secretsmanager:us-east-2:593831182595:secret:DB-oadAey";
        String region = "us-east-2";

        // Create a Secrets Manager client
        AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
                .withRegion(region)
                //.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("","")))
                .build();

        // In this sample we only handle the specific exceptions for the 'GetSecretValue' API.
        // See https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
        // We rethrow the exception by default.

        String secret, decodedBinarySecret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = null;

        try {
            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            throw e;
        }

        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
            return gson.fromJson(secret,AwsSecrets.class);
        }
        return null;
        /*
        else {
            decodedBinarySecret = new String(Base64.getDecoder().decode(getSecretValueResult.getSecretBinary()).array());
        }
         */

        // Your code goes here.

    }

}

