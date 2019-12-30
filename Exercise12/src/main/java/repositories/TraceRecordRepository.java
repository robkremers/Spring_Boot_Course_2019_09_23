package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.TraceRecord;

/**
 * Both methods below work.
 * But the second is nicer since no annotation \@SuppressWarning is necessary.
 * 
 * @author robkr
 *
 */
public interface TraceRecordRepository extends JpaRepository<TraceRecord, Long> {
	
  @SuppressWarnings("unchecked")
  @Transactional(propagation=Propagation.REQUIRES_NEW)
  TraceRecord save(TraceRecord traceRecord);
  
  @Transactional(propagation=Propagation.REQUIRES_NEW)
  default void storeTraceRecord(TraceRecord traceRecord) {
	  this.save(traceRecord);
  }

}
