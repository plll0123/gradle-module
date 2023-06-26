package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void add() {
        Member newMember = new Member("동탄", "um@123.123");
        Assertions.assertNull(newMember.getId());
        memberRepository.save(newMember);
        Assertions.assertNotNull(newMember.getId());
    }
}