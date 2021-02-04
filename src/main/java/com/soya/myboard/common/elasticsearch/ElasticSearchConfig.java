/*
package com.soya.myboard.common.elasticsearch;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


*/
/**
 * 1. 프로젝트명 : icf
 * 2. 패키지명   : com.fourfree.common.elasticsearch
 * 3. 작성일     : 2020. 11. 23. 오후 4:36
 * 4. 작성자     : 고병만
 * 5. 이메일     : scormrte@gmail.com
 * 6  연락처     : 010-8299-5258
 *//*


@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.fourfree.elasticsearch"})
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private String port;

    @Value("${elasticsearch.cluster_name}")
    private String clusterName;

    @Value("${elasticsearch.user_name}")
    private String userName;

    @Value("${elasticsearch.user_password}")
    private String userPassword;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(host+":" + port)
                .withBasicAuth(userName,userPassword)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
    
    @Bean
    public ElasticsearchOperations elasticsearchOperations(){
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }

}
*/
