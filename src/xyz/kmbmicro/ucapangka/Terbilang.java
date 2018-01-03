/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.kmbmicro.ucapangka;

import java.math.BigInteger;

/**
 *
 * @author arfan
 */
public class Terbilang {
    
    public static String sebut(BigInteger i) {

        StringBuilder buffer = new StringBuilder();
        
        if(i.compareTo(BigInteger.valueOf(2000))<0){
            if(i.equals(BigInteger.valueOf(1000))) {
                buffer.append("seribu");
            } else if(i.compareTo(BigInteger.valueOf(1000))<0){
                buffer.append("seribu ");
                buffer.append(sebut3(i.mod(BigInteger.valueOf(1000)).intValue()));
            } else {
                buffer.append(sebut3(i.mod(BigInteger.valueOf(1000)).intValue()));
            }
            return buffer.toString();
        }

        int satuan = i.mod(BigInteger.valueOf(1000)).intValue();
        int ribuan = (i.divide(BigInteger.valueOf(1000))).mod(BigInteger.valueOf(1000)).intValue();
        int jutaan = (i.divide(BigInteger.valueOf(1000000))).mod(BigInteger.valueOf(1000)).intValue();
        int milyaran = (i.divide(BigInteger.valueOf(1000000000))).mod(BigInteger.valueOf(1000)).intValue();
        int triliunan = (i.divide(BigInteger.valueOf(1000000000000L))).mod(BigInteger.valueOf(1000)).intValue();
        int kuadriliunan = (i.divide(BigInteger.valueOf(1000000000000000L))).mod(BigInteger.valueOf(1000)).intValue();
        int kuantiliunan = (i.divide(BigInteger.valueOf(1000000000000000000L))).mod(BigInteger.valueOf(1000)).intValue();
        int sekstiliunan = (i.divide(BigInteger.valueOf(1000000000000000000L)).divide(BigInteger.valueOf(1000L))).mod(BigInteger.valueOf(1000)).intValue();
        int septiliunan = (i.divide(BigInteger.valueOf(1000000000000000000L)).divide(BigInteger.valueOf(1000000L))).mod(BigInteger.valueOf(1000)).intValue();
        int oktiliunan = (i.divide(BigInteger.valueOf(1000000000000000000L)).divide(BigInteger.valueOf(1000000000L))).mod(BigInteger.valueOf(1000)).intValue();
        int noniliunan = (i.divide(BigInteger.valueOf(1000000000000000000L)).divide(BigInteger.valueOf(1000000000000L))).mod(BigInteger.valueOf(1000)).intValue();
        int desiliunan = (i.divide(BigInteger.valueOf(1000000000000000000L)).divide(BigInteger.valueOf(1000000000000000L))).mod(BigInteger.valueOf(1000)).intValue();


        if(desiliunan>0) {
            buffer.append(sebut3(desiliunan));
            buffer.append(" desiliun ");
        }
        if(noniliunan>0) {
            buffer.append(sebut3(noniliunan));
            buffer.append(" noniliun ");
        }
        if(oktiliunan>0) {
            buffer.append(sebut3(oktiliunan));
            buffer.append(" oktiliun ");
        }
        if(septiliunan>0) {
            buffer.append(sebut3(septiliunan));
            buffer.append(" septiliun ");
        }
        if(sekstiliunan>0) {
            buffer.append(sebut3(sekstiliunan));
            buffer.append(" sekstiliun ");
        }
        if(kuantiliunan>0) {
            buffer.append(sebut3(kuantiliunan));
            buffer.append(" kuantiliun ");
        }
        if(kuadriliunan>0) {
            buffer.append(sebut3(kuadriliunan));
            buffer.append(" kuadriliun ");
        }

        if(triliunan>0) {
            buffer.append(sebut3(triliunan));
            buffer.append(" triliun ");
        }
        
        if(milyaran>0) {
            buffer.append(sebut3(milyaran));
            buffer.append(" milyar ");
        }
        if(jutaan>0) {
            buffer.append(sebut3(jutaan));
            buffer.append(" juta ");
        }
        if(ribuan>0) {
            buffer.append(sebut3(ribuan));
            buffer.append(" ribu ");
        }

        if(satuan>0) {
            buffer.append(sebut3(satuan));
        }

        //System.out.println();
        return buffer.toString();
    }

    private static String sebut3(int i) {
        
        StringBuilder buffer = new StringBuilder();
        if(i>999){
            System.err.println("parameter error ["+i+"]");
            return null;
        }

        int ratusan,puluhan, satuan;

        ratusan = i/100 %10;
        puluhan = i/10 % 10;
        satuan = i % 10;

        if(ratusan==1) {
            buffer.append("seratus");
        } else if(ratusan ==2) {
            buffer.append("dua-ratus");
        } else if(ratusan ==3) {
            buffer.append("tiga-ratus");
        } else if(ratusan ==4) {
            buffer.append("empat-ratus");
        } else if(ratusan ==5) {
            buffer.append("lima-ratus");
        } else if(ratusan ==6) {
            buffer.append("enam-ratus");
        } else if(ratusan ==7) {
            buffer.append("tujuh-ratus");
        } else if(ratusan ==8) {
            buffer.append("delapan-ratus");
        } else if(ratusan ==9) {
            buffer.append("sembilan-ratus");
        }

        if(ratusan>0)
            buffer.append(" ");

        boolean skipSatuan = false;
        if(puluhan==1) {
            if(satuan==0) {
                buffer.append("sepuluh");
            } else if(satuan==1) {
                buffer.append("sebelas");
            } else if(satuan==2) {
                buffer.append("dua-belas");
            } else if(satuan==3) {
                buffer.append("tiga-belas");
            } else if(satuan==4) {
                buffer.append("empat-belas");
            } else if(satuan==5) {
                buffer.append("lima-belas");
            } else if(satuan==6) {
                buffer.append("enam-belas");
            } else if(satuan==7) {
                buffer.append("tujuh-belas");
            } else if(satuan==8) {
                buffer.append("delapan-belas");
            } else if(satuan==9) {
                buffer.append("sembilan-belas");
            }

            skipSatuan = true;
        } else if(puluhan==2) {
            buffer.append("dua-puluh");
        } else if(puluhan==3) {
            buffer.append("tiga-puluh");
        } else if(puluhan==4) {
            buffer.append("empat-puluh");
        } else if(puluhan==5) {
            buffer.append("lima-puluh");
        } else if(puluhan==6) {
            buffer.append("enam-puluh");
        } else if(puluhan==7) {
            buffer.append("tujuh-puluh");
        } else if(puluhan==8) {
            buffer.append("delapan-puluh");
        } else if(puluhan==9) {
            buffer.append("sembilan-puluh");
        }

        if(!skipSatuan) {
            if(puluhan>0)
                buffer.append(" ");

            if(satuan==1) {
                buffer.append("satu");
            } else if(satuan ==2) {
                buffer.append("dua");
            } else if(satuan ==3) {
                buffer.append("tiga");
            } else if(satuan ==4) {
                buffer.append("empat");
            } else if(satuan ==5) {
                buffer.append("lima");
            } else if(satuan ==6) {
                buffer.append("enam");
            } else if(satuan ==7) {
                buffer.append("tujuh");
            } else if(satuan ==8) {
                buffer.append("delapan");
            } else if(satuan ==9) {
                buffer.append("sembilan");
            }
        }

        return buffer.toString();
        //System.out.println();
    }
}
