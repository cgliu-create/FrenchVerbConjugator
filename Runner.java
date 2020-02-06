import java.util.Scanner;

public class Runner {
 //test
 public static void main(String[] args){
    String go = "yes";
    Scanner kb = new Scanner(System.in);
    do{
        System.out.println("Enter infinitive of verb::");
        String theVerb = kb.nextLine();
        System.out.println("For specific verb forms, there is Present, Imparfait, PasseCompose, Conditional, and Futur.");
        System.out.println("there is also PlusQueParfait, FuturAnterieur, FuturProche, Imperatif, and Subjonctif");
        System.out.println("For specific suject forms, there is Je, Tu, Il/Elle/On, Nous, Vous. Ils/Elles");
        System.out.println("Enter the verb form::");
        String theForm = kb.nextLine();
        System.out.println("Enter the verb specific subject form or All::");
        String theSubject = kb.nextLine();
        VerbConjugator conj = new VerbConjugator();
        if(theForm.equalsIgnoreCase("Present")){
            System.out.println(conj.conjPresentForm(theVerb, theSubject));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("Imparfait")){
            System.out.println(conj.conjImparfaitForm(theVerb, theSubject));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("PasseCompose")){
            System.out.println(conj.conjPasseCompose(theVerb, theForm));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
            // need to add helping verb
        }
        else if(theForm.equalsIgnoreCase("Conditional")){
            System.out.println(conj.conjConditionnelForm(theVerb, theSubject, false));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("Futur")){
            System.out.println(conj.conjFuturSimpleForm(theVerb, theSubject));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("FuturProche")){
            System.out.println(conj.conjFuturProcheForm(theVerb, theSubject));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("PlusQueParfait")){
            System.out.println(conj.conjPlusQueParfaitForm(theVerb, theSubject));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("FuturAnterieur")){
            System.out.println(conj.conjFuturAnterieurForm(theVerb, theSubject));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("Subjonctif")){
            System.out.println(conj.conjSubjonctifForm(theVerb, theSubject, false));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("Imperatif")){
            System.out.println(conj.conjImperatifForm(theVerb, theSubject));
            System.out.println("Continue? y/n");
            go = kb.nextLine();
        }
        else if(theForm.equalsIgnoreCase("All")){
            System.out.println("Present");
            System.out.println(conj.conjPresentForm(theVerb, theSubject));
            System.out.println("Imparfait");
            System.out.println(conj.conjImparfaitForm(theVerb, theSubject));
            System.out.println("PasseCompose");
            System.out.println(conj.conjPasseCompose(theVerb, theForm));
            System.out.println("Conditional");
            System.out.println(conj.conjConditionnelForm(theVerb, theSubject, false));
            System.out.println("Futur");
            System.out.println(conj.conjFuturSimpleForm(theVerb, theSubject));
            System.out.println("FuturProche");
            System.out.println(conj.conjFuturProcheForm(theVerb, theSubject));
            System.out.println("PlusQueParfait");
            System.out.println(conj.conjPlusQueParfaitForm(theVerb, theSubject));
            System.out.println("FuturAnterieur");
            System.out.println(conj.conjFuturAnterieurForm(theVerb, theSubject));
            System.out.println("Subjonctif");
            System.out.println(conj.conjSubjonctifForm(theVerb, theSubject, false));
            System.out.println("Imperatif");
            System.out.println(conj.conjImperatifForm(theVerb, theSubject));
        }
        else{
            System.out.println("This is an invalid form");
        }
    
    }while(go.equalsIgnoreCase("yes") || go.equalsIgnoreCase("y"));
    kb.close();
}
}