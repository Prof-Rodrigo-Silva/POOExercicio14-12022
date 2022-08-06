package classeexecutavel;
import java.sql.SQLException;
import java.util.List;
import conexaojdbc.SingleConnection;
import dao.ClasseDAO;
import model.Aluno;
import model.BeanAlunoTelefone;
import model.Telefone;

public class executavel {

	public static void main(String[] args) {

		//initBanco();
		//initSalvar();
		//initListar();
		//initBuscar();
		initAtualizar();
		//initDeletar();
		//salvarTelefone();
		//initListarAlunoTelefone();
		//initDeletarCascata();
		//initUltimoRegistro();

	}

	public static void initBanco() {
		SingleConnection.getConnetion();
	}

	public static void initSalvar() {
		
		Aluno aluno = new Aluno();
		ClasseDAO classeDao = new ClasseDAO();

		//classeDao.salvar(aluno);

		//aluno.setId(2L);
		aluno.setNome("Froning");
		aluno.setEmail("froning@gmail.com");

		classeDao.salvar(aluno);
	}

	public static void initListar() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			List<Aluno> list = classeDao.listar();

			for(Aluno aluno : list) {
				System.out.println(aluno.toString());
				System.out.println("----------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void initBuscar() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Aluno aluno = classeDao.buscar(4L);

			System.out.println(aluno.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initAtualizar() {

		try {
			ClasseDAO classeDao = new ClasseDAO();
			Aluno aluno = classeDao.buscar(5L);

			aluno.setNome("Rodrigo");

			classeDao.atualizar(aluno);
		} catch (Exception e) {

			e.printStackTrace();
		}	
	}

	public static void initDeletar() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			classeDao.deletar(7L);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void salvarTelefone() {
		Telefone telefone = new Telefone();
		ClasseDAO classeDAO = new ClasseDAO();
		telefone.setNumero("99900334455");
		telefone.setTipo("comercial");
		telefone.setIdAluno(4L);

		classeDAO.salvarTelefone(telefone);
	}

	public static void initListarAlunoTelefone() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			List<BeanAlunoTelefone> list = classeDao.listarAlunoFone(5L);

			for(BeanAlunoTelefone beanAlunoFone : list) {
				System.out.println(beanAlunoFone.toString());
				System.out.println("--------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void initDeletarCascata() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			classeDao.deletarCascata(6L);

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void initUltimoRegistro() throws SQLException {
		ClasseDAO classeDAO = new ClasseDAO();
		String id = classeDAO.ultimoRegistro();
		System.out.println(id);
	}

}
