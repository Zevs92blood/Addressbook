package ru.stqa.pft.addressbook.tech;

public class UData {


    private final String fName;
    private final String lName;
    private int id;
    public UData (String fName, String lName, int id){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }
    public UData (String fName, String lName){
        this.id = Integer.MAX_VALUE;
        this.fName = fName;
        this.lName = lName;
    }
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UData{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UData uData = (UData) o;

        if (fName != null ? !fName.equals(uData.fName) : uData.fName != null) return false;
        return lName != null ? lName.equals(uData.lName) : uData.lName == null;
    }

    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        return result;
    }
}
