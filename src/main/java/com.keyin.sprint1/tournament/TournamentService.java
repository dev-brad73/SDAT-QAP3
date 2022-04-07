package com.keyin.sprint1.tournament;
import com.keyin.sprint1.members.Member;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {

    public List<Tournament> getTournament(Integer id) {
        List<Tournament> tournamentList = new ArrayList<Tournament>();

        tournamentList.add(new Tournament(
                1,
                LocalDate.of(2022, Month.JANUARY, 01),
                LocalDate.of(2022, Month.JANUARY, 04),
                "Scotland",
                200.00,
                1000.00
        ));

        tournamentList.add(new Tournament(
                2,
                LocalDate.of(2022, Month.JANUARY, 15),
                LocalDate.of(2022, Month.JANUARY, 20),
                "Pebble",
                100.00,
                500.00
        ));

        tournamentList.add(new Tournament(
                3,
                LocalDate.of(2022, Month.MARCH, 01),
                LocalDate.of(2022, Month.MARCH, 04),
                "European",
                300.00,
                1500.00
        ));

        for (Tournament tournament : tournamentList ) {
            if (tournament.getTournamentId() == id) {
                return List.of(tournament);
            }
        }
        return null;
    }
}