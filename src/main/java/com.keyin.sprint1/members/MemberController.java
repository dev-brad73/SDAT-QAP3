package com.keyin.sprint1.members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }


    // Get a list of all members
    @GetMapping(path = "api/v1/member")
    public List<Member> getMember(){
        return memberRepository.findAll();
    }

    // Find a member by email address
    @GetMapping(path = "api/v1/member/email/{memberEmail}")
    public List<Member> getMemberByEmail(@PathVariable("memberEmail") String memberEmail){
        System.out.println(memberEmail);
        return memberRepository.findByMemberEmail(memberEmail);
    }

    // Find a member by name
    @GetMapping(path = "api/v1/member/name/{memberName}")
    public List<Member> getMemberByName(@PathVariable("memberName") String memberName){
        System.out.println(memberName);
        return memberRepository.findByMemberName(memberName);
    }

    // Find a member by membership type
    @GetMapping(path = "api/v1/member/membershipType/{membershipType}")
    public List<Member> getMemberByMembershipType(@PathVariable("membershipType") String membershipType){
        System.out.println(membershipType);
        return memberRepository.findByMembershipType(membershipType);
    }

    // Find a member by phone number
    @GetMapping(path = "api/v1/member/phoneNumber/{memberPhoneNumber}")
    public List<Member> getMemberByPhoneNumber(@PathVariable("memberPhoneNumber") String memberPhoneNumber){
        System.out.println(memberPhoneNumber);
        return memberRepository.findByMemberPhoneNumber(memberPhoneNumber);
    }

    // Find a members by tournament start date
    @GetMapping(path = "api/v1/member/tournamentStartDate/{tournamentStartDate}")
    public List<Member> getMemberByTournamentStartDate(@PathVariable("tournamentStartDate") String tournamentStartDate){
        System.out.println(tournamentStartDate);
        return memberRepository.findByTournamentStartDate(tournamentStartDate);
    }

    @PostMapping(path = "api/v1/member")
    public void registerNewMember(@RequestBody Member member){
        memberService.addNewMember(member);
    }

    @DeleteMapping(path= "api/v1/member/delete/{memberId}")
    public void deleteMember(@PathVariable("memberId") Integer memberId ){
        memberService.deleteMember(memberId);
    }

    @PutMapping(path = "api/v1/member/update/{memberId}")
    public void updateMember(
            @PathVariable("memberId") Integer memberId,
            @RequestParam(required = false) String memberName,
            @RequestParam(required = false) String memberEmail,
            @RequestParam(required = false) String memberPhoneNumber,
            @RequestParam(required = false) String memberAddress) {
        memberService.updateMember(memberId, memberName, memberEmail, memberPhoneNumber, memberAddress);
    }
}
