package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TicketConsumoItem;



public class TicketConsumoItemDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(TicketConsumoItem objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return id;
	}

	public void actualizar(TicketConsumoItem objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {

			session.close();
		}
	}

	public void eliminar(TicketConsumoItem objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public TicketConsumoItem traerTicketConsumoItem(long id) throws HibernateException {
		/*TicketConsumoItem objeto = null;
		try {
			iniciaOperacion();
			objeto = (TicketConsumoItem) session.get(TicketConsumoItem.class, idTicketConsumoItem);
		} finally {
			session.close();
		}
		return objeto;
		*/
		
		TicketConsumoItem objeto = null;
		try {
			iniciaOperacion();
			objeto = (TicketConsumoItem) session.createQuery("from TicketConsumoItem c where c.id=" + id ).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}


	@SuppressWarnings("unchecked")
	public List<TicketConsumoItem> traerTicketConsumoItem() throws HibernateException {
		List<TicketConsumoItem> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from TicketConsumoItem c ").list();

		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<TicketConsumoItem> traerListaTicketConsumoItem(int ticketConsumo,int consumo) throws HibernateException {
		List<TicketConsumoItem> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from TicketConsumoItem t where t.ticketConsumo="+ticketConsumo+" and t.consumo="+consumo).list();

		} finally {
			session.close();
		}
		return lista;
	}


}
