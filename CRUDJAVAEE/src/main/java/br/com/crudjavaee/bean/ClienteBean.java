package br.com.crudjavaee.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.crudjavaee.dao.ClienteDAO;
import br.com.crudjavaee.entity.Cliente;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class ClienteBean implements Serializable{
	private Cliente cliente;
	private List<Cliente> clientes;
	
	public void novo() {
		cliente = new Cliente();
	 
	}	
	public void salvar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			
			cliente.setDataInicio(new Date());
			clienteDAO.merge(cliente);
				
			cliente = new Cliente();
			clientes = clienteDAO.listar();
			
			Messages.addFlashGlobalInfo("Cliente salvo com sucesso!");
			
			}catch (RuntimeException erro) {
				Messages.addGlobalError("Erro ao tentar salvar o Cliente.");
				erro.printStackTrace();
			}
	}
	
	public void excluir(ActionEvent evento) {
		try {
				
		cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluir(cliente);
		
		clientes = clienteDAO.listar();
		
		Messages.addGlobalInfo("Cliente excluído com sucesso.");
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar excluir o Cliente.");
			erro.printStackTrace();
		}
		}
	
	@PostConstruct
	public void listar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();

			clientes = clienteDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Clientes");
			erro.printStackTrace();
		}
	}
	
	
	public void editar(ActionEvent evento) {
		cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
		
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	} 
	
	
	
}
