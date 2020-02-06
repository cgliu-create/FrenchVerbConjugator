import java.util.ArrayList;

public class VerbList {
    private ArrayList<Verb> myVerbs;

public VerbList(){
    this.myVerbs = new ArrayList<Verb>();
 }
public void add(Verb m){
    this.myVerbs.add(m);
 }
public String toString(){
    String stuff = "";
    for (int i = 0; i < myVerbs.size(); i++){
        if (i == 0)
        stuff = stuff + myVerbs.get(0).toString();
        else{
        stuff = stuff + ", " + myVerbs.get(i).toString();
        }
    }
    return stuff;
}
}