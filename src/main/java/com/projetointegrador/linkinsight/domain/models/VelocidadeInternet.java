package com.projetointegrador.linkinsight.domain.models;

import lombok.Data;

import java.math.BigDecimal;

public enum VelocidadeInternet {

    CEM("100", "100,00"),
    DUZENTOS("200", "119,00"),
    TREZENTOS("300","149,00");

    VelocidadeInternet(String descricao, String valor) {
    }
}
