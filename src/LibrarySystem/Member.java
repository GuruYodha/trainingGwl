package LibrarySystem;

public class Member {

    private int memberId;
    private String memberName;
    private String memberAddress;

    public Member(int memberId, String memberName, String memberAddress) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberAddress = memberAddress;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    @Override
    public String toString() {
        return "Member [ID=" + memberId +
               ", Name=" + memberName +
               ", Address=" + memberAddress + "]";
    }
}