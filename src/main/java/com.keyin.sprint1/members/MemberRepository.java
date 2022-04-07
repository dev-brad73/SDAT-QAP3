package com.keyin.sprint1.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "member", path = "member")
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findMemberByMemberEmail(String email); // Used to check if an email is already used
    List<Member> findAll();
    List<Member> findByMemberEmail(String memberEmail);
    List<Member> findByMembershipType(String membershipType);
    List<Member> findByMemberPhoneNumber(String phoneNumber);
    List<Member> findByMemberName(String memberName);
    List<Member> findByTournamentStartDate(String tournamentStartDate);
}
