/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.construcao.calendario;

/**
 *
 * @author alunoinf
 */
public class Calendario {

    static boolean anoBisexConhecido, anoBisexDesconhecido;
    static int anoBisexto;

    public static int diaDaSemana(int dataDesconhecida, int anoBisexto,
            int dataConhecida, int diaDaSemana) throws Exception {

        int diaDesconhecido;
        int diaConhecido;
        int mesDesconhecido;
        int mesConhecido;
        int anoDesconhecido;
        int anoConhecido;
        int aux;
        

        //pegando o ano, mes e o dia desconhecidos
        anoDesconhecido = dataDesconhecida / 10000;
        aux = dataDesconhecida % 10000;
        mesDesconhecido = aux / 100;
        diaDesconhecido = aux % 100;
        
        //pegando ano, mes e o dia da data conhecida.
        anoConhecido = dataConhecida / 10000;
        aux = dataDesconhecida % 10000;
        mesConhecido = aux / 100;
        diaConhecido = aux % 100;
        
        //verificando se os anos sao bisextos.
        verificaAnoBisexto(anoBisexto, anoConhecido, anoDesconhecido);
        
        //verificando se a data informada é uma data valida
        if ((anoDesconhecido <= 999 || anoDesconhecido >= 10000) ||
                (anoConhecido <= 999 || anoConhecido >= 10000)) {
            return -1;
        }

        if ((mesDesconhecido < 1 || mesDesconhecido > 12) ||
                (mesConhecido < 1 || mesConhecido > 12)) {
            return -1;
        }
        
        if (!verificaDiaValido(diaDesconhecido, mesDesconhecido,
                anoBisexDesconhecido)) {
            return -1;
        }

        if (!verificaDiaValido(diaConhecido, mesConhecido,
                anoBisexConhecido)) {
            return -1;
        }
        
        
        return 0;
    }

    private static boolean verificaDiaValido(int dia, int mes, boolean n) {

        boolean v = false;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia >= 1 && dia <= 31) {
                    v = true;
                    
                }
                break;
                
            case 2:
                if (n) {
                    if (dia >= 1 && dia <= 29) {
                        v = true;
                        
                    }

                } else {
                    if (dia >= 1 && dia <= 28) {
                        v = true;
                        
                    }
                    
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia >= 1 && dia <= 30) {
                        v = true;
                        
                    }
                break;
            default:
        }

        return v;

    }

    private static void verificaAnoBisexto( int anoB, int anoC,int anoD) {
        
        //verificando se ano conhecido é bisexto.
        if(anoB > anoC) {
            
        } else {
            
        }
        
        //verificando se ano desconhecido é bisexto.
        if(anoB > anoC) {
            
        } else {
            
        }
        
    }
}
