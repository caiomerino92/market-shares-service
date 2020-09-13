package com.market.shares.repository;

import com.market.shares.model.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IShareRepository extends JpaRepository<Share, Long> {

    @Query("SELECT s\n" +
            "FROM Share s\n" +
            "WHERE s.ticketAcronym = :ticketAcronym")
    Share findByTicketAcronym(String ticketAcronym);
}
