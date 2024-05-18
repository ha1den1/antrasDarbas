package lt.viko.eif.rdelinda.library.model;

/**
 * Represents a member of the library.
 */
public class Member {
    private String memberId;
    private String name;

    /**
     * Constructs a new Member with the specified member ID and name.
     *
     * @param memberId the ID of the member
     * @param name     the name of the member
     */
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
