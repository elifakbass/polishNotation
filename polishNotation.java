/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev30;

import java.util.Scanner;

/**
 *
 * @author EXCALIBUR
 */
public class polishNotation {

    public static void main(String[] args) {
        String metin;
        Scanner read = new Scanner(System.in);
        System.out.println("metni giriniz:");
        metin = read.nextLine();

        String[] metin2 = metin.split(" ");
        char[] operant = new char[20];
        String[] degerler = new String[20];
        int indeks = metin2.length;
        int o = 0, d = 0, sonuc = 0;
        for (int i = 0; i < metin2.length; i++) {

            if (metin2[i].equals("+") || metin2[i].equals("*")) {
                if (i == 0) {
                    o = 0;
                }
                operant[o] = metin2[i].charAt(0);
                o++;

            } else {
                degerler[d] = metin2[i];
                if (!metin2[i + 1].equals("+") && !metin2[i + 1].equals("*")) {   //eger sonraki string ifade de sayı ise işlemi yapıp metini düzenleriz

                    int sayi1 = Integer.parseInt(metin2[i + 1]);
                    int sayi2 = Integer.parseInt(degerler[d]);
                    sonuc = islem(sayi1, sayi2, operant[o - 1]);
                    o = o - 1;
                    degerler[d] = String.valueOf(sonuc);
                    duzenleme(metin2, i, degerler[d], indeks);

                    i = -1;

                }
                if (metin2[0].equals(degerler[d])) {  //eger sonuc degeri metinin ilk indexine yazılırsa işlem tamamlanmıştır.
                    break;
                }
                d++;

            }

        }
        System.out.println("" + sonuc);

    }

    public static int islem(int sayi1, int sayi2, char oprnt) {
        if (oprnt == '+') {
            return sayi1 + sayi2;
        } else {
            return sayi1 * sayi2;
        }

    }

    public static void duzenleme(String[] metin, int i, String degerler, int index) {
        metin[i - 1] = degerler;
        for (int j = i; j < index; j++) {
            if (j + 2 < index) { //j+2 nin metinin index uzunluğunu aşıp aşmadığını kontrol ederiz
                metin[j] = metin[j + 2];
            } else {
                metin[j] = "";
            }
        }

    }
}
