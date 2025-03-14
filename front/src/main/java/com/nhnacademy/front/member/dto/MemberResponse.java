package com.nhnacademy.front.member.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@JacksonXmlRootElement(localName = "member")
public class MemberResponse {


    public MemberResponse(Long mbNo, String mbEmail, String mbName, String mbMobile, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime withdrawalAt) {
        this.mbNo = mbNo;
        this.mbEmail = mbEmail;
        this.mbName = mbName;
        this.mbMobile = mbMobile;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.withdrawalAt = withdrawalAt;
    }

    public MemberResponse() {
    }

    //회원_번호
    @JsonProperty("no")
    Long mbNo;

    //회원_이메일
    @JsonProperty("email")
    String mbEmail;

    //회원_이름
    @JsonProperty("name")
    String mbName;

    //모바일 연락처
    @JsonProperty("mobile")
    String mbMobile;

    //가입일자
    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt;

    //수정일자
    @JsonIgnore
    @JsonProperty("updatedAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatedAt;

    /// 탈퇴일자
    @JsonProperty("withdrawalAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime withdrawalAt;

    public Long getMbNo() {
        return mbNo;
    }

    public String getMbEmail() {
        return mbEmail;
    }

    public String getMbName() {
        return mbName;
    }

    public String getMbMobile() {
        return mbMobile;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getWithdrawalAt() {
        return withdrawalAt;
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "mbNo=" + mbNo +
                ", mbEmail='" + mbEmail + '\'' +
                ", mbName='" + mbName + '\'' +
                ", mbMobile='" + mbMobile + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", withdrawalAt=" + withdrawalAt +
                '}';
    }
}