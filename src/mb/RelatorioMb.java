package mb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import entity.Relatorio;
import rn.RelatorioRN;

@ManagedBean
public class RelatorioMb {
	private List<Relatorio> relatorio;
	private Date fim;
	private Date inicio;
	private RelatorioRN rn;

	@PostConstruct
	public void init() {
		rn = new RelatorioRN();
	}

	public List<Relatorio> getRelatorio() {
		if (relatorio == null) {
			inicio = getValorOuData(inicio, true);
			fim = getValorOuData(fim, false);
			
			relatorio = rn.buscarPorPeriodo(inicio, fim);
		}
		return relatorio;
	}
	private Date getValorOuData(Date data, boolean ehInicio) {
		if (data != null) {
			return data;
		}
		Calendar date = Calendar.getInstance();
		int dia = ehInicio ? 1 : date.getActualMaximum(Calendar.DAY_OF_MONTH);
		int hora = ehInicio ? 0 : date.getActualMaximum(Calendar.HOUR);
		int periodo = ehInicio ? Calendar.AM: Calendar.PM;
		int minuto = ehInicio ? 0 : date.getActualMaximum(Calendar.MINUTE);
		int segundo = ehInicio ? 0 : date.getActualMaximum(Calendar.SECOND);
		
		date.set(Calendar.AM_PM, periodo);
		date.set(Calendar.DAY_OF_MONTH, dia);
		date.set(Calendar.HOUR, hora);
		date.set(Calendar.MINUTE, minuto);
		date.set(Calendar.SECOND, segundo);

		return date.getTime();
	}

	public void setRelatorio(List<Relatorio> relatorio) {
		this.relatorio = relatorio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public RelatorioRN getRn() {
		return rn;
	}

	public void setRn(RelatorioRN rn) {
		this.rn = rn;
	}
	public String buscar() {
		relatorio = null;
		return "";
	}
	


}
