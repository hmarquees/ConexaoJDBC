package entity;

public class produto {

    private static int codigo;
    private static String descricao;
    private static double valor;
    
    public static void setCodigo(int codigo) {
        produto.codigo = codigo;
    }
    
    public static void setDescricao(String descricao) {
        produto.descricao = descricao;
    }
    
    public static void setValor(double valor) {
        produto.valor = valor;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static String getDescricao() {
        return descricao;
    }

    public static double getValor() {
        return valor;
    }


    
}
