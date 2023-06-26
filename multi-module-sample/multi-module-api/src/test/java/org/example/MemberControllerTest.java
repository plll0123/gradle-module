package org.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberControllerTest {

    @Autowired
    private MemberService memberService;

    @Test
    void assertNotNull() {
        Member member = new Member("준식", "kakao@kakao");
        Long membersId = memberService.signUp(member);
        assertThat(membersId).isEqualTo(1L);
    }

}
