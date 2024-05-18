package lt.viko.eif.rdelinda.library.tests;

import lt.viko.eif.rdelinda.library.model.Member;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void testMemberCreation() {
        Member member = new Member("1", "John Doe");
        assertEquals("1", member.getMemberId());
        assertEquals("John Doe", member.getName());
    }

    @Test
    void testSetters() {
        Member member = new Member("1", "John Doe");
        member.setName("Jane Doe");
        member.setMemberId("2");
        assertEquals("Jane Doe", member.getName());
        assertEquals("2", member.getMemberId());
    }
}
