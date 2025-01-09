import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    List<Season> findByStartDateAfter(java.time.LocalDate startDate);

    List<Season> findByEndDateBefore(java.time.LocalDate endDate);

    List<Season> findByNameIgnoreCase(String name);

    List<Season> findByStartDateBeforeAndEndDateAfter(java.time.LocalDate currentDate1, java.time.LocalDate currentDate2);
}
