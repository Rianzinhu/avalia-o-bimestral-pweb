public enum TipoContaEnum {
    // atividade avaliativa A
    ALUNO,
    PROFESSOR,
    DIRETOR;
    }
    public class ContaCantina {
        private TipoContaEnum tipoConta;
        private double saldo;
        private double limite;
        private double saldoMinimo;

        public ContaCantina(double saldo) {
            this.tipoConta = tipoContaEnum.ALUNO;
            this.saldo = saldo;
            this.limite = 10;
            this.saldoMinimo = 0;
        }

        public ContaCantina(TipoContaEnum tipoConta, double saldo) {
            this.tipoConta = tipoConta;
            this.saldo = saldo;
            this.saldoMinimo = 10;
        }
        public void emitirAlertaSaldoBaixo() {
            if (this.saldo <= this.saldoMinimo) {
                System.out.println("ALERTA DE SALDO BAIXO: R$ " + this.saldo);
            } else {
                System.out.println("Saldo: R$ " + this.saldo);
            }
        }
        public void debitar(double valor) {
            if (this.tipoConta == TipoContaEnum.DIRETOR) {
                if (this.saldo >= valor) {
                    this.saldo -= valor;
                    emitirAlertaSaldoBaixo();
                } else {
                    System.out.println("Conta sem saldo suficiente");
                }
            } else if (this.tipoConta == TipoContaEnum.PROFESSOR) {
                if (this.saldo + this.limite >= valor) {
                    this.saldo -= valor;
                    emitirAlertaSaldoBaixo();
                } else {
                    System.out.println("Conta sem saldo suficiente");
                }
            } else {
                System.out.println("Conta sem saldo suficiente");
            }
        }
        public void creditar(double valor) {
            this.saldo += valor;
            if (this.tipoConta == TipoContaEnum.ALUNO && valor > 100) {
                this.saldo += 5.0; // Acrescenta 5 reais se for ALUNO e o crédito for acima de 100
            }
            emitirAlertaSaldoBaixo();
        }
        public void setSaldoMinimo(double saldoMinimo){
            this.saldoMinimo = saldoMinimo;
            emitirAlertaSaldoBaixo();
        }
        public TipoContaEnum getTipoConta(){
            return tipoConta;
        }
        public void  setTipoConta(TipoContaEnum tipoConta){
            return TipoConta;
        }
        public double getSaldo(){
            return saldo;
        }
        public void setSaldo(double saldo){
            this.saldo = saldo;
        }
        public double getLimite(){
            return limite;
        }
        public void setLimite(double limite){
            this.limite = limite;
        }
        public double getSaldoMinimo(){
            return  saldoMinimo;
        }

    }