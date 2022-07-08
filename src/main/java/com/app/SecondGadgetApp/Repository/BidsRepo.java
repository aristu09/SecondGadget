package com.app.SecondGadgetApp.Repository;

import com.app.SecondGadgetApp.Entity.Bids;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidsRepo extends JpaRepository<Bids, Long>
{
    Bids findByBidId(Long bidId);
}
