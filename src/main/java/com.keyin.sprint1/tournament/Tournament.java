package com.keyin.sprint1.tournament;
import com.keyin.sprint1.members.Member;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Tournament {

    @Id
    @SequenceGenerator(
            name = "tournament_sequence",
            sequenceName = "tournament_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tournament_sequence"
    )
    private Integer tournamentId;

    private LocalDate tournamentStartDate;
    private LocalDate tournamentEndDate;
    private String tournamentLocation;
    private Double tournamentEntryFee;
    private Double cashPrizeAmount;

//    private List<Member> participatingMembers;

    public Tournament() {
    }

    public Tournament(Integer tournamentId,
                      LocalDate tournamentStartDate,
                      LocalDate tournamentEndDate,
                      String tournamentLocation,
                      Double tournamentEntryFee,
                      Double cashPrizeAmount
    ) {
        this.tournamentId = tournamentId;
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentEndDate = tournamentEndDate;
        this.tournamentLocation = tournamentLocation;
        this.tournamentEntryFee = tournamentEntryFee;
        this.cashPrizeAmount = cashPrizeAmount;
    }

    public Tournament(LocalDate tournamentStartDate,
                      LocalDate tournamentEndDate,
                      String tournamentLocation,
                      Double tournamentEntryFee,
                      Double cashPrizeAmount
    ) {
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentEndDate = tournamentEndDate;
        this.tournamentLocation = tournamentLocation;
        this.tournamentEntryFee = tournamentEntryFee;
        this.cashPrizeAmount = cashPrizeAmount;
    }

    public int getTournamentId() {
        return tournamentId;
    }
    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public LocalDate getTournamentStartDate() {
        return tournamentStartDate;
    }
    public void setTournamentStartDate(LocalDate tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    public LocalDate getTournamentEndDate() {
        return tournamentEndDate;
    }
    public void setTournamentEndDate(LocalDate tournamentEndDate) {
        this.tournamentEndDate = tournamentEndDate;
    }

    public String getTournamentLocation() {
        return tournamentLocation;
    }
    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public double getTournamentEntryFee() {
        return tournamentEntryFee;
    }
    public void setTournamentEntryFee(double tournamentEntryFee) {
        this.tournamentEntryFee = tournamentEntryFee;
    }

    public double getCashPrizeAmount() {
        return cashPrizeAmount;
    }
    public void setCashPrizeAmount(double cashPrizeAmount) {
        this.cashPrizeAmount = cashPrizeAmount;
    }

//    public List<Member> getParticipatingMembers() {
//        return participatingMembers;
//    }
//    public void setParticipatingMembers(List<Member> participatingMembers) {
//        this.participatingMembers = participatingMembers;
//    }

    @Override
    public String toString() {
        return "Tournament{" +
                "Tournament Id=" + tournamentId +
                ", Tournament Start Date='" + tournamentStartDate + '\'' +
                ", Tournament End Date='" + tournamentEndDate + '\'' +
                ", Tournament Location='" + tournamentLocation + '\'' +
                ", Tournament Entry Fee=" + "$" + tournamentEntryFee +
                ", Cash Prize Amount=" + "$" + cashPrizeAmount +
                '}';
    }
}

