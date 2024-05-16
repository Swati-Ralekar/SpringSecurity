package nz.co.stylesoftware.SpringSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import nz.co.stylesoftware.SpringSecurity.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{

	public Users getByUserId(Integer userId);
}
