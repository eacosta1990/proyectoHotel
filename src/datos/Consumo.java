package datos;

import java.util.Set;

public class Consumo {

	private int idConsumo;
	private String consumo;
	private float precio;
	private Set<FrigobarItem> frigobarItem;
	private Set<TicketConsumoItem> ticketConsumoItem;

	public Consumo() {
	}

	public Consumo(String consumo, float precio) {
		this.consumo = consumo;
		this.precio = precio;
	}

	public Set<FrigobarItem> getFrigobarItem() {
		return frigobarItem;
	}

	public void setFrigobarItem(Set<FrigobarItem> frigobarItem) {
		this.frigobarItem = frigobarItem;
	}

	public Set<TicketConsumoItem> getTicketConsumoItem() {
		return ticketConsumoItem;
	}

	public void setTicketConsumoItem(Set<TicketConsumoItem> ticketConsumoItem) {
		this.ticketConsumoItem = ticketConsumoItem;
	}

	public int getIdConsumo() {
		return idConsumo;
	}

	protected void setIdConsumo(int idConsumo) {
		this.idConsumo = idConsumo;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Consumo [idConsumo=" + idConsumo + ", consumo=" + consumo
				+ ", precio=" + precio +  "]";
	}

}
