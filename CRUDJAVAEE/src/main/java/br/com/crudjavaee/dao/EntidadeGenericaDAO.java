package br.com.crudjavaee.dao;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.crudjavaee.util.HibernateUtil;

import org.hibernate.criterion.Order;

public class EntidadeGenericaDAO<Entidade> {

	@SuppressWarnings("unused")
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public EntidadeGenericaDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); 
		Transaction transacao = null;   

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); // pegando sessao aberta
		try {

			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 try {
			 @SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(classe);
			 consulta.add(Restrictions.idEq(codigo));
			 Entidade resultado = (Entidade) consulta.uniqueResult();
			 return resultado;
			 
		 } catch (RuntimeException erro) {
			 throw erro;
		}finally {
			sessao.close();
		}
	}
	
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 Transaction transacao = null;
		 
		 try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit(); 
			
		 } catch (RuntimeException erro) {
				if (transacao != null) {
					transacao.rollback();
				}
				
			} finally {
				sessao.close();
			}
		}
	
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 Transaction transacao = null;
		 
		 try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit(); 
			
		 } catch (RuntimeException erro) {
				if (transacao != null) {
					transacao.rollback();
				}
				
			} finally {
				sessao.close();
			}
		} 
	
	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 Transaction transacao = null;
		 
		 try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit(); 
			
		 } catch (RuntimeException erro) {
				if (transacao != null) {
					transacao.rollback();
				}
				
			} finally {
				sessao.close();
			}
		}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campoOrdenacao) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 try {
			 @SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(classe);
			 consulta.addOrder(Order.asc(campoOrdenacao));
			 List<Entidade> resultado = consulta.list();
			 return resultado;
			 
		 } catch (RuntimeException erro) {
			 throw erro;
		}finally {
			sessao.close();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listarOrdenado(String campoOrdenacao) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 try {
			 @SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(classe);
			 consulta.addOrder(Order.asc(campoOrdenacao));
			 List<Entidade> resultado = consulta.list();
			 return resultado;
			 
		 } catch (RuntimeException erro) {
			 throw erro;
		}finally {
			sessao.close();
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeGenericaDAO other = (EntidadeGenericaDAO) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		return true;
	}
	
	

}
