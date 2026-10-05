import habitantes.*;

import static java.lang.IO.*;
void main(){

    println("Personagens criados");

    try {
        Habitantes agricultor = new Agricultor("Toninho",50, 100, 100, 1000, "");
        Habitantes cientista = new Cientista("Carlos", 25, 100);
        Habitantes engenheiro = new Engenheiro("Nicolas", 21, 100);
        Habitantes medico = new Medico("Jullia",19, 100);

    } catch (IllegalArgumentException e) {
        println("[ERRO DE VALIDAÇÃO]: " + e.getMessage());
    }
}