package harkka.EstateManagement.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ManagementRepository extends CrudRepository<Management, Long>{
	
	List<Management> findByManagementName(String managementName);
	
}
