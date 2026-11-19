package com.member.dto;

public class MemberResponseDto {
    //속성
    private Long id;
    private String name;
    private int age;
    private String mbti;

    //생성자
    public MemberResponseDto(Long id, String name, int age, String mbti) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    //기능
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMbti() {
        return mbti;
    }
}
