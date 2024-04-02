package application.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compromissos")
public class Compromisso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricaoCompromisso;
    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private String horaFim;

    //@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a z") //14:00:00 AM timeZone
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Calendar dataHoraInicial;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Calendar dataHoraFinal;

    public Calendar getDataHoraInicial() {
        return dataHoraInicial;
    }

    public void setDataHoraInicial(Calendar dataHoraInicial) {
        this.dataHoraInicial = dataHoraInicial;
    }

    public Calendar getDataHoraFinal() {
        return dataHoraFinal;
    }

    public void setDataHoraFinal(Calendar dataHoraFinal) {
        this.dataHoraFinal = dataHoraFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoCompromisso() {
        return descricaoCompromisso;
    }

    public void setDescricaoCompromisso(String descricaoCompromisso) {
        this.descricaoCompromisso = descricaoCompromisso;
    }

    public String getDataInicio() {
    return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
    this.dataInicio = dataInicio;
    }

    public String getDataFim() {
    return dataFim;
    }

    public void setDataFim(String dataFim) {
    this.dataFim = dataFim;
    }

    public String getHoraInicio() {
    return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
    this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
    return horaFim;
    }

    public void setHoraFim(String horaFim) {
    this.horaFim = horaFim;
    }
}
