package com.member.service;

import com.member.dto.MemberCreateRequestDto;
import com.member.dto.MemberResponseDto;
import com.member.entity.Member;
import com.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {
    //속성
    private final MemberRepository memberRepository;

    //생성자
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //기능
    //회원 생성
    @Transactional
    public MemberResponseDto createMember(MemberCreateRequestDto requestDto) {
          // 1. 데이터 준비
        String memberName = requestDto.getName();
        int memberAge = requestDto.getAge();
        String memberMbti = requestDto.getMbti();

        // 2. 엔티티 저장
        Member member = new Member(memberName, memberAge, memberMbti);
        Member savedMember = memberRepository.save(member);

        // 3. dto 데이터 준비
        Long savedId = savedMember.getId();
        String savedName = savedMember.getName();
        int savedAge = savedMember.getAge();
        String savedMbti = savedMember.getMbti();


        // 4. dto 생성
        MemberResponseDto response = new MemberResponseDto(savedId, savedName, savedAge, savedMbti);

        // 5. 반환
        return response;
    }
    // 회원 조회
    public MemberResponseDto getMember(Long id) {
        // 1. 데이터 준비
        Long memberId = id;

        // 2. 엔티티 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀원입니다. id=" + memberId));

        // 3. dto 준비
        Long foundId = member.getId();
        String foundName = member.getName();
        int foundAge = member.getAge();
        String foundMbti = member.getMbti();

        // 4. dto 생성
        MemberResponseDto response = new MemberResponseDto(foundId, foundName, foundAge, foundMbti);

        // 5.반환
        return response;
    }
}
