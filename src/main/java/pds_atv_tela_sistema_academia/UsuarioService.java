package pds_atv_tela_sistema_academia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class UsuarioService {
	
	
	public static void criarUsuario(String nome, int exp, String endereco, char genero, String senha) {
		int matricula = TelaLogin.cadastrados;
		if(nome.length() > 4 && endereco.length() > 4 && senha.length() > 4) {
			File novoUsuario = new File("data/users/"+matricula+".txt");
			FileWriter escritor;
			
			try {
				novoUsuario.createNewFile();
				escritor = new FileWriter(novoUsuario);
				escritor.write("NOM:"+nome+";\nEND:"+endereco+";\nGEN:"+genero+";\nEXP:"+exp+";\nSEN:"+senha+";\n");
				
				escritor.close();
				JOptionPane.showMessageDialog(null, "Usuário criado com matrícula "+matricula, "Sucesso", 3);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", 2);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Os campos estão demasiadamente pequenos!", "Erro!", 2);
			
		}
	}
		
		public static void usuario(String nome, int exp, String endereco, char genero, String senha, char mode) {
			int matricula = TelaLogin.cadastrados;
			if(mode == 'U') {
				matricula = Integer.parseInt(TelaLogin.loggedUser);
			}
			
			if(nome.length() > 4 && endereco.length() > 4 && senha.length() > 4) {
				File arquivoUsuario = new File("data/users/"+matricula+".txt");
				FileWriter escritor;
				
				try {
					arquivoUsuario.createNewFile();
					escritor = new FileWriter(arquivoUsuario);
					escritor.write("NOM:"+nome+";\nEND:"+endereco+";\nGEN:"+genero+";\nEXP:"+exp+";\nSEN:"+senha+";\n");
					
					escritor.close();
					if(mode == 'U') {
						JOptionPane.showMessageDialog(null, "Usuário atualizado", "Sucesso", 3);
					}else {
						JOptionPane.showMessageDialog(null, "Usuário criado com matrícula "+matricula, "Sucesso", 3);
					}
					
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", 2);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Os campos estão demasiadamente pequenos!", "Erro!", 2);
				
			}
		}
		
		public static boolean validar(String validar, String senha) {
			if(senha.equals(Leitor.getSenha(validar))) {
				return true;
			}
			return false;
		}
		
		public static File buscarUsuario(String nome) {
			ArrayList<File> listaDeUsuarios = new ArrayList<File>();
			listaDeUsuarios.addAll(Arrays.asList(new File("data/users").listFiles()));
			for (File usuario : listaDeUsuarios) {
				if(Leitor.getNome(usuario.getName().replace(".txt", "")).equals(nome)) {
					return usuario;
				}
			}
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro!", 3);
			return null;
		}
		
	}
	


