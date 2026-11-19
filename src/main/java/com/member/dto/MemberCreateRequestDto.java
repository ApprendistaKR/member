package com.member.dto;

public class MemberCreateRequestDto {

    //속성
    private final String name;
    private final int age;
    private final String mbti;

    //샐성자
    public MemberCreateRequestDto(String name, int age, String mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    //기능
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
