package com.construcao.calendario;

import java.text.ParseException;

/**
 * Serviços oferecidos para verificar o dia da semana.
 *
 * @author Estevão Cristino
 */
public class Calendario {

    public static int diaSemana(int data, int bissexto,
            int conhecida, int ds) throws Exception {

        int dd;// dia desconhecido
        int dc;// dia conhecido
        int md;// mes desconhecido
        int mc;// mes conhecido
        int ad;// ano desconhecido
        int ac;// ano conhecido
        int aux;// auxiliar

        //pegando o ano, mes e o dia desconhecidos
        ad = data / 10000;
        aux = data % 10000;
        md = aux / 100;
        dd = aux % 100;

        //pegando ano, mes e o dia da data conhecida.
        ac = conhecida / 10000;
        aux = conhecida % 10000;
        mc = aux / 100;
        dc = aux % 100;

        //verificando se o dia da semana esta entre 0 e 6
        if (ds >= 0 && ds <= 6) {

            //verificando se o ano bissexto é maior que 0
            if (bissexto > 0) {

                //verificando se a data informada é uma data valida
                //verificando ano valido
                if ((ad > 999 && ad < 10000) && (ac > 999 && ac < 10000)) {

                    //verificando mes valido
                    if ((md >= 1 && md <= 12) && (mc >= 1 && mc <= 12)) {

                        //verificando dia valido
                        if ((verificaQntDiasNoMes(md, ad, bissexto) >= dd && dd > 0)
                                && (verificaQntDiasNoMes(mc, ac, bissexto) >= dc
                                && dc > 0)) {

                            int qntDias = qntDias(data, conhecida, ad, ac, md,
                                    mc, dd, dc, bissexto);

                            if (data == conhecida) {
                                return ds;
                            } else {
                                int diaSem = 0;
                              
                                if(dc > dd && md != mc) {
                                   diaSem = 1;
                                }
                                
                                if(ac < ad) {
                                    diaSem--;
                                }
                                
                                
                                if (conhecida > data) {
                                    
                                    diaSem += ((qntDias - ds) % 7); 

                                } else {
                                    
                                    diaSem += ((qntDias + ds) % 7);

                                }
                                
                                if(ad < ac) {
                                    if((ac - ad) > 4){
                                        diaSem += (ac - ad);
                                        diaSem = diaSem % 7;
                                    }
                                }
                                
                                return diaSem;
                            }

                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Metodo que verifica a quantidade de dias no Mes
     *
     * @param mes
     * @param ano
     * @return
     */
    private static int verificaQntDiasNoMes(int mes, int ano, int bissexto) {

        int qntDias;
        qntDias = 0;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                qntDias = 31;
                break;

            case 2:
                if (verificaAnoBisexto(ano, bissexto)) {
                    qntDias = 29;

                } else {
                    qntDias = 28;

                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                qntDias = 30;
                break;

        }
        return qntDias;
    }

    private static boolean verificaAnoBisexto(int ano, int bissexto) {

        if (bissexto % 400 == 0) {
            if (ano % 400 == 0) {
                return true;
            } else if ((ano % 4 == 0) && (ano % 100 != 0)) {
                return true;
            } else {
                return false;
            }

        } else if ((bissexto % 4 == 0) && (bissexto % 100 != 0)) {
            if (ano % 400 == 0) {
                return true;
            } else if ((ano % 4 == 0) && (ano % 100 != 0)) {
                return true;
            } else {
                return false;
            }

        } else {
            int aux = bissexto % 4;
            if ((ano + aux) % 400 == 0) {
                return true;
            } else if (((ano + aux) % 4 == 0) && ((ano + aux) % 100 != 0)) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static int qntDias(int data, int conhecida, int ad, int ac, int md, int mc, int dd,
            int dc, int bissexto) throws ParseException {

        int ano, mes, dia, qntdia = 0, totDia = 0;
        int[] d = new int[2];
        int[] m = new int[2];
        int[] a = new int[2];
        boolean x = false;

        if (ac > ad) {
            d[0] = dd;
            m[0] = md;
            a[0] = ad;
            d[1] = dc;
            m[1] = mc;
            a[1] = ac;
            x = true;
        } else if (ad > ac) {
            d[0] = dc;
            m[0] = mc;
            a[0] = ac;
            d[1] = dd;
            m[1] = md;
            a[1] = ad;
        } else if (mc > md) {
            d[0] = dd;
            m[0] = md;
            a[0] = ad;
            d[1] = dc;
            m[1] = mc;
            a[1] = ac;
            x = true;
        } else if (md > mc) {
            d[0] = dc;
            m[0] = mc;
            a[0] = ac;
            d[1] = dd;
            m[1] = md;
            a[1] = ad;
        } else if (dc > dd) {
            d[0] = dd;
            m[0] = md;
            a[0] = ad;
            d[1] = dc;
            m[1] = mc;
            a[1] = ac;
            x = true;
        } else {
            d[0] = dc;
            m[0] = mc;
            a[0] = ac;
            d[1] = dd;
            m[1] = md;
            a[1] = ad;
        }
        //contando anos
        for (ano = a[0]; ano <= a[1]; ano++) {
            //se o ano for igual ao ultimo
            
            if (ano == a[1]) {
                //contando os messes
                for (mes = m[0]; mes <= m[1]; mes++) {
                    //se o mês for igual ao ultimo
                    if (mes == m[1]) {
                        //contando até o ultimo dia
                        for (dia = d[0]; dia <= d[1]; dia++) {
                            totDia++;
                        }
                    } //se o mes for diferente do ultimo
                    else {
                        //peando a qntidade de dias de um mes
                        qntdia = verificaQntDiasNoMes(mes, ano, bissexto);
                        //contando os dias
                        for (dia = d[0]; dia <= qntdia; dia++) {
                            totDia++;
                        }
                        //ao virar o mes os dias se torna 1
                        d[0] = 1;
                    }
                }
            } //se nao for o ultimo ano
            else {
                
                //contando os meses
                for (mes = m[0]; mes <= 12; mes++) {
                    
                    //pegando a quantidade de dias no mes
                    qntdia = verificaQntDiasNoMes(mes, ano, bissexto);
                    //contando dias
                    for (dia = d[0]; dia <= qntdia; dia++) {
                        totDia++;
                        
                    }
                    //na virada do mes o dia se torna 1
                    d[0] = 1;
                }
                //na virada do ano, o mes se torna 1
                m[0] = 1;
            }
        }

        return totDia - 1;
    }

}
