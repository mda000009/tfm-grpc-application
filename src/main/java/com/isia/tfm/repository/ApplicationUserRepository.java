package com.isia.tfm.repository;

import com.isia.tfm.entity.ApplicationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Application user repository.
 */
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUserEntity, String> {

    /**
     * Finds a list of ApplicationUserEntity by gender.
     *
     * @param gender the gender to filter by
     * @return {@link List<ApplicationUserEntity>} a list of ApplicationUserEntity with the specified gender
     */
    List<ApplicationUserEntity> findByGender(String gender);

}
