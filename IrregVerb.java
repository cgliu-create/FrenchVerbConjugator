import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IrregVerb {

    public boolean checkIfIrreg(String verb) {
        try {
            Scanner file = new Scanner(new File("Irregular.txt"));
            while(file.hasNextLine()){
                String ln = file.nextLine();
                if(ln.equalsIgnoreCase(verb)){
                    file.close();
                    return true;
                } // fixed 
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public String conjIrregPresentForm(String verb, String form){
        try {
            Scanner file = new Scanner(new File("Irregular.txt"));
            String ln = file.nextLine();
            while(!(ln.equalsIgnoreCase(verb))){
                ln = file.nextLine();
            }
            ln = file.nextLine();
            ln = file.nextLine();
            if(ln.equalsIgnoreCase("R")){
                VerbConjugator R = new VerbConjugator();
                file.close();
                return R.conjPresentForm(verb, form);
            }
            String jef = ln.substring(ln.indexOf('1')+1, ln.indexOf('2'));
            String tuf = ln.substring(ln.indexOf('2')+1, ln.indexOf('3'));
            String ilelleonf = ln.substring(ln.indexOf('3')+1, ln.indexOf('4'));
            String nousf = ln.substring(ln.indexOf('4')+1, ln.indexOf('5'));
            String vousf = ln.substring(ln.indexOf('5')+1, ln.indexOf('6'));
            String ilsellesf = ln.substring(ln.indexOf('6')+1);
            // add forms
            Verb je = new Verb("Je", jef);
            Verb tu = new Verb("Tu", tuf);
            Verb ilelleon = new Verb("Il/Elle/On", ilelleonf);
            Verb nous = new Verb("Nous", nousf);
            Verb vous = new Verb("Vous", vousf);
            Verb ilselles = new Verb("Ils/Elles", ilsellesf);
            file.close();
            // return requested form
            if (form.equalsIgnoreCase("Je")) {
                return je.toString();
            }
            if (form.equalsIgnoreCase("Tu")) {
                return tu.toString();
            }
            if (form.equalsIgnoreCase("Il") || form.equalsIgnoreCase("Elle") || form.equalsIgnoreCase("On")) {
                return ilelleon.toString();
            }
            if (form.equalsIgnoreCase("Nous")) {
                return nous.toString();
            }
            if (form.equalsIgnoreCase("Vous")) {
                return vous.toString();
            }
            if (form.equalsIgnoreCase("Ils") || form.equalsIgnoreCase("Elles")) {
                return ilselles.toString();
            }
            // return list
            VerbList verbs = new VerbList();
            verbs.add(je);
            verbs.add(tu);
            verbs.add(ilelleon);
            verbs.add(nous);
            verbs.add(vous);
            verbs.add(ilselles);
            return verbs.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    public String conjIrregAvoirorEtre(String verb){
        try {
            Scanner file = new Scanner(new File("Irregular.txt"));
            String ln = file.nextLine();
            while(!(ln.equalsIgnoreCase(verb))){
                ln = file.nextLine();
            }
            ln = file.nextLine();
            file.close();
            return ln;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkStemIrregConditionnelFutur(String verb){
        try {
            Scanner file = new Scanner(new File("Irregular.txt"));
            String ln = file.nextLine();
            while(!(ln.equalsIgnoreCase(verb))){
                ln = file.nextLine();
            }
            ln = file.nextLine();
            ln = file.nextLine();
            ln = file.nextLine();
            if(ln.equalsIgnoreCase("R")){
                file.close();
                return verb;
            }
            file.close();
            return ln;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String conjIrregSubjonctifForm(String verb){
        try {
            Scanner file = new Scanner(new File("Irregular.txt"));
            String lnx;
            String ln = file.nextLine();
            while(!(ln.equalsIgnoreCase(verb))){
                ln = file.nextLine();
            }
            ln = file.nextLine();
            ln = file.nextLine();
            ln = file.nextLine();
            ln = file.nextLine();
            lnx = file.nextLine();
            file.close();
            return ln + lnx;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
 }