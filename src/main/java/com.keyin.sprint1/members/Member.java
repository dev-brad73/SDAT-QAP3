package com.keyin.sprint1.members;

import com.keyin.sprint1.tournament.Tournament;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Member {

    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "member_sequence"
    )
    private Integer memberId;

    private String memberName;
    private String memberAddress;
    private String memberEmail;
    private String memberPhoneNumber;
    private LocalDate membershipStartDate;

    @Transient
    private String membershipDuration;

    private String membershipType;
    private String tournamentStartDate;

    @OneToMany
    private List<Tournament> tournaments;

    public Member() {
    }

    public Member(Integer id,
                  String memberName,
                  String memberAddress,
                  String memberEmail,
                  String memberPhoneNumber,
                  LocalDate membershipStartDate,
                  String membershipType,
                  String tournamentStartDate,
                  List<Tournament> tournaments)
    {
        this.memberId = id;
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberPhoneNumber = memberPhoneNumber;
        this.membershipStartDate = membershipStartDate;
        this.membershipType = membershipType;
        this.tournamentStartDate = tournamentStartDate;
        this.tournaments = tournaments;
    }

    public Member(String memberName,
                  String memberAddress,
                  String memberEmail,
                  String memberPhoneNumber,
                  LocalDate membershipStartDate,
                  String membershipType,
                  String tournamentStartDate,
                  List<Tournament> tournaments) {
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberPhoneNumber = memberPhoneNumber;
        this.membershipStartDate = membershipStartDate;
        this.membershipType = membershipType;
        this.tournamentStartDate = tournamentStartDate;
        this.tournaments = tournaments;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }


    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }


    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }


    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }


    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }


    public String getMembershipDuration() {
        Period duration = Period.between(this.membershipStartDate,LocalDate.now());
        return duration.getYears() + " years, " + duration.getMonths() + " months, " + duration.getDays() + " days";
    }

    public void setMembershipDuration(String membershipDuration) {this.membershipDuration = membershipDuration;}


    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getTournamentStartDate() {
        return tournamentStartDate;
    }

    public void setTournamentStartDate(String tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public String toString() {
        return ("Member{" + "Member Id=" + memberId +
                ", Member Name='" + memberName + '\'' +
                ", Member Address='" + memberAddress + '\'' +
                ", Member Email='" + memberEmail + '\'' +
                ", Member Phone Number='" + memberPhoneNumber + '\'' +
                ", Membership Start Date='" + membershipStartDate + '\'' +
                ", Membership Duration='" + membershipDuration + '\'' +
                ", Membership Type='" + membershipType + '\'' +
                ", Tournament Start Date='" + tournamentStartDate + '\'' +
                ", Tournaments='" + tournaments + '\'' +
                '}');
    }
}
