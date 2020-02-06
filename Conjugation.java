public interface Conjugation{
    // present
        public String conjPresentForm(String verb, String form);
    // past
        public String conjImparfaitForm(String verb, String form);
        public String conjPasseCompose(String verb, String form);
        public String conjPlusQueParfaitForm(String verb, String form);
    // conditional
        public String conjConditionnelForm(String verb, String form, boolean past);
    // future
        public String conjFuturSimpleForm(String verb, String form);
        public String conjFuturAnterieurForm(String verb, String form);
        public String conjFuturProcheForm(String verb, String form);
    // commands
        public String conjImperatifForm(String verb, String form);
    // opinions/uncertainty
        public String conjSubjonctifForm(String verb, String form, boolean past);
    }
    // take off ending / take off ending and determine verb type
    // add appropriate ending
    // return list / return requested form
    //ok