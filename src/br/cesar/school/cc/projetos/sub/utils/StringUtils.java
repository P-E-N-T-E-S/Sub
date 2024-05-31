package br.cesar.school.cc.projetos.sub.utils;

public class StringUtils {
    public static String getUltimosCaracteres(String str, int quantidade) {
        if (str == null || str.length() < quantidade+1) {
            return str; // Retorna a string inteira se for menor que 3 caracteres ou null
        }
        return str.substring(str.length() - quantidade+1); // Pega os três últimos caracteres
    }

    public static boolean isVaziaOuNula(String valor) {
        return valor == null || valor.trim().equals("");
    }
}
