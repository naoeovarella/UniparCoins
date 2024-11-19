import java.util.ArrayList;
import java.util.List;

public class CarteiraDigital {

    private double saldo;
    private List<String> historico;

    public CarteiraDigital() {
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public void adicionarSaldo(double valor) {
        if (isValorPositivo(valor)) {
            saldo += valor;
            registrarHistorico("Adição de " + valor + " ao saldo.");
            mostrarSaldoAtual();
        } else {
            exibirMensagem("Valor inválido para adicionar.");
        }
    }

    public void realizarPagamento(double valor) {
        if (isPagamentoValido(valor)) {
            saldo -= valor;
            registrarHistorico("Pagamento de " + valor + " realizado com sucesso.");
            mostrarSaldoAtual();
        } else {
            exibirMensagem("Saldo insuficiente. Seu saldo atual é R$" + saldoFormatado());
        }
    }

    public void verificarSaldo() {
        mostrarSaldoAtual();
    }

    public void historicoTransacoes() {
        if (historico.isEmpty()) {
            exibirMensagem("Nenhuma transação realizada até o momento.");
        } else {
            exibirMensagem("Histórico de Transações:");
            for (String transacao : historico) {
                exibirMensagem("- " + transacao);
            }
        }
    }

    private boolean isValorPositivo(double valor) {
        return valor > 0;
    }

    private boolean isPagamentoValido(double valor) {
        return valor <= saldo;
    }

    private void registrarHistorico(String transacao) {
        historico.add(transacao);
    }

    private void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    private void mostrarSaldoAtual() {
        System.out.println("Seu saldo atual é: R$" + saldoFormatado());
    }

    private String saldoFormatado() {
        return String.format("%.2f", saldo);
    }
}
