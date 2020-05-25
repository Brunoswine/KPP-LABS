package LABA3;

abstract class AbstractStudent {
    public String name;
    public String surname;

    public AbstractStudent(){;}
    public AbstractStudent(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public abstract String getName();

    public abstract String getSurname();

    public abstract void setName(String name);

    public abstract void setSurname(String surname);

    public abstract String retThanks();

    public abstract void setMarks(String mark);
    public abstract String getMarks();
}
