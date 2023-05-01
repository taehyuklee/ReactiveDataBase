package com.reativeDB.MultiDataBase.scores;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScoreRepository extends PagingAndSortingRepository<Scores,String>{
    //auto-config를 배제하지 않으면, JPA에서 제공해주는 모든 repository들에 맞는 datasource 또는 mongoconfig가져온다.
}
