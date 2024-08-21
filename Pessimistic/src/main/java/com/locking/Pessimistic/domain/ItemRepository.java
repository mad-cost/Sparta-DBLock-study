package com.locking.Pessimistic.domain;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {


  /* PESSIMISTIC_WRITE: 비관적 락 / 쓰기 락(Exclusive Lock)설정,
     다른 트랜잭션이 해당 데이터를 읽거나 수정하지 못하도록 합니다.*/
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("select  i from Item i where i.id =:id")
  Item findByIdWithLock(Long id);
}
