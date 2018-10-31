package projeto.vendas.model.validacoes;

import static java.lang.Integer.parseInt;


public class ValidaCPF {
    public static boolean validaCpf(String cpf) {
        int  Teste = 0;
        double  Mult = 0;
        int Aux = 1;
        int c = 0;
        
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");
        cpf = cpf.replace(" ","");
        
        if (cpf.length() < 11 || cpf == null) {//testa o tamanho
            return false;
        }
        if (cpf.length() == 11){ //testa se sao iguais
            for(c=0;c<10;c++){
                if (cpf.charAt(c) == cpf.charAt(c + 1)){
                    Teste = Teste + 1;
                }
            }
        }
        if (Teste == c) { //se todas as letras forem iguais
                return false;
        }
        else {  //se caso os testes forem falsos de tamanho e igualdade entao..
           // System.out.println(cpf);
            for(c=0;c<9;c++) {
                    //System.out.println("Mult " + Mult + "numero "+ Character.getNumericValue(cpf.charAt(c)) + "Aux " + Aux);
                    Mult = Mult + Character.getNumericValue(cpf.charAt(c)) * Aux;
                    Aux = Aux + 1;
            }
            Mult = Mult % 11;
           // System.out.println(Mult);
            if (Mult == 10) {
                    Mult = 0;
            }
           // System.out.println(Mult + " " + Character.getNumericValue(cpf.charAt(9)));
            if (Mult != Character.getNumericValue(cpf.charAt(9))) {
                    return false;
            }
            if (Mult == Character.getNumericValue(cpf.charAt(9))) {  //teste 2° digito
                    Mult = 0;
                    Aux = 11;
                    for(c=0;c<10;c++) {
                      //  System.out.println("Mult " + Mult + "numero "+ Character.getNumericValue(cpf.charAt(c)) + "Aux " + Aux);
                        Mult = Mult + Character.getNumericValue(cpf.charAt(c)) * Aux;
                        Aux = Aux - 1;
                    }
                    Mult = (Mult * 10) % 11;
                 //   System.out.println(Mult);
                    if (Mult == 10) {
                        Mult = 0;
                    }
                    if (Mult != Character.getNumericValue(cpf.charAt(10))) {
                        return false;
                    }
            }
        return true;
        }  
    }
   

  
}