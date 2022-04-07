//package com.keyin.sprint1;
//import com.keyin.sprint1.members.Member;
//import com.keyin.sprint1.members.MemberService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
////@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
//class Sprint1ApplicationTests {
//
//	@Mock
//	private MemberService memberService;
//
//	@Test
//	public void testFindMember() {
//		List<Member> memberList = new ArrayList<Member>();
//
//		Member memberToFind = new Member();
//		memberToFind.setMemberId(1);
//		memberToFind.setMemberName("John Doe");
//		memberToFind.setMemberAddress("123 Main Street");
//		memberToFind.setMemberEmail("jdoe@mail.com");
//		memberToFind.setMemberPhoneNumber("7095555555");
//		memberToFind.setMembershipStartDate(LocalDate.of(2022, Month.JANUARY, 1));
//		memberToFind.setMembershipDuration("2 years");
//		memberToFind.setMembershipType("Premium");
//		memberToFind.setCurrentTournaments("Pebble, Scottish");
//		memberToFind.setPastTournaments("Pebble, Scottish, British, American");
//		memberToFind.setUpcomingTournaments("European");
//
//		memberList.add(memberToFind);
//
//		Mockito.when(memberService.getMembers(1)).thenReturn(memberList);
//	}
//}
