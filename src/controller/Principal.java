package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;

public class Principal {
	
	//
	static List<Cliente> clientes = new ArrayList<Cliente>(); 
	static String hora;
	static int novoCliente = 0;
	
	public static void main(String[] args){
		
		int numero = menu();
		
		if(numero == 1){
			novoCliente = 1;
			preencheDadosCliente();
			
			if(exibeMensagemConsultaCadastrados() == 1){
				exibeClientesCadastrados();
			}
			
		}else
			if(numero == 2){
				exibeClientesCadastrados();
		}else{
			System.out.println("numero inválido");
		}
	}
	
	//exige o metodo como static
	public static int menu(){
		System.out.println("## AGENDA ##");
		System.out.println("1- Dados usuário");
		System.out.println("2- Agendamentos");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha um numero:");
		
		return scanner.nextInt();
	}
	
	
	public static void preencheDadosCliente() {
		Cliente cliente = new Cliente();
		Scanner scanner = new Scanner(System.in);
		
		while(novoCliente == 1){
		
			System.out.println("## INFORME OS SEGUINTES DADOS ##");
			System.out.println("Nome do  Cliente:");
			cliente.setNome(scanner.next());
			
			System.out.println("Telefone:");
			cliente.setTelefone(scanner.nextInt());
			
			System.out.println("Cpf:");
			cliente.setCpf(scanner.nextInt());
			
			System.out.println("Rua:");
			cliente.setRua(scanner.next());
			
			System.out.println("Numero:");
			cliente.setNumero(scanner.nextInt());
			
			System.out.println("Bairro:");
			cliente.setBairro(scanner.next());
			
			System.out.println("Cidade:");
			cliente.setCidade(scanner.next());
			
			System.out.println("Descrição do Serviço Agendado:");
			cliente.setDescricao(scanner.next());
			
			//
			System.out.println("Horário:");
			hora = scanner.next();
			DateFormat df = new SimpleDateFormat("hh:mm");
			//
			try {
				cliente.setHora(df.parse(hora));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if( exibeMensagemNovoCadastro() == 2){
				novoCliente = 0;
			}
			//static
			clientes.add(cliente);
		}
	}
	
	public static void exibeClientesCadastrados(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o nome do cliente");
		String nome = scanner.nextLine();
		
		for(int i = 0; i <= clientes.size(); i++){
			if(clientes.contains(nome)){
				exibeDadosCiente(clientes.get(i));
			}		
		}
		System.out.println("Cliente não encontrado!");
	}
	
	
	public static void exibeDadosCiente(Cliente c){
		System.out.println("Nome:"+ c.getNome());
		System.out.println("Telefone:"+ c.getTelefone());
		System.out.println("Descrição:"+ c.getDescricao());
		System.out.println("Horário:"+ c.getHora());
		
	}
	
	public static int exibeMensagemNovoCadastro(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Gostaria de cadastrar um novo cliente ?");
		System.out.println(" 1 - Sim     2 - Não");
		
		return scanner.nextInt();
	}
	
	public static int exibeMensagemConsultaCadastrados(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Gostaria de visualizar os clientes já cadastrados ?");
		System.out.println(" 1 - Sim     2 - Não");
		
		return scanner.nextInt();
	}
}
