package jp.co.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Modelentity,Long> {

}
