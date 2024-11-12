/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


/**
 *
 * @author kauan
 */
//INTERFACE: A CLASSE QUE O IMPLEMENTA, OBRIGATORIAMENTE DEVE IMPLEMENTAR OS MÉTODOS E ATRIBUTOS DESTA INTERFACE.
//QUANDO ÚTIL: UM MÉTODO ESPECÍFICO QUE SÓ PODE SER USADO POR DETERMINADAS CLASSES, MAS QUE NÃO PODEM SER HERDADAS POR QUEM NÃO DEVE.
/*
EX.: Esta interface de pagamento só será útil nas mãos de um funcionário. Pode existir uma classe cliente que herde de pessoa, não faria
sentido ter esse método em pessoa e que cliente o herde.
Mas não seria mais fácil então colocar esse método em funcionário? Não, somente determinados funcionários podem acessar a aba de
pagamento: gestor, vendedor...

*/
public interface Pagamento {
    public void pagamento(); //corpo só nas classes que implementam a interface
}
