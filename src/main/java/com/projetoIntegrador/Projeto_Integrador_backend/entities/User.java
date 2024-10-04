package com.projetoIntegrador.Projeto_Integrador_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sexo;
    private int idade;
    @Column(unique = true)
    private String email;
    private String password;

    private Double altura;
    private Double peso;

    private Double gastoBasal;
    @OneToMany(mappedBy = "user")
    private List<Consumption> consumptions;

    public Double getGastoBasal() {
        return gastoBasal;
    }


    public String getSexo() {
        return sexo;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
        updateGastoBasal();
    }

    public void setAltura(Double altura) {
        this.altura = altura;
        updateGastoBasal();
    }

    public void setIdade(int idade) {
        this.idade = idade;
        updateGastoBasal();
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
        updateGastoBasal();
    }

    private void updateGastoBasal() {
        if (peso != null && altura != null && idade > 0 && sexo != null && !sexo.isEmpty()) {
            this.gastoBasal = calcBasal(peso, altura, idade, sexo);
        }
    }

    private double calcBasal(double peso, double altura, int idade, String sexo) {
        double gastoBasal;
        if (sexo.equalsIgnoreCase("masculino")) {
            gastoBasal = (10 * peso) + (6.25 * altura) - (5 * idade) + 5;
        } else if (sexo.equalsIgnoreCase("feminino")) {
            gastoBasal = (10 * peso) + (6.25 * altura) - (5 * idade) - 161;
        } else {
            throw new IllegalArgumentException("Sexo deve ser 'masculino' ou 'feminino'");
        }
        return gastoBasal;
    }


    public Double getAltura() {
        return altura;
    }



    public Double getPeso() {
        return peso;
    }


    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(Long id, String name, String sexo, int idade, String email, String password, Double altura, Double peso, Double gastoBasal, List<Consumption> consumptions) {
        this.id = id;
        this.name = name;
        this.sexo = sexo;
        this.idade = idade;
        this.email = email;
        this.password = password;
        this.altura = altura;
        this.peso = peso;
        this.gastoBasal = gastoBasal;
        this.consumptions = consumptions;
    }
}
