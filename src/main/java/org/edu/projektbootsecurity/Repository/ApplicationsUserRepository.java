package org.edu.projektbootsecurity.Repository;

import org.edu.projektbootsecurity.Model.ApplicationsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //markerar att interfacet är en repository komponent
public interface ApplicationsUserRepository extends JpaRepository<ApplicationsUser, Long> {
//jpa är till för att komma åt crud metoderna för att inte behöva skriva sql frågor själv
    public ApplicationsUser findByUsername(String username);

}
