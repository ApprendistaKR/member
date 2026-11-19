package com.member.controller;

import com.member.dto.MemberCreateRequestDto;
import com.member.dto.MemberResponseDto;
import com.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    // 속성
    private final MemberService memberService;

    // 생성자
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 기능
    // 멤버 저장 API
    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberCreateRequestDto request) {
        // 1. 서비스 처리
        MemberResponseDto createResponse = memberService.createMember(request);

        // 2. 응답 생성
        ResponseEntity<MemberResponseDto> response = new ResponseEntity<>(createResponse, HttpStatus.CREATED);

        // 3. 반환
        return response;
    }
    // 멤버 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long id) {
        // 1. 서비스 처리
        MemberResponseDto findResponse = memberService.getMember(id);

        // 2. 응답 생성
        ResponseEntity<MemberResponseDto> response = new ResponseEntity<>(findResponse, HttpStatus.OK);

        // 3. 반환
        return response;
    }
}

