package com.example.techiteasybijles.repositories;

import com.example.techiteasybijles.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TelevisionRepository extends JpaRepository <Television, Long> {

 List<Television> findByBrand (String brand);


//    @Query(value = "SELECT u FROM User u ORDER BY id")
//    Page<User> findAllUsersWithPagination(Pageable pageable);
}
