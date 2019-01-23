package com.swp.elasticsearch.service;

import com.swp.elasticsearch.model.ArticleEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-22 2:26 PM
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<ArticleEntity, Long> {

}
