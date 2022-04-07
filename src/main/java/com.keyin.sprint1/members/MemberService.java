package com.keyin.sprint1.members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void addNewMember(Member member) {
        Optional<Member> memberOptional = memberRepository.findMemberByMemberEmail(member.getMemberEmail());

        if (memberOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        memberRepository.save(member);
    }

    public void deleteMember(Integer memberId) {
        boolean exists = memberRepository.existsById(memberId);
        if (!exists) {
            throw new IllegalStateException("Member with id: " + memberId + " does not exist");
        }
        memberRepository.deleteById(memberId);
    }

    @Transactional
    public void updateMember(Integer memberId,
                             String memberName,
                             String memberEmail,
                             String memberPhoneNumber,
                             String memberAddress) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException(
                "Member with Id: " + memberId + " does not exist"));

        if (memberName != null && memberName.length() > 0 && !Objects.equals(member.getMemberName(), memberName)) {
            member.setMemberName(memberName);
        }

        if (memberEmail != null
                && memberEmail.length() > 0
                && !Objects.equals(member.getMemberEmail(), memberEmail)) {
            Optional<Member> memberOptional = memberRepository.findMemberByMemberEmail(memberEmail);
            if (memberOptional.isPresent()){
                throw new IllegalStateException("Email is already taken");
            }
            member.setMemberEmail(memberEmail);
        }

        if (memberPhoneNumber != null && memberPhoneNumber.length() > 0 && !Objects.equals(member.getMemberPhoneNumber(), memberPhoneNumber)) {
            member.setMemberPhoneNumber(memberPhoneNumber);
        }

        if (memberAddress != null && memberAddress.length() > 0 && !Objects.equals(member.getMemberAddress(), memberAddress)) {
            member.setMemberAddress(memberAddress);
        }
    }
}