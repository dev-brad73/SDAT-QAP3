package com.keyin.sprint1.tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @RequestMapping(path = "api/v1/tournament/{id}")
    public List<Tournament> getTournament(@PathVariable int id){

        return tournamentService.getTournament(id);
    }
}
