public class Verb{
    private String subjectpronoun;
    private String verbform;

    public Verb(String subject, String verb){
        this.subjectpronoun = subject;
        this.verbform = verb;
    }
    public String toString(){
		return this.subjectpronoun + " " + this.verbform;
    }
}


