package model;

import java.time.LocalDate;

public class movimentacaoEstoque {
    private int id;
    private int idFornecedorProduto;
    private LocalDate data;
    private double quantidade;
    private String tipoMovimentacao;
    private double custo;
    private int lote;
    private LocalDate validade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFornecedorProduto() {
        return idFornecedorProduto;
    }

    public void setIdFornecedorProduto(int idFornecedorProduto) {
        this.idFornecedorProduto = idFornecedorProduto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "movimentacaoEstoque{" +
                "id=" + id +
                ", idFornecedorProduto=" + idFornecedorProduto +
                ", data=" + data +
                ", quantidade=" + quantidade +
                ", tipoMovimentacao='" + tipoMovimentacao + '\'' +
                ", custo=" + custo +
                ", lote=" + lote +
                ", validade=" + validade +
                '}';
    }
}
