package org.example.tp2.Repositories;


import org.example.tp2.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 If you have the dependency:

 *<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
 *</dependency>


 *then Spring Data REST automatically exposes all your JpaRepository beans as REST resources, even without @RepositoryRestResource.

 *@RepositoryRestResource is optional — it just customizes the path or disables exposure.
 * By default, Spring Data REST will expose the repository at a path derived from the entity name.
 * For example, if your entity is named Account, the default path would be /accounts.
 * You can customize the path by using the @RepositoryRestResource annotation and specifying a different path.
 * <p>
 * Example:
 * @RepositoryRestResource(path = "my-accounts")
 * public interface accountRepo extends JpaRepository<Account, String> {
 *     // repository methods
 * }
 * <p>
 * This would expose the repository at /my-accounts instead of /accounts.
 * <p>
 * If you want to prevent Spring Data REST from exposing a particular repository,
 * you can set exported = false in the @RepositoryRestResource annotation.
 * <p>
 * Example:
 * @RepositoryRestResource(exported = false)
 * public interface accountRepo extends JpaRepository<Account, String> {
 *     // repository methods
 * }
 *
 * This would prevent the repository from being exposed as a REST resource.
 */

@RepositoryRestResource(path = "accounts")
@Repository
public interface accountRepo extends JpaRepository<Account,String> {
    @RestResource(path = "by-currency")
    List<Account> findByCurrency(@Param("curr") String currency);
}
