package mk.ukim.finki.emt_lab.repository;

import mk.ukim.finki.emt_lab.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host,Long> {
}
